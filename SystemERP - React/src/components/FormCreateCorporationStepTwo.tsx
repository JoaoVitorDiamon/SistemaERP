import InputPersonalized from "./InputPersonalized";
import {EmpresaCreateDto} from "../../models/EmpresaCreateDto"
import { SubmitHandler, useForm } from "react-hook-form";
import { useEffect, useState } from "react";
import ProgressBar from "./ProgressBar";
import { useNavigate } from "react-router-dom";
function FormCreateCorporationStepTwo() {
    const navigate = useNavigate()
    const empresa = localStorage.getItem("data")
    const [tiposdeempresa, setTiposDeEmpresa] = useState({'valor':[{'idTipoDeEmpresa':1, 'name':null}], 'mensagem':null, 'status':true})
    const [setores, setSetores] = useState({'valor':[{'idSetor':1, 'nome':null}], 'mensagem':null, 'status':true})
    const { register, handleSubmit, formState: { errors }} = useForm<EmpresaCreateDto>();
    const onSubmit: SubmitHandler<EmpresaCreateDto> = data => {
        console.log(data)
        let name = data.name
        let setor = data.setor
        let idTipoDeEmpresa = data.idTipoDeEmpresa
        if(empresa != null){
            let empresaLocalStorage = JSON.parse(empresa)
            Object.assign(empresaLocalStorage, {name, idTipoDeEmpresa, setor})
            console.log(empresaLocalStorage)
            localStorage.setItem("data", JSON.stringify(empresaLocalStorage))
            navigate("/EmpresaEndereco")  
        }
    };
    useEffect(()=>{
        CarregandoSetores()
        CarregandoTipos()
        if(!empresa){
            navigate("/CriarEmpresa")
        }
    }, [])
    function CarregandoTipos(){
        fetch('https://localhost:7106/api/TipoDeEmpresa', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            },
        })
        .then((resp) => resp.json())
        .then((data) => setTiposDeEmpresa(data))
        .catch((error) => console.log(error))
    } 
    function CarregandoSetores(){
        fetch('https://localhost:7106/api/Setor', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            },
        })
        .then((resp) => resp.json())
        .then((data) => setSetores(data))
        .catch((error) => console.log(error))
    }

    return (
        <div className="h-screen bg-white w-2xl xl:min-w-3xl min-w-xl flex flex-col justify-center items-center">
            <div className="flex mb-24">
                <ProgressBar step="STEP 1" descricao="Dado da Empresa" estado="Progresso"/>
                <ProgressBar step="STEP 2" descricao="Endereço" estado="Pendente"/>
                <ProgressBar step="STEP 3" descricao="Payment info" estado="Pendente"/>
            </div>
            <div className="w-full max-w-md p-9 md:p-0">    
                <h1 className="md:text-3xl text-2xl text-center font-semibold md:mb-1">Detalhes da empresa</h1>
                <div className="">
                    <form onSubmit={handleSubmit(onSubmit)} className="sm:mt-10 mt-6 space-y-4 text-gray-600">
                        <div>
                            <p>Setor da Empresa</p>
                            <select {...register("setor", {required: true})} className="w-full p-3 border mt-1 border-gray-300 rounded-[8px] focus:outline-none focus:ring-2 focus:ring-blue-300">
                                <option value=""></option>
                                {setores.valor.map((option)=>(
                                    <option value={option.idSetor} key={option.idSetor}>{option.nome}</option>
                                ))}
                            </select>
                            {errors?.setor?.type === "required" && <p className="text-red-600 text-sm">Setor está vázio.</p>}
                        </div>
                        <div>
                            <p>Tipo da Empresa</p>
                            <select {...register("idTipoDeEmpresa", {required: true})} className="w-full p-3 border mt-1 border-gray-300 rounded-[8px] focus:outline-none focus:ring-2 focus:ring-blue-300">
                                <option value=""></option>
                                {tiposdeempresa.valor.map((option) => (
                                    <option value={option.idTipoDeEmpresa} key={option.idTipoDeEmpresa}>{option.name}</option>
                                ))}
                            </select>
                            {errors?.idTipoDeEmpresa?.type === "required" && <p className="text-red-600 text-sm">Tipo de empresa está vázio.</p>}
                        </div>
                        <div>
                            <p>Razão social</p>
                            <InputPersonalized type="text" {...register("name", { required: true })}/>
                            {errors?.name?.type === "required" && <p className="text-red-600 text-sm">Razão Social inválida</p>}
                        </div>
                        <button type="submit" className="w-xs mx-auto block bg-blue-700 text-white p-3 mt-12 rounded-4xl hover:bg-blue-800 font-semibold">Próximo</button>
                    </form>
                    
                </div>
            </div>
        </div>
    )
}
export default FormCreateCorporationStepTwo;
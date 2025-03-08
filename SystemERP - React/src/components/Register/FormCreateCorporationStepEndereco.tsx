import InputPersonalized from "../InputPersonalized";
import { SubmitHandler, useForm } from "react-hook-form";
import ProgressBar from "./ProgressBar";
import { useEffect, useState } from "react";
import InputPersonalizedDisable from "../InputPersonalizedDisable";
import { useNavigate } from "react-router-dom";
interface ICep {
    cep: string
    logradouro: string
    complemento: string
    localidade: string
    bairro: string
    estado: string
    numero: string

}
function FormCreateCorporationStepEndereco() {
    const navigate = useNavigate()
    const empresa = localStorage.getItem("data")
    const [cepDados, SetarCEPDados] = useState<ICep>();
    const [cep, setarCEP] = useState("")
    const { register, setValue, handleSubmit, formState: { errors }} = useForm<ICep>();
    const onSubmit: SubmitHandler<ICep> = data => {
        viaCEP()
        if(cepDados){
            let endereco = `Brasil, ${cep}, ${cepDados.localidade},
             ${cepDados.bairro}, ${cepDados.logradouro}, ${data.numero}`
            if(empresa!=null){
                let empresaLC = JSON.parse(empresa)
                Object.assign(empresaLC, {endereco})
                console.log(empresaLC)
                localStorage.setItem("data", JSON.stringify(empresaLC))
                navigate("/CadastroRepresentante")
            }
        }
    };

    function viaCEP(){
        fetch(`http://localhost:5068/api/Empresa/cep/${cep}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            },
        })
        .then((resp) => resp.json())
        .then((data) => {SetarCEPDados(data); setarCEP(data.cep || cep)})
        .catch((error) => console.log(error))
        console.log(cepDados)
    }
    useEffect(()=>{
        if(cepDados){
            setValue("estado", cepDados.estado)
            setValue("localidade", cepDados.localidade)
            setValue("logradouro", cepDados.logradouro)
        }
        if(!empresa){
            navigate("/CriarEmpresa")
        }
    },[cepDados])
    return (
        <div className="h-screen bg-white w-2xl xl:min-w-3xl min-w-xl flex flex-col justify-center items-center">
            <div className="flex mb-24">
                <ProgressBar step="STEP 1" descricao="Dado da Empresa" estado="Completado"/>
                <ProgressBar step="STEP 2" descricao="Endereço" estado="Progresso"/>
                <ProgressBar step="STEP 3" descricao="Payment info" estado="Pendente"/>
            </div>
            <div className="w-full md:p-0 ">
                <h1 className="md:text-3xl text-2xl font-semibold md:mb-1 text-center">Endereço da empresa</h1>
                <div className="">
                    <form onSubmit={handleSubmit(onSubmit)} className="sm:mt-10 w-full mt-6 space-y-4 text-gray-600">
                        <div className="flex justify-around">
                            <div className="w-2/5">
                                <div className="flex items-center justify-between">
                                    <label>CEP</label>
                                    <div className="bg-cover bg-center bg-[url(https://cdn-icons-png.flaticon.com/128/2319/2319177.png)] w-5 h-5 ml-4 border rounded-[8px]" onClick={()=>(viaCEP())}></div>
                                </div>
                                <InputPersonalized type="text" required value={cep} onChange={(event)=>setarCEP(event.target.value)}/>
                                {errors?.cep?.type === "required" && <p className="text-red-600 text-sm">Email ou cnpj inválidos</p>}
                            </div>

                            <div className="w-2/5">
                                <label>Estado</label>
                                <InputPersonalizedDisable type="text" {...register("estado", {disabled: true})}/>
                            </div>
                        </div>
                        <div className="flex justify-around">
                            <div className="w-2/5">
                                <label>Cidade</label>
                                <InputPersonalizedDisable type="text"{...register("localidade", {disabled: true})}/>
                                {errors?.localidade?.type === "required" && <p className="text-red-600 text-sm">Email ou cnpj inválidos</p>}
                            </div>
                            <div className="w-2/5">
                                <label>Rua</label>
                                <InputPersonalizedDisable type="text"{...register("logradouro", {disabled: true, })}/>
                                {errors?.logradouro?.type === "required" && <p className="text-red-600 text-sm">Senha inválida.</p>}
                            </div>
                        </div>
                        <div className="flex justify-around">
                            <div className="w-2/5">
                                <label>Número</label>
                                <InputPersonalized type="number" {...register("numero", { required: true })}/>
                                {errors?.numero?.type === "required" && <p className="text-red-600 text-sm">Email ou cnpj inválidos</p>}
                            </div>
                            <div className="w-2/5">
                                <label>Complemento</label>
                                <InputPersonalized type="text" {...register("complemento")}/>
                            </div>
                        </div>
                        <button type="submit" className="w-xs mx-auto block bg-blue-500 text-white p-3 mt-12 rounded-4xl hover:bg-blue-700">Entrar</button>
                    </form>
                </div>
            </div>
        </div>
    )
}
export default FormCreateCorporationStepEndereco;

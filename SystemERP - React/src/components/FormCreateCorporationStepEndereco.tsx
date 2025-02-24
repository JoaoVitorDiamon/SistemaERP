import InputPersonalized from "./InputPersonalized";
import { SubmitHandler, useForm } from "react-hook-form";
import ProgressBar from "./ProgressBar";
import { useEffect, useState } from "react";
interface ICep {
    cep: string
    logradouro: string
    complemento: string
    unidade: string
    bairro: string
    localidade: string
    uf: string
    estado: string
    regiao: string
    ibge: string
    gia: string
    ddd: string
    siafi: string
}
function FormCreateCorporationStepEndereco() {
    const [cepDados, SetarCEPDados] = useState({"estado":""});
    const [cep, setarCEP] = useState("")
    const { register, setValue, handleSubmit, formState: { errors }} = useForm<ICep>();
    const onSubmit: SubmitHandler<ICep> = data => console.log(data);

    function viaCEP(){
        fetch(`https://localhost:7106/api/Empresa/cep/${cep}`, {
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
        setValue("estado", cepDados.estado)
    },[cepDados])
    return (
        <div className="h-screen bg-white w-2xl xl:min-w-3xl min-w-xl flex flex-col justify-center items-center">
            <div className="flex mb-24">
                <ProgressBar step="STEP 1" descricao="Dado da Empresa" estado="Progresso"/>
                <ProgressBar step="STEP 2" descricao="Endereço" estado="Pendente"/>
                <ProgressBar step="STEP 3" descricao="Payment info" estado="Pendente"/>
            </div>
            <div className="w-full md:p-0 ">
                <h1 className="md:text-3xl text-2xl font-semibold md:mb-1 text-center">Endereço da empresa</h1>
                <div className="">
                    <form onSubmit={handleSubmit(onSubmit)} className="sm:mt-10 w-full mt-6 space-y-4 text-gray-600">
                        <div className="flex justify-around">
                            <div className="w-2/5">
                                <label>CEP</label>
                                <InputPersonalized type="text" value={cep} onChange={(event)=>setarCEP(event.target.value)}/>
                                {errors?.cep?.type === "required" && <p className="text-red-600 text-sm">Email ou cnpj inválidos</p>}
                            </div>
                            <p className="bg-amber-200 w-4 h-4" onClick={()=>(viaCEP())}></p>
                            <div className="w-2/5">
                                <label>Estado</label>
                                <div className="bg-gray-300 rounded-[8px]"><InputPersonalized type="text" {...register("estado", {disabled: true, })}/></div>
                            </div>
                        </div>
                        <div className="flex justify-around">
                            <div className="w-2/5">
                                <label>Cidade</label>
                                <div className="bg-gray-300 rounded-[8px]"><InputPersonalized type="text"{...register("complemento", {disabled: true, })}/></div>
                                {errors?.estado?.type === "required" && <p className="text-red-600 text-sm">Email ou cnpj inválidos</p>}
                            </div>
                            <div className="w-2/5">
                                <label>Rua</label>
                                <div className="bg-gray-300 rounded-[8px]"><InputPersonalized type="text"{...register("complemento", {disabled: true, })}/></div>
                                {errors?.estado?.type === "required" && <p className="text-red-600 text-sm">Senha inválida.</p>}
                            </div>
                        </div>
                        <div className="flex justify-around">
                            <div className="w-2/5">
                                <label>Número</label>
                                <InputPersonalized type="email" {...register("complemento", { required: true })}/>
                                {errors?.estado?.type === "required" && <p className="text-red-600 text-sm">Email ou cnpj inválidos</p>}
                            </div>
                            <div className="w-2/5">
                                <label>Complemento</label>
                                <InputPersonalized type="password" {...register("complemento", {required: true, })}/>
                                {errors?.estado?.type === "required" && <p className="text-red-600 text-sm">Senha inválida.</p>}
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
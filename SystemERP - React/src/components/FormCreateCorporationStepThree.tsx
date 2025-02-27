import InputPersonalized from "./InputPersonalized";
import { SubmitHandler, useForm } from "react-hook-form";
import ProgressBar from "./Register/ProgressBar";
import { useNavigate } from "react-router-dom";
import { useEffect } from "react";
interface Representante {
    Nome: String;
    CPF: String;
    EmailRepresentante: String;
  }
function FormCreateCorporationStepThree() {
    const navigate = useNavigate()
    const empresa = localStorage.getItem("data")
    const { register, handleSubmit, formState: { errors }} = useForm<Representante>();
    const onSubmit: SubmitHandler<Representante> = data => {
        console.log(data)
        if(empresa){
            let empresaLocalStorage = JSON.parse(empresa);
            let representante = {Nome:data.Nome, CPF:data.CPF, EmailRepresentante:data.EmailRepresentante}
            Object.assign(empresaLocalStorage, {representante})
            localStorage.setItem("data", JSON.stringify(empresaLocalStorage))
            console.log(empresaLocalStorage)
        }
    };
    useEffect(()=>{
        if(!empresa){
            navigate("/CriarEmpresa")
        }
    }, [])
    return (
        <div className="h-screen rounded-4xl bg-white w-2xl xl:min-w-3xl md:min-w-xl flex flex-col justify-center items-center">
            <div className="flex mb-24">
                <ProgressBar step="STEP 1" descricao="Dado da Empresa" estado="Completado"/>
                <ProgressBar step="STEP 2" descricao="Endereço" estado="Completado"/>
                <ProgressBar step="STEP 3" descricao="Payment info" estado="Progresso"/>
            </div>
            <div className="w-full max-w-md p-9 md:p-0">
                <h1 className="md:text-3xl text-2xl font-semibold md:mb-16 text-center">Representante Legal da empresa</h1>
                <div className="">
                    <form onSubmit={handleSubmit(onSubmit)} className="sm:mt-10 mt-6 space-y-4 text-gray-600">
                        <div>
                            <label>Nome do representante</label>
                            <InputPersonalized type="text" {...register("Nome", { required: true })}/>
                            {errors?.Nome?.type === "required" && <p className="text-red-600 text-sm">Campo vázio</p>}
                        </div>
                        <div>
                            <label>CPF do representante</label>
                            <InputPersonalized type="text" {...register("CPF", { required: true })}/>
                            {errors?.CPF?.type === "required" && <p className="text-red-600 text-sm">CPF inválido</p>}
                        </div>
                        <div>
                            <label>Email do representante</label>
                            <InputPersonalized type="email" {...register("EmailRepresentante", { required: true })}/>
                            {errors?.EmailRepresentante?.type === "required" && <p className="text-red-600 text-sm">Email inválido</p>}
                        </div>
                        <button type="submit" className="w-xs mx-auto block bg-blue-500 text-white p-3 mt-18 rounded-4xl hover:bg-blue-700">Concluir</button>
                    </form>
                </div>
            </div>
        </div>
    )
}
export default FormCreateCorporationStepThree;
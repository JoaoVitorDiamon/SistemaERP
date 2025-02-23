import InputPersonalized from "./InputPersonalized";
import {EmpresaCreateDto} from "../../models/EmpresaCreateDto"
import { SubmitHandler, useForm } from "react-hook-form";
import { useNavigate } from "react-router";
function FormCreateCorporationStepOne() {
    const navigate = useNavigate()
    const { register, handleSubmit, formState: { errors }} = useForm<EmpresaCreateDto>();
    const onSubmit: SubmitHandler<EmpresaCreateDto> = data => {
        console.log(data)
        localStorage.setItem("data", JSON.stringify(data))  
        navigate("/CriarDetalhes")
    };
    return (
        <div className="h-screen bg-white w-2xl xl:min-w-3xl md:min-w-xl flex justify-center  items-center">
            <div className="w-full max-w-md p-9 md:p-0">
                <div className="">
                    <h1 className="md:text-3xl text-2xl font-semibold md:mb-1">Criar sua conta corporativa</h1>
                    <p className="text-sm">Já tem uma conta? <a href="#" className="text-blue-600">Entre aqui</a></p>
                </div>
                <div className="">
                    <form onSubmit={handleSubmit(onSubmit)} className="sm:mt-10 mt-6 space-y-4 text-gray-600">
                        <div>
                            <p>Nome Fantasia Da Empresa</p>
                            <InputPersonalized type="text" {...register("nomeFantasia", {required: true})}/>
                            {errors?.nomeFantasia?.type === "required" && <p className="text-red-600 text-sm">Nome da empresa está vázio.</p>}
                        </div>
                        <div>
                            <p>CNPJ</p>
                            <InputPersonalized type="text" {...register("cnpj", {required: true, minLength: 14,})}/>
                            {errors?.cnpj?.type === "required" && <p className="text-red-600 text-sm">CNPJ inválido</p>}
                            {errors?.cnpj?.type === "minLength" && <p className="text-red-600 text-sm">CNPJ inválido</p>}
                        </div>
                        <div>
                            <p>Email</p>
                            <InputPersonalized type="email" {...register("email", { required: true })}/>
                            {errors?.email?.type === "required" && <p className="text-red-600 text-sm">Email inválido</p>}
                        </div>
                        <div>
                            <p>Senha</p>
                            <InputPersonalized type="password"/>
                        </div>
                        <p className="text-sm mt-6">Ao criar essa conta você concordar com os 
                        termos de uso e com as politicas de privacidade.</p>
                        <button type="submit" className="w-xs mx-auto block bg-blue-500 text-white p-3 mt-12 rounded-4xl hover:bg-blue-700 font-semibold">Criar conta</button>
                    </form>
                </div>
            </div>
        </div>
    )
}
export default FormCreateCorporationStepOne;
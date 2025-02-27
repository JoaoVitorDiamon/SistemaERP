import InputPersonalized from "./InputPersonalized";
import { SubmitHandler, useForm } from "react-hook-form";
import ProgressBar from "./ProgressBar";
import { useNavigate } from "react-router-dom";
import { useEffect } from "react";
import { ResponsePostDto } from "../../models/ResponsePostDto"
import { EmpresaCreateDto } from "../../models/EmpresaCreateDto";
interface Representante {
    Name: String;
    CPF: String;
    EmailRepresentante: String;
  }
function FormCreateCorporationStepThree() {
    const navigate = useNavigate()
    const empresa = localStorage.getItem("data")
    const { register, setFocus, setValue, handleSubmit, formState: { errors }} = useForm<Representante>();
    const onSubmit: SubmitHandler<Representante> = async (data) => {
        console.log(data)
        if(await VerificarCPF(data.CPF)){
            setFocus("CPF")
            setValue("CPF", "")
        }
        else if(await VerificarEmail(data.EmailRepresentante)){
            setFocus("EmailRepresentante")
            setValue("EmailRepresentante", "")
        }
        else if(empresa){
            let empresaLocalStorage = JSON.parse(empresa);
            console.log(empresaLocalStorage)
            let representante = {Name:data.Name, CPF:data.CPF, EmailRepresentante:data.EmailRepresentante}
            let idDono = (await CriarRepresentante(representante)).valor.id
            console.log(idDono)
            let empresa_dto : EmpresaCreateDto = {
                "name": empresaLocalStorage.name,
                "nomeFantasia" : empresaLocalStorage.nomeFantasia,
                "idDono" : idDono,
                "cnpj": empresaLocalStorage.cnpj,
                "email" : empresaLocalStorage.email,
                "endereco" : empresaLocalStorage.endereco,
                "cep" : empresaLocalStorage.cep,
                "idTipoDeEmpresa" : empresaLocalStorage.idTipoDeEmpresa,
                "idSetor" : empresaLocalStorage.idSetor,
                "telefone" : "123123",
                "dataCriacao" : "2025-02-27T00:02:24.239Z"
            }
            await CriarEmpresa(empresa_dto)
            localStorage.setItem("data", JSON.stringify(empresaLocalStorage))
            console.log(empresaLocalStorage)
        }
    };
    useEffect(()=>{
        if(!empresa){
            navigate("/CriarEmpresa")
        }
    }, [])

    async function VerificarCPF(cpf:String) : Promise<boolean>{
        var response = await fetch(`https://localhost:7106/api/Usuario/CPF/${cpf}`,{
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            },
        })
        const result = await response.json();
        return result.valor === "Usado";
    }
    async function VerificarEmail(email:String) : Promise<boolean>{
        var response = await fetch(`https://localhost:7106/api/Usuario/Email/${email}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            },
        })
        const result = await response.json()
        return result.valor === "Usado"
    }
    async function CriarRepresentante(representante:Representante) : Promise<ResponsePostDto>{
        var response = await fetch(`https://localhost:7106/api/Usuario`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(
                {
                    Name:representante.Name, 
                    CPF:representante.CPF, 
                    Email:representante.EmailRepresentante
                })
        })
        const result = await response.json()
        return result
    }
    async function CriarEmpresa(novaEmpresa:EmpresaCreateDto){
        var response = await fetch(`https://localhost:7106/api/Empresa`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(novaEmpresa)
        })
        const result = await response.json()
        console.log(result)
    }
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
                            <InputPersonalized type="text" {...register("Name", { required: true })}/>
                            {errors?.Name?.type === "required" && <p className="text-red-600 text-sm">Campo vázio</p>}
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
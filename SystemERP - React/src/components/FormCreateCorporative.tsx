import InputPersonalized from "./InputPersonalized";
import {EmpresaCreateDto} from "../../models/EmpresaCreateDto"
import { useState } from "react";
function FormCreateCorporative() {
    const [nome, setNome] = useState("");
    const [cnpj, setCNPJ] = useState("");
    const [email, setEmail] = useState("");
    let empresa : EmpresaCreateDto
    function criarConta(){
        if(nome.length < 3){
            console.log("Nome em branco")
        }
        else if(cnpj.length != 14){
            console.log("CNPJ inválido")
        }
        else if(email.length < 3){
            console.log("Email inválido")
        }
        else{
            empresa = {
                name: nome,
                cnpj: cnpj,
                email: email
            }
            console.log(empresa.name)
        }
    }
    return (
        <div className="h-screen bg-white w-2xl xl:min-w-3xl md:min-w-xl flex justify-center  items-center">
            <div className="w-full max-w-md p-9 md:p-0">
                <div className="">
                    <h1 className="md:text-3xl text-2xl font-semibold md:mb-1">Criar sua conta corporativa</h1>
                    <p className="text-sm">Já tem uma conta? <a href="#" className="text-blue-600">Entre aqui</a></p>
                </div>
                <div className="">
                    <form action={criarConta} className="sm:mt-10 mt-6 space-y-4 text-gray-600">
                        <div>
                            <p>Nome Da Empresa</p>
                            <InputPersonalized type="text" value={nome} onChange={(event)=> {
                                setNome(event.target.value)
                            }}/>
                        </div>
                        <div>
                            <p>CNPJ</p>
                            <InputPersonalized type="text" value={cnpj} onChange={(event) => {
                                setCNPJ(event.target.value)
                            }}/>
                        </div>
                        <div>
                            <p>Email</p>
                            <InputPersonalized type="email" value={email} onChange={(event) => {
                                setEmail(event.target.value)
                            }}/>
                        </div>
                        <div>
                            <p>Senha</p>
                            <InputPersonalized type="password"/>
                        </div>
                        <p className="text-sm">Ao criar essa conta você concordar com os 
                        termos de uso e com as politicas de privacidade.</p>
                        <button type="submit" className="w-xs mx-auto block bg-blue-500 text-white p-3 mt-12 rounded-4xl hover:bg-blue-700 font-semibold">Criar conta</button>
                    </form>
                </div>
            </div>
        </div>
    )
}
export default FormCreateCorporative;
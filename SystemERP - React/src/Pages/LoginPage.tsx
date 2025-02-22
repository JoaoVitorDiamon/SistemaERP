import FormLogin from "../components/FormLogin"

function LoginPage(){
    return(
        <div className='h-screen flex justify-items-end'>
            <div className="w-screen h-screen bg-gradient-to-tr from-blue-700 via-sky-400 to-teal-300"></div>
            <FormLogin />
        </div>
    )
    
}
export default LoginPage
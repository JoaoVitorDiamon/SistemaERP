import InputPersonalized from "../InputPersonalized";
import { SubmitHandler, useForm } from "react-hook-form";
interface IFormInput {
  Email: string;
  Senha: string;
}
function FormLogin() {
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm<IFormInput>();
  const onSubmit: SubmitHandler<IFormInput> = (data) => console.log(data);

  return (
    <div className="h-screen rounded-4xl bg-white w-2xl xl:min-w-3xl md:min-w-xl flex flex-col justify-center items-center">
      <div className="w-full max-w-md p-9 md:p-0 flex-grow flex flex-col justify-center">
        <h1 className="md:text-3xl text-2xl font-poppins font-semibold md:mb-1 text-center">
          Entre com sua conta
        </h1>
        <div className="">
          <form
            onSubmit={handleSubmit(onSubmit)}
            className="sm:mt-10 mt-6 space-y-4 text-gray-600"
          >
            <div>
              <label className="font-poppins font-medium">Email ou CNPJ</label>
              <InputPersonalized
                type="email"
                {...register("Email", { required: true })}
              />
              {errors?.Email?.type === "required" && (
                <p className="font-poppins mt-1  font-bold text-red-600 text-sm">Email ou cnpj inválidos</p>
              )}
            </div>
            <div>
              <label className="font-poppins font-medium">Senha</label>
              <InputPersonalized
                type="password"
                {...register("Senha", { required: true })}
              />
              {errors?.Senha?.type === "required" && (
                <p className=" font-poppins font-bold mt-1 text-red-600 text-sm">Senha inválida.</p>
              )}
            </div>
            <button
              type="submit"
              className="w-xs mx-auto block font-poppins font-bold bg-blue-500 text-white p-3 mt-12 rounded-4xl hover:bg-blue-700"
            >
              Entrar
            </button>
            <div className="flex justify-between items-center mt-16">
              <div className="flex items-center">
                <input type="checkbox" />
                <p className="text-sm ml-2 font-poppins font-medium">Lembrar de mim</p>
              </div>
              <a href="#" className="text-sm font-poppins font-medium">
                Ajuda?
              </a>
            </div>
          </form>
        </div>
      </div>
      <p className="text-sm text-center font-poppins pb-12">
        Não tem conta?{" "}
        <a href="#" className="font-bold font-poppins underline">
          Crie aqui
        </a>
      </p>
      <p className="text-sm text-center font-poppins pb-4">
        Essa página é protegida pelo Google reCAPTCHA para garantir que você não
        é um bot.{" "}
        <a href="#" className="font-poppins font-semibold">
          Saiba mais.
        </a>
      </p>
    </div>
  );
}
export default FormLogin;

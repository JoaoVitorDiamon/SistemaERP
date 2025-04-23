import InputPersonalized from "@/components/InputPersonalized";
import { useFormCorporation } from "./useFormCorporation";


function FormCreateCorporationStepOne() {
  const { register, handleSubmit, onSubmit, errors } = useFormCorporation();

  return (
    <div className="h-screen bg-white w-2xl xl:min-w-3xl md:min-w-xl flex justify-center items-center">
      <div className="w-full max-w-md p-9 md:p-0">
        <h1 className="md:text-3xl text-2xl font-semibold md:mb-1">Criar sua conta corporativa</h1>
        <p className="text-sm">Já tem uma conta? <a href="#" className="text-blue-600">Entre aqui</a></p>

        <form onSubmit={handleSubmit(onSubmit)} className="sm:mt-10 mt-6 space-y-4 text-gray-600">
          <div>
            <p>Nome Fantasia Da Empresa</p>
            <InputPersonalized type="text" {...register("nomeFantasia", { required: true })} />
            {errors?.nomeFantasia && <p className="text-red-600 text-sm">Nome da empresa está vázio.</p>}
          </div>

          <div>
            <p>CNPJ</p>
            <InputPersonalized type="text" {...register("cnpj", { required: true, minLength: 14 })} />
            {errors?.cnpj && <p className="text-red-600 text-sm">CNPJ inválido</p>}
          </div>

          <div>
            <p>Email</p>
            <InputPersonalized type="email" {...register("email", { required: true })} />
            {errors?.email && <p className="text-red-600 text-sm">Email inválido</p>}
          </div>

          <div>
            <p>Senha</p>
            <InputPersonalized type="password" {...register("Senha", { required: true })} />
            {errors?.Senha && <p className="text-red-600 text-sm">Senha inválida</p>}
          </div>

          <p className="text-sm mt-6">Ao criar essa conta você concorda com os termos de uso e com as políticas de privacidade.</p>
          <button type="submit" className="w-xs mx-auto block bg-blue-500 text-white p-3 mt-12 rounded-4xl hover:bg-blue-700 font-semibold">
            Criar conta
          </button>
        </form>
      </div>
    </div>
  );
}

export default FormCreateCorporationStepOne;

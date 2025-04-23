import InputPersonalized from "../../InputPersonalized";
import ProgressBar from "../ProgressBar";
import { useFormCorporationStepThree } from "./useFormCorporationStepThree";

function FormCreateCorporationStepThree() {
  const { register, handleSubmit, onSubmit, errors } = useFormCorporationStepThree();

  return (
    <div className="h-screen rounded-4xl bg-white w-2xl xl:min-w-3xl md:min-w-xl flex flex-col justify-center items-center">
      <div className="flex mb-24">
        <ProgressBar step="STEP 1" descricao="Dado da Empresa" estado="Completado" />
        <ProgressBar step="STEP 2" descricao="Endereço" estado="Completado" />
        <ProgressBar step="STEP 3" descricao="Payment info" estado="Progresso" />
      </div>

      <div className="w-full max-w-md p-9 md:p-0">
        <h1 className="md:text-3xl text-2xl font-semibold md:mb-16 text-center">Representante Legal da empresa</h1>

        <form onSubmit={handleSubmit(onSubmit)} className="sm:mt-10 mt-6 space-y-4 text-gray-600">
          <div>
            <label>Nome do representante</label>
            <InputPersonalized type="text" {...register("Name", { required: true })} />
            {errors?.Name && <p className="text-red-600 text-sm">Campo vazio</p>}
          </div>

          <div>
            <label>CPF do representante</label>
            <InputPersonalized type="text" {...register("CPF", { required: true })} />
            {errors?.CPF && <p className="text-red-600 text-sm">CPF inválido</p>}
          </div>

          <div>
            <label>Email do representante</label>
            <InputPersonalized type="email" {...register("EmailRepresentante", { required: true })} />
            {errors?.EmailRepresentante && <p className="text-red-600 text-sm">Email inválido</p>}
          </div>

          <button type="submit" className="w-xs mx-auto block bg-blue-500 text-white p-3 mt-18 rounded-4xl hover:bg-blue-700">
            Concluir
          </button>
        </form>
      </div>
    </div>
  );
}

export default FormCreateCorporationStepThree;

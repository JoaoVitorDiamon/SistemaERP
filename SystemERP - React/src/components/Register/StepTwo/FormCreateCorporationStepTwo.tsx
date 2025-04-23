import InputPersonalized from "../../InputPersonalized";
import ProgressBar from "../ProgressBar";
import { useFormCorporationStepTwo } from "./useFormCorporationStepTwo";

function FormCreateCorporationStepTwo() {
  const { tiposdeempresa, setores, register, handleSubmit, onSubmit, errors } = useFormCorporationStepTwo();

  return (
    <div className="h-screen bg-white w-2xl xl:min-w-3xl min-w-xl flex flex-col justify-center items-center">
      <div className="flex mb-24">
        <ProgressBar step="STEP 1" descricao="Dado da Empresa" estado="Progresso" />
        <ProgressBar step="STEP 2" descricao="Endereço" estado="Pendente" />
        <ProgressBar step="STEP 3" descricao="Payment info" estado="Pendente" />
      </div>

      <div className="w-full max-w-md p-9 md:p-0">
        <h1 className="md:text-3xl text-2xl text-center font-semibold md:mb-1">Detalhes da empresa</h1>

        <form onSubmit={handleSubmit(onSubmit)} className="sm:mt-10 mt-6 space-y-4 text-gray-600">
          <div>
            <p>Setor da Empresa</p>
            <select {...register("idSetor", { required: true })} className="w-full p-3 border mt-1 border-gray-300 rounded-[8px] focus:outline-none focus:ring-2 focus:ring-blue-300">
              <option value=""></option>
              {setores.valor.map((option: any) => (
                <option value={option.idSetor} key={option.idSetor}>{option.nome}</option>
              ))}
            </select>
            {errors?.idSetor && <p className="text-red-600 text-sm">Setor está vázio.</p>}
          </div>

          <div>
            <p>Tipo da Empresa</p>
            <select {...register("idTipoDeEmpresa", { required: true })} className="w-full p-3 border mt-1 border-gray-300 rounded-[8px] focus:outline-none focus:ring-2 focus:ring-blue-300">
              <option value=""></option>
              {tiposdeempresa.valor.map((option: any) => (
                <option value={option.idTipoDeEmpresa} key={option.idTipoDeEmpresa}>{option.name}</option>
              ))}
            </select>
            {errors?.idTipoDeEmpresa && <p className="text-red-600 text-sm">Tipo de empresa está vázio.</p>}
          </div>

          <div>
            <p>Razão social</p>
            <InputPersonalized type="text" {...register("name", { required: true })} />
            {errors?.name && <p className="text-red-600 text-sm">Razão Social inválida</p>}
          </div>

          <button type="submit" className="w-xs mx-auto block bg-blue-700 text-white p-3 mt-12 rounded-4xl hover:bg-blue-800 font-semibold">
            Próximo
          </button>
        </form>
      </div>
    </div>
  );
}

export default FormCreateCorporationStepTwo;

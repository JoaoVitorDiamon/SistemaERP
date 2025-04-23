import { useEffect, useState } from "react";
import { useForm, SubmitHandler } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import { EmpresaCreateDto } from "../../../../models/EmpresaCreateDto";
import { buscarSetores, buscarTiposDeEmpresa } from "./services";

export function useFormCorporationStepTwo() {
  const navigate = useNavigate();
  const empresa = localStorage.getItem("data");

  const [tiposdeempresa, setTiposDeEmpresa] = useState({ valor: [], mensagem: null, status: true });
  const [setores, setSetores] = useState({ valor: [], mensagem: null, status: true });

  const { register, handleSubmit, formState: { errors } } = useForm<EmpresaCreateDto>();

  useEffect(() => {
    if (!empresa) {
      navigate("/create-corporation");
      return;
    }

    buscarSetores()
      .then(data => setSetores(data))
      .catch(err => console.error(err));

    buscarTiposDeEmpresa()
      .then(data => setTiposDeEmpresa(data))
      .catch(err => console.error(err));
  }, []);

  const onSubmit: SubmitHandler<EmpresaCreateDto> = (data) => {
    const { name, idSetor, idTipoDeEmpresa } = data;
    if (empresa) {
      const empresaLocal = JSON.parse(empresa);
      Object.assign(empresaLocal, { name, idSetor, idTipoDeEmpresa });
      localStorage.setItem("data", JSON.stringify(empresaLocal));
      navigate("/crete-corporation-step-endereco");
    }
  };

  return {
    tiposdeempresa,
    setores,
    register,
    handleSubmit,
    onSubmit,
    errors,
  };
}

import { useForm, SubmitHandler } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import { useEffect } from "react";
import { jaExisteCNPJ, jaExisteEmail } from "./services";

export interface Representante {
  nomeFantasia: string;
  cnpj: string;
  email: string;
  Senha: string;
}

export function useFormCorporation() {
  const navigate = useNavigate();
  const { register, setValue, setFocus, handleSubmit, formState: { errors } } = useForm<Representante>();

  useEffect(() => {
    localStorage.clear();
  }, []);

  const onSubmit: SubmitHandler<Representante> = async (data) => {
    if (await jaExisteCNPJ(data.cnpj)) {
      setFocus("cnpj");
      setValue("cnpj", "");
      return;
    }

    if (await jaExisteEmail(data.email)) {
      setFocus("email");
      setValue("email", "");
      return;
    }

    localStorage.setItem("data", JSON.stringify(data));
    navigate("/crete-corporation-step-two");
  };

  return {
    register,
    handleSubmit,
    onSubmit,
    errors,
  };
}

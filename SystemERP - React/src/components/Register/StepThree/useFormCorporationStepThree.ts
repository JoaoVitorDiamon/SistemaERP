import { useEffect } from "react";
import { useForm, SubmitHandler } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import { EmpresaCreateDto } from "../../../models/EmpresaCreateDto";
import { ResponsePostDto } from "../../../models/ResponsePostDto";
import {
  verificarCPF,
  verificarEmail,
  criarRepresentante,
  criarEmpresa
} from "./services";

interface Representante {
  Name: string;
  CPF: string;
  EmailRepresentante: string;
  Senha?: string;
}

export function useFormCorporationStepThree() {
  const navigate = useNavigate();
  const empresa = localStorage.getItem("data");

  const {
    register,
    setFocus,
    setValue,
    handleSubmit,
    formState: { errors },
  } = useForm<Representante>();

  useEffect(() => {
    if (!empresa) {
      navigate("/CriarEmpresa");
    }
  }, []);

  const onSubmit: SubmitHandler<Representante> = async (data) => {
    if (await verificarCPF(data.CPF)) {
      setFocus("CPF");
      setValue("CPF", "");
      return;
    }

    if (await verificarEmail(data.EmailRepresentante)) {
      setFocus("EmailRepresentante");
      setValue("EmailRepresentante", "");
      return;
    }

    if (empresa) {
      const empresaStorage = JSON.parse(empresa);
      const representante = {
        ...data,
        Senha: empresaStorage.Senha,
      };

      const representanteCriado: ResponsePostDto = await criarRepresentante(representante);
      const idDono = representanteCriado.valor.id;

      const empresaDto: EmpresaCreateDto = {
        ...empresaStorage,
        idDono,
        telefone: "123123", // TODO: ajustar com dado real
        dataCriacao: new Date().toISOString(),
      };

      await criarEmpresa(empresaDto);
      localStorage.setItem("data", JSON.stringify(empresaStorage));
      navigate("/dashboard");
    }
  };

  return {
    register,
    handleSubmit,
    onSubmit,
    errors,
  };
}

import { useEffect, useState } from "react";
import { useForm, SubmitHandler } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import { ICep, buscarEnderecoPorCep } from "./service";

export function useFormCorporationStepEndereco() {
  const navigate = useNavigate();
  const empresa = localStorage.getItem("data");

  const [cepDados, setCepDados] = useState<ICep>();
  const [cep, setCep] = useState("");

  const {
    register,
    setValue,
    handleSubmit,
    formState: { errors },
  } = useForm<ICep>();

  useEffect(() => {
    if (!empresa) navigate("/CriarEmpresa");
    if (cepDados) {
      setValue("estado", cepDados.estado);
      setValue("localidade", cepDados.localidade);
      setValue("logradouro", cepDados.logradouro);
    }
  }, [cepDados]);

  const viaCEP = async () => {
    const data = await buscarEnderecoPorCep(cep);
    if (data) {
      setCepDados(data);
      setCep(data.cep || cep);
    }
  };

  const onSubmit: SubmitHandler<ICep> = (data) => {
    viaCEP();
    if (cepDados) {
      const enderecoFormatado = `${cepDados.logradouro}, ${data.numero} - ${cepDados.bairro}, ${cepDados.localidade} - ${cepDados.estado}`;
      if (empresa != null) {
        const empresaParsed = JSON.parse(empresa);
        Object.assign(empresaParsed, { endereco: enderecoFormatado, cep });
        localStorage.setItem("data", JSON.stringify(empresaParsed));
        navigate("/CadastroRepresentante");
      }
    }
  };

  return {
    cep,
    setCep,
    register,
    handleSubmit,
    onSubmit,
    viaCEP,
    errors,
  };
}

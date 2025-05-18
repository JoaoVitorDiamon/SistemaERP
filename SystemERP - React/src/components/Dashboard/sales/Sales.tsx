import { ButtonExport } from "./ButtonExport";
import { SalesCard } from "./SalesCard";

export const Sales = () => {
  return (
    <div className=" flex flex-col  ml-8 mt-8">
      <div className="flex flex-row items-center justify-between">
        <div>
          <h1 className="font-poppins font-bold text-2xl text-dashboard">
            Vendas
          </h1>
          <span className="font-poppins font-semibold text-gray-400">
            Resumo das Vendas
          </span>
        </div>

        <div>
          <ButtonExport />
        </div>
      </div>

      <div className="flex flex-row gap-2 mt-5">
        <SalesCard
          logo="../../../../assets/salesIcon.svg"
          titlePrimary="R$ 1k"
          titleSecond="Total de Vendas"
          thirdTitle="+8% nessa semana"
          background="#FFE2E5"
        />
        <SalesCard
          logo="../../../../assets/orderIcon.svg"
          titlePrimary="300"
          titleSecond="Total de Pedidos"
          thirdTitle="+8% nessa semana"
          background="#FFF4DE"
        />
        <SalesCard
          logo="../../../../assets/product.svg"
          titlePrimary="505"
          titleSecond="Produtos "
          thirdTitle="+8% nessa semana"
          background="#DCFCE7"
        />
        <SalesCard
          logo="../../../../assets/client.svg"
          titlePrimary="805"
          titleSecond="Novos Clientes"
          thirdTitle="+8% nessa semana"
          background="#F3E8FF"
        />
      </div>
    </div>
  );
};

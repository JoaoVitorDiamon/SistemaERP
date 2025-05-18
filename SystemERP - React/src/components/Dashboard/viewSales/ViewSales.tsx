import { ChartSales } from "./chartsSales";

export const ViewSales = () => {
  return (
    <div className="flex flex-col  ml-8 mt-8">
      <h1 className="font-poppins font-bold text-2xl ml-4 text-[#007AFF]">
        Visualização das Vendas
      </h1>
      <span className="font-poppins font-semibold text-gray-400 ml-4">
        <span className="font-poppins font-semibold text-[#48BB78]">
          (+5) mais
        </span>
         <span> em 2025</span>
      </span>

        <div>
          <ChartSales/>
        </div>
    </div>
  );
};

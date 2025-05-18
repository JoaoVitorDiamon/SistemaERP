import { TrackOrder } from "./trackOrder";

export const OrderDetails = () => {
  return (
    <div className="flex flex-col  ml-50 mt-10">
      <div className="">
        <h1 className="font-poppins font-bold text-2xl ml-4 text-[#007AFF]">
          Detalhes dos Pedidos
        </h1>
        <span className="font-poppins font-semibold text-gray-400 ml-4">
          <span className="font-poppins font-semibold text-[#48BB78]">
            +30%
          </span>
          <span className="font-poppins font-semibold text-gray-400">
            {" "}
            nesse mes
          </span>
        </span>
        <div className="mt-10">
          <TrackOrder />
        </div>
      </div>
    </div>
  );
};

import { MostSellerHeader } from "./MostSellerHeader";
import { MostSellerTable } from "./MostSellerTable";

export const MostSeller = () => {
  return (
    <div>
      <div className="flex flex-col bg-background  w-full justify-start items-left mt-8 ml-8">
        <h1 className="text-2xl font-bold font-poppins  mt-4 text-dashboard">
          Produtos mais vendidos
        </h1>
        <MostSellerHeader />
        <MostSellerTable index={1} name="Freeco" popularity={50} sales={80} />
        <MostSellerTable index={2} name="Computador" popularity={50} sales={80} />
        <MostSellerTable index={3} name="Oreruela" popularity={50} sales={80} />
        <MostSellerTable index={4} name="Maniaco do parque" popularity={50} sales={80} />
      </div>
    </div>
  );
};

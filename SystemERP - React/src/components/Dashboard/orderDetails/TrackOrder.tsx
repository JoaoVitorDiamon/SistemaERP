import { TrackTitle } from "./TrackTitle";

export const TrackOrder = () => {
  return (
    <div>
      <div className="flex flex-row">
        <div className="flex flex-col justify-center items-center">
          <img src="../../../../assets/sino.svg" alt="" width={25} height={25}/>
          <img src="../../../../assets/linha.svg" alt="" width={6} height={6} />
          <img src="../../../../assets/css.svg" alt="" width={26} height={26}/>
          <img src="../../../../assets/linha.svg" alt="" width={6} height={6} />
          <img src="../../../../assets/carinho.svg" alt="" width={26} height={26}/>
          <img src="../../../../assets/linha.svg" alt=""  width={6} height={6}/>
          <img src="../../../../assets/cartao.svg" alt="" width={25} height={25}/>
          <img src="../../../../assets/linha.svg" alt=""  width={6} height={6}/>
        </div>

        <div className="flex flex-col gap-7">
          <TrackTitle title="R$2400, Mudança no Design" date="22 DEC 7:20 PM" />
          <TrackTitle title="Novo Pedido #4219423" date="21 DEC 11:21 PM" />
          <TrackTitle title="Pagamento de Abril" date="21 DEC 9:28 PM" />
          <TrackTitle title="Novo cartao adicionado" date="20 DEC 3:52 PM" />
        </div>
      </div>
    </div>
  );
};

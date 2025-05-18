interface SalesCardProps {
  logo: string;
  titlePrimary: string;
  titleSecond: string;
  thirdTitle: string;
  background: string;
}

export const SalesCard = ({ ...cardProps }: SalesCardProps) => {
  return (
    <div
      style={{ backgroundColor: cardProps.background }}
      className="w-[180px] h-[200px] rounded-[16px] flex flex-col justify-center gap-3 items-center "
    >
      <div className=" flex  flex-col  gap-1.5">
        <div className="mb-3">
          <img src={cardProps.logo} alt="" />
        </div>
        <h1 className="text-2xl font-poppins text-[#151D48] font-bold">
          {cardProps.titlePrimary}
        </h1>
        <h3 className="text-[18px] font-poppins font-bold text-[#425166]">
          {cardProps.titleSecond}
        </h3>
        <h4 className="text-[15px] font-poppins font-bold text-[#4079ED]">
          {cardProps.thirdTitle}
        </h4>
      </div>
    </div>
  );
};

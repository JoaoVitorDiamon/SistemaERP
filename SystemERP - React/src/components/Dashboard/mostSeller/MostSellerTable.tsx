import ProgressBar from "@ramonak/react-progress-bar";

interface MostSellerTableProps {
  index: number;
  name: string;
  popularity: number;
  sales: number;
}

export const MostSellerTable = ({ ...seller }: MostSellerTableProps) => {
  const colors = [
    "#FF5733",
    "#33FF57",
    "#3357FF",
    "#FF33A1",
    "#FF8C33",
    "#33FFF5",
  ];

  return (
    <div className="grid grid-cols-4 items-center h-8  w-full gap-4 mt-2 px-4">
      <h3 className="text-gray-500 font-poppins">{seller.index}</h3>
      <h3 className="text-gray-500 font-poppins">{seller.name}</h3>
      <div className="w-3/4">
        <ProgressBar
          completed={seller.popularity}
          bgColor={colors[seller.index % colors.length]}
          height="6px"
          labelSize="10px"
          isLabelVisible={false}
        />
      </div>
      <div
        className="w-20 rounded-full  text-center"
        style={{
          border: `2px solid ${colors[seller.index % colors.length]}`,
          backgroundColor: `${colors[seller.index % colors.length]}10`,
        }}
      >
        <h3
          style={{ color: colors[seller.index % colors.length] }}
          className="text-sm font-medium"
        >
          {seller.sales}%
        </h3>
      </div>
    </div>
  );
};

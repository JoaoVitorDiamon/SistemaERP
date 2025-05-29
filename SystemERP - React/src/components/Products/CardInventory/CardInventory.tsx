interface CardProps {
    index: number,
    title1: string,
    value1: string,
    value2?: string,
    status1: string,
    status2?: string
}

const titleColors = ["#1570EF", "#E19133", "#845EBC", "#F36960"];


export default function CardInventory({ ...cards }: CardProps) {
    return (
        <div className="flex flex-row mt-6 gap-6">
            {cards.status2 == "" && cards.value2 == "" ?
                (
                    <div className="flex flex-col mt-4 gap-5">
                        <h1 className="text-[16px] font-poppins font-bold" style={{ color: titleColors[cards.index % titleColors.length] }}>{cards.title1}</h1>
                        <span className="text-sm">{cards.value1}</span>
                        <span className="text-sm text-nav">{cards.status1}</span>
                    </div>
                ) :
                (
                    <div className="flex flex-row items-end gap-6">
                        <div className="bg-nav w-[2px] h-26 mt-4 rounded-2xl">
                        </div>
                        <div className="flex flex-col mt-4 gap-5">
                            <h1 className="text-[16px] font-poppins font-bold" style={{ color: titleColors[cards.index % titleColors.length] }}>{cards.title1}</h1>
                            <span className="text-sm">{cards.value1}</span>
                            <span className="text-sm text-nav">{cards.status1}</span>
                        </div>
                        <div className="flex flex-col mt-4 gap-5">
                            <span className="text-sm">{cards.value2}</span>
                            <span className="text-sm text-nav">{cards.status2}</span>
                        </div>
                    </div>
                )
            }
        </div>
    );
}
import { data } from "./CardData";
import CardInventory from "./CardInventory";

export default function InventoryStats(){
    return(
        <div className="flex flex-col mt-6">
            <h1>Inventario</h1>
            <div className="flex flex-row gap-4">
                {data.map((item, index) => (
                    <div key={index}>
                        <CardInventory
                        index={item.id}
                        title1={item.title1}
                        status1={item.status1}
                        status2={item.status2}
                        value1={item.value1}
                        value2={item.value2}
                        />
                    </div>
                ))}
            </div>
        </div>
    );
}
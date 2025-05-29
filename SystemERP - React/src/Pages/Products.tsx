import InputSearch from "@/components/InputSearch";
import { NavSide } from "@/components/Nav/SideNav";
import InventoryStats from "@/components/Products/CardInventory/InventoryStats";
import ProductsCard from "@/components/Products/ProductsCards/ProductsCard";

export default function Products(){
    return(
        <div className="flex flex-row gap-10">
            <NavSide/>
            <div>
                <InputSearch/>
                <InventoryStats/>
                <ProductsCard/>
            </div>
        </div>
    );
}
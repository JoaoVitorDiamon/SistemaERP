import { MostSeller } from "@/components/Dashboard/mostSeller/MostSeller"
import { NavSide } from "@/components/Nav/SideNav"


export const Dashboard = () => {
    return(
        <div className="flex flex-row bg-background h-screen">
            <NavSide/>
            <MostSeller/>
        </div>
    )
}

import { CustomerSatisfation } from "@/components/Dashboard/customerSatisfaction/CustomerSatisfaction"
import { MostSeller } from "@/components/Dashboard/mostSeller/MostSeller"
import { OrderDetails } from "@/components/Dashboard/orderDetails/OrderDetails"
import { Sales } from "@/components/Dashboard/sales/Sales"
import { ViewSales } from "@/components/Dashboard/viewSales/ViewSales"
import { NavSide } from "@/components/Nav/SideNav"


export const Dashboard = () => {
    return(
        <div className="flex flex-row bg-background h-screen">
            <NavSide/>
            <div className="flex flex-row">

            <div className="flex flex-col">
            <MostSeller/>
            <Sales/>
            <ViewSales/>
            </div>

            <div className="flex flex-col items-center ">
              <OrderDetails/>
              <CustomerSatisfation/>
            </div>


            </div>
        </div>
    )
}

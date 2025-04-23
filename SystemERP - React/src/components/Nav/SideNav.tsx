import { CalendarIcon } from "../Icons/calendarIcon"
import { BankIcon } from "../Icons/bankIcon"
import { DashboardIcon } from "../Icons/dashboardIcon"
import { EmailIcon } from "../Icons/emailIcon"
import { InvoiceIcon } from "../Icons/invoiceIcon"
import Logo from "../Icons/logo"
import { MrpIcon } from "../Icons/mrpIcon"
import { OrderIcon } from "../Icons/orderIcon"
import { ProductIcon } from "../Icons/productIcon"
import { TeamsIcon } from "../Icons/teamsIcon"
import { ThirtyPartyIcon } from "../Icons/thirtyPartyIcon"
import { NavItem } from "./NavItens"


export const NavSide = () => {
    return (
        <div className="flex flex-col w-64 h-screen  text-white mt-6">
            <div className="flex items-center justify-center h-16">
                <Logo/>
            </div>
            <nav className="flex flex-col mt-4">
            <NavItem title="Dashboard" icon={(isActive) => <DashboardIcon isActive={isActive} />} url="/dashboard"/>
            <NavItem title="Terceiros" icon={(isActive) => <ThirtyPartyIcon isActive={isActive} />} url="/thirtyParty"/>
            <NavItem title="Produtos" icon={(isActive) => <ProductIcon isActive={isActive} />} url="/products"/>
            <NavItem title="MRP" icon={(isActive) => <MrpIcon isActive={isActive} />} url="/mrp"/>
            <NavItem title="Faturamento" icon={(isActive) => <InvoiceIcon isActive={isActive} />} url="/invoices"/>
            <NavItem title="Banco" icon={(isActive) => <BankIcon isActive={isActive} />} url="/bank"/>
            <NavItem title="Pedidos" icon={(isActive) => <OrderIcon isActive={isActive} />} url="/orders"/>
            <NavItem title="Email" icon={(isActive) => <EmailIcon isActive={isActive} />} url="/email"/>
            <NavItem title="Equipe" icon={(isActive) => <TeamsIcon isActive={isActive} />} url="/teams"/>
            <NavItem title="Calendario" icon={(isActive) => <CalendarIcon isActive={isActive} />} url="/calendar"/>
            </nav>
        </div>
    )


}

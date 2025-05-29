import { BankIcon } from "../Icons/bankIcon";
import { DashboardIcon } from "../Icons/dashboardIcon";
import { EmailIcon } from "../Icons/emailIcon";
import { OrderIcon } from "../Icons/orderIcon";
import { ProductIcon } from "../Icons/productIcon";
import { CalendarsIcon } from "../Icons/calendarIcon";

export const NavContent = [
  {
    title: "Dashboard",
    icon: (isActive: boolean) => <DashboardIcon isActive={isActive} />,
    url: "/dashboard",
  },
  {
    title: "Financeiro",
    icon: (isActive: boolean) => <BankIcon isActive={isActive} />,
    url: "/financy",
  },
  {
    title: "Vendas",
    icon: (isActive: boolean) => <OrderIcon isActive={isActive} />,
    url: "/vendas",
  },
  {
    title: "Produtos",
    icon: (isActive: boolean) => <ProductIcon isActive={isActive} />,
    url: "/products",
  },
  {
    title: "Contatos",
    icon: (isActive: boolean) => <EmailIcon isActive={isActive} />,
    url: "/contatos",
  },
  {
    title: "Calendário",
    icon: (isActive: boolean) => <CalendarsIcon isActive={isActive} />,
    url: "/calendario",
  },
];

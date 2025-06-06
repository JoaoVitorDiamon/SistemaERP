import Logo from "../Icons/logo";
import { NavItem } from "./NavItens";
import { NavContent } from "./ContentNav";
import { HelpCard } from "../helpCard";

export const NavSide = () => {
  return (
    <div className="flex flex-col w-64 h-screen items-center  text-white mt-6">
      <div className="flex items-center justify-center h-16">
        <Logo />
      </div>
      <nav className="flex flex-col mt-4">
        {NavContent.map((item, index) => (
          <div key={index}>
            <NavItem icon={item.icon} title={item.title} url={item.url} />
          </div>
        ))}
      </nav>

      <div className="flex  mt-42">
        <HelpCard />
      </div>
    </div>
  );
};

import { NavLink } from "react-router"


interface NavItemProps {
    title: string;
     icon: (isActive: boolean) => React.ReactNode;
     url: string;
}


export const NavItem: React.FC<NavItemProps> = ({ title, icon, url }) => {
    return (
      <div className="flex flex-col items-center gap-2 p-2 rounded-md cursor-pointer">
        <NavLink
          to={url}
          className={({ isActive }) =>
            isActive
              ? "flex items-center gap-2 text-white font-dmSans font-bold p-2 w-56 justify-center rounded-md bg-navIsActive transition-colors "
              : "flex items-center gap-2 text-navColor font-dmSans font-bold p-2 rounded-md"
          }
        >
          {({ isActive }) => (
            <>
              {icon(isActive)}
              {title}
            </>
          )}
        </NavLink>
      </div>
    );
  };


// className="flex items-center gap-2 text-navColor font-dmSans font-medium p-2 rounded-md hover:bg-gray-200 transition-colors duration-300

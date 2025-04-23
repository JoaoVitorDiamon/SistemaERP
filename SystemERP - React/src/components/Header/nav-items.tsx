import { JSX } from "react"

type NavItensProps = {
    name: string
    icon: JSX.Element
    url: string
}


export const NavItems =  ({...props}: NavItensProps) => {
    return(
        <div>
            <div className="flex flex-row gap-2 items-center text-gray-500 hover:text-gray-900 cursor-pointer">
                {props.icon}
                <a href={props.url}>
                    <span className="text-sm font-semibold">
                        {props.name}
                    </span>
                </a>
            </div>
    </div>
    )
}

function ProgressBar({step = 'STEP 1', descricao = 'Dados', estado = "Pendente"}){
    return(
        <div className="flex ml-4 flex-col">
            <div className="flex items-center">
                <div className={`rounded-3xl w-5 h-5 flex justify-center
                    ${estado === "Completado" ? "bg-[url(../../assets/StepSuccess.png)] bg-center bg-cover" : 
                    "bg-white border-[0.5px] border-blue-600"}`}>

                    <div className={`w-2.5 h-2.5 rounded-3xl m-auto 
                        ${estado === "Progresso" ? "bg-blue-600" : estado === "Completado" ? "w-0 h-0" : "bg-gray-400"}`}></div>
                </div>
                <div className={`xl:w-40 lg:w-30 w-25 h-[3px] ml-2 
                    ${estado === "Pendente" ? "bg-gray-400" : "bg-blue-600"} rounded-3xl`}></div>
            </div>
            <p className="text-[11px] text-gray-400 mt-2 font-medium">{step}</p>
            <p className="text-[12px] text-gray-400 font-bold">{descricao}</p>
            <p className={`text-[12px] ${estado === "Progresso" ? "text-blue-600" 
                : estado === "Completado" ? "text-green-500" 
                : "text-gray-400"} mt-2 font-medium`}>{estado}</p>
        </div>
    )
}

export default ProgressBar;
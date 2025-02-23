function ProgressBar({step = 'STEP 1', descricao = 'Dados', estado = "Em progresso", color = 'gray-400'}){
    return(
        <div className="flex ml-4 flex-col">
            <div className="flex items-center">
                <div className={`border-[0.5px] border-blue-500 rounded-3xl w-5 h-5 flex justify-center`}>
                    <div className={`w-2.5 h-2.5 rounded-3xl m-auto bg-${color}`}></div>
                </div>
                <div className={`xl:w-40 lg:w-30 w-25 h-[3px] ml-2 bg-${color} rounded-3xl`}></div>
            </div>
            <p className="text-[11px] text-gray-400 mt-2 font-medium">{step}</p>
            <p className="text-[12px] text-gray-400 font-bold">{descricao}</p>
            <p className={`text-[12px] text-${color} mt-2 font-medium`}>{estado}</p>
        </div>
    )
}

export default ProgressBar;
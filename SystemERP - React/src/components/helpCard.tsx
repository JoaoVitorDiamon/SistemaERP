export const HelpCard = () => {
  return (
    <div className="rounded-lg p-6 flex flex-col items-center ">
      <div className="bg-[url(../../assets/helpBackground.png)]  h-52 w-58  ml-2  bg-no-repeat bg-cover rounded-lg">
        <div className="bg-white w-[50px] h-[50px]  rounded-2xl flex items-center justify-center mt-4 ml-4">
          <img
            src="../../assets/interrogacao.svg"
            alt="Interrogacao"
          />
        </div>
        <div className="flex flex-col items-left justify-center mt-4 ">
          <h2>
            <span className="text-1xl font-bold text-white text-center ml-4">
              Precisa de ajuda?
            </span>
          </h2>
          <p className="text-sm font-semibold text-white mt-2 ml-4">
            Envie uma mensagem
          </p>

          <div className="flex items-center justify-center ">
            <button className="bg-white text-sm text-black font-semibold py-2 px-16 rounded-2xl  mt-4">
              Contato
            </button>
          </div>
        </div>
      </div>
    </div>
  );
};

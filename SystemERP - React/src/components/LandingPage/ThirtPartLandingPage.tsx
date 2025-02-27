import { motion } from "framer-motion";


export default function ThirtPartLandingPage() {
  return (
    <motion.div
      initial={{ opacity: 0, x: -100 }}
      whileInView={{ opacity: 1, x: 0 }}
      viewport={{ once: true, amount: 0.3 }}
      transition={{ duration: 1, ease: "easeOut" }}
      className="bg-gradient-to-r from-[#151934] to-[#060b27] text-white min-h-screen p-10 justify-center items-center"
    >
      <h1 className="text-white font-poppins text-center ml-5 text-[40px] font-bold  tracking-normal  ">Planos e beneficios</h1>

      <div className="grid grid-cols-4 justify-center items-center gap-5 mt-10">
        <div className="flex flex-col justify-center items-start gap-2">
          <svg width="31" height="37" viewBox="0 0 31 37" fill="none" xmlns="http://www.w3.org/2000/svg">
            <path fill-rule="evenodd" clip-rule="evenodd" d="M2.87278 0.950195H28.1268C29.3641 0.95762 30.3633 1.96281 30.3633 3.2002V12.5947C30.3982 22.7485 24.8135 32.0885 15.8523 36.8632C15.7437 36.9206 15.6226 36.9505 15.4998 36.9502C15.3773 36.9502 15.2567 36.9198 15.1488 36.8617C6.18627 32.089 0.600491 22.7487 0.636279 12.5947V3.2002C0.636257 1.96281 1.63541 0.95762 2.87278 0.950195ZM13.6998 22.9177L24.3498 12.8677C24.7394 12.4993 24.9028 11.951 24.7786 11.4294C24.6543 10.9077 24.2612 10.492 23.7473 10.3389C23.2334 10.1857 22.6769 10.3183 22.2873 10.6867L12.6948 19.7272L10.1718 17.1772C9.797 16.7859 9.24029 16.6271 8.71546 16.7618C8.19062 16.8965 7.77925 17.3039 7.63933 17.8273C7.4994 18.3508 7.65267 18.9091 8.04028 19.2877L11.5998 22.8817C12.1732 23.4635 13.1068 23.4795 13.6998 22.9177Z" fill="#4E2D92" />
          </svg>
          <h3 className="text-white font-poppins text-center  text-[20px] font-bold  tracking-normal  ">30 dias de garantia</h3>
        </div>
        <div className="flex flex-col justify-center items-center ">
          <h4 className="text-white font-poppins text-center  text-[20px] font-bold  tracking-normal  ">Gratis</h4>
          <h4 className="text-white font-poppins text-center  text-[35px] font-bold  tracking-normal  ">R$0</h4>
          <h4 className="text-nav font-poppins text-center  text-[10px] font-bold  tracking-normal  ">por mês</h4>
          <button className="bg-white rounded-4xl text-fontPrice px-5 font-poppins text-center py-2 text-[15px] font-bold  tracking-normal mt-4 ">Escolher plano</button>
        </div>
        <div className="flex bg-fontPrice flex-col justify-center items-center w-[260px] h-[393px] rounded-3xl ">
          <h4 className="text-white font-poppins text-center  text-[20px] font-bold  tracking-normal  ">Iniciante</h4>
          <h4 className="text-white font-poppins text-center  text-[35px] font-bold  tracking-normal  ">R$59</h4>
          <h4 className="text-nav font-poppins text-center  text-[10px] font-bold  tracking-normal  ">por mês</h4>
          <button className="bg-white rounded-4xl text-fontPrice px-5 font-poppins text-center py-2 text-[15px] font-bold  tracking-normal mt-4 ">Escolher plano</button>
        </div>
        <div className="flex flex-col justify-center items-center w-[260px] h-[393px] rounded-3xl ">
          <h4 className="text-white font-poppins text-center  text-[20px] font-bold  tracking-normal  ">Empresa</h4>
          <h4 className="text-white font-poppins text-center  text-[35px] font-bold  tracking-normal  ">R$199</h4>
          <h4 className="text-nav font-poppins text-center  text-[10px] font-bold  tracking-normal  ">por mês</h4>
          <button className="bg-white rounded-4xl text-fontPrice px-5 font-poppins text-center py-2 text-[15px] font-bold  tracking-normal mt-4 ">Escolher plano</button>
        </div>
        <div >
          <div className="w-[1300px] h-[80px] bg-white rounded-4xl flex flex-row justify-end items-center gap-56 ">
            <h1 className="text-black font-poppins text-left  text-[20px] font-bold tracking-normal  mr-10">
              Funcionalidades Básicas
            </h1>
            <div>

            </div>
            <div className="flex flex-row justify-end items-center gap-[320px] mr-32">

              <div>
                <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                  <path fill-rule="evenodd" clip-rule="evenodd" d="M0 12C0 5.37258 5.37258 0 12 0C18.6242 0.00771476 23.9923 5.37578 24 12C24 18.6274 18.6274 24 12 24C5.37258 24 0 18.6274 0 12ZM12.082 17.489L18.927 8.2C19.1584 7.91359 19.2137 7.52318 19.0709 7.18377C18.9281 6.84437 18.6104 6.61089 18.2438 6.57604C17.8773 6.54118 17.5212 6.71059 17.317 7.017L11.09 15.468L7.014 12.207C6.58267 11.8618 5.95318 11.9317 5.608 12.363C5.26282 12.7943 5.33267 13.4238 5.764 13.769L10.652 17.677C10.8657 17.844 11.1375 17.9182 11.4064 17.8829C11.6753 17.8475 11.9188 17.7056 12.082 17.489Z" fill="#4E2D92" />
                </svg>
              </div>   <div>
                <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                  <path fill-rule="evenodd" clip-rule="evenodd" d="M0 12C0 5.37258 5.37258 0 12 0C18.6242 0.00771476 23.9923 5.37578 24 12C24 18.6274 18.6274 24 12 24C5.37258 24 0 18.6274 0 12ZM12.082 17.489L18.927 8.2C19.1584 7.91359 19.2137 7.52318 19.0709 7.18377C18.9281 6.84437 18.6104 6.61089 18.2438 6.57604C17.8773 6.54118 17.5212 6.71059 17.317 7.017L11.09 15.468L7.014 12.207C6.58267 11.8618 5.95318 11.9317 5.608 12.363C5.26282 12.7943 5.33267 13.4238 5.764 13.769L10.652 17.677C10.8657 17.844 11.1375 17.9182 11.4064 17.8829C11.6753 17.8475 11.9188 17.7056 12.082 17.489Z" fill="#4E2D92" />
                </svg>
              </div>
            </div>


          </div>
        </div>

      </div>
      <div >
        <div className="w-[1300px] h-[80px]  mt-4 rounded-4xl flex flex-row justify-end items-center gap-56 ">
          <h1 className="text-white font-poppins text-left  text-[20px] font-bold tracking-normal  mr-21 ">
            Exportação de dados
          </h1>
          <div>

          </div>
          <div className="flex flex-row justify-end items-center gap-[320px] mr-32">

            <div>
              <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path fill-rule="evenodd" clip-rule="evenodd" d="M0 12C0 5.37258 5.37258 0 12 0C18.6242 0.00771476 23.9923 5.37578 24 12C24 18.6274 18.6274 24 12 24C5.37258 24 0 18.6274 0 12ZM12.082 17.489L18.927 8.2C19.1584 7.91359 19.2137 7.52318 19.0709 7.18377C18.9281 6.84437 18.6104 6.61089 18.2438 6.57604C17.8773 6.54118 17.5212 6.71059 17.317 7.017L11.09 15.468L7.014 12.207C6.58267 11.8618 5.95318 11.9317 5.608 12.363C5.26282 12.7943 5.33267 13.4238 5.764 13.769L10.652 17.677C10.8657 17.844 11.1375 17.9182 11.4064 17.8829C11.6753 17.8475 11.9188 17.7056 12.082 17.489Z" fill="#4E2D92" />
              </svg>
            </div>   <div>
              <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path fill-rule="evenodd" clip-rule="evenodd" d="M0 12C0 5.37258 5.37258 0 12 0C18.6242 0.00771476 23.9923 5.37578 24 12C24 18.6274 18.6274 24 12 24C5.37258 24 0 18.6274 0 12ZM12.082 17.489L18.927 8.2C19.1584 7.91359 19.2137 7.52318 19.0709 7.18377C18.9281 6.84437 18.6104 6.61089 18.2438 6.57604C17.8773 6.54118 17.5212 6.71059 17.317 7.017L11.09 15.468L7.014 12.207C6.58267 11.8618 5.95318 11.9317 5.608 12.363C5.26282 12.7943 5.33267 13.4238 5.764 13.769L10.652 17.677C10.8657 17.844 11.1375 17.9182 11.4064 17.8829C11.6753 17.8475 11.9188 17.7056 12.082 17.489Z" fill="#4E2D92" />
              </svg>
            </div>
          </div>


        </div>
      </div>
      <div >
        <div className="w-[1300px] h-[80px] bg-white rounded-4xl flex flex-row justify-end items-center gap-56 ">
          <div>
            <h1 className="text-black font-poppins text-left w-[600px] text-[20px] font-bold tracking-normal relative left-[420px] ">
              Publicidade incluída no uso
            </h1>

          </div>
          <div className="flex flex-row justify-end items-center gap-[320px] mr-32">
            <div className="relative left-9">
              <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path fill-rule="evenodd" clip-rule="evenodd" d="M0 12C0 5.37258 5.37258 0 12 0C18.6242 0.00771476 23.9923 5.37578 24 12C24 18.6274 18.6274 24 12 24C5.37258 24 0 18.6274 0 12ZM12.082 17.489L18.927 8.2C19.1584 7.91359 19.2137 7.52318 19.0709 7.18377C18.9281 6.84437 18.6104 6.61089 18.2438 6.57604C17.8773 6.54118 17.5212 6.71059 17.317 7.017L11.09 15.468L7.014 12.207C6.58267 11.8618 5.95318 11.9317 5.608 12.363C5.26282 12.7943 5.33267 13.4238 5.764 13.769L10.652 17.677C10.8657 17.844 11.1375 17.9182 11.4064 17.8829C11.6753 17.8475 11.9188 17.7056 12.082 17.489Z" fill="#4E2D92" />
              </svg>
            </div>

            <div>
              <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path fill-rule="evenodd" clip-rule="evenodd" d="M0 12C0 5.37258 5.37258 0 12 0C18.6242 0.00771476 23.9923 5.37578 24 12C24 18.6274 18.6274 24 12 24C5.37258 24 0 18.6274 0 12ZM12.082 17.489L18.927 8.2C19.1584 7.91359 19.2137 7.52318 19.0709 7.18377C18.9281 6.84437 18.6104 6.61089 18.2438 6.57604C17.8773 6.54118 17.5212 6.71059 17.317 7.017L11.09 15.468L7.014 12.207C6.58267 11.8618 5.95318 11.9317 5.608 12.363C5.26282 12.7943 5.33267 13.4238 5.764 13.769L10.652 17.677C10.8657 17.844 11.1375 17.9182 11.4064 17.8829C11.6753 17.8475 11.9188 17.7056 12.082 17.489Z" fill="#4E2D92" />
              </svg>
            </div>
            <div>
              <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path fill-rule="evenodd" clip-rule="evenodd" d="M0 12C0 5.37258 5.37258 0 12 0C18.6242 0.00771476 23.9923 5.37578 24 12C24 18.6274 18.6274 24 12 24C5.37258 24 0 18.6274 0 12ZM12.082 17.489L18.927 8.2C19.1584 7.91359 19.2137 7.52318 19.0709 7.18377C18.9281 6.84437 18.6104 6.61089 18.2438 6.57604C17.8773 6.54118 17.5212 6.71059 17.317 7.017L11.09 15.468L7.014 12.207C6.58267 11.8618 5.95318 11.9317 5.608 12.363C5.26282 12.7943 5.33267 13.4238 5.764 13.769L10.652 17.677C10.8657 17.844 11.1375 17.9182 11.4064 17.8829C11.6753 17.8475 11.9188 17.7056 12.082 17.489Z" fill="#4E2D92" />
              </svg>
            </div>
          </div>


        </div>
      </div>
      <div >
        <div className="w-[1300px] h-[80px]  mt-4 rounded-4xl flex flex-row justify-end items-center gap-56 ">
          <h1 className="text-white font-poppins text-left  text-[20px] font-bold tracking-normal  mr-119 ">
            Projetos/Eventos
          </h1>
          <div>

          </div>
          <div className="flex flex-row justify-end items-center gap-[320px] mr-[126px]">
            <div>
              <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path fill-rule="evenodd" clip-rule="evenodd" d="M0 12C0 5.37258 5.37258 0 12 0C18.6242 0.00771476 23.9923 5.37578 24 12C24 18.6274 18.6274 24 12 24C5.37258 24 0 18.6274 0 12ZM12.082 17.489L18.927 8.2C19.1584 7.91359 19.2137 7.52318 19.0709 7.18377C18.9281 6.84437 18.6104 6.61089 18.2438 6.57604C17.8773 6.54118 17.5212 6.71059 17.317 7.017L11.09 15.468L7.014 12.207C6.58267 11.8618 5.95318 11.9317 5.608 12.363C5.26282 12.7943 5.33267 13.4238 5.764 13.769L10.652 17.677C10.8657 17.844 11.1375 17.9182 11.4064 17.8829C11.6753 17.8475 11.9188 17.7056 12.082 17.489Z" fill="#4E2D92" />
              </svg>
            </div>
          </div>


        </div>
      </div>
      <div >
        <div className="w-[1300px] h-[80px] bg-white rounded-4xl flex flex-row justify-end items-center gap-56 ">
          <div>
            <h1 className="text-black font-poppins text-left w-[600px] text-[20px] font-bold tracking-normal relative left-[420px] ">
              Suporte via FAQ
            </h1>

          </div>
          <div className="flex flex-row justify-end items-center gap-[320px] mr-32">
            <div className="relative left-9">
              <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path fill-rule="evenodd" clip-rule="evenodd" d="M0 12C0 5.37258 5.37258 0 12 0C18.6242 0.00771476 23.9923 5.37578 24 12C24 18.6274 18.6274 24 12 24C5.37258 24 0 18.6274 0 12ZM12.082 17.489L18.927 8.2C19.1584 7.91359 19.2137 7.52318 19.0709 7.18377C18.9281 6.84437 18.6104 6.61089 18.2438 6.57604C17.8773 6.54118 17.5212 6.71059 17.317 7.017L11.09 15.468L7.014 12.207C6.58267 11.8618 5.95318 11.9317 5.608 12.363C5.26282 12.7943 5.33267 13.4238 5.764 13.769L10.652 17.677C10.8657 17.844 11.1375 17.9182 11.4064 17.8829C11.6753 17.8475 11.9188 17.7056 12.082 17.489Z" fill="#4E2D92" />
              </svg>
            </div>

            <div>
              <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path fill-rule="evenodd" clip-rule="evenodd" d="M0 12C0 5.37258 5.37258 0 12 0C18.6242 0.00771476 23.9923 5.37578 24 12C24 18.6274 18.6274 24 12 24C5.37258 24 0 18.6274 0 12ZM12.082 17.489L18.927 8.2C19.1584 7.91359 19.2137 7.52318 19.0709 7.18377C18.9281 6.84437 18.6104 6.61089 18.2438 6.57604C17.8773 6.54118 17.5212 6.71059 17.317 7.017L11.09 15.468L7.014 12.207C6.58267 11.8618 5.95318 11.9317 5.608 12.363C5.26282 12.7943 5.33267 13.4238 5.764 13.769L10.652 17.677C10.8657 17.844 11.1375 17.9182 11.4064 17.8829C11.6753 17.8475 11.9188 17.7056 12.082 17.489Z" fill="#4E2D92" />
              </svg>
            </div>
            <div>
              <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path fill-rule="evenodd" clip-rule="evenodd" d="M0 12C0 5.37258 5.37258 0 12 0C18.6242 0.00771476 23.9923 5.37578 24 12C24 18.6274 18.6274 24 12 24C5.37258 24 0 18.6274 0 12ZM12.082 17.489L18.927 8.2C19.1584 7.91359 19.2137 7.52318 19.0709 7.18377C18.9281 6.84437 18.6104 6.61089 18.2438 6.57604C17.8773 6.54118 17.5212 6.71059 17.317 7.017L11.09 15.468L7.014 12.207C6.58267 11.8618 5.95318 11.9317 5.608 12.363C5.26282 12.7943 5.33267 13.4238 5.764 13.769L10.652 17.677C10.8657 17.844 11.1375 17.9182 11.4064 17.8829C11.6753 17.8475 11.9188 17.7056 12.082 17.489Z" fill="#4E2D92" />
              </svg>
            </div>
          </div>


        </div>
      </div>




    </motion.div>

  )
}

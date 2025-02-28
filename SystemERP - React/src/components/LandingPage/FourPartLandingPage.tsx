import { motion } from "framer-motion";


export default function () {
  return (
    <motion.div
      initial={{ opacity: 0, y: 50 }}
      whileInView={{ opacity: 1, y: 0 }}
      viewport={{ once: true, amount: 0.2 }}
      transition={{ duration: 0.8, ease: "easeInOut" }} className="bg-gradient-to-r from-[#151934] to-[#060b27] text-white  p-10 justify-center items-center">
      <div>
        <div className="flex flex-col justify-center items-center">

          <h1 className="text-white text-center font-poppins text-5xl font-black mt-10 tracking-normal">
            Feedback dos clientes
          </h1>
          <span className="text-nav  text-center  font-bold font-poppins  mt-2  tracking-normal">A opinião dos nossos clientes é essencial para aprimorar continuamente nossa <br></br> plataforma</span>
        </div>
      </div>

      <div className="flex flex-row gap-9 justify-center mt-10">
        <div className="w-[343px] h-[235px] bg-cards border border-cardsStroke rounded-2xl justify-center items-center  ">
          <div className="flex flex-col justify-center items-center mt-4 ">
            <div className="flex flex-row justify-center items-center mt-3 gap-6">
              <img src="../../../assets/Avatar.png" alt="" />
              <div className="flex flex-col justify-center items-center">
                <h3 className="text-white  font-poppins font-black  tracking-normal">Cameron Williamson</h3>
                <span className="text-nav  font-poppins font-medium  tracking-normal">Web Designer</span>
              </div>
              <svg width="58" height="42" viewBox="0 0 58 42" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path d="M25.5283 16.5844C25.5283 7.01246 20.0382 0.950195 12.449 0.950195C5.34419 0.950195 0.5 5.89572 0.5 12.9152C0.5 19.9346 5.18272 23.923 10.9958 23.923C12.772 23.923 14.2252 23.6039 15.517 23.1253C15.517 28.709 10.5113 33.0163 3.56799 34.2926V41.9502C16.4858 40.3549 25.5283 29.9852 25.5283 16.5844ZM57.5 16.5844C57.5 7.01246 52.0099 0.950195 44.4207 0.950195C37.3159 0.950195 32.4717 5.89572 32.4717 12.9152C32.4717 19.9346 36.9929 23.923 42.806 23.923C44.5822 23.923 46.0354 23.6039 47.3272 23.1253C47.3272 28.709 42.483 33.0163 35.5397 34.2926V41.9502C48.4575 40.3549 57.5 29.9852 57.5 16.5844Z" fill="#060B27" />
              </svg>

            </div>
            <div className="mt-4">
              <p className="text-center text-white font-poppins font-normal  tracking-normal">Gostei da interface, mas algumas funcionalidades poderiam ser mais fáceis de acessar.</p>
            </div>
          </div>
        </div>
        <div className="w-[343px] h-[235px] bg-cards border border-cardsStroke justify-center rounded-2xl items-center  ">
          <div className="flex flex-col justify-center items-center mt-4 ">

            <div className="flex flex-row justify-center items-center mt-3 gap-8">
              <img src="../../../assets/Avatar1.png" alt="" />
              <div className="flex flex-col justify-center items-center">
                <h3 className="text-white  font-poppins font-black  tracking-normal">Esther Howardn</h3>
                <span className="text-nav  font-poppins font-medium  tracking-normal">Web Designer</span>
              </div>
              <svg width="58" height="42" viewBox="0 0 58 42" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path d="M25.5283 16.5844C25.5283 7.01246 20.0382 0.950195 12.449 0.950195C5.34419 0.950195 0.5 5.89572 0.5 12.9152C0.5 19.9346 5.18272 23.923 10.9958 23.923C12.772 23.923 14.2252 23.6039 15.517 23.1253C15.517 28.709 10.5113 33.0163 3.56799 34.2926V41.9502C16.4858 40.3549 25.5283 29.9852 25.5283 16.5844ZM57.5 16.5844C57.5 7.01246 52.0099 0.950195 44.4207 0.950195C37.3159 0.950195 32.4717 5.89572 32.4717 12.9152C32.4717 19.9346 36.9929 23.923 42.806 23.923C44.5822 23.923 46.0354 23.6039 47.3272 23.1253C47.3272 28.709 42.483 33.0163 35.5397 34.2926V41.9502C48.4575 40.3549 57.5 29.9852 57.5 16.5844Z" fill="#060B27" />
              </svg>

            </div>
            <div className="mt-4">
              <p className="text-center text-white font-poppins font-normal  tracking-normal">Seria útil ter mais opções de personalização dentro da plataforma.</p>
            </div>
          </div>
        </div>
        <div className="w-[343px] h-[235px] bg-cards border border-cardsStroke rounded-2xl justify-center items-center  ">
          <div className="flex flex-col justify-center items-center mt-4 ">
            <div className="flex flex-row justify-center items-center mt-3 gap-8">
              <img src="../../../assets/Avatar2.png" alt="" />
              <div className="flex flex-col justify-center items-center">
                <h3 className="text-white  font-poppins font-black  tracking-normal">Jenny Wilson</h3>
                <span className="text-nav  font-poppins font-medium  tracking-normal">UI/UX Designer</span>
              </div>
              <svg width="58" height="42" viewBox="0 0 58 42" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path d="M25.5283 16.5844C25.5283 7.01246 20.0382 0.950195 12.449 0.950195C5.34419 0.950195 0.5 5.89572 0.5 12.9152C0.5 19.9346 5.18272 23.923 10.9958 23.923C12.772 23.923 14.2252 23.6039 15.517 23.1253C15.517 28.709 10.5113 33.0163 3.56799 34.2926V41.9502C16.4858 40.3549 25.5283 29.9852 25.5283 16.5844ZM57.5 16.5844C57.5 7.01246 52.0099 0.950195 44.4207 0.950195C37.3159 0.950195 32.4717 5.89572 32.4717 12.9152C32.4717 19.9346 36.9929 23.923 42.806 23.923C44.5822 23.923 46.0354 23.6039 47.3272 23.1253C47.3272 28.709 42.483 33.0163 35.5397 34.2926V41.9502C48.4575 40.3549 57.5 29.9852 57.5 16.5844Z" fill="#060B27" />
              </svg>
            </div>
            <div className="mt-4">
              <p className="text-center text-white font-poppins font-normal  tracking-normal">No geral, a experiência é positiva, mas há espaço para melhorias na usabilidade</p>
            </div>
          </div>
        </div>
      </div>
      <div className="flex flex-row justify-center mt-10 gap-2">
        <svg width="39" height="39" viewBox="0 0 39 39" fill="none" xmlns="http://www.w3.org/2000/svg">
          <rect x="1" y="1.4502" width="37" height="37" rx="7.5" fill="#0E1330" />
          <rect x="1" y="1.4502" width="37" height="37" rx="7.5" stroke="#282D45" />
          <path d="M26.5 19.9502L12.5 19.9502" stroke="#282D45" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
          <path d="M19.5 26.9502L12.5 19.9502L19.5 12.9502" stroke="#282D45" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
        </svg>
        <svg width="39" height="39" viewBox="0 0 39 39" fill="none" xmlns="http://www.w3.org/2000/svg">
          <rect x="1" y="1.4502" width="37" height="37" rx="7.5" fill="#0E1330" />
          <rect x="1" y="1.4502" width="37" height="37" rx="7.5" stroke="#282D45" />
          <path d="M12.5 19.9502H26.5" stroke="#8F9BB7" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
          <path d="M19.5 12.9502L26.5 19.9502L19.5 26.9502" stroke="#8F9BB7" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
        </svg>
      </div>
    </motion.div>


  )
}

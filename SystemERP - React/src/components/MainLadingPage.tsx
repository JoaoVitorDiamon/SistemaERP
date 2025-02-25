import { motion } from "motion/react"

export default function MainLadingPage() {
  return (
    <motion.div   className="bg-gradient-to-r from-[#151934] to-[#060b27] text-white min-h-screen p-10"> {/*container do main landing page*/}
      <div> {/*container do titulo*/}
        <h1 className="text-white text-center text-4xl font-black mt-10 tracking-normal">Transforme a Gestão da Sua Empresa com Nosso ERP Completo</h1>
      </div>
      <div className="flex flex-col items-center justify-center">
        <p className="text-nav text-center  text-lg font-normal mt-4 tracking-normal">Transforme a gestão do seu negócio com nosso ERP Web, uma solução completa e intuitiva<br></br> para otimizar processos e aumentar a produtividade. Gerencie finanças, estoque, vendas e <br></br> muito mais em um único sistema.</p>
        <div className="flex mt-10 gap-4 justify-center">
          <button className="bg-button text-white px-4 py-2 rounded-4xl">Demonstração</button>
          <button className="bg-transparent border border-nav text-nav px-4 py-2 rounded-4xl">Ver Planos</button>
        </div>
        <div className="mt-10  rounded-2xl">
          <img src="../../../assets/systemImage.png" alt="image" />
        </div>
      </div>

    </motion.div>
  )
}

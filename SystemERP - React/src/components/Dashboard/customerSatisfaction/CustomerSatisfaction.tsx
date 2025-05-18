import { ChartSatisfaction } from "./chartSatisfaction"


export const CustomerSatisfation = () => {
  return (
    <div className="flex ml-30 mt-10 flex-col justify-center items-center">
        <h1 className="text-2xl font-bold font-poppins  mt-4 text-dashboard">
          Satisfacao do Cliente
        </h1>

        <div className="flex flex-col justify-center items-center">
          <ChartSatisfaction/>
        </div>
        </div>
  )
}

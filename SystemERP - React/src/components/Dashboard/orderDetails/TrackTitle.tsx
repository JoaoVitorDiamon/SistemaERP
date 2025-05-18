interface TrackTitleProps {
  title: string
  date: string
}



export const TrackTitle = ({...track}: TrackTitleProps) => {
  return (
    <div>
      <div className="flex flex-col justify-center items-left ml-4 mt-5">
        <h1 className="text-xl font-poppins font-bold">{track.title}</h1>
        <h1 className="text-xl font-poppins font-normal text-[#A0AEC0]">{track.date}</h1>
      </div>
    </div>
  )
}

import NavBar from "../components/LandingPage/NavBar";
import MainLadingPage from "../components/LandingPage/FirstPartLadingPage";
import SecondPartLandingPage from "../components/LandingPage/SecondPartLandingPage";
import ThirtPartLandingPage from "../components/LandingPage/ThirtPartLandingPage";
import FourPartLandingPage from "@/components/LandingPage/FourPartLandingPage";
export default function LandingPage() {
  return (
    <div className="bg-[#151934]">
    <div className="bg-gradient-to-r from-[#151934] to-[#060b27] w-full min-h-screen">
      <NavBar />
      <MainLadingPage />
      <SecondPartLandingPage />
      <ThirtPartLandingPage />
      <FourPartLandingPage />
    </div>
    </div>
  )


}

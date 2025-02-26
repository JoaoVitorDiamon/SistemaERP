import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import { createBrowserRouter } from 'react-router'
import { RouterProvider } from 'react-router-dom'
import CreateCorporationStepOnePage from './Pages/CreateCorporationStepOnePage.tsx'
import LoginPage from './Pages/LoginPage.tsx'
import LandingPage from './Pages/LandingPage.tsx'
import CreateCorporationStepTwoPage from './Pages/CreateCorporationStepTwo.tsx'
import CreateCorporationStepEndereco from './Pages/CreateCorporationStepEndereco.tsx'
import CreateCorporationStepThreePage from './Pages/CreateCorporationStepThreePage.tsx'

const router = createBrowserRouter([
  {
    path: "CriarEmpresa",
    element: <CreateCorporationStepOnePage/>
  },
  {
    path: "CriarDetalhes",
    element: <CreateCorporationStepTwoPage/>
  },
  {
    path: "EmpresaEndereco",
    element: <CreateCorporationStepEndereco/>
  },
  {
    path: "CadastroRepresentante",
    element: <CreateCorporationStepThreePage/>
  },
  {
    path: "Login",
    element: <LoginPage />
  },
  {
    path: "LandingPage",
    element: <LandingPage />
  }
])

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <RouterProvider router={router} />
  </StrictMode>,
)

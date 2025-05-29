import { createBrowserRouter } from 'react-router-dom'
import CreateCorporationStepOnePage from './pages/CreateCorporationStepOnePage.tsx'
import LoginPage from './pages/LoginPage.tsx'
import CreateCorporationStepTwoPage from './pages/CreateCorporationStepTwo.tsx'
import CreateCorporationStepEndereco from './pages/CreateCorporationStepEndereco.tsx'
import CreateCorporationStepThreePage from './pages/CreateCorporationStepThreePage.tsx'
import { Dashboard } from './pages/Dahsboard.tsx'
import Products from './Pages/Products.tsx'
import LandingPage from './Pages/LandingPage.tsx'

const router = createBrowserRouter([
  {
    path: "/landing-page",
    element: <LandingPage/>
  },
  {
    path: "/create-corporation",
    element: <CreateCorporationStepOnePage />
  },
  {
    path: "/crete-corporation-step-two",
    element: <CreateCorporationStepTwoPage />
  },
  {
    path: "/crete-corporation-step-endereco",
    element: <CreateCorporationStepEndereco />
  },
  {
    path: "/crete-corporation-step-three",
    element: <CreateCorporationStepThreePage />
  },
  {
    path: "/login",
    element: <LoginPage />
  },
  {
    path: "/dashboard",
    element: <Dashboard />
  },
  {
    path: "/thirtyParty",
    element: <Dashboard />
  },
  {
    path: "/products",
    element: <Products/>
  }
])

export default router

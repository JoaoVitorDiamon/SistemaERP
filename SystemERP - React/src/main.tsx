import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import { createBrowserRouter } from 'react-router'
import { RouterProvider } from 'react-router-dom'
import CreateCorporationPage from './Pages/CreateCorporationPage.tsx'
import LoginPage from './Pages/LoginPage.tsx'
import LandingPage from './Pages/LandingPage.tsx'

const router = createBrowserRouter([
  {
    path: "CriarEmpresa",
    element: <CreateCorporationPage />
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

import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.tsx'
import { createBrowserRouter } from 'react-router'
import { RouterProvider } from 'react-router-dom'
import CreateCorporationPage from './Pages/CreateCorporationPage.tsx'
import LoginPage from './Pages/LoginPage.tsx'

const router = createBrowserRouter([
  {
    path: "/",
    element: <App />
  },
  {
    path: "CriarEmpresa",
    element: <CreateCorporationPage/>
  },
  {
    path: "Login",
    element: <LoginPage/>
  }
])

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <RouterProvider router={router}/>
  </StrictMode>,
)

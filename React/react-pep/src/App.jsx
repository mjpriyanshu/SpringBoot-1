import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'
import heroImg from './assets/hero.png'
import About from './Components/About'
import Navigation from './Components/Navigation/Navigation'
import ContactForm from './Components/ContactForm'
import './App.css'

function App() {
  return (
    <>
      <Navigation />
      <div>Hello world</div>
      <br></br>
      <About/>
      <ContactForm />
    </>
  )
}

export default App

//import { StrictMode } from 'react'
//import { createRoot } from 'react-dom/client'
//import './index.css'
window.global = window;

import React from 'react'
import ReactDOM from 'react-dom'
import App from './App.jsx'

// 부트스트랩
import 'bootstrap/dist/css/bootstrap.min.css'
// 전체스타일 
import './assets/css/main.css'

// createRoot(document.getElementById('root')).render(
//   <StrictMode>
//     <App />
//   </StrictMode>,
// )

ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById('root')
)
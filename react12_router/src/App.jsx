import { BrowserRouter, Routes, Route } from 'react-router-dom'

import Layout from '/src/assets/pages/Layout'
import Home from '/src/assets/pages/Home'
import News from '/src/assets/pages/News'
import Notice from './assets/pages/Notice'
import Community from '/src/assets/pages/Community'
import Login from '/src/assets/pages/Login'

import '/src/assets/css/style.css'
function App() {

  return (
    <BrowserRouter>
      <Routes>
        {/* /로 접속을 하여 표시할 페이지 */}
        <Route path="/" element={<Layout />}>
          { /* Layout의 Outlet표시할 컴퍼넌트(page) */}
          <Route index element={<Home />}></Route>
          <Route path="/news" element={<News/>}></Route>
          <Route path="/notice" element={<Notice/>}></Route>
          <Route path="/community" element={<Community/>}></Route>
          <Route path="/login" element={<Login/>}></Route>
        </Route>
      </Routes>
    </BrowserRouter>
  )
}

export default App

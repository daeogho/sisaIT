
import '/src/assets/css/layout.css'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import Layout from '/src/assets/pages/Layout'
import HomeLog_index from '/src/assets/pages/HomeLog_index'

import Login from '/src/assets/pages/Login'
import MyPage from '/src/assets/pages/MyPage'
import Member from '/src/assets/pages/Member'
import MemberEdit from '/src/assets/pages/MemberEdit';

import Sharing from '/src/assets/pages/Sharing'
import BoardForm from '/src/assets/pages/BoardForm'
import BoardView from '/src/assets/pages/BoardView'
import BoardEdit from '/src/assets/pages/BoardEdit'

import Ask from '/src/assets/pages/Ask'
import AskForm from '/src/assets/pages/AskForm'
import AskEdit from '/src/assets/pages/AskEdit';
import Interior from '/src/assets/pages/Interior';
import InteriorForm from '/src/assets/pages/InteriorForm';
import InteriorEdit from '/src/assets/pages/InteriorEdit';
import As from '/src/assets/pages/As';
import AsForm from '/src/assets/pages/AsForm';
import AsEdit from '/src/assets/pages/AsEdit';

function App() {

  return (
    <BrowserRouter>
      <Routes>
        {/*    /로 접속하여 표시할 페이지 */}
        <Route path="/" element={<Layout />}>
          {/* Layout의 Outlet표시할 컴퍼넌트(page) */}
          <Route index element={<HomeLog_index />}></Route>
          <Route path="/member/login" element={<Login />}></Route>
          <Route path="/member/mypage" element={<MyPage />}></Route>
          <Route path="/member/member" element={<Member />}></Route>
          <Route path="/member/memberEdit" element={<MemberEdit />}></Route>

          <Route path="/member/sharing" element={<Sharing />}></Route>
          <Route path="/member/boardform" element={<BoardForm />}></Route>
          <Route path="/member/boardview/:board_no" element={<BoardView />}></Route>
          <Route path="/member/boardedit/:board_no" element={<BoardEdit />}></Route>
          

          <Route path="/ask/list" element={<Ask />}></Route>
          <Route path="/ask/form" element={<AskForm />}></Route>
          <Route path="/ask/edit/:no" element={<AskEdit />}></Route>

          <Route path="/interior/list" element={<Interior />}></Route>
          <Route path="/interior/write" element={<InteriorForm />}></Route>
          <Route path="/interior/edit/:no" element={<InteriorEdit />}></Route>

          <Route path="/as/list" element={<As />}></Route>
          <Route path="/as/form" element={<AsForm />}></Route>
          <Route path="/as/edit/:no" element={<AsEdit />}></Route>







        </Route>
      </Routes>
    </BrowserRouter>
  )
}

export default App
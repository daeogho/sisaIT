import { BrowserRouter, Routes, Route } from 'react-router-dom';

import Layout from './assets/pages/Layout';
import Home from './assets/pages/Home';
// 회원인증
import JoinsForm from './assets/pages/joins/JoinsForm'
import Login from './assets/pages/joins/Login'
import JoinsEdit from './assets/pages/joins/JoinsEdit'
//BBS
import BbsList from './assets/pages/bbs/BbsList'
import BbsForm from './assets/pages/bbs/BbsForm'
import BbsDetail from './assets/pages/bbs/BbsDetail'
import BbsEdit from './assets/pages/bbs/BbsEdit';
import DataForm from './assets/pages/data/DataForm';
import DataList from './assets/pages/data/DataList';
import DataDetail from './assets/pages/data/DataDetail';
import DataEdit from './assets/pages/data/DataEdit';
// 공지사항
import QnaList from './assets/pages/qna/QnaList';
import QnaForm from './assets/pages/qna/QnaForm';
import QnaDetail from './assets/pages/qna/QnaDetail';
import QnaEdit from './assets/pages/qna/QnaEdit';
//API 페이지
import LayoutApi from './assets/pagesApi/LayoutApi';
import ApiHome from './assets/pagesApi/ApiHome';
import Chatting from './assets/pagesApi/Chatting'; // 채팅페이지
import Chartjs from './assets/pagesApi/Chartjs';


function App() {

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route index element={<Home />}></Route>
          {/* 회원인증 */}
          <Route path="/joins/JoinsForm" element={<JoinsForm/>}></Route>
          <Route path="/joins/login" element={<Login/>}></Route>
          <Route path="/joins/JoinsEdit" element={<JoinsEdit/>}></Route>
          {/* BBS */}
          <Route path="/bbs/bbsList" element={<BbsList/>}></Route>
          <Route path="/bbs/bbsForm" element={<BbsForm/>}></Route>
          <Route path="/bbs/bbsDetail/:id" element={<BbsDetail/>}></Route>
          <Route path="/bbs/bbsEdit/:id" element={<BbsEdit/>}></Route>
          {/* 자료실 */}
          <Route path="/data/dataList"  element={<DataList/>}></Route>
          <Route path="/data/dataForm"  element={<DataForm/>}></Route>
          <Route path="/data/dataDetail/:id"  element={<DataDetail/>}></Route>
          <Route path="/data/dataEdit/:id"  element={<DataEdit/>}></Route>
          {/*공지사항 */}
          <Route path="/qna/qnaList"  element={<QnaList/>}></Route>
          <Route path="/qna/qnaForm"  element={<QnaForm/>}></Route>
          <Route path="/qna/qnaDetail/:id"  element={<QnaDetail/>}></Route>
          <Route path="/qna/qnaEdit/:id"  element={<QnaEdit/>}></Route>
        </Route>
        <Route path="/apiLayout" element={<LayoutApi/>}>
          <Route index element={<ApiHome/>}></Route>
          <Route path="/apiLayout/chatting" element={<Chatting/>}></Route>
          <Route path="/apiLayout/chartjs" element={<Chartjs/>}></Route>
        </Route>
      </Routes>
    </BrowserRouter>

  )
}

export default App
import { Outlet } from 'react-router-dom'
import Footer from './Footer'
import axios from 'axios';
import { Link } from 'react-router-dom';

function Layout() {
        //로그아웃
        //스트링부트의 session삭제
        //sessionStorage정보 삭제
        function logoutFnt(){

                axios.get('http://43.202.150.110:9988/joins/logout')
                .then((response)=>{
                        // sessionStorage의 모든 변수를 삭제한다.
                        window.sessionStorage.clear();
                        window.location.href = "/";
                })
                .catch((error)=>{
                        console.log("로그아웃 에러 발생함..",error)
                })
        }
        return (
                <div>
                        <div className="top-logo"><Link to="/">시사 it 아카데미</Link></div>
                        <div className="main-menu">
                                <div><Link to="/">홈</Link></div>
                                {
                                        (window.sessionStorage.getItem("logStatus") == "null" || window.sessionStorage.getItem("logStatus") != 'Y')
                                        && (<div><Link to="/joins/login">로그인</Link></div>)
                                }
                                {
                                        (window.sessionStorage.getItem("logStatus") == "null" || window.sessionStorage.getItem("logStatus") != 'Y')
                                        && (<div><Link to="/joins/joinsForm">회원가입</Link></div>)
                                }
                                {
                                        (window.sessionStorage.getItem("logStatus") == "null" || window.sessionStorage.getItem("logStatus") == 'Y')
                                        && (<div><Link to="#" onClick={logoutFnt}>로그아웃</Link></div>)
                                }
                                {
                                        (window.sessionStorage.getItem("logStatus") == "null" || window.sessionStorage.getItem("logStatus") == 'Y')
                                        && (<div><Link to="/joins/joinsEdit">회원정보수정</Link></div>)
                                }
                                <div><Link to="/bbs/bbsList">BBS</Link></div>
                                <div><Link to="/data/dataList">자료실</Link></div>
                                <div><Link to="/qna/qnaList">공지사항</Link></div>
                                <div><Link to="/apiLayout">API페이지</Link></div>
                        </div>

                        <Outlet></Outlet>

                        <Footer />
                </div>

        )
}

export default Layout;
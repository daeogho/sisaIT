import { Outlet } from "react-router-dom"
import { useState, useEffect } from 'react'
import '/src/assets/css/layout.css'
import axios from 'axios'

function Layout() {
        // // 로그인 정보를 저장
        const [logStatus, setLogStatus] = useState('N')

        // // 처음에 한번만 호출된다.
        useEffect(()=>{
               var log = window.sessionStorage.getItem('logStatus')
               if(log == null || log==''){
                        setLogStatus('N')
               }else{
               setLogStatus(log)
                }
        },[])

        function logoutFnc(){
                axios.get('http://192.168.4.86:9988/logout')
                .then(function(response){
                        if(response.data.logout=='yes'){
                                setLogStatus('N')
                                window.sessionStorage.removeItem('logStatus')
                                window.sessionStorage.removeItem('user')
                                 alert('로그아웃 되었습니다.')
                                window.location.href = '/';
                        }
                })
                .catch(function(e){
                        console.log(e)
                })

        }

        return (
                <>
                        <div className="category">
                                <div className='logo'>
                                        <a href="/"><img src="/src/assets/img/logo.png" /></a>
                                </div>

                                <div className='category_icon'>
                                        <img src="/src/assets/img/category.png" />
                                </div>

                                <div className='menu'>
                                        <a href="/interior/list">인테리어 TIP</a>
                                        <a href="/member/sharing">집들이</a>
                                        <a href="/ask/list">집꾸미기</a>
                                        <a href="/as/list">고객지원</a>
                                </div>

                                
                                <div className='user_menu'>
                                {/* 로그인이 안된 경우 */}
                                { logStatus=='N' && <a href="/member/login">로그인</a>}
                                { logStatus=='N' && <a href="/member/member">회원가입</a> }
                                {/* 로그인이 된 경우 */}
                                { logStatus=='Y' && <a href="javascript:void(0)" onClick={logoutFnc}>Logout</a>}
                                { logStatus=='Y' && <a href="/member/mypage">마이페이지</a>}        
                                        
                                </div>
                        </div>

                        <Outlet />
                        <footer>
                                <h3>Homelog</h3><hr />
                                <a>인테리어 Tip · 집들이 · Q&A 커뮤니티</a><br/>
                                <a>문의: support@homelog.com</a><br/>
                                <a>© 2026 homelog. All rights reserved.</a>
                        </footer>


                </>





        )

}
export default Layout
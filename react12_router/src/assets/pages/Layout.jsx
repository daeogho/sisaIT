import {Outlet} from 'react-router-dom'
function Layout(){

        return(
                <>
                <div class="menu">
                        < a href="/">HOME</a>
                        < a href="/news">뉴스</a>
                        < a href="/notice">공지사항</a>
                        < a href="/community">커뮤니티</a>
                        < a href="/login">로그인</a>
                </div>

                {/* 메뉴를 선택하면 해당페이지를 표시할 곳 */}
                <Outlet/>

                <footer>
                        Company@시사IT 아카데미
                </footer>
                </>
        )
}
export default Layout
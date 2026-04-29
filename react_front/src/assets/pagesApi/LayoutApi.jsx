import { Link, Outlet } from "react-router-dom"
import Footer from "../pages/Footer"


function LayoutApi(){

        return(
                <div style={{background:'black'}}>
                        {/*상단 로고 및 메뉴 */}
                        <div className="top-logo">
                                <Link to="" style={{color:'white'}}>OPEN API</Link>
                        </div>
                        <div className="main-menu">
                                <div><Link to="/">메인</Link> </div>
                                <div><Link to="/apiLayout/chatting">채팅(websocket)</Link></div>
                                <div><Link to="/apiLayout/chartjs">차트(chartjs)</Link></div>
                                
                        </div>
                        <Outlet></Outlet>

                        <Footer></Footer>
                </div>
        )



}
export default LayoutApi
function Home(){
        return(
                <div className='container'>
                        {/* react에서 springboot의 서버에 있는 파일을 다운로드 하면 다운로드 안됨 
                        <a href="http://192.168.4.50:9988/uploads/cafe1.jpeg" download>
                                <img src="/img/jeju25.jpg"/>
                        </a>
                        */}
                        <img src="/img/jeju25.jpg" style={{width:'100%'}}/>
                        <hr/>
                        <button>Click</button>


                </div>
        )

}
export default Home;
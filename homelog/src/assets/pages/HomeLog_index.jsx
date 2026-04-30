import '/src/assets/css/Ls_style.css'
import 'bootstrap/dist/css/bootstrap.min.css';
import  Carousel  from 'react-bootstrap/Carousel';

function HomeLog_index() {
  
  return (
    <>
    <link rel="preconnect" href="https://fonts.googleapis.com"/>
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link href="https://fonts.googleapis.com/css2?family=Gowun+Batang&family=Nanum+Pen+Script&family=Sunflower:wght@300&display=swap" rel="stylesheet"></link>
      <div className='banner'>
                  <Carousel>
                      <Carousel.Item>
                            <img
                              className="d-block w-100"
                              src="/src/assets/img/baner.jpg"
                              alt="First slide"
                              />
                              <Carousel.Caption>
                              <h3 style={{color:'black',fontWeight:'bold'}}>Home Log</h3>
                              <p style={{color:'gray',fontWeight:'bold'}}><i>당신의 공간을 더 아름답게 꾸며주세요.</i></p>
                              </Carousel.Caption>
                        </Carousel.Item>
                        <Carousel.Item>
                              <img
                              className="d-block w-100"
                              src="/src/assets/img/baner2.jpg"
                              alt="Second slide"                              
                              />
                        </Carousel.Item>
                  </Carousel>
      </div>
      <div className='imgbtn'>
        <div className='category1'>
          <a href="/interior/list">
            <img src="./src/assets/img/img1.jpg" className='category-img'/>
            <div className="overlay-text">
            <h3 style={{fontFamily:'Nanum Pen Script',fontSize:'5em'}}>인테리어Tip</h3>
            <p style={{fontFamily:'Nanum Pen Script',fontSize:'3em'}}>공간을 더 예쁘고 효율적으로<br/> 만드는 인테리어 팁을 모았습니다.</p>
            </div>
          </a>
        </div>
        <div className='category1'>
          <a href="/member/sharing">
            <img src="./src/assets/img/img9.jpg" className='category-img'/>
            <div class="overlay-text">
            <h3 style={{fontFamily:'Nanum Pen Script',fontSize:'5em'}}>집들이</h3>
            <p style={{fontFamily:'Nanum Pen Script',fontSize:'3em'}}>취향과 개성이 담긴<br/>나만의 방 인테리어를 공유하는<br/>집들이 카테고리입니다.</p>
            </div>
          </a>
        </div>
        <div className='category1'>
          <a href="/ask/list">
            <img src="./src/assets/img/img15.jpg" className='category-img'/>
            <div class="overlay-text">
            <h3 style={{fontFamily:'Nanum Pen Script',fontSize:'5em'}}>Q&A</h3>
            <p style={{fontFamily:'Nanum Pen Script',fontSize:'3em'}}>셀프 인테리어에 대한<br/>궁금증을 묻고 답하는<br/>Q&A 카테고리입니다.</p>
            </div>
          </a>
        </div>
      </div>
    </>
  )
}

export default HomeLog_index
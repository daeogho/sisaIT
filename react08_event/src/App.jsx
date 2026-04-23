import './App.css'

function App() {
 const btnCss={
  backgroundColor:'orange',
  color:'#fff',
  fontSize:'1.5em',
  margin:'20px',
  padding:'10px'
 }
 // 버튼이 클릭되면 호출할 함수 : 매개변수 없을때
 const eventTest = ()=>{
  alert("버튼이 클릭되었습니다.");
 }
 // 마우스오버시 호출할 함수 : 매개변수 있을때
 const eventTest2 = (data)=>{ // function eventTest2(data){}
  alert("마우스오버 이벤트가 발생하였습니다.\n전달받은 값은 : "+data)
 }
// 마우스 클릭시 : 이벤트 종류, 매개변수 전달
const eventTest3 = (_event, val)=>{
    alert(val + "--->" + _event._reactName);        //_reactName : 이벤트 종류를 가지고 있다.
}

  return (
    <div className='container' style={{border:'1px solid gray'}}>
    <h1>리엑트에서 이벤트 사용하기</h1>
    {
      /*
      click, mouseover(mouseenter), mouseout(mouseleave), keyup, keydown, blur, focus

      <button onclick=""> Click </button>
      document.getElementById("btn").addEventListener('click', function(){})


      javascript          react
        onclick          onClick
          Click          onMouseOver
      */
    }
    <button style={btnCss} onClick={eventTest}>클릭이벤트 처리하기(매개변수 없을때)</button>
    <div className = 'btn btn-primary btn-block'>
    <button style={btnCss} onMouseOver={()=>eventTest2('사과')}>마우스오버 이벤트 처리하기(매개변수가 있을때)</button>
   </div>
    <button onClick={(event)=>eventTest3(event, 'event.종류 알아내는 방법 테스트')} className= 'btn btn-outline-danger'>클릭이벤트 처리하기(매개변수, 이벤트종류 알아내기)</button>
    </div>
  )
}

export default App

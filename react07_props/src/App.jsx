import './App.css'

function App() {
  // 함수를 이용하여 호출하기
  function myFlower(flowerName) {
    return <h2>내가 좋아하는 꽃은  flowerName입니다.</h2>
  }

  // props는 자바스크립에서 매개변수, html에서는 속성을 뜻한다.
  function MyFlower2(props) {
    return <h2>내가 좋아하는 꽃은 {props.flowername}입니다.</h2>
  }
  // 변수에 대입 후 사용하기
  const mF = <MyFlower2 flowername="코스모스"></MyFlower2>

  // 함수 내에서 다른 함수를 호출하여 props사용하는 방법
  function MyCar(props) {
    return <h3>나의 자동차는 {props.brand}입니다...</h3>
  }
  //             {carname:'모닝', company:'현대자동차'}
  function MyCar2(props){
    return <h3>나의 자동차는 {props.brand.carname}이고 {props.brand.company}생산되었습니다.</h3>
  }
  function MyChago() {
    var carName = "그렌져";
    var carInfo = {carname: '모닝', company: '현대자동차' };

  
  return (
    <div>
      <h2>마이차고~~~~~~~~~~~~~</h2>
      <MyCar brand={carName}></MyCar>
      <MyCar2 brand={carInfo}></MyCar2>
    </div>
  )
}

  return(
    <>
    { myFlower("해바라기") }
  { myFlower("장미") }
  {/* 함수를 컴퍼넌트로 사용하는 방식 */ }
  <MyFlower2 flowername='히야신스'></MyFlower2>
  { mF }
  <MyChago></MyChago>
    </>
  )
}

export default App

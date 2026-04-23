import './App.css'

function App() {
  // 배열선언          [0]       [1]     [2]        [3]
  const myFruit = ['banana', 'apple', 'mango', 'pineapple'];
  // <p>banana</p><p>apple</p><p>mango</p><p>pineapple</p>
  // map() : 배열을 반복처리하는 함수
  // 배열명.map();
  //          람다식함수
  // 리턴문자 jsx태그를 누적시킨다.
  var myFruitList = myFruit.map((item) => { return (<p>{item}</p>) });
  // var myFruiteList = muFruit.mmap((item)=><p>{item}</p>);

  // 1. 배열의 값을 일반 변수에 대입하기
  const f1 = myFruit[0]; // banana
  const f2 = myFruit[1]; // apple
  const f3 = myFruit[2]; // mango

  // 2.
  const [a1, a2, a3] = myFruit;

  // 3.배열의 일부 값만 변수에 치환
  const [b1, b2, b3] = myFruit;


  // 함수를 이용한 배열처리하기 -> 매개변수로 값을 2개입력받아 사칙연산처리하여 배열로 반환한다.
  function calculator(first, second){
    const add = first + second;
    const substract = first - second;
    const multiple = first * second;
    const divide = first / second;
    return [add, substract, multiple, divide];

  }
  // 함수 호출
  var [plus, minus, gob, div] = calculator(20, 6); // result = [26, 14, 120, 3.222]

  // 배열의 분해
  // ...(spreat)연산자를 이용하여 배열의 일부 또는 배열의 전체를 단일값으로 빠르게 복사
  const arr1 = [10, 20, 30];
  const arr2 = [40, 50, 60];

  // arr1, arr2배열을 하나로 합치기
  const arrCombined = [...arr1, ...arr2]; // [10,20,30,40,50,60]
  const arrCombinedStr = arrCombined.join(',');

  // 배열을 원하는 변수 또는 배열로 나눠서 대입하기
  const arr3 = [1,2,3,4,5,6,7,8];
  // one =1, two=2, three=3, arr=[4,5,6,7,8]
  const [] = arr3;
  const arr4 = {one, two, three, arrVar};
  return (
    <>
      <h2>배열의 값을 map()함수로 반복처리</h2>
      {myFruitList}
      <hr/>
      <p>f1 : {f1}, f2 : {f2}, f3 : {f3}</p>
      <p>a1 : {a1}, a2 : {a2}, a3 : {a3}</p>
      <p>b1: {b1}, b2 : {b2}, b3 : {b3}</p>
      <h2>함수를 이용한 배열처리</h2>
      <p>plus : {plus}, minus : {minus}, gob : {gob}, div : {div}</p>
      <hr/>
      <h2>배열의 분해</h2>
      <p>배열의 합치기 : {arrCombinedStr}</p>
      <p>배열의 조개기 : one : {one}, two : {two}, three : {three}, arrVar = {arrVar}</p>
    </>

  )
}

export default App

import { useState } from 'react'
import axios from 'axios';
function App() {
  var [data1, setData1] = useState({});
  var [data2, setData2] = useState({});
  var [board, setBoard] = useState({});
  function nodeServer1() {
    // 비동기식으로 node서버에 정보 요청하기

    axios({//접속 관련정보
      method: 'get',
      url: 'http://127.0.0.1:4000/test1',
      responseType: 'json',
      params: {
        no: 5,
        name: '홍길동'
      }
    })
      .then(function (response) { // 정상응답받을 경우
        console.log(response.data);
        setData1(response.data);
      })
      .catch(function (error) { //에러발생시
        console.log(error)
      }) 
  }

  // 단축형 비동기식 접속
  function nodeServer2() {
    axios.get('http://127.0.0.1:4000/test1', {
      params: {
        no: 555,
        name: '세종대왕'
      }
    })
      .then(function (res) {
        console.log(res);
        setData2(res.data);
      })
      .catch(function (error) {
        console.log(error);
      })
  }

  //post 방식 비동기 통신
  const nodePostServer = () => {
    axios.post('http://127.0.0.1:4000/test2', {
      pageNum: 7,
      searchWord: '고구마'
    }).then((response) => {
      console.log(response)
      setBoard(response.data)
    }).catch((error) => {
      console.log(error)
    })

  }

  return (
    <div>
      <h1>React에서 비동기 통신하기</h1>
      <button onClick={nodeServer1}>get방식 Node서버에서 정보 받아오기(기본형)</button>
      <div style={{ backgroundColor: 'beige', height: '40px' }}>
        아이디 : {data1.userid}, 이름: {data1.username}
      </div>
      <button onClick={nodeServer2}>get방식 Node서버에서 정보 받아오기(단축형)</button>
      <div style={{ backgroundColor: 'yellow', height: '40px' }}>
        아이디 : {data2.userid}
      </div>
      <div style={{ backgroundColor: 'pink', height: '40px' }}>
        이름 : {data2.username}
      </div>

      <hr />
      <h2>React Post방식 비동기 통신하기</h2>
      <button onClick={nodePostServer}>post방식 Node서버에서 정보 받아오기</button>
      <div style={{ backgroundColor: 'lightblue' }}>
        글번호 : {board.no}<br />
        글제목 : {board.subject}<br />
        글내용 : {board.content}<br />
      </div>

    </div>


  )
}
export default App

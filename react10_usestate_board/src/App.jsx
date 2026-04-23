import { useState } from 'react'

function App() {

  const [boardList, setBoardList] = useState([
    { no: 1, title: '이것은 글 제목이야...', username: '나작가', hit: 0, writedate: '2025-12-12' },
    { no: 2, title: '이것은 리엑트에서 useState테스트하고 있어.', username: '김작가', hit: 2, writedate: '2025-12-15' },
    { no: 3, title: '이것은 글제목을 왜 이렇게 써!!!!..', username: '오작가', hit: 53, writedate: '2025-12-23' }
  ]);
  var [num, setNum] = useState(100);

  function insertRecord(){
    setNum(num+1);
    // boardList에 레코드 추가... 기존데이터를 보존
    setBoardList((previous)=>{
      return [...previous, {no:num, title:'새로 추가된 글.....', username:'홍길동', hit:0, writedate:'2026-01-08'}]
    });

  };

  return (
    <div className='container'>
      <h1>게시판목록</h1>
      <hr />
      <button className="btn btn-success" onClick={insertRecord}>글추가</button>
      {/* 항목 */}
      <div className="row" style={{ borderBottom: '2px solid #999' }}>
        <div className="col-sm-1 p-3">번호</div>
        <div className="col-sm-8 p-3">제목</div>
        <div className="col-sm-1 p-3">글쓴이</div>
        <div className="col-sm-1 p-3">조회수</div>
        <div className="col-sm-1 p-3">등록일</div>
      </div>


      {boardList.map((record) => {
        return (
          < div className="row" style={{ borderBottom: '1px solid #ddd' }}>
            <div className="col-sm-1 p-3">{record.no}</div>
            <div className="col-sm-7 p-3">{record.title}</div>
            <div className="col-sm-1 p-3">{record.username}</div>
            <div className="col-sm-1 p-3">{record.hit}</div>
            <div className="col-sm-2 p-3">{record.writedate}</div>
          </div>
        )
      })}

    </div >
  )
}

export default App

import { useState, useEffect } from 'react'
import axios from 'axios'
import '/src/assets/css/kdh_style.css'

function Sharing() {

  // 로그인 확인 여부
  const loginCheck = () => {
    var logStatus = window.sessionStorage.getItem(`logStatus`);
    if (logStatus == null || logStatus == 'N') { // 로그인 안됨
      window.location.href = '/member/login';
    } else if (logStatus == 'Y') { //로그인 됨
      window.location.href = '/member/boardform'; // 버튼을 눌렀을때 이동하는 페이지
    }

  }

  // 뉴스 목록을 DB에서 가져와서 출력
  const [boardList, setBoardList] = useState([]) // [{news:1, subject:'a'...}]
  const [searchQuery, setSearchQuery] = useState(""); // 일반 검색어
  const [posts, setPosts] = useState([]);            // 검색 결과
  useEffect(() => {
    getBoardList()
  }, [searchQuery])

  const getBoardList = () => {
    console.log('searchQuery', searchQuery)
    axios.get('http://192.168.4.86:9988/member/sharing',
      {
        params: {
          tag: searchQuery // 🔥 서버에서 받는 이름에 맞춰야 함         

        }
      }
    )

      .then((response) => {
        console.log(response.data.records)
        //이전리스트 지우기
        setBoardList([]);
        response.data.records.map((board) => {
          //글내용에 이미지가 없을 수 있다.
          var thumnailImage = "";
          var index = board.context.indexOf('<img src="');
          var indexEnd = board.context.indexOf('"', index + 10);
          if (index > 0) {//이미지가 있다.

            thumnailImage = board.context.substring(index + 10, indexEnd);
          } else {//이미지가 없다.
            thumnailImage = "http://192.168.4.86:9988/uploads/1.avif"
          };
          // console.log(thumnailImage);
          // console.log(board.likenum)
          var likeImg = 'like.png';
          console.log('likenum==>', board.likenum)
          if (board.likenum != null) {
            likeImg = 'addlike.png';
          }
          setBoardList((prev) => {
            return [...prev, { no: board.no, userid: board.userid, tag: board.tag, hit: board.hit, writedate: board.writedate, subject: board.subject, thumnail: thumnailImage, likeImg: likeImg }]
          })
        })
        //setBoardList(response.data.records)
      })
      .catch((error) => {
        console.log(error)
      })
  }



  return (
    <>
      <div className="content">
        <div className='content_text'>
          <link rel="preconnect" href="https://fonts.googleapis.com" />
          <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
          <link href="https://fonts.googleapis.com/css2?family=Chiron+GoRound+TC:wght@200..900&display=swap" rel="stylesheet" />

          <p className="title">Log :</p>
          <p className="description">
            단순한 공간 자랑이 아닌, 나만의 취향과 이야기를 기록하고 나누는 공간입니다.
          </p>
          <hr />
        </div>

        <div className='content_action'>
          <button type="submit"
            className="btn btn-dark write_btn" onClick={loginCheck}>등록하기</button>

          <div className="search_box">
            <form onSubmit={(e) => {
              e.preventDefault();    // 페이지 새로고침 방지
              getBoardList();         // axios 호출
            }}>
              <div class="search" style={{ display: 'flex' }} >
                <input class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                  type="text"
                  value={searchQuery}
                  onChange={(e) => setSearchQuery(e.target.value)}
                  placeholder="#태그 입력" />
                <button type="submit" class="btn btn-dark write_btn" style={{ marginLeft: '10px' }}>검색</button>
              </div>

            </form>
          </div>
        </div>

        {/* 게시글 목록  */}
        <div className='content_banner'>

          {
            boardList.map((board) => {
              return (
                <div className='content_board' style={{ border: 'solid 1px #9b9b9b', borderRadius: '20px' }} >
                  {/* <a href="#"><img src={'/src/assets/' + board.img} /></a> */}
                  <a href={"/member/boardview/" + board.no}><img src={board.thumnail} style={{ borderRadius: '20px' }} /></a>

                  <div className="board_title">
                    <a href={"/member/boardview/" + board.no}>{board.subject}</a> <br />
                  </div>
                  <div style={{ marginLeft: '20px', fontSize: '1.1em' }}>
                    
                    <div className='board_like'>
                      {board.userid}
                      <img src={'/src/assets/img/' + board.likeImg} />
                    </div>
                    <span style={{marginLeft:'8px', color:'#4696f1'}}>#{board.tag}</span>
                  </div>
                  <div className="board_hit">
                    <span>조회수 {board.hit}회</span>

                  </div>

                  {/* <span>💬 {board.###}</span> */}
                </div>
              )
            })
          }
        </div>
      </div>

      <div className='container'>
        <button type="submit" className="btn btn-outline-light text-dark">1</button>
      </div>

    </>
  )
}

export default Sharing
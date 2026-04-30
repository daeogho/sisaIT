import '/src/assets/css/rgy_style.css'
import { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import axios from 'axios'

function Interior() {
  const [logStatus, setLogStatus] = useState('N')
  const [qnaList, setQnaList] = useState([])
  const [openNo, setOpenNo] = useState(null)
  const navigate = useNavigate()

  /* 로그인 상태 */
  useEffect(() => {
    const log = sessionStorage.getItem('logStatus')
    if (log) setLogStatus(log)
  }, [])

  /* QnA 목록 */
  useEffect(() => {
    axios.get('http://192.168.4.86:9988/interior/list')
      .then(res => {
        const list = res.data.record.map(qna => {
          const context = qna.context || ''
          let thumbnail

          const imgIdx = context.indexOf('<img src="')
          if (imgIdx !== -1) {
            const endIdx = context.indexOf('"', imgIdx + 10)
            thumbnail = context.substring(imgIdx + 10, endIdx)
          } else {
            thumbnail = 'http://192.168.4.86:9988/uploads/1769067242086-img.jpg'
          }

          return {
            no: qna.no,
            subject: qna.subject,
            hit: qna.hit,
            context,
            thumbnail
          }
        })
        setQnaList(list)
      })
      .catch(console.error)
  }, [])

  const toggleContent = (no) => {
    setOpenNo(prev => (prev === no ? null : no))
  }

  const loginCheck = () => {
    if (logStatus !== 'Y') navigate('/member/login')
    else navigate('/interior/write')
  }

  const qnaEdit = (qna) => {
    sessionStorage.setItem('editQna', JSON.stringify(qna))
    navigate(`/interior/edit/${qna.no}`)
  }

  const qnaDel = (no) => {
    if (!window.confirm('현재 글을 삭제하시겠습니까?')) return
    axios.post('http://192.168.4.86:9988/interior/del', { no })
      .then(res => {
        if (res.data.result === 'ok') {
          setQnaList(prev => prev.filter(item => item.no !== no))
        } else alert('삭제 실패')
      })
      .catch(console.error)
  }

  return (
    <div className="interior-qna">
      <link rel="preconnect" href="https://fonts.googleapis.com"/>
      <link rel="preconnect" href="https://fonts.gstatic.com" />
      <link href="https://fonts.googleapis.com/css2?family=Gowun+Batang&family=Nanum+Pen+Script&family=Sunflower:wght@300&display=swap" rel="stylesheet"></link>
      <h1 style={{fontFamily:'Nanum Pen Script',fontSize:'5em',margin:'100px 0px',borderTop:'3px solid #d3d3d3',borderBottom:'3px solid #d3d3d3',padding:'30px',textAlign:'center'}}>
        <i>인테리어 Tip</i>
      </h1> 
      {qnaList.map(qna => (
        <div className="interior-qna__item" key={qna.no}>

          {/* 질문 카드 */}
          <div
            className="interior-qna__question"
            onClick={() => toggleContent(qna.no)}
          >
            {/* 답변 열렸을 때는 사진 안 보이게 */}
            {openNo !== qna.no && (
              <img
                src={qna.thumbnail}
                alt=""
                className="interior-qna__thumb"
              />
            )}

            <div className="interior-qna__info">
              <div className="interior-qna__subject">
                {qna.subject}
              </div>
            </div>
          </div>

          {/* 답변 */}
          {openNo === qna.no && (
            <div className="interior-qna__answer">
              <div
                className="interior-qna__content"
                dangerouslySetInnerHTML={{ __html: qna.context || '내용이 없습니다.' }}
              />

              {logStatus === 'Y' && (
                <div className="interior-qna__btns">
                  <button onClick={() => qnaEdit(qna)}>수정</button>
                  <button onClick={() => qnaDel(qna.no)}>삭제</button>
                </div>
              )}
            </div>
          )}

        </div>
      ))
      }

      {
        logStatus === 'Y' && (
          <div className="interior-qna__write">
            <button onClick={loginCheck}>작성하기</button>
          </div>
        )
      }
    </div >
  )
}

export default Interior
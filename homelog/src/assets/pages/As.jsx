import '/src/assets/css/rgy_style.css'
import { useState, useEffect } from 'react';
import axios from 'axios';

function As() {

  const [logStatus, setLogStatus] = useState('N');
  const [openIndex, setOpenIndex] = useState(null)
  const [asList, setAsList] = useState([])

  useEffect(() => {
    const log = window.sessionStorage.getItem('logStatus');
    if (log) setLogStatus(log);
  }, []);

  useEffect(() => {
    getAsList();
  }, []);

  const getAsList = () => {
    axios.get('http://192.168.4.86:9988/as/ask')
      .then((res) => {
        console.log("서버 데이터 응답:", res.data);
        if (res.data && res.data.record) {
          setAsList(res.data.record);
        }
      })
      .catch((err) => console.error("데이터 로딩 실패:", err));
  };

  //로그인 되어 있을 시 글 작성
  const loginCheck = () => {
    var logStatus = window.sessionStorage.getItem('logStatus');
    if (logStatus == null || logStatus == 'N') {//로그인 안 됨
      window.location.href = '/member/login';
    } else if (logStatus == 'Y') {//로그인 됨
      window.location.href = '/as/write';
    }
  }

  // 글 수정
  const asEdit = (as) => {
    sessionStorage.setItem('editAs', JSON.stringify(as));
    window.location.href = `/as/edit/${as.no}`;
  }
  // 글 삭제
  const asDel = (no) => {
    if (window.confirm("현재 글을 삭제하시겠습니까?")) {
      //해당 글을 지우고 목록으로 이동
      axios.post('http://192.168.4.86:9988/as/del', {
        no: no
      })
        .then((response) => {
          if (response.data.result == 'ok') {
            getAsList();
          } else {
            alert("삭제하지 못했습니다.")
          }
        })
        .catch((err) => console.error("요청 실패:", err))
    }
  }
  const toggle = (index) => {
    setOpenIndex(openIndex === index ? null : index)
  }

  return (
    <div className='qna'>
      <h1 className='main-logo'>무엇을 도와 드릴까요?</h1>

      <div className='mainq'>

        <div>
          
          {asList.map((as, index) => (
            <div key={index}>
              <a
                className={`as ${openIndex === index ? 'open' : ''}`}
                onClick={() => toggle(index)}
                style={{ cursor: 'pointer', display: 'block' }}
              >
                Q. {as.subject}
              </a>

              {openIndex === index && (
                <div className='answer-box'>
                  <p className='answer'>A. <div dangerouslySetInnerHTML={{ __html: as.context || '내용이 없습니다.' }}/></p>
                  {logStatus === 'Y' && (
                    <div id='btn-area'>
                      <button id='btn1' onClick={() => asEdit(as)}>수정</button>
                      <button id='btn1' onClick={(e) => {
                        e.stopPropagation();
                        asDel(as.no);
                      }}>삭제</button>
                    </div>
                  )}
                </div>
              )}
            </div>
          ))}
        </div>
      </div>

      <div id='btn-area'>
        {logStatus === 'Y' && (
          <button id='btn1'><a href='/as/form' style={{ color: '#ffffff' }}>작성하기</a></button>
        )}
      </div>
    </div>
  );
}

export default As
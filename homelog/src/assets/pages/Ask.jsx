import '/src/assets/css/rgy_style.css'
import { useState, useEffect } from 'react'
import axios from 'axios'
import { useNavigate } from 'react-router-dom'


function Ask() {
    const [logStatus, setLogStatus] = useState('N')
    const [askList, setAskList] = useState([])
    const [openIndex, setOpenIndex] = useState(null)
    const navigate = useNavigate()
    


    /* 로그인 상태 체크 */
    useEffect(() => {
        const log = sessionStorage.getItem('logStatus')
        if (log) setLogStatus(log)
    }, [])


    /* Q&A 목록 가져오기 */
    // useEffect(() => {
    //     getAskList()
    // }, [])


    // const getAskList = () => {
    //     axios.get('http://192.168.4.86:9988/ask/list')
    //         .then(res => {
    //             if (res.data?.record) setAskList(res.data.record)
    //         })
    //         .catch(err => console.error(err))
    // }
    useEffect(() => {
        axios.get('http://192.168.4.86:9988/ask/list')
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
                setAskList(list)
            })
            .catch(console.error)
    }, [])


    const toggle = (index) => {
        setOpenIndex(prev => (prev === index ? null : index))
    }


    const loginCheck = () => {
        if (logStatus !== 'Y') navigate('/member/login')
        else navigate('/ask/form')
    }


    const askEdit = (ask) => {
        sessionStorage.setItem('editAsk', JSON.stringify(ask))
        navigate(`/ask/edit/${ask.no}`)
    }


    const askDel = (no) => {
        if (!window.confirm('현재 글을 삭제하시겠습니까?')) return
        axios.post('http://192.168.4.86:9988/ask/del', { no })
            .then(res => {
                if (res.data.result === 'ok'){
                    alert('삭제 되었습니다.')
                    window.location.href='/ask/list'
                } 
                else alert('삭제하지 못했습니다.')

            })
            .catch(err => console.error(err))
    }


    return (
        <div className="interior-qna" style={{ minHeight: '70vh', maxWidth: '800px', margin: '0 auto', padding: '20px' }}>
            <h1 className="main-logo">집꾸미기</h1>
            <div className="interior-qna__list">
                {askList.map((ask, index) => (
                    <div className="interior-qna__item" key={ask.no}>
                        <div
                            className="interior-qna__question"
                            onClick={() => toggle(index)}
                        >
                            <div className="interior-qna__subject">
                                Q. {ask.subject}
                            </div>
                        </div>


                        {openIndex === index && (
                            <div className="interior-qna__answer">
                                <div className="interior-qna__content">
                                    A.<div dangerouslySetInnerHTML={{ __html: ask.context }} />     
                                </div>


                                {logStatus === 'Y' && (
                                    <div className="interior-qna__btns">
                                        <button onClick={() => askEdit(ask)}>수정</button>
                                        <button onClick={() => askDel(ask.no)}>삭제</button>
                                    </div>
                                )}
                            </div>
                        )}
                    </div>
                ))}
            </div>


            {/* 글쓰기 버튼 */}
            {logStatus === 'Y' && (
                <div className="interior-qna__write" style={{ justifyContent: 'flex-end' }}>
                    <button onClick={loginCheck}>작성하기</button>
                </div>
            )}
        </div>
    )
}


export default Ask
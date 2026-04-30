import '@toast-ui/editor/dist/toastui-editor.css'
import { Editor } from '@toast-ui/react-editor'
import axios from 'axios'
import { useRef, useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import '/src/assets/css/rgy_style.css'


function Ask() {
        const editorRef = useRef()
        const navigate = useNavigate()


        // 폼 데이터
        const [askData, setAskData] = useState({ subject: '' })


        // 페이지 로딩 시 에디터 초기화
        useEffect(() => {
                editorRef.current?.getInstance().setHTML('')
        }, [])


        // input 공통 onChange
        const onChangeForm = (e) => {
                const { name, value } = e.target
                setAskData(prev => ({ ...prev, [name]: value }))
        }


        // 글 등록
        const submitWrite = (e) => {
                e.preventDefault()
                const editorHtml = editorRef.current?.getInstance().getHTML()


                if (!askData.subject) {
                        alert('제목을 입력하세요.')
                        return
                }
                if (!editorHtml || editorHtml === '') {
                        alert('내용을 입력하세요.')
                        return
                }


                axios.post('http://192.168.4.86:9988/ask/write', {
                        subject: askData.subject,
                        context: editorHtml
                })
                        .then(res => {
                                if (res.data.result === 'success') {
                                        alert('게시글이 등록되었습니다.')
                                        navigate('/ask/list')
                                } else {
                                        alert('게시글이 등록되지 않았습니다.')
                                }
                        })
                        .catch(err => {
                                console.error(err)
                                alert('서버 요청 중 오류가 발생했습니다.')
                        })
        }


        return (
                <div className="form-container">


                        <header className="form-header">
                                <img src="/src/assets/img/writeicon.png" alt="icon" />
                                <h1 className="form-title">집꾸미기 글쓰기</h1>
                        </header>


                        <hr className="form-divider" />


                        <form className="form-body" onSubmit={submitWrite}>


                                <div className="form-group">
                                        <label className="form-label">제목</label>
                                        <input
                                                type="text"
                                                name="subject"
                                                className="form-input"
                                                value={askData.subject}
                                                onChange={onChangeForm}
                                        />
                                </div>


                                <div className="form-group">
                                        <label className="form-label">내용</label>
                                        <Editor
                                                ref={editorRef}
                                                height="700px"
                                                previewStyle="vertical"
                                                initialEditType="wysiwyg"
                                                useCommandShortcut={false}
                                                hooks={{
                                                        addImageBlobHook: async (blob, callback) => {
                                                                const formData = new FormData()
                                                                formData.append('image', blob)


                                                                const res = await fetch(
                                                                        'http://192.168.4.86:9988/upload',
                                                                        { method: 'POST', body: formData }
                                                                )
                                                                const data = await res.json()
                                                                callback(data.url)
                                                        }
                                                }}
                                        />
                                </div>


                                <div className="form-actions form-actions--double">
                                        <button type="submit" className="form-submit">
                                                글등록
                                        </button>
                                        <button
                                                type="button"
                                                className="form-cancel"
                                                onClick={() => navigate('/ask/list')}
                                        >
                                                취소
                                        </button>
                                </div>


                        </form>
                </div>
        )
}


export default Ask
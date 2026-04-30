import '@toast-ui/editor/dist/toastui-editor.css'
import { Editor } from '@toast-ui/react-editor'
import axios from 'axios'
import { useRef, useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import '/src/assets/css/rgy_style.css'


function InteriorForm() {
        const editorRef = useRef()
        const navigate = useNavigate()


        const [qnaData, setQnaData] = useState({ subject: '' })


        // 에디터 초기화
        useEffect(() => {
                editorRef.current?.getInstance().setHTML('')
        }, [])


        // input 공통 처리
        const onChangeForm = (e) => {
                const { name, value } = e.target
                setQnaData(prev => ({ ...prev, [name]: value }))
        }


        // 글 등록
        const submitWrite = (e) => {
                e.preventDefault()
                const editorHtml = editorRef.current?.getInstance().getHTML()


                if (!qnaData.subject) {
                        alert('제목을 입력하세요.')
                        return
                }
                if (!editorHtml || editorHtml === '<p><br></p>') {
                        alert('내용을 입력하세요.')
                        return
                }


                axios.post('http://192.168.4.86:9988/interior/write', {
                        subject: qnaData.subject,
                        context: editorHtml
                })
                        .then(res => {
                                if (res.data.result === 'success') {
                                        alert('게시글이 등록되었습니다.')
                                        navigate('/interior/list')
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
                                <h1 className="form-title">INTERIOR Tip</h1>
                        </header>


                        <hr className="form-divider" />


                        <form className="form-body" onSubmit={submitWrite}>


                                <div className="form-group">
                                        <label className="form-label">제목</label>
                                        <input
                                                type="text"
                                                name="subject"
                                                className="form-input"
                                                value={qnaData.subject}
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
                                                onClick={() => navigate('/interior/list')}
                                        >
                                                취소
                                        </button>
                                </div>


                        </form>
                </div>
        )
}


export default InteriorForm
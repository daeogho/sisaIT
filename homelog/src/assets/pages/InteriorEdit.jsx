import '@toast-ui/editor/dist/toastui-editor.css'
import { Editor } from '@toast-ui/react-editor'
import axios from 'axios'
import { useRef, useEffect, useState } from 'react'
import { useParams, useNavigate } from 'react-router-dom'
import '/src/assets/css/rgy_style.css'


function InteriorEdit() {
        const { no } = useParams()
        const navigate = useNavigate()
        const editorRef = useRef()


        const [interiorData, setInteriorData] = useState({
                subject: '',
                context: ''
        })


        useEffect(() => {
                axios.post('http://192.168.4.86:9988/interior/editForm', { no })
                        .then(res => {
                                setInteriorData(res.data.record)
                                editorRef.current?.getInstance().setHTML(res.data.record.context)
                        })
                        .catch(err => console.error(err))
        }, [no])


        const onChangeForm = (e) => {
                const { name, value } = e.target
                setInteriorData(prev => ({ ...prev, [name]: value }))
        }


        const submitEdit = (e) => {
                e.preventDefault()
                const editorHtml = editorRef.current?.getInstance().getHTML()


                if (!interiorData.subject) {
                        alert('제목을 입력하세요.')
                        return
                }
                if (!editorHtml || editorHtml === '<p><br></p>') {
                        alert('내용을 입력하세요.')
                        return
                }


                axios.post('http://192.168.4.86:9988/interior/editOk', {
                        no: interiorData.no,
                        subject: interiorData.subject,
                        context: editorHtml
                })
                        .then(res => {
                                if (res.data.result === 'success') {
                                        alert('게시글이 수정되었습니다.')
                                        navigate(`/interior/list`)
                                } else {
                                        alert('수정 실패')
                                }
                        })
                        .catch(err => {
                                console.error(err)
                                alert('서버 오류')
                        })
        }


        return (
                <div className="form-container">


                        <header className="form-header">
                                <img src="/src/assets/img/writeicon.png" alt="icon" />
                                <h1 className="form-title">INTERIOR TIP EDIT</h1>
                        </header>


                        <hr className="form-divider" />

                        <form className="form-body" onSubmit={submitEdit}>

                                <div className="form-group">
                                        <label className="form-label">제목</label>
                                        <input
                                                type="text"
                                                name="subject"
                                                className="form-input"
                                                value={interiorData.subject}
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


                                <div className="form-actions">
                                        <button type="submit" className="form-submit">
                                                수정하기
                                        </button>
                                </div>


                        </form>
                </div>
        )
}


export default InteriorEdit
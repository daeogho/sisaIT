import '@toast-ui/editor/dist/toastui-editor.css'
import { Editor } from '@toast-ui/react-editor'
import axios from 'axios'
import { useRef, useEffect, useState } from 'react'
import { useParams, useNavigate } from 'react-router-dom'
import '/src/assets/css/rgy_style.css'


function AskEdit() {
  const editorRef = useRef()
  const navigate = useNavigate()
  const { no } = useParams()


  const [askData, setAskData] = useState({ subject: '', context: '' })


  useEffect(() => {
    const storedAsk = sessionStorage.getItem('editAsk')
    if (storedAsk) {
      const ask = JSON.parse(storedAsk)
      setAskData({
        subject: ask.subject || '',
        context: ask.context || ''
      })
      editorRef.current?.getInstance().setHTML(ask.context || '')
    }
  }, [])


  const setAskFormData = (e) => {
    const { name, value } = e.target
    setAskData(prev => ({ ...prev, [name]: value }))
  }


  const submitEdit = (e) => {
    e.preventDefault()
    const editorHtml = editorRef.current?.getInstance().getHTML()


    if (!askData.subject) {
      alert('제목을 입력하세요.')
      return
    }
    if (!editorHtml || editorHtml === '<p><br></p>') {
      alert('내용을 입력하세요.')
      return
    }


    axios.post('http://192.168.4.86:9988/ask/editOk', {
      no,
      subject: askData.subject,
      context: editorHtml
    })
      .then(res => {
        if (res.data.result === 'success') {
          alert('수정이 완료되었습니다.')
          window.location.href='/ask/list'
        } else {
          alert('수정에 실패했습니다.')
        }
      })
      .catch(err => console.error(err))
  }
  


  return (
    <div className="form-container">


      <header className="form-header">
        <img src="/src/assets/img/writeicon.png" alt="icon" />
        <h1 className="form-title">집꾸미기 수정하기</h1>
      </header>


      <hr className="form-divider" />


      <form className="form-body" onSubmit={submitEdit}>
        <div className="form-group">
          <label className="form-label">제목</label>
          <input
            type="text"
            name="subject"
            className="form-input"
            value={askData.subject}
            onChange={setAskFormData}
          />
        </div>


        <div className="form-group">
          <label className="form-label">내용</label>
          <Editor
            ref={editorRef}
            height="400px"
            previewStyle="vertical"
            initialEditType="wysiwyg"
            useCommandShortcut={false}
            hooks={{
              // 이미지 업로드 훅 예시
              addImageBlobHook: async (blob, callback) => {
                const formData = new FormData();
                formData.append('image', blob);


                // 실제 서버 API로 교체
                const res = await fetch('http://192.168.4.86:9988/upload', { method: 'POST', body: formData })
                const data = await res.json()

                // 업로드 완료 후 URL 콜백
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


export default AskEdit
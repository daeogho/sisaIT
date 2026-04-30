import '@toast-ui/editor/dist/toastui-editor.css'
import { Editor } from '@toast-ui/react-editor'
import axios from 'axios'
import { useRef, useEffect, useState } from 'react'
import { useParams, useNavigate } from 'react-router-dom'


function AsEdit() {
  const editorRef = useRef()
  const navigate = useNavigate()
  const { no } = useParams()


  const [asData, setAsData] = useState({ subject: '', context: '' })


  useEffect(() => {
    const storedAs = sessionStorage.getItem('editAs')
    if (storedAs) {
      const as = JSON.parse(storedAs)
      setAsData({
        subject: as.subject || '',
        context: as.context || ''
      })
      editorRef.current?.getInstance().setHTML(as.context || '')
    }
  }, [])


  const setAsFormData = (e) => {
    const { name, value } = e.target
    setAsData(prev => ({ ...prev, [name]: value }))
  }


  const submitEdit = (e) => {
    e.preventDefault()
    const editorHtml = editorRef.current?.getInstance().getHTML()


    if (!asData.subject) {
      alert('제목을 입력하세요.')
      return
    }
    if (!editorHtml) {
      alert('내용을 입력하세요.')
      return
    }


    axios.post('http://192.168.4.86:9988/as/editOk', {
      no,
      subject: asData.subject,
      context: editorHtml
    })
      .then(res => {
        if (res.data.result === 'success') {
          alert('수정이 완료되었습니다.')
          navigate('/as/list')
        } else {
          alert('수정 실패')
        }
      })
      .catch(err => console.error(err))
  }


  return (
    <div className="form-container">


      <header className="form-header">
        <img src="/src/assets/img/writeicon.png" alt="icon" />
        <h1 className="form-title">고객지원</h1>
      </header>


      <hr className="form-divider" />


      <form className="form-body" onSubmit={submitEdit}>
        <div className="form-group">
          <label className="form-label">제목</label>
          <input
            type="text"
            name="subject"
            className="form-input"
            value={asData.subject}
            onChange={setAsFormData}
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


export default AsEdit
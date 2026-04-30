import '@toast-ui/editor/dist/toastui-editor.css'
import { Editor } from '@toast-ui/react-editor'
import axios from 'axios'
import { useRef, useEffect, useState } from 'react'

function BoardForm() {
        const editorRef = useRef()

        // 페이지 로딩 시 초기 내용 설정
        useEffect(() => {
                editorRef.current?.getInstance().setHTML('')
        }, [])

        //폼 데이터를 담을 변수
        const [BoardData, setBoardData] = useState({ subject: '' })
        const setBoardFormData = function (event) {
                var key = event.target.name
                var value = event.target.value
                console.log(key, value)

                setBoardData((prev) => {
                        return { ...prev, [key]: value };
                })
        }
        //비동기식 통신
        const BoardWrite = function (event) {
                event.preventDefault();
                //에디터에서 현재 입력된 HTML 내용을 가져온다.
                const editorHtml = editorRef.current?.getInstance().getHTML();
                console.log(editorHtml)
                if (BoardData.subject == '') {
                        alert('제목을 입력하세요.');
                        return false;
                }
                if (editorHtml === '') {
                        alert('내용을 입력하세요.');
                        return false;
                }
                const sendData = {
                        subject: BoardData.subject,
                        context: editorHtml, // 서버의 request.body.content와 이름을 맞춤
                        tag:BoardData.tag
                };

                axios.post('http://192.168.4.86:9988/board/write', sendData)
                        .then((response) => {
                                console.log(response.data)

                                if (response.data.result == 'success') {
                                        alert("게시글이 등록되었습니다.");
                                        window.location.href = '/member/sharing'
                                } else {
                                        alert("게시글이 등록되지 않았습니다.");
                                }
                        })
                        .catch((error) => {
                                console.log("전송 에러:", error);
                                alert('서버 요청 중 오류가 발생하였습니다.');
                        });
        };

        return (
                <div className='qna' style={{ width: '1500px', margin: '50px auto' }}>
                        <div className='main-logo'
                                style={{
                                        textAlign: 'Left',
                                        margin: '50px 0px'
                                }}>
                                <img src='/src/assets/img/writeicon.png' style={{ width: '100px', marginRight: '20px' }} />
                                BOARD
                        </div>
                        <hr style={{ marginBottom: '50px' }} />

                        <form onSubmit={BoardWrite}>
                                <div className='main-1'>
                                        <div className='editor-section'>
                                                <div style={{
                                                        border: '2px solid #f4f4f4',
                                                        padding: '30px 30px', borderRadius: '20px',
                                                        background: '#ffffff',
                                                        marginBottom: '30px'
                                                }}>
                                                        <p style={{ fontSize: '1.3em', color: 'grey' }}>#태그</p>
                                                        <input type="text" name="tag" className='tag'
                                                                style={{
                                                                        marginBottom: '50px',
                                                                        height: '60px',
                                                                        borderRadius: '20px',
                                                                        width: '50%'
                                                                }}
                                                                onChange={setBoardFormData} />
                                                </div>

                                                <p style={{ fontSize: '1.3em', color: 'grey' }}>제목</p>

                                                <input type="text" name="subject" className="form-input"
                                                        style={{
                                                                marginBottom: '30px',
                                                                height: '60px',
                                                                borderRadius: '20px'
                                                        }}
                                                        onChange={setBoardFormData} />

                                                <p style={{ fontSize: '1.3em', color: 'grey' }}>
                                                        내용</p>

                                                <Editor
                                                        ref={editorRef}
                                                        height="700px"
                                                        previewStyle="vertical"
                                                        initialValue=""
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
                                                <div className='btn-area' style={{ margin: '50px auto' }}>
                                                        <button id='btn1' type="submit" style={{
                                                                width: '150px',
                                                                height: '50px',
                                                                fontSize: '1.1em'
                                                        }}>
                                                                글등록</button>
                                                        <button id='btn1' onClick={() => { window.location.href = '/member/sharing' }}
                                                                style={{
                                                                        width: '150px',
                                                                        height: '50px',
                                                                        fontSize: '1.1em',
                                                                        marginLeft: '50px'
                                                                }}>취소</button>
                                                </div>
                                        </div>
                                </div>
                        </form>
                </div>
        )
}

export default BoardForm

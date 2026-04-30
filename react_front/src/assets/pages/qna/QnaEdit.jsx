import {  useEffect } from "react";
import { useState, useRef } from "react";
// Toast UI Editor
import {Editor} from '@toast-ui/react-editor'
import '@toast-ui/editor/dist/toastui-editor.css';
// 색상 플러그인
import colorSyntax from "@toast-ui/editor-plugin-color-syntax";
import "tui-color-picker/dist/tui-color-picker.css";
import "@toast-ui/editor-plugin-color-syntax/dist/toastui-editor-plugin-color-syntax.css";
import axios from "axios";

import { useParams } from "react-router-dom";


function QnaEdit() {
      
  
  const editorRef = useRef();
  // 현재 글 정보가져오기
  const {id} = useParams(); // 글번호 가져오기    
  const mounted = useRef(false);
  //원글을 보관할 변수
  const [qnaData, setQnaData] = useState({}); 
  useEffect(()=>{
         
                        getQnaData();
          
  },[]);    
  var setFormData =(event)=>{
                const key = event.target.name; // searchKey, searchWord
                const value = event.target.value; // 검색옵션값 또는 검색어

                setQnaData((prev)=>{
                        return {...prev, [key]:value}
                })

        }            
  function getQnaData(){
        axios.get(`http://43.202.150.110:9988/qna/qnaDetail/${id}`)
        .then((response)=>{
               console.log("글수정 폼 글 정보가져오기 성공==>",response.data);
               setQnaData({
                        id:response.data.id,
                        subject:response.data.subject,
                        content:response.data.content
                });
                const editor = editorRef.current?.getInstance();
                if (editor) {
                        editor.setHTML(response.data.content);
                }
        })
        .catch((error)=>{
                console.log("글수정 폼 글 정보가져오기 에러 발생함..",error);
        })
  }
  // 수정 버튼
  const handleRegisterButton = () => {
        const editor = editorRef.current?.getInstance();
        if (!editor) return;

        const html = editor.getHTML(); // useState에 글내용이 없으므로 useState변수에 대입한다.
        // setBbsData((prev)=>{
        //         return {...prev, content:html}
        // })    
        var qnaData2 = {
                id:qnaData.id,
                subject:qnaData.subject,
                content:html
        }


        console.log("등록할 데이터:", qnaData2);
        if(qnaData2.subject == ''){
                alert("글제목을 입력하세요.");
                return false;
        }
        if(qnaData2.content == '' || qnaData2.content == '<p><br></p>'){
                alert("글내용을 입력하세요.");
                return false;
        }       

        // 비동기 호출
        axios.post("http://43.202.150.110:9988/qna/qnaEditOk", qnaData2)
        .then((response) => {
                console.log(response.data);
                if(response.data){
                        window.location.href = `/qna/qnaDetail/${qnaData2.id}`;  
                }
        })
        .catch((error)=>{
                console.log("글등록 에러발생==>",error)
        })

  }



        return(
                <div className="container">
                      <h2>QnA 글수정폼</h2>

                        <div className="mb-3 mt-3">
                                <label htmlFor="subject" className="form-label">
                                제목
                                </label>
                                <input
                                type="text"
                                name="subject"
                                className="form-control"
                                id="subject"
                                placeholder="글제목"
                                value={qnaData.subject || ''}
                                onChange={setFormData}
                                />
                        </div>

                        <div className="mb-3 mt-3">
                                <Editor
                                ref={editorRef}
                                initialValue=" "
                                previewStyle="vertical"
                                height="400px"
                                initialEditType="wysiwyg"
                                hideModeSwitch={true}
                                useCommandShortcut={false}
                                plugins={[colorSyntax]}        
                                />
                        </div>

                        <div className="mb-3 mt-3 d-grid">
                                <input
                                type="submit"
                                value="공지사항수정"
                                onClick={handleRegisterButton}
                                className="btn btn-success btn-block"
                                />
                        </div>

                </div>
        )

}
export default QnaEdit
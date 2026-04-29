import React from "react";
import { useState, useRef } from "react";
// Toast UI Editor
import {Editor} from '@toast-ui/react-editor'
import '@toast-ui/editor/dist/toastui-editor.css';
// 색상 플러그인
import colorSyntax from "@toast-ui/editor-plugin-color-syntax";
import "tui-color-picker/dist/tui-color-picker.css";
import "@toast-ui/editor-plugin-color-syntax/dist/toastui-editor-plugin-color-syntax.css";
import axios from "axios";


function DataForm() {
      
  const [subject, setSubject] = useState(""); // 글제목
  const editorRef = useRef(); // 글내용
  const [files, setFiles] = useState([]); // ['a.gif','b.txt', 'c.exe']]
  // 첨부파일을 선택하면
  function handleFileChange(event){
        setFiles(Array.from(event.target.files));
  }      
  // ✅ 등록 버튼
  const handleRegisterButton = () => {
        // 첨부파일을 보내야하므로 Form객체를 만들어 데이터를 담아 전송해야한다.    
        const editor = editorRef.current?.getInstance();
        if (!editor) return;

        const html = editor.getHTML(); //글내용
     
        if(subject== ''){
                alert("글제목을 입력하세요.");
                return false;
        }
        if(html == '' || html == '<p><br></p>'){
                alert("글내용을 입력하세요.");
                return false;
        }       
        // 첨부파일이 있는지 확인
        if(files.length == 0){
                alert("첨부파일은 반드시 1개 이상이여야 합니다.");
                return false;
        }

        const formData = new FormData();
        formData.append("joinsEntity.id", window.sessionStorage.getItem("id")); //글쓴이
        formData.append("subject",subject); // 글제목
        formData.append("content",html); // 글내용
        // 첨부파일
        for(var i=0 ;i<files.length ;i++){
                formData.append("files",files[i])// 여러개 파일을 form객체에 추가 <input type="file">
        }

        // 비동기 호출
        axios.post("http://192.168.4.50:9988/data/dataWrite", formData,{
                headers: {
                        "Content-Type": "multipart/form-data"
                }
        })
        .then((response) => {
                console.log("response.data", response.data);
                console.log("flies",files);    
                if(response.data == "OK"){
                        window.location.href="/data/dataList";
                }
        })
        .catch((error)=>{
                console.log("글등록 에러발생==>",error)
        })

  }



        return(
                <div className="container">
                      <h2>자료실 글쓰기폼</h2>

                        <div className="mb-3 mt-3">
                                <label htmlFor="subject" className="form-label">
                                제목
                                </label>
                                <input
                                type="text" name="subject"
                                className="form-control"
                                id="subject"placeholder="글제목"
                                value={subject || ''}onChange={(e) => setSubject(e.target.value)}
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
                        {/*첨부파일 */}
                          <div className="mb-3 mt-3">
                                <label htmlFor="files" className="form-label">첨부파일</label>
                                <input type="file" name="files" 
                                className="form-control" id="files"
                                multiple onChange={handleFileChange}/>
                        </div>
                        <div className="mb-3 mt-3 d-grid">
                                <input
                                type="submit"
                                value="자료실 등록"
                                onClick={handleRegisterButton}
                                className="btn btn-success btn-block"
                                />
                        </div>

                </div>
        )

}
export default DataForm
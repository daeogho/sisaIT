import { useEffect, useRef, useState } from "react";
import axios from "axios";
import { useParams } from "react-router-dom";

import {Editor} from '@toast-ui/react-editor';
import "@toast-ui/editor/dist/toastui-editor.css";

// 색상 플러그인
import colorSyntax from "@toast-ui/editor-plugin-color-syntax";
import "tui-color-picker/dist/tui-color-picker.css";
import "@toast-ui/editor-plugin-color-syntax/dist/toastui-editor-plugin-color-syntax.css";

function DataEdit(){
        const [subject, setSubject] = useState("");
        const editorRef = useRef();
        const [files, setFiles] = useState([]); //['a.gif', 'b.txt', 'c.exe']
        //기존 첨부파일 가져오기
        const [orgFile, setOrgFile] = useState([])//기존 첨부파일 {id, 파일명}
        const [delFile, setDelFile] = useState([])//삭제할 파일 정보 저장

        //첨부파일을 선택하면
        function handleFileChange(event){
                setFiles(Array.from(event.target.files));
        }

        // 해당 글 번호
        const {id} = useParams()
        // 기존 글 가져오기
        const mounted = useRef(false)
        useEffect(()=>{
               
                        getOriginalData()
        }, [])
        const getOriginalData = ()=>{
                axios.get(`http://192.168.4.50:9988/data/dataDetail/${id}`)
                .then((response)=>{
                        console.log("파일왔는지확인->", response.data)
                        //제목
                        setSubject(response.data.data.subject)
                        //글내용
                        const editor = editorRef.current?.getInstance()
                        if(editor){
                                editor.setHTML(response.data.data.content)
                        }
                        //기존 첨부파일
                        const fileList = []
                        response.data.fileList.map((f)=>{
                                console.log("파일명확인", f.filename)
                                fileList.push({id:f.id, filename:f.filename+"."+f.extname})
                        })
                        setOrgFile(fileList)
                        console.log("리스트에 왔는지 확인", fileList)
                })
                .catch((error)=>{
                        console.log("원글 가져오기 예외 발생"+error)
                })
        }
        //삭제할 파일 저장
        const addDelFile = (event, fileId)=>{
                //이전 데이터 보전하고 삭제할 파일의 id를 추가한다.
                delFile.push(fileId)
                //<b>태그의 부모인 <div>를 지우거나 안 보이게 한다.
                const parentElement =event.target.parentElement;
                parentElement.style.display = "none";

                console.log(delFile)
        }

        // ✅ 등록 버튼------------------------------------------------------
        const handleDataButton = async() => {
                //첨부파일을 보내야 하므로 Form객체를 만들어 데이터를 담아 전송한다.
                const editor = editorRef.current?.getInstance();
                if (!editor) return;

                const html = editor.getHTML();//글 내용

                //데이터 입력 확인 subject, content
                if(subject==""){
                        alert("제목을 입력하세요.");
                        return;
                }
                if(html==""||html=="<p><br></p>"){
                        alert("글 내용을 입력하세요.");
                        return;
                }
                //첨부파일 확인
                //새로 추가+이전 업로드 파일-삭제한 이전 업로드 파일
                //  0 + 3 - 3 = 0 일 시는 알람이 뜨고 1 + 3 - 3 = 1일 시에는 알람x
                if(files.length + orgFile.length - delFile.length == 0){
                        alert("첨부파일은 반드시 1개 이상이어야 합니다.");
                        return false;
                }
                const formData = new FormData(); // <form></form>
                formData.append("id", id)//원글번호
                formData.append("subject", subject)//수정한 제목
                formData.append("content", html)//수정한 글 내용
                //첨부파일
                console.log("files:", files);
                console.log("files.length", files.length)

                //새로 추가한 첨부 파일
                for(var i=0; i<files.length; i++){
                        formData.append("files", files[i])//여러 개 파일을 form객체에 배열로 추가 <input type="file">
                }
                //수정에서 삭제할 파일 목록
                for(var i=0; i<delFile.length; i++){
                        formData.append("delFile", delFile[i])
                }

                //비동기호출
                axios.post('http://192.168.4.50:9988/data/dataEditOk', formData,{
                        headers:{
                                "Content-Type":"multipart/form-data"
                        }
                })
                .then((response)=>{
                        console.log(response.data);
                        if(response.data == "OK"){
                                window.location.href = `/data/dataDetail/${id}`
                        }
                })
                .catch((error)=>{
                        console.log(error);
                })
        }

        return(
                <div className="container">
                        <h2>자료실 수정 폼</h2>

                        <div className="mb-3 mt-3">
                                <label htmlFor="subject" className="form-label">
                                제목
                                </label>
                                <input
                                        type="text" name="subject" className="form-control"
                                        id="subject" placeholder="글 제목 입력" value={subject||''}
                                        onChange={(e) => setSubject(e.target.value)}
                                />
                        </div>

                        <div className="mb-3 mt-3">
                                <Editor
                                        ref={editorRef} initialValue=" " previewStyle="vertical"
                                        height="400px" initialEditType="wysiwyg" hideModeSwitch={true}
                                        useCommandShortcut={false} plugins={[colorSyntax]}          
                                />
                        </div>

                        {/* 원글의 첨부파일 */}
                        <div className="mb-3 mt-3">
                                <label className="form-label">첨부파일</label>
                                {       
                                        orgFile.map((f, idx)=>{
                                                return <div key={idx} style={{float:'left', padding:'10px'}}>
                                                                <img src = {`http://192.168.4.50:9988/uploads/${f.filename}`}
                                                                style={{width:'100px', height:'100px'}}/>
                                                                <b onClick={(event)=>addDelFile(event, f.id)}
                                                                style={{cursor:"pointer"}}>X</b>
                                                        </div>
                                        })
                                }
                        </div>

                        {/* 첨부파일 */}
                        <div className="mb-3 mt-3">
                                <input
                                        type="file" name="files" className="form-control"
                                        multiple
                                        onChange={handleFileChange}
                                        // onChange={(e) => setSubject(e.target.value)}
                                />
                        </div>

                        <div className="mb-3 mt-3 d-grid">
                                <input
                                        type="submit" value="자료 수정"
                                        onClick={handleDataButton}
                                        className="btn btn-success btn-block"
                                />
                        </div>
                </div>
        )
}

export default DataEdit
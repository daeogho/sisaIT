import axios from "axios";
import { useEffect, useRef, useState } from "react";
import { Link, useParams } from "react-router-dom";

function DataDetail(){

        const {id} = useParams()
        const [filelist, setFilelist] = useState([]) // ['a.png','b.jpg','c.jpeg']
        const [data, setData] = useState({})

        const mounted = useRef(false)
        useEffect(()=>{
              
                        getDataDetail()
                
        },[])
        function getDataDetail(){
                axios.get(`http://43.202.150.110:9988/data/dataDetail/${id}`)
                .then((response)=>{
                        let d = response.data.data;
                        console.log("d",d);
                        setData({
                                id:d.id,
                                username:d.joinsEntity.username,
                                hit:d.hit,
                                writedate:d.writedate,
                                subject:d.subject,
                                content:d.content
                        })
                        // 첨부파일
                        const file = [];
                        console.log(response.data.fileList)
                        response.data.fileList.map((f)=>{
                                file.push(f.filename+"."+f.extname);
                        })
                        setFilelist(file);
                })
                .catch((error)=>{
                        console.log("자료실 상세보기 에러==>",error)
                })
                


        }
        // 첨부파일 다운로드
        const downloadFile = async (dFilename) =>{
             // 다운로드 받을 파일을 boot에 요청   
             const response =  await axios.get(`http://43.202.150.110:9988/data/file/download/${dFilename}`,
                                        {responseType:'blob'}
             )
             // href에 대입할 주소 만들기  href="파일명", href="바이너리 코드"
             const url = window.URL.createObjectURL(new Blob([response.data]))
             // a태그 만들기
             const a = document.createElement("a")
             // href속성에 url대입
             a.href = url
             a.download = `${dFilename}`

             // body에 a태그 추가
             document.body.appendChild(a)
             a.click()
             a.remove()
             // 브라우저에 심어 놓은 정보를 제거
             window.URL.revokeObjectURL(url)

        }
        // 자료실 글 삭제
        function dataDel(){
                if(confirm("글을 삭제하시겠습니까?")){
                        
                        axios.get(`http://43.202.150.110:9988/data/dataDelete/${id}`)
                        .then((response)=>{
                                console.log(response.data) 
                                if(response.data == "Ok"){
                                        window.location.href = "/data/dataList"
                                }
                        })
                        .catch((error)=>{
                                console.log(error)
                        })


                }
        }
        return (
                <div className="container">
                        <h1>자료실 글 내용보기</h1>
                        <div class="row" style={{borderBottom:"1px solid #ddd"}}>
                                <div class="col-sm-2 p-3">번호</div>
                                <div class="col-sm-10 p-3">{data.id}</div>
                        </div>
                          <div class="row" style={{borderBottom:"1px solid #ddd"}}>
                                <div class="col-sm-2 p-3">조회수</div>
                                <div class="col-sm-10 p-3">{data.hit}</div>
                        </div>
                        <div class="row" style={{borderBottom:"1px solid #ddd"}}>
                                <div class="col-sm-2 p-3">작성자</div>
                                <div class="col-sm-10 p-3">{data.username}</div>
                        </div>
                        <div class="row" style={{borderBottom:"1px solid #ddd"}}>
                                <div class="col-sm-2 p-3">작성일</div>
                                <div class="col-sm-10 p-3">{data.writedate}</div>
                        </div>
                        <div class="row" style={{borderBottom:"1px solid #ddd"}}>
                                <div class="col-sm-2 p-3">제목</div>
                                <div class="col-sm-10 p-3">{data.subject}</div>
                        </div>
                        <div class="row" style={{borderBottom:"1px solid #ddd"}}>
                                <div class="col-sm-2 p-3">글내용</div>
                                <div class="col-sm-10 p-3" dangerouslySetInnerHTML={{__html:data.content}}></div>
                        </div>
                          <div class="row" style={{borderBottom:"1px solid #ddd"}}>
                                <div class="col-sm-2 p-3">첨부파일</div>
                                <div class="col-sm-10 p-3">
                                        {/*첨부파일 목록 */}
                                        {
                                                filelist.map((file, i)=>{
                                                        return (
                                                                <img src={`http://43.202.150.110:9988/uploads/${file}`}
                                                                     style={{width:'100px', height:'100px',margin:'10px',cursor:'pointer'}}
                                                                     onClick={()=> downloadFile(`${file}`)}
                                                                     key={i}   
                                                                     />
                                                        )
                                                })
                                        }
                                </div>
                        </div>
                        {
                                (data.username == window.sessionStorage.getItem("logName"))
                                &&(
                                        <div style={{padding:'20px 0'}}>
                                                <button type="button" class="btn btn-success" onClick={()=> window.location.href = `/data/dataEdit/${data.id}`}>수정</button>
                                                <button type="button" class="btn btn-danger" onClick={dataDel}>삭제</button>
                                        </div>
                                )
                        }
                        
                </div>
        )
}
export default DataDetail;
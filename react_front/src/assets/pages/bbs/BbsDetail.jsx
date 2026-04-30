import axios from "axios";
import { useEffect, useRef, useState } from "react";
import { Link, useParams } from "react-router-dom";


function BbsDetail(){
        // (글번호) 전페이지에서 보낸 글번호 받아오기
        const {id} = useParams();

        // 가져온 게시글 보관할 변수
        const [bbsData, setBbsData] = useState({});

        // 서버에서 1번 현재 글 정보 가져오기
        const mounted = useRef(false);
        useEffect(()=>{
                // if(!mounted.current){
                //         mounted.current = true;
                // }else{
                        getBbsDetail();
                
        },[]);
        function getBbsDetail(){
                axios.get(`http://43.202.150.110:9988/bbs/bbsDetail/${id}`)
                .then((response)=>{
                        console.log(response.data);
                        setBbsData({
                                id:response.data.id,
                                username:response.data.joinsEntity.username,
                                hit:response.data.hit, 
                                writedate:response.data.writedate,
                                subject:response.data.subject,
                                content:response.data.content,
                                joins_id:response.data.joinsEntity.id // 글쓴사람 아이디                               
                        });
                })
                .catch((error)=>{
                        console.log("글 정보 가져오기 에러 발생함..",error);
                })
        }
        // 글삭제
        function bbsDelete(){
                if(confirm("글을 삭제하시겠습니까?")){
                        axios.delete(`http://43.202.150.110:9988/bbs/bbsDelete/${bbsData.id}`)
                        .then((response)=>{//글삭제시 목록으로 이동하기
                                console.log(response.data);
                                if(response.data == 1){
                                        window.location.href = "/bbs/bbsList";
                                }
                        })
                        .catch((e)=>{
                                console.log("삭제 에러====>",e);
                        })
                }
        }
        return(
                <div>
                        <h1>뉴스글 내용보기</h1>
                        <table class="table">
                                <tbody>
                                        <tr>
                                                <td>번호</td>
                                                <td>{bbsData.id}</td>                  
                                        </tr>
                                        <tr>
                                                <td>작성자</td>
                                                <td>{bbsData.username}</td>                  
                                        </tr>
                                         <tr>
                                                <td>조회수</td>
                                                <td>{bbsData.hit}</td>                  
                                        </tr>
                                        <tr>
                                                <td>등록일</td>
                                                <td>{bbsData.writedate}</td>                  
                                        </tr>
                                        <tr>
                                                <td>제목</td>
                                                <td>{bbsData.subject}</td>                  
                                        </tr>
                                        <tr>
                                                <td>내용</td>
                                                <td dangerouslySetInnerHTML={{__html: bbsData.content}}></td>                  
                                        </tr>
                                        {
                                                (bbsData.joins_id == window.sessionStorage.id)
                                                &&(<tr>
                                                        <td colSpan={2}>
                                                        <Link to={`/bbs/bbsEdit/${bbsData.id}`}>수정</Link>
                                                        <Link onClick={bbsDelete}>삭제</Link>
                                                        </td>            
                                                   </tr>
                                                )
                                        }
                                        
                                    
                                </tbody>
                        </table>
                </div>
        )
        
}
export default BbsDetail;
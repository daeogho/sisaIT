import axios from "axios";
import { useEffect, useRef, useState } from "react"
import { Link } from "react-router-dom"

function QnaList() {
        // 처음에 서버에 가서 목록과 관련된 정보를 가져와야한다.
        // 총레코드수, 총페이지, 현재페이지, 해당 페이지의 레코드를 가져온다.
        const mounted = useRef(false);
        // page, 검색관련 변수
        const [pages, setPages] = useState({});

        // page번호를 보관할 배열
        const[pagenum, setPageNum] = useState([]); 

        // 선택한 레코드를 담을 변수
        const [list, setList] = useState([]); // [{},{},{}, ...]
        
        // 검색키와 검색어를 담을 변수
        const [searchData, setSearchData] = useState({searchKey:'subject', searchWord:''});
        useEffect(()=>{
             
                        getQnaList(1); 
                
        },[]);

        // springboot 서버에서 비동기식으로 정보를 가져올 함수
        function getQnaList(page){
                var url= "?nowPage=" + page;
                if(searchData.searchWord != ''){ // 검색어가 있을때 url : ex) http://192.168.4.50:9988/bbs/bbsList?nowPage=1&searchKey=subject&searchWord=자바
                        url +="&searchKey="+searchData.searchKey+"&searchWord="+searchData.searchWord;
                }

                axios.get('http://192.168.4.50:9988/qna/qnaList' + url)
                .then((response)=>{
                        console.log(response.data);
                        // 페이지 관련정보를 useState로 보관
                        setPages({
                                totalRecord: response.data.pages.totalRecord, // 총 레코드 수
                                totalPage: response.data.pages.totalPage, // 총 페이지
                                nowPage: response.data.pages.nowPage, // 현재 페이지
                                startPage: response.data.pages.startPage, // 시작페이지
                                onePageNumCount: response.data.pages.onePageNumCount // 한 페이지당 레코드 수
                              
                        })
                        // 출력할 페이지 번호 만들기
                        setPageNum([]); // 기존 페이지번호 초기화
                        let temp = [];
                        for(let p_num =response.data.pages.startPage; 
                        p_num < response.data.pages.startPage + response.data.pages.onePageNumCount; 
                        p_num++){
                        
                                if(p_num <= response.data.pages.totalPage){
                                        temp.push(p_num);
                                }
                        }
                        setPageNum(temp); 
                        console.log("페이지번호=>",temp);
                       

                        // 선택 레코드를 useState변수에 저장하기
                        setList([]); // 기존 레코드 초기화                   
                        response.data.qnaList.map((record)=>{
                                setList((previous)=>{
                                        // 원래 데이터 보존하면서 레코드 추가하기
                                        return [...previous,{
                                          id:record.id,
                                          subject : record.subject,
                                          username : record.joinsEntity.username,
                                          hit : record.hit,
                                          writedate : record.writedate
                                        }]
                                });
                        })

                })
                .catch((error)=>{
                        console.log("목록조회 에러발생==>",error)
                })
        }
        //검색키와 검색어 이벤트 처리
        var seachKeyWordChange =(event)=>{
                const key = event.target.name; // searchKey, searchWord
                const value = event.target.value; // 검색옵션값 또는 검색어

                setSearchData((prev)=>{
                        return {...prev, [key]:value}
                })

        }

        return(
                <div className="container">
                        <h1>공지사항 목록</h1>
                        {
                                (window.sessionStorage.getItem("logStatus")=='Y')
                                && ( <div>
                                        <Link to="/qna/qnaForm">공지작성하기</Link>
                                     </div>
                                )
                        }
                               
                        <div className="row">
                                <div className="col-sm-6 p-3 ">총 레코드 수 : {pages.totalRecord}</div>
                                <div className="col-sm-6 p-3 " style={{textAlign:'right',fontWeight:'bold'}}>{pages.nowPage}/{pages.totalPage}</div>
                        </div>
                        {/* 뉴스목록 */}
                         <div className="row" style={{background:'#f3f2f2'}}>
                                <div className="col-sm-1 p-3 ">번호</div>
                                <div className="col-sm-7 p-3 ">제목</div>
                                <div className="col-sm-1 p-3 ">작성자</div>
                                <div className="col-sm-1 p-3 ">조회수</div>
                                <div className="col-sm-2 p-3 ">등록일</div>
                        </div>
                        {
                                list.map((record, idx)=>{
                                        return(
                                              
                                                <div key={idx} className="row" style={{borderBottom:'1px solid #ccc'}}>
                                                        <div className="col-sm-1 p-3 ">{record.id}</div>
                                                        <div className="col-sm-7 p-3 "><Link to={`/qna/qnaDetail/${record.id}`}>{record.subject}</Link></div>
                                                        <div className="col-sm-1 p-3 ">{record.username}</div>
                                                        <div className="col-sm-1 p-3 ">{record.hit}</div>
                                                        <div className="col-sm-2 p-3 ">{record.writedate}</div>
                                                </div>
                                        )
                                })
                        }

                        {/* paging */}
                        <ul className="pagination justify-content-center" style={{margin:'50px 0'}}>
                                {/*이전페이지*/}
                                {
                                        (pages.nowPage>1)
                                        &&(  
                                                <li className="page-item"><Link className="page-link" onClick={()=>getQnaList(pages.nowPage-1)}>Prev</Link></li>
                                        )
                                }
                              
                                
                                {/*페이지 번호*/}
                                {
                                        pagenum.map((p, i)=>{
                                                // 현재 보는 페이지 "page-item active", 안 보는 페이지 "page-item"     
                                                var activeStyle= "page-item";
                                                if(p==pages.nowPage){
                                                        activeStyle = "page-item active";

                                                } 
                                                return(
                                                        <li key={i} className={activeStyle}>
                                                                <Link className="page-link" onClick={()=>getQnaList(p)}>{p}</Link>
                                                        </li>
                                                )
                                        })
                                }  
                                
                                {/*다음페이지*/}
                                {
                                        (pages.totalPage>pages.nowPage)
                                        &&(<li className="page-item"><Link className="page-link" onClick={()=>getQnaList(pages.nowPage+1)}>Next</Link></li>)
                                }
                                
                        </ul>
                        {/* 검색 */}
                        <div style={{padding:'30px 0'}}>
                                <select name="searchKey" id="searchKey" onChange={seachKeyWordChange}>
                                        <option value="subject">제목</option>
                                        <option value="username">작성자</option>
                                        <option value="content">글내용</option>
                                </select>
                                <input type="text" name="searchWord" id="searchWord"
                                        placeholder="검색어 입력"
                                        value={searchData.searchWord || ''}
                                        onChange={seachKeyWordChange}
                                        />
                                <input type="button" value="검색" onClick={()=>getQnaList(1)}/>
                        </div>



                </div>
        )
}
export default QnaList
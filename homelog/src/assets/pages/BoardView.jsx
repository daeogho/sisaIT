import { useParams } from "react-router-dom"
import { useState, useEffect } from 'react'
import axios from 'axios'
import '/src/assets/css/kdh_style.css'
const BoardView = () => {
        // useParams혹은 이전페이지에서 보낸값을 request해준다.
        const { board_no } = useParams();
        console.log('url받은 no:', board_no)

        //해당글 내용 가져오기
        const [boardData, setboardData] = useState({})

        // 댓글
        const [commentCount, setCommentCount] = useState([])

        // 댓글 등록
        const [commentText, setCommentText] = useState('')

        // 댓글 목록
        const [commentList, setCommentList] = useState([])

        // 프로필
        const [profile, setProfile] = useState([])

        //하트
        const [like, setLike] = useState('like.png')

        const userid = JSON.parse(sessionStorage.getItem("user")).userid // 로그인 알아내기위해

        useEffect(() => {
                getboard()
                getCommentList()
        }, [])

        const getboard = () => {
                axios.post('http://192.168.4.86:9988/member/boardview', { board_no: board_no })
                        .then((response) => {
                                console.log('게시판 서버응답', response.data)
                                setboardData(response.data.record)
                                if(response.data.likecheck==1){
                                       setLike('addlike.png') 
                                }
                        })
                        .catch((error) => {
                                console.log(error)
                        })
        }
        // 게시글 메인이동
        const boardMain = () => {
                window.location.href = '/member/sharing'
        }
        // 글수정으로 이동
        const boardEdit = () => {
                window.location.href = '/member/boardedit/' + boardData.no // /board/boardEdit
        }

        // 글삭제
        const boardDel = () => {
                if (window.confirm("현재글을 삭제하시겠습니까")) {
                        axios.post('http://192.168.4.86:9988/board/del', { board_no: boardData.no })
                                .then((response) => {
                                        if (response.data.result == "ok") {
                                                alert("삭제 되었습니다.")
                                                window.location.href = '/member/sharing'
                                        } else {
                                                alert("삭제못함.")
                                        }
                                })
                                .catch((error) => {
                                        console.log(error)
                                })
                }
        }
        // 좋아요
        const likeCheck = () => {
                axios.post('http://192.168.4.86:9988/member/like', { board_no: boardData.no })
                        .then((response) => {
                                console.log(response.data.likecheck)
                                if (response.data.likecheck == "like") {
                                        setLike('addlike.png')
                                } else if (response.data.likecheck == "unlike") {
                                        setLike('like.png')
                                }
                        })
                        .catch((error) => {
                                console.log(error)
                        })
        }
        // 댓글등록
        const getCommentWrite = () => {
                console.log('댓글:', commentText)
                if (commentText.trim() == '') {
                        alert('댓글을 입력하세요')
                        return
                }
                axios.post('http://192.168.4.86:9988/comment/write', {
                        board_no: board_no,
                        context: commentText,
                        board: 'homelog_db'
                }
                )
                        .then((res) => {
                                console.log('서버 응답:', res.data)

                                if (res.data.result == 'success') {
                                        alert('댓글이 등록 되었습니다')
                                        setCommentText('')
                                        getCommentList()
                                } else if (res.data.result == 'no-login') {
                                        alert('로그인이 필요합니다.')
                                }
                        })
                        .catch((error) => {
                                console.log(error)
                        })
        }
        // 댓글 목록
        const getCommentList = () => {
                axios.post('http://192.168.4.86:9988/comment/list', {
                        board_no,
                })
                        .then(res => {
                                setCommentList(res.data.records)
                        })
                        .catch(err => console.log(err))
        }
        // 댓글 삭제
        const deleteComment = (comentno) => {
                if (!window.confirm('댓글을 삭제하시겠습니까?')) return
                axios.post('http://192.168.4.86:9988/comment/delete', {
                        comentno,
                        userid
                })
                        .then(res => {
                                console.log(res.data.result)
                                if (res.data.result === 'success') {
                                        alert('댓글이 삭제되었습니다')
                                        getCommentList()
                                } else if (res.data.result === 'no-auth') {
                                        alert('삭제 권한이 없습니다')
                                } else {
                                        alert('삭제 실패')
                                }
                        })
                        .catch(err => console.log(err))
        }

        return (
                <div className='post'>

                        {/*제목 */}
                        <div style={{width:'60%', margin:'70px auto',textAlign:'center', borderBottom: 'solid 2px #d3d3d3',borderTop: 'solid 2px #d3d3d3',padding:'10px'}}>
                                <h1>{boardData.subject}</h1> 
                                <div className="meta_right" style={{ fontSize:'1.3em'}}>
                                        <div className="meta_date">{boardData.writedate}</div>
                                        <div className="meta_hit">조회수 : {boardData.hit}</div>
                                </div>

                        </div>
                        

                        {/* 글내용  */}
                        
                        <div className='post_main'  dangerouslySetInnerHTML={{ __html: boardData.context }} />

                        <hr />
                        <div className='container'>
                                {(userid === boardData.userid) && (
                                        <>
                                                <button className='btn btn-outline-dark' onClick={boardEdit}>수정</button>
                                                <button className='btn btn-outline-dark' onClick={boardDel}>삭제</button>
                                        </>
                                )}

                                <button className='btn btn-outline-dark' onClick={boardMain} style={{width:'90px',height:'60px',fontSize:'1.2em'}}>
                                        목록
                                </button>
                        </div>

                        {/* 작성자 프로필 */}
                        <div className='like' 
                        style={{ width: '1100px', height: '100px',height:'100px',display:'flex',margin:'40px auto',justifyContent:'center',lineHeight:'100px' }}>
                                <img src='/src/assets/img/profile-img.png'sytle={{width:'70px'}} className='profile-img'  />
                                <div style={{ fontSize: '1.5em',fontWeight:'blod',marginLeft:'15px'}}>{boardData.userid}</div>
                                <div style={{ fontSize: '1.5em' }}><span>{boardData.tag}</span>
                                <button onClick={likeCheck} style={{ border: 'none', background: 'none', marginLeft:'500px' }}><img src={'/src/assets/img/' + like} style={{ width: '50px' }} /></button>
                                </div>
                                
                        </div>

                        {/* 댓글 */}
                        <div className='post_comment' style={{ width: '1100px',margin:'200px auto'}}>
                                <img src='/src/assets/img/comment.png' />
                                {commentCount.map((count) => {
                                        return <p>댓글({count.count})</p>
                                })}

                                <input type="text" className="form-control"
                                        placeholder="댓글을 입력하세요" style={{
                                                width: '800px',
                                                height:'60px',
                                                float: 'left',
                                                marginRight:'15px'
                                        }}
                                        value={commentText}
                                        onChange={(e) => setCommentText(e.target.value)} />
                                <button onClick={getCommentWrite} className="btn btn-outline-dark"
                                 style={{width:'90px',height:'60px',fontSize:'1.2em'}}>등록</button>
                        </div>

                       
                                {commentList.map((commenttxt) => {
                                        return (
                                                <div className='post_comment_list' sytle={{display:'flex'}} >
                                                        <div className="row" style={{width:'1100px',margin:'30px auto',textAlign:'center',justifyContent:'center',borderBottom:'2px solid #818181'  }}>
                                                                <div className="col-sm-1 p-3 " 
                                                                style={{fontSize:'1.3em',fontWeight:'blod'}}>
                                                                        {commenttxt.userid}</div>
                                                                <div className="col-sm-7 p-3 "  style={{fontSize:'1.3em',textAlign:'left'}}>
                                                                        {commenttxt.context}</div>
                                                                <div className="col-sm-3 p-3 " style={{fontSize:'1.3em'}}>
                                                                        {commenttxt.writedate}</div>
                                                                {/* 삭제 버튼 */}
                                                                <div className="col-sm-1 p-3">
                                                                        {userid === commenttxt.userid && (
                                                                                <button
                                                                                        className="btn btn-outline-light text-dark"
                                                                                        onClick={() => deleteComment(commenttxt.comentno)}
                                                                                >
                                                                                        x
                                                                                </button>
                                                                        )}
                                                                </div>
                                                        </div>
                                                </div>


                                              
                                        )
                                })
                                }
                        

                </div>
        )
}

export default BoardView



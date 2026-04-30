import { useState, useEffect } from 'react'
import axios from 'axios'
import '/src/assets/css/Ls_style.css'
import 'bootstrap/dist/css/bootstrap.min.css';


function MyPage() {
        const [member, setMember] = useState({}) // {} {userid:'aaaa',userpwd:'ccc',username:'bbb',tel:'010-1111-2222'}
        const [boardlist, setBoardlist] = useState([])
        const [likeList, setLikeList] = useState([]) // 좋아요
        const [coment, setComent] = useState([]) // 댓글
        // 회원가입한 기존정보를 session의 값을 이용하여 DB에서 선택하여야 한다.
        useEffect(() => {
                getMemberData();
                getMyboard();
                getMylike();
                getMyComent();
        }, [])
        function getMemberData() {
                axios.get('http://192.168.4.86:9988/member/myPage')
                        .then(function (response) {
                                console.log("마이페이지 회원정보 ==>", response)
                                setMember({
                                        userid: response.data.record.userId,
                                        username: response.data.record.username,
                                        tel: response.data.record.tel,
                                        email: response.data.record.email
                                })
                        })
                        .catch(function (error) {
                                console.log(error)
                        })
        }

        function getMyboard() {
                axios.get('http://192.168.4.86:9988/member/writeboard')
                        .then((response) => {
                                const list = response.data.record.map((item) => {
                                        let thumbnail = "http://192.168.4.86:9988/uploads/1769067242086-img.jpg"


                                        const index = item.context.indexOf('<img src="')
                                        if (index !== -1) {
                                                const end = item.context.indexOf('"', index + 10)
                                                thumbnail = item.context.substring(index + 10, end)
                                        }


                                        return {
                                                ...item,
                                                thumnail: thumbnail
                                        }
                                })


                                setBoardlist(list)
                        })
                        .catch(console.log)
        }

        function getMylike() {
                axios.get('http://192.168.4.86:9988/member/likelist')
                        .then((response) => {
                                const list = response.data.record.map((item) => {
                                        let thumbnail =
                                                "http://192.168.4.86:9988/uploads/1769067242086-img.jpg"


                                        const index = item.context?.indexOf('<img src="')
                                        if (index !== -1 && index !== undefined) {
                                                const end = item.context.indexOf('"', index + 10)
                                                thumbnail = item.context.substring(index + 10, end)
                                        }


                                        return {
                                                ...item,
                                                thumnail: thumbnail
                                        }
                                })


                                setLikeList(list)
                        })
                        .catch(console.log)
        }
        function getMyComent() {
                axios.get('http://192.168.4.86:9988/member/mycoment')
                        .then(function (response) {
                                const list = response.data.record.map((coment) => {

                                        return {
                                                ...coment
                                        }
                                })


                                setComent(list)
                        })
                        .catch(function (error) {
                                console.log(error)
                        })
        }

        return (
                <div className='mypage'>
                        <link rel="preconnect" href="https://fonts.googleapis.com" />
                        <link rel="preconnect" href="https://fonts.gstatic.com" />
                        <link href="https://fonts.googleapis.com/css2?family=Gowun+Batang&family=Nanum+Pen+Script&family=Sunflower:wght@300&family=Ubuntu:ital,
                wght@0,300;0,400;0,500;0,700;1,300;1,400;1,500;1,700&display=swap" rel="stylesheet" />
                        <h1 style={{ fontFamily: "Ubuntu", fontWeight: 'bolder', fontSize: '3em', margin: '50px 0', textAlign: 'center' }}>
                                MYPAGE
                        </h1>
                        <hr/>
                        <div className='profile'>
                                <img src='/src/assets/img/profile-img.png' className='profile-img' />
                                <div className='profile-text'>
                                        <span>{member.username}</span><br />
                                        <span>{member.userid}</span>
                                </div>
                                <button className='btn btn-dark' onClick={() => window.location.href = '/member/memberEdit'}
                                        style={{ height: '40px', borderRadius: '10px', marginLeft: '200px', marginTop: '25px' }}>
                                        프로필 정보수정→
                                </button>
                        </div>
                        <div className='mystory'>
                                <h1 style={{ fontWeight: 'bold', fontSize: '2em', margin: '30px 0' }}>MY STORY</h1>
                                <div className="tebMenu">
                                        <ul>
                                                <li><img src="/src/assets/img/check.png" style={{ width: '30px', height: '30px' }} /><a href="#"><label htmlFor="m1">작성글</label></a></li>
                                                <li><img src="/src/assets/img/like.png" style={{ width: '30px', height: '30px' }} /><a href="#"><label htmlFor="m2">좋아요</label></a></li>
                                                <li><img src="/src/assets/img/write.png" style={{ width: '30px', height: '30px' }} /><a href="#"><label htmlFor="m3">댓글</label></a></li>
                                        </ul>
                                        <input type="radio" name="teb" id="m1" value="1" defaultChecked />
                                        <input type="radio" name="teb" id="m2" value="2" />
                                        <input type="radio" name="teb" id="m3" value="3" />

                                        <div className='write-list' >
                                                {
                                                        boardlist.map((write) => {

                                                                return (

                                                                        <div className='write-cnt'>
                                                                                <a href={"/member/boardview/" + write.no}><img src={write.thumnail} /></a>

                                                                                <a href={"/member/boardview/" + write.no}>{write.subject}</a>
                                                                                <div>조회수<span>{write.hit}</span></div>
                                                                        </div>


                                                                )
                                                        }
                                                        )}
                                        </div>

                                        <div className='like-list'>
                                                {
                                                        likeList.map((likelist) => {
                                                                return (
                                                                        <div className='like-cnt'>
                                                                                <a href={"/member/boardview/" + likelist.no}><img src={likelist.thumnail} /></a>

                                                                                <a href={"/member/boardview/" + likelist.no}>{likelist.subject}</a>
                                                                                <div>조회수<span>{likelist.hit}</span></div>
                                                                        </div>
                                                                )
                                                        }
                                                        )}

                                        </div>

                                        <div className='coment-list-container'>
                                                {coment.map((comentlist) => (
                                                        <div className='coment-list' key={comentlist.comentno} style={{width:''}}>
                                                                <a href={"/member/boardview/" + comentlist.no}>
                                                                {comentlist.subject}
                                                                <p style={{color:'gray',fontSize:'0.9em'}}>댓글 : {comentlist.context} </p>
                                                                <p style={{color:'gray',fontSize:'0.8em'}}>{comentlist.writedate}</p>
                                                                </a>
                                                        </div>
                                                ))}
                                        </div>
                                </div>
                        </div>
                </div>


        )




} export default MyPage
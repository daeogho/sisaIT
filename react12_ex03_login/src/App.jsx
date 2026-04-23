import Login from './assets/member/Login'
function App() {
  const logCss={
    height:'100px',
    textAlign:'center',
    fontSize:'4em',
    backgroundColor:'Olive',
    color:'#fff',
    lineHeight:'100px'
  }
  return (
    <>
      <div style={logCss}>리엑트에서 만든 로그인 폼</div>
      <Login></Login>
    </>
  )
}

export default App

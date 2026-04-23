import './assets/css/gallery.css'
import GalleryPage from './assets/gallery/GalleryPage'

function App() {

  return (
    <>
      {/* 상단 메뉴 */}
      <header>
        <div className='title_logo'><a href="">시사IT 아카데미</a></div>
        <nav className='main-menu'>
          <a href="">홈</a>
          <a href="">로그인</a>
          <a href="">갤러리</a>
        </nav>
      </header>
      <GalleryPage/>
    </>
  )
}

export default App

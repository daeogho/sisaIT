import './assets/ex02.css'
import { useState } from 'react'


function App() {
  // <a href = '/productList?category=1'
  const topMenu = [
    { category: 1, menu: '베스트100' },
    { category: 2, menu: '신상7%' },
    { category: 3, menu: '끝장세일~80%' },
    { category: 4, menu: '마지막재고~80%' },
    { category: 5, menu: '시즌오프~80%' },
    { category: 6, menu: '생활한복' },
    { category: 7, menu: '자체제작' },
    { category: 8, menu: '당일출고' },
    { category: 9, menu: '🌿인견모음' }
  ]
  const mainMenu = [
    { category: 11, menu: '코트/자켓/점퍼' },
    { category: 12, menu: '티셔츠/블라우스' },
    { category: 13, menu: '바지/치마' },
    { category: 14, menu: '조끼/가디건' },
    { category: 15, menu: '원피스' },
    { category: 16, menu: '홈웨어/잠옷' },
    { category: 17, menu: '인견속옷' },
    { category: 18, menu: '신발' },
    { category: 19, menu: '스카프' },
    { category: 20, menu: '악세서리' },
    { category: 21, menu: '상하세트' }
  ]


  const banner = [
    { category: 101, menu_txt: '신상7%', src: '/menu_img/menu01.png' },
    { category: 102, menu_txt: '시즌오프', src: '/menu_img/menu02.png' },
    { category: 103, menu_txt: '패딩모음', src: '/menu_img/menu03.png' },
    { category: 104, menu_txt: '홈웨어', src: '/menu_img/menu04.png' },
    { category: 105, menu_txt: '1+1', src: '/menu_img/menu05.png' },
    { category: 106, menu_txt: '아우터', src: '/menu_img/menu06.png' },
    { category: 107, menu_txt: '상의', src: '/menu_img/menu07.png' },
    { category: 108, menu_txt: '하의', src: '/menu_img/menu08.png' },
    { category: 109, menu_txt: '9,900원', src: '/menu_img/menu09.png' },
    { category: 110, menu_txt: '방한덧신❤️', src: '/menu_img/menu10.png' }
  ]

  /* 상품목록 */
  const [hotList, setHotList] = useState([
    {procCode:'1000', size: 'FREE(55~99)', special: '시즌오픈특가', title: '[로즈맘단독]효란인조소프트밍크니트조끼', revire: 183, discount: '80%', price: '7900', season: '80%', img: '/product_webp/p1.webp' },
    {procCode:'2000', size: '3XL(55-66), 5XL(77-88)', special: '시즌오픈특가', title: '[로즈맘단독]해빈인조소프트밍크니트가디건', revire: 38, discount: '80%', price: '9900', season: '80%', img: '/product_webp/p2.webp' },
    {procCode:'3000', size: 'L(55-77),xl(88-99)', special: '시즌오픈특가', title: '[로즈맘단독]유향누빔패딩반팔조끼', revire: 5, discount: '80%', price: '8900', season: '80%', img: '/product_webp/p3.webp' },
    {procCode:'4000', size: 'FREE(66-99)', special: '시즌오픈특가', title: '[로즈맘단독]연아롱후드누빔패딩조끼', revire: 999, discount: '80%', price: '8900', season: '80%', img: '/product_webp/p4.webp' }
  ]);
  return (
    <>
      {/* 할인 메뉴 */}
      <div className='top-menu'>
        {
          topMenu.map((saleMenu) => {
            return <a href={'/productList?category=' + saleMenu.category}>{saleMenu.menu}</a>
          })
        }
      </div>

      { /* 메인메뉴 */}
      <div className='main-menu'>
        <a><img src='/src/assets/icon/ham.png' width='30' />카테고리</a>
        {
          mainMenu.map((m) => {
            return <a href={'/product/List?category=' + m.category}>{m.menu}</a>
          })
        }
      </div>

      { /* 배너 메뉴 */}
      <div className='banner-menu'>
        {
          banner.map((bannerMenu) => {
            return (
              <div>
                <a href={"/productList?category=" + bannerMenu.category}>
                  <img src={'/src/assets' + bannerMenu.src} /><br />
                  {bannerMenu.menu_txt}
                </a>
              </div>
            )
          })
        }
      </div>

      { /* 상품목록 */}
      <div className='hot'>
        <a herf="/hot_product">인기상품 &gt;</a>
      </div>

      { /* 상품목록 */}
      <div className="hot-list">
        {
          hotList.map((proc) => {
            return (
              <div>
                <a href={'/detail?procCode='+proc.procCode}><img src={'/src/assets/'+proc.img} /></a>
                
                <div>{proc.size}</div>

                <div className='proc-title'>
                  <div><a href="#"><span style={{color:'red'}}>[{proc.special}]</span>{proc.title}</a></div>
                  <div>리뷰<br />{proc.revire}</div>
                </div>

                <div sytle={{fontSize:'1.2em', fontWeight:'bold'}}>
                  <span style ={{color:'#880015'}}>{proc.discount}</span>
                  {proc.price.toLocaleString()}원
                </div>

                <div><span style={{backgroundColor:'red', color:'#fff'}}>시즌오프<span style={{color:'yellow', fontWeight:'bold'}}>{proc.season}</span></span></div>
              </div>
            )
          })
        }

      </div>
    </>
  )
}

export default App

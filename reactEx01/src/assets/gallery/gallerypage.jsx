import './../css/gallery.css'

function GalleryPage(){
        const images = [
                {
                        src:'./img/image1.jpeg',
                        alt:'첫번째 이미지'
                },
                {
                        src:'./img/image2.jpeg',
                        alt:'두번째 이미지'
                },
                {
                        src:'/img/image1.jpeg',
                        alt:'세번째 이미지'
                },
                {
                        src:'/img/image2.jpeg',
                        alt:'네번째 이미지'
                },
        ]


        return(
                <div>
                        <div className='gallery-title'>🖼️ 갤러리</div>
                        <h2>이미지로 갤러리 연습</h2>
                        <div>
                                {
                                        images.map((img)=><img src={img.src} alt={img.alt} className='i'/>)
                                }
                        </div>
                </div>
        )
}

export default GalleryPage
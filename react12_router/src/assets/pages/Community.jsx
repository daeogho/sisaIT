import Carousel from 'react-bootstrap/Carousel'

function Community() {
        return (
                <>
                        <h1>Carousel</h1>
                        <Carousel>
                                <Carousel.Item>
                                        <img
                                                className="d-block w-100"
                                                src="/src/assets/img/image1.jpeg"
                                                alt="First slide"
                                                style={{height:'500px', width:'100%'}}
                                        />
                                        <Carousel.Caption>
                                                <h3>First slide label</h3>
                                                <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
                                        </Carousel.Caption>
                                </Carousel.Item>
                                <Carousel.Item>
                                        <img
                                                className="d-block w-100"
                                                src="/src/assets/img/image2.jpeg"
                                                alt="Second slide"
                                                style={{height:'500px', width:'100%'}}
                                        />
                                        <Carousel.Caption>
                                                <h3>Second slide label</h3>
                                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                                        </Carousel.Caption>
                                </Carousel.Item>
                                <Carousel.Item>
                                        <img
                                                className="d-block w-100"
                                                src="/src/assets/img/image3.gif"
                                                alt="Third slide"
                                                style={{height:'500px', width:'100%'}}
                                        />
                                        <Carousel.Caption>
                                                <h3>Third slide label</h3>
                                                <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>
                                        </Carousel.Caption>
                                </Carousel.Item>
                        </Carousel>
                </>
        )

}

export default Community

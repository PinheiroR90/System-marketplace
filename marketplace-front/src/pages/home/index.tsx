import { useEffect, useState } from "react";
import { Card, Col, Container, Form, Row, Spinner } from "react-bootstrap";
import axios from "axios";

import "../../index.css"

const Home = () => {
    const [products, setProducts] = useState([])
    const [checkbox,setCheckbox] = useState("all")
    const [load,setLoad] = useState(false)
   
    const getGenderProducts = async () => {
        setLoad(true)
            await axios.get(`http://localhost:8080/products/${checkbox}`)
            .then((res) => {
                const product = res.data;
                setProducts(product)
            })
            .catch((error) => console.log(error))
    }    
  
    useEffect(() => {
        setTimeout(()=>{
           setLoad(false)
        },2000)
        getGenderProducts();
    }, [checkbox])

    return (
        <>
            <Container>
            <div className="" style={{marginTop:"20px" ,marginBottom:"20px"}}></div>
                <Form>
                <Form.Check 
                        inline
                        label={"Todos"}
                        checked={checkbox === "all"}
                        type="radio"
                        name="gender"
                        value="all"
                        onChange={(e:any)=> setCheckbox(e.target.value)}
                        onClick={async()=> await getGenderProducts()}
                    />
                    <Form.Check 
                        inline
                        id="man"
                        label={"Man"}
                        checked={checkbox === "man"}
                        type="radio"
                        name="gender"
                        value="man"
                        onChange={(e:any)=> setCheckbox(e.target.value)}
                        onClick={async()=> await getGenderProducts()}
                    />
                    <Form.Check 
                        inline
                        id="woman"
                        label={"Woman"}
                        checked={checkbox === "woman"}
                        type="radio"
                        name="gender"
                        value="woman"
                        onChange={(e:any)=> setCheckbox(e.target.value)}
                        onClick={async()=> await getGenderProducts()}
                    />
                          
                </Form>
                <div className="" style={{marginTop:"20px" ,marginBottom:"20px"}}></div>
                <Row>
                    {load ?
                    <p> <Spinner animation="grow" variant="primary" /> Aguarde...</p>
                        : products.map((i: any, index: number) => (
                            <Col key={index} style={{ marginBottom: "20px" }}>
                                <Card style={{ width: "12rem", height: "auto" }}>
                                    <Card.Body>
                                        <Card.Subtitle className="mb-0 text-muted">{i.id}</Card.Subtitle>
                                        <Card.Title className="title">{i.name}</Card.Title>
                                        <Card.Img variant="top" src={i.urlImg} />
                                        <Card.Text className="mb-1 my-text">
                                            Some quick example text to build on the card .
                                        </Card.Text>
                                        <Card.Subtitle className="mb-0 text-muted">
                                            <p className="my-p">Preço: <span>{i.price}</span></p>
                                            <p className="my-p">genero:  <span>{i.gender}</span></p>
                                        </Card.Subtitle>
                                    </Card.Body>
                                </Card>
                            </Col>
                        ))}
                </Row>
            </Container>
        </>
    )
}

export default Home;

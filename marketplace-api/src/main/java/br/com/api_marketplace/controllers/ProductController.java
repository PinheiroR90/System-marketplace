package br.com.api_marketplace.controllers;

import br.com.api_marketplace.dto.ProductDTO;
import br.com.api_marketplace.services.ProductService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {
    @Autowired
    private ProductService productService;


@GetMapping(value = "/all")
    public ResponseEntity<List<ProductDTO>> getAllProds(){
        List<ProductDTO> productDTOS = productService.getAllProduts();
        return ResponseEntity.ok(productDTOS);
    }

    @GetMapping(value = "/woman")
    public ResponseEntity<List<ProductDTO>> getAllProdsWoman(){
        List<ProductDTO> productDTOS = productService.getProdutsWoman();
        return ResponseEntity.ok(productDTOS);
    }

    @GetMapping(value = "/man")
    public ResponseEntity<List<ProductDTO>> getAllProdsMan(){
        List<ProductDTO> productDTOS = productService.getProdutsMan();
        return ResponseEntity.ok(productDTOS);
    }

}

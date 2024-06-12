package br.com.api_marketplace.services;

import br.com.api_marketplace.dto.ProductDTO;
import br.com.api_marketplace.entities.Product;
import br.com.api_marketplace.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getAllProduts(){
        List<Product> products =  productRepository.findAll();
        return products.stream().map(ProductDTO::new).toList();
    }

    public List<ProductDTO> getProdutsWoman(){
        List<Product> products =  productRepository.filterWoman();
        return products.stream().map(ProductDTO::new).toList();
    }
    public List<ProductDTO> getProdutsMan(){
        List<Product> products =  productRepository.filterMan();
        return products.stream().map(ProductDTO::new).toList();
    }

}

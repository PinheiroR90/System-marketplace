package br.com.api_marketplace.repositories;

import br.com.api_marketplace.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query(nativeQuery = true,value = "SELECT * FROM TB_PRODUCTS WHERE GENDER = 'Female'")
    List<Product> filterWoman();

    @Query(nativeQuery = true,value = "SELECT * FROM TB_PRODUCTS WHERE GENDER = 'Male'")
    List<Product> filterMan();

}

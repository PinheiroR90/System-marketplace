package br.com.api_marketplace.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String _name;
    private String price;
    private String gender;
    private String urlImg;

    public Product(){}

    public Product(Long id, String _name, String price, String gender, String urlImg) {
        this.id = id;
        this._name = _name;
        this.price = price;
        this.gender = gender;
        this.urlImg = urlImg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", _name='" + _name + '\'' +
                ", price='" + price + '\'' +
                ", gender='" + gender + '\'' +
                ", urlImg='" + urlImg + '\'' +
                '}';
    }
}

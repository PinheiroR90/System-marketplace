package br.com.api_marketplace.dto;

import br.com.api_marketplace.entities.Product;

public class ProductDTO {
    private Long id;
    private String _name;
    private String price;
    private String gender;
    private String urlImg;

    public ProductDTO(){
    }

    public ProductDTO(Long id, String _name, String price, String gender, String urlImg) {
        this.id = id;
        this._name = _name;
        this.price = price;
        this.gender = gender;
        this.urlImg = urlImg;
    }
    public ProductDTO(Product product) {
        id = product.getId();
        _name = product.get_name();
        price = product.getPrice();
        gender = product.getGender();
        urlImg = product.getUrlImg();
    }

    public Long getId() {
        return id;
    }

    public String get_name() {
        return _name;
    }

    public String getPrice() {
        return price;
    }

    public String getGender() {
        return gender;
    }

    public String getUrlImg() {
        return urlImg;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", _name='" + _name + '\'' +
                ", price='" + price + '\'' +
                ", gender='" + gender + '\'' +
                ", urlImg='" + urlImg + '\'' +
                '}';
    }
}

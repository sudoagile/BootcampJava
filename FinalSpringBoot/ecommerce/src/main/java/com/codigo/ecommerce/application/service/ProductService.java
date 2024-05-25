package com.codigo.ecommerce.application.service;

import com.codigo.ecommerce.application.repository.ProductRepository;
import com.codigo.ecommerce.domain.Product;
import com.codigo.ecommerce.domain.User;

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {this.productRepository = productRepository;}

    public Iterable<Product> getProducts(){return  productRepository.getProducts();}
    public Iterable<Product> getProductsByUser(User user){return productRepository.getProductsByUser(user);}

    public Product getProductById(Integer id){return  productRepository.getProductById(id);}

    public Product saveProduct(Product product){return   productRepository.saveProduct(product);}

    public void deleteProductById(Integer id){productRepository.deleteProductById(id);}


}

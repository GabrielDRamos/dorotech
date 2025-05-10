package br.com.dorotech.service;

import br.com.dorotech.service.domain.ProductDomain;

public interface ProductService {
    ProductDomain create(ProductDomain domain);
    ProductDomain getProduct(Long id);
    ProductDomain getProductName(String name);
}

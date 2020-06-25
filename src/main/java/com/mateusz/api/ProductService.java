package com.mateusz.api;

import com.mateusz.model.Product;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    List<Product> getAllProducts() throws IOException;
    Integer getCountOfProducts() throws IOException;
    Product getProductByProductName(String productName) throws IOException;
    Product getProductByProductId(int productId) throws IOException;

    boolean isProductOnWarehouse(String productName);
    boolean isProductExist(String productName);
    boolean isProductExist(int productId);

    boolean saveProduct(Product product);
}

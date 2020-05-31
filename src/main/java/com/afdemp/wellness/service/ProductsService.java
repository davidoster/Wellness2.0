package com.afdemp.wellness.service;

import com.afdemp.wellness.entities.Product;
import java.util.List;

public interface ProductsService {
     public List<Product> getAllProducts();
     public List<Product> getProductByCategory(String category);
     public Product getProductById(int id);
     public boolean addProduct(Product p);
     public boolean updateProduct(Product p);
     public boolean deleteProductById(int id);

}

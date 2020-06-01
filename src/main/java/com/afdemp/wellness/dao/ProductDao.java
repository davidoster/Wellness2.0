package com.afdemp.wellness.dao;

import com.afdemp.wellness.entities.Product;
import java.util.List;


public interface ProductDao {
    
    public List<Product> getAllProducts();
    
    public List<Product> getProductByCategory(String category);
    
    public Product getProductById(int id);
    
    public boolean addProduct(Product product); 

    public boolean updateProduct(Product product);
    
    public boolean deleteProductById(int id);
    

    
    
}

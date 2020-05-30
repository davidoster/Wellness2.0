/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afdemp.wellness.service;

import com.afdemp.wellness.entities.Product;
import java.util.List;

/**
 *
 * @author giorgos
 */
public interface ProductsService {
     public List<Product> getAllProducts();
     public List<Product> getProductByCategory(String category);
     public Product getProductById(int id);
     public boolean addProduct(Product p);
     public boolean updateProduct(Product p);
     public boolean deleteProductById(int id);
     public boolean reduceProductStock(int id,int quantity);
}

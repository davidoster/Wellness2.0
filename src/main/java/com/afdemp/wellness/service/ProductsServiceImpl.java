/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afdemp.wellness.service;

import com.afdemp.wellness.dao.ProductDao;
import com.afdemp.wellness.entities.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author giorgos
 */
@Service("productService")
@Transactional
public class ProductsServiceImpl implements ProductsService {
    
    @Autowired
    private ProductDao pdao;

    @Override
    public List<Product> getAllProducts() {
        return pdao.getAllProducts();
    }

    @Override
    public List<Product> getProductByCategory(String category) {
        return pdao.getProductByCategory(category);
    }

    @Override
    public Product getProductById(int id) {
        return pdao.getProductById(id);
    }

    @Override
    public boolean addProduct(Product p) {
        return pdao.addProduct(p);
    }

    @Override
    public boolean updateProduct(Product p) {
        return pdao.updateProduct(p);
    }

    @Override
    public boolean deleteProductById(int id) {
        return pdao.deleteProductById(id);
    }

//    @Override
//    public boolean reduceProductStock(int id, int quantity) {
//        return pdao.reduceProductStock(id, quantity);
//    }
//    
}

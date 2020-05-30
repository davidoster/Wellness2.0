/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afdemp.wellness.service;

/**
 *
 * @author giorgos
 */
public interface AppService {
    
    /**
     * This method returns the principal[user-name] of logged-in user.
     * 
     */
    String getPrincipal();
    
}

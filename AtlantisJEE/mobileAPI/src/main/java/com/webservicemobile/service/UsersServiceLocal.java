/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservicemobile.service;

import com.webservicemobile.domain.Users;
import javax.ejb.Local;

/**
 *
 * @author cesi
 */
@Local
public interface UsersServiceLocal 
{
    public void addUsers(String firstname, String lastname);
    
    public void save(Users users);
}

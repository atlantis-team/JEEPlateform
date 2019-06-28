package com.webserviceadmin.dao;

import com.webserviceadmin.domain.Users;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author cesi
 */
@Stateless
public class UsersDAO 
{
    @PersistenceContext(unitName = "adminPU")
    private EntityManager em;
    
    public void insert(Users users)
    {
        em.persist(users);
    }
}

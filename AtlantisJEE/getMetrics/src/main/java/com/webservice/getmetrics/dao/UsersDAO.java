package com.webservice.getmetrics.dao;

import com.webservice.getmetrics.domain.Users;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author cesi
 */
@Stateless
public class UsersDAO 
{
    @PersistenceContext(unitName = "getMetricsPU")
    private EntityManager em;
    
    public void insert(Users users)
    {
        em.persist(users);
    }
}

package com.webservicemobile.dao;

import com.webservicemobile.domain.Users;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author cesi
 */
@Stateless
public class MetricsDAO 
{
    @PersistenceContext(unitName = "mobilePU")
    private EntityManager em;
    
    public void insert(Users users)
    {
        em.persist(users);
    }
}

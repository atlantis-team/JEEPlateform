package com.webservicemobile.dao;

import com.webservicemobile.domain.Data;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author cesi
 */
@Stateless
public class DataDAO 
{
    @PersistenceContext(unitName = "mobilePU")
    private EntityManager em;
    
    public void insert(Data data)
    {
        em.persist(data);
    }
}

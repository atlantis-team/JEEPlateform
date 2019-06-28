package com.webservicemetrics.dao;

import com.webservicemetrics.domaine.Data;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author cesi
 */
@Stateless
public class DataDAO 
{
    @PersistenceContext(unitName = "metricsPU")
    private EntityManager em;
    
    public void insert(Data data)
    {
        em.persist(data);
    }
}

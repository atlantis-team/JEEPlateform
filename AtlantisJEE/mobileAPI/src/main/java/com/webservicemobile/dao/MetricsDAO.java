package com.webservicemobile.dao;

import com.webservicemobile.domain.Metrics;
import com.webservicemobile.domain.Users;
import java.util.List;
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
    
    private final String SELECT_QUERY = "select m from Metrics m where m.Device_ID = :id order by m.ID desc";//, limit 3 ";//"SELECT d FROM Device d WHERE d.User_OID = :id";// INNER JOIN users ON devices.User_ID = users.User_ID";
    
    public void insert(Users users)
    {
        em.persist(users);
    }
    
    public List<Metrics> getLastMetrics(int deviceId) {
        List<Metrics> metrics = (List<Metrics>) em.createQuery(SELECT_QUERY).setParameter("id", deviceId).getResultList();
        return metrics;
    }
}

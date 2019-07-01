package com.webservice.getmetrics.dao;

import com.webservice.getmetrics.domain.Metrics;
import com.webservice.getmetrics.domain.Users;
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
    @PersistenceContext(unitName = "getMetricsPU")
    private EntityManager em;
    
    private final String SELECT_QUERY = "select m from Metrics m where m.MetricDate >= DATEADD(HOUR, -1, GETDATE()";//, limit 3 ";//"SELECT d FROM Device d WHERE d.User_OID = :id";// INNER JOIN users ON devices.User_ID = users.User_ID";

    public void insert(Users users)
    {
        em.persist(users);
    }
    
    public List<Metrics> getLastMetrics(int deviceId) {
        List<Metrics> metrics = (List<Metrics>) em.createQuery(SELECT_QUERY).setParameter("id", deviceId).getResultList();
        return metrics;
    }
}

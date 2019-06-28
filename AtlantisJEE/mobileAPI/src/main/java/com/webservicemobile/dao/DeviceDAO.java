package com.webservicemobile.dao;

import com.webservicemobile.domain.Device;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author cesi
 */
@Stateless
public class DeviceDAO 
{
    @PersistenceContext(unitName = "mobilePU")
    private EntityManager em;
    
    private final String SELECT_QUERY = "SELECT d FROM Device d WHERE d.User_OID = :id";// INNER JOIN users ON devices.User_ID = users.User_ID";
    
    public void insert(Device device)
    {
        em.persist(device);
    }
    
    public List<Device> select(String userOID)
    {
        //String qlString = "Select * from devices where dev_id = :id";
        List<Device> devices = (List<Device>) em.createQuery(SELECT_QUERY).setParameter("id", userOID).getResultList();
        return devices;
        
        //return (Device)query.getSingleResult();
        //em.createQuery(SELECT_QUERY+userID, ArrayList.class);
    }
}

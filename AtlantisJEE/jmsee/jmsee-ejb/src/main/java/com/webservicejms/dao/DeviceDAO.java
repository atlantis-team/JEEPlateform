package com.webservicejms.dao;

import com.webservicejms.domain.Device;
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
    @PersistenceContext(unitName = "jmseePU")
    private EntityManager em;
    
    private final String SELECT_QUERY = "SELECT d FROM Device d WHERE d.MacAdress = :mac";// INNER JOIN users ON devices.User_ID = users.User_ID";
    
    public void insert(Device device)
    {
        em.persist(device);
    }
    
    public List<Device> select(String macAdress)
    {
        //String qlString = "Select * from devices where dev_id = :id";
        List<Device> devices = (List<Device>) em.createQuery(SELECT_QUERY).setParameter("mac", macAdress).getResultList();
        return devices;
        
        //return (Device)query.getSingleResult();
        //em.createQuery(SELECT_QUERY+userID, ArrayList.class);
    }
}

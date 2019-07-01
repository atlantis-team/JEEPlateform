package com.webservicerawdata.dao;

import com.webservicerawdata.domain.Device;
import com.webservicerawdata.domain.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author cesi
 */
@Stateless
public class UsersDAO 
{
    @PersistenceContext(unitName = "rawDataPU")
    private EntityManager em;
    
    String sqlCheckUser = "SELECT u FROM Users u WHERE u.oid=:id";
    
    public void insert(Users users)
    {
        em.persist(users);
    }
    
    public Boolean IsUserInDB(String oid) {
        List<Users> devices = (List<Users>) em.createQuery(sqlCheckUser).setParameter("id", oid).getResultList();
        if(devices.size() > 0)
            return true;
        else
            return false;
    }
    
    
}

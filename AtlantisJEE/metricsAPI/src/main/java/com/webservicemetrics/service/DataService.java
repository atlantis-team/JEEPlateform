package com.webservicemetrics.service;

import com.webservicemetrics.domaine.Data;
import com.webservicemetrics.dao.DataDAO;
import com.webservicemetrics.domaine.Data;
import javax.ejb.Remove;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author cesi
 */
@Stateless
public class DataService implements DataServiceLocal
{
    private Data data = new Data();
    
    @Inject
    DataDAO dataDAO;
    
    public void addData(String Device_Id, String MetricValue, String MetricDate) 
    {
        
        data.setDevice_Id(Device_Id);
        data.setMetricValue(MetricValue);
        data.setMetricDate(MetricDate);
        System.out.println("Data device: "+Device_Id+" "+MetricValue+" "+MetricDate);
    }
    
/*    @Override
    public void addAuthenticationInformations(String email, String pwd) 
    {
        users.setEmail(email);
        users.setPassword(pwd);
        System.out.println("ajout des informations d'authentification : "+email+" -"+pwd);
    }
*/  
    @Remove
    public void save(Data data) 
    {
        dataDAO.insert(data);
        System.out.println("data saved");
    }
}

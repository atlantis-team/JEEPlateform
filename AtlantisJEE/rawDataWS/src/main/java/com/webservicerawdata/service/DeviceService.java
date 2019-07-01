package com.webservicerawdata.service;

import com.webservicerawdata.dao.DeviceDAO;
import com.webservicerawdata.domain.Device;
import java.util.List;
import javax.ejb.Remove;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author cesi
 */
@Stateless
public class DeviceService implements DeviceServiceLocal
{
    private Device device = new Device();
    
    @Inject
    DeviceDAO deviceDAO;
    
 /*   public void addDevice(String String ID, String User_ID, String DeviceName) 
    {
        
        device.setDevice_Id(Device_Id);
        data.setMetricValue(MetricValue);
        data.setMetricDate(MetricDate);
        System.out.println("Data device: "+Device_Id+" "+MetricValue+" "+MetricDate);
    }
 */
    
/*    @Override
    public void addAuthenticationInformations(String email, String pwd) 
    {
        users.setEmail(email);
        users.setPassword(pwd);
        System.out.println("ajout des informations d'authentification : "+email+" -"+pwd);
    }
*/  
    @Remove
    public void save(Device device) 
    {
        deviceDAO.insert(device);
        System.out.println("data saved");
    }

    @Override
    public List<Device> select(String User_OID) 
    {
        List<Device> devices = deviceDAO.select(User_OID);
        System.err.println("Get Devices");
        return devices;
    }
    
    
}

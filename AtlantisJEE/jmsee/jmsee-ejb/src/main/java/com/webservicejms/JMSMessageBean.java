/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservicejms;

import com.webservicejms.service.DeviceServiceLocal;
import com.webservicejms.service.MetricServiceLocal;
import com.webservicejms.service.UsersServiceLocal;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.*;
import javax.jms.MessageListener;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.webservicejms.domain.Device;
import com.webservicejms.domain.Metrics;
import java.util.List;

/**
 *
 * @author cesi
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "queueDest")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class JMSMessageBean implements MessageListener {
    
    @Inject
    UsersServiceLocal uService;
    
    @Inject
    DeviceServiceLocal dService;
    
    @Inject
    MetricServiceLocal mService;
    
    public JMSMessageBean() {
    }
    
    @Override
    public void onMessage(Message message) {
        System.out.println(message);
        try{
            TextMessage textMessage = (TextMessage)message;
            
            if(textMessage != null){
                System.out.println(textMessage.getText());
                Gson gson = new Gson();
                MetricsModel o = gson.fromJson(textMessage.getText(), MetricsModel.class);
                List<Device> devices = dService.select(o.getMacAdress());
                if(devices.size() > 0){
                    Metrics m = new Metrics();
                    m.setDevice_ID(devices.get(0).getID());
                    m.setMetricDate(o.getMetricDate());
                    m.setMetricValue(Float.parseFloat(o.getMetricValue()));
                    
                } else{
                    Device d = new Device();
                    d.setDeviceName(o.getName());
                    d.setMacAdress(o.getMacAdress());
                    d.setDeviceType(o.getDeviceType());
                    dService.save(d);
                }
            }
        }   catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}

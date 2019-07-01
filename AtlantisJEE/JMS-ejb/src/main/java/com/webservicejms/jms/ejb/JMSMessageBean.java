/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservicejms.jms.ejb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author cesi
 */
@MessageDriven(mappedName = "queueDest", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class JMSMessageBean implements MessageListener {
    
    public JMSMessageBean() {
    }
    
    @Override
    public void onMessage(Message message) {
        try{
            TextMessage textMessage = (TextMessage)message;
            if(textMessage != null){
                System.out.println(textMessage.getText());
            }
        }   catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}

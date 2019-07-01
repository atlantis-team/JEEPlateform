/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservicejms.jms.war;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Queue;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;

/**
 *
 * @author cesi
 */
@Named(value = "jMSController")
@SessionScoped
public class JMSController implements Serializable {

    @Resource(mappedName = "queueDest")
    private javax.jms.Queue queueDest;

    @Inject
    @JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory")
    private JMSContext context;
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JMSController() {
    }

    private void sendJMSMessageToQueueDest(String messageData) {
        context.createProducer().send(queueDest, messageData);
    }
    
    public void send(){
        this.sendJMSMessageToQueueDest(this.name);
    }
    
}

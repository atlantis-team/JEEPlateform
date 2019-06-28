/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

/**
 *
 * @author cesi
 */
@Named(value = "jmsController")
@SessionScoped
public class JmsController implements Serializable
{
    @Resource(mappedName = "queueDest")
    private Queue queueDest;
    private String name;

    @Inject
    @JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory")
    private JMSContext context;

    public JmsController() {
    }

    private void sendJMSMessageToQueueDest(String messageData) 
    {
        context.createProducer().send(queueDest, messageData);
    }
    
    public void send()
    {
        this.sendJMSMessageToQueueDest("Message JMSController mobileapi " + this.name);
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }
}

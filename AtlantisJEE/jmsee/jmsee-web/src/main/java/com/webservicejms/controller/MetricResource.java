/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservicejms.controller;

import com.google.gson.Gson;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import com.google.gson.JsonObject;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author cesi
 */
@Path("metric")
@RequestScoped
public class MetricResource {
    
    public MetricResource() {
    }

    /**
     * Retrieves representation of an instance of com.webservicejms.controller.MetricResource
     * @return an instance of java.lang.String
     */
/*    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
*/
    /**
     * PUT method for updating or creating an instance of MetricResource
     * @param content representation for the resource
     */
    
    @Inject
    JMSJSFManagedBean jmsMB;
    
    @Path("insertMetric")
    @POST
    //@Consumes(MediaType.APPLICATION_JSON)
    public String insertMetric(String json) {
        //TODO : replace JsonObject by MetricsModel
        System.out.println(json);
        Gson gson = new Gson();
        MetricsModel metric = gson.fromJson(json, MetricsModel.class);
        jmsMB.send(metric);
        
        
        return "Saluuuut";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservicemetrics.metricsapi.facade;

import com.webservicemetrics.domaine.Data;
import com.webservicemetrics.service.DataServiceLocal;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author cesi
 */
@Stateless
@Path("metrics")
public class MetricsResource {

    public MetricsResource() {
    }
    
    @Inject
    DataServiceLocal dService;
    
    @Path("sendMetric")
    @POST
    public void SendMetric() {
        //Connect to JMS's send()
        
        
    }
    
    /*
    @Path("getmetrics")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        String restMsg="{\"message\":\"hello REST\"}";
        return restMsg;
    }
    
    @Path("createData")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createData(DataModel data) 
    {
        Data dat = new Data();
        
       // JsonParser jParser = new JsonParser();
      //  JsonObject jobject = (JsonObject)jParser.parse(content) ;
        
        data.setDevice_Id(data.getDevice_Id());
        data.setMetricValue(data.getMetricValue());
        data.setMetricDate(data.getMetricDate());
        
        
        
        dService.save(dat);
        //retour d'une réponse sans corps indiquant un statut 202 : la requête a été acceptée mais le processus n'est pas terminé
        return Response.accepted().build();
    }
*/
}

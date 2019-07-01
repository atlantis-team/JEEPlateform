/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservice.getmetrics.facade;

import com.webservice.getmetrics.domain.Users;
import com.webservice.getmetrics.service.DeviceServiceLocal;
import com.webservice.getmetrics.service.MetricServiceLocal;
import com.webservice.getmetrics.service.UsersServiceLocal;
import com.google.gson.Gson;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author cesi
 */
@Stateless
@Path("getMetrics")
public class GetMetricsResource {
    
    @Inject
    UsersServiceLocal uService;
    
    @Inject
    DeviceServiceLocal dService;
    
    @Inject
    MetricServiceLocal mService;

    public GetMetricsResource() {
    }

    @Path("listMetric")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public MetricsModel listMetric(String json) {
        //TODO : replace JsonObject by MetricsModel
        
        Gson gson = new Gson();
        MetricsModel metric = gson.fromJson(json, MetricsModel.class);
        
        return metric;
    }

    @Path("createUser")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUsers(UserModel user) 
    {
        Users users = new Users();
        
       // JsonParser jParser = new JsonParser();
      //  JsonObject jobject = (JsonObject)jParser.parse(content) ;
        
        users.setFirstName(user.getUsername());
        users.setLastName(user.getLastName());
        
        uService.save(users);
        //retour d'une réponse sans corps indiquant un statut 202 : la requête a été acceptée mais le processus n'est pas terminé
        return Response.accepted().build();
    }
}

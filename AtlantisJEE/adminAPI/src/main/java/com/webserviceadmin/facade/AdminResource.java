/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webserviceadmin.facade;

import com.webserviceadmin.domain.Users;
import com.webserviceadmin.service.UsersServiceLocal;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
@Path("admin")
public class AdminResource {
    
    @Inject
    UsersServiceLocal uService;

    public AdminResource() {
    }

    @Path("recup")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAdm() {
        String restMsg="{\"message\":\"hello REST\"}";return restMsg;
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

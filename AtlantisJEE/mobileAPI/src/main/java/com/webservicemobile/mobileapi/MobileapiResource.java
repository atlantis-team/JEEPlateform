package com.webservicemobile.mobileapi;

import com.webservicemobile.domain.Device;
import com.webservicemobile.domain.Users;
import com.webservicemobile.service.DeviceServiceLocal;
import com.webservicemobile.service.UsersServiceLocal;
import java.util.List;
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
@Path("mobile")
public class MobileapiResource 
{
    
    @Inject
    UsersServiceLocal uService;
    
    @Inject
    DeviceServiceLocal dService;
    
    public MobileapiResource() 
    {
        
    }
    
    //Lister device
    @POST
    @Path("getDevices")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Device> getDevicesList() 
    {
        List<Device> devices = dService.select("4087fab0-fb70-4358-8b11-56c10c16c078");
        return devices;
    }
    
    //get calculated metric
    @POST
    @Path("getCalculatedMetrics")
    @Produces(MediaType.APPLICATION_JSON)
    public void getCalculatedMetrics() {
        //Get calculated metrics
    }
    
    //Fonction that create user if he doesn't exist
    public void CheckToken(String token) {
        //Possible creation of a user
    } 
    
  /* 
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("id") UserModel user)
    {
        Users users = new Users();
        
        users.getFirstName();
        users.getLastName();
        
        return Response.ok(users).build();
        
    }*/
 /*   
    @GET
    @Path("getuserdevice")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserDevice(UserModel user)
    {
        List<Users> users = Users.get();
        GenericEntity<List<Users>> entity = new GenericEntity<List<Users>>(Users) {};
    
        return Response.ok(entity).build();
        
    }
    
    
    @Path("getdevicerawmetrics")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDeviceRawMetrics(DataModel data)
    {
        
    } 
    
    @Path("getcalcmetrics")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDeviceCalcMetrics(CalcDataModel CalcData)
    {
        
    }
    
  */
    @Path("createUser")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUsers(UserModel user) 
    {
        Users users = new Users();
        
        users.setFirstName(user.getUsername());
        users.setLastName(user.getLastName());
        
        uService.save(users);

        return Response.accepted().build();
    }
  
}

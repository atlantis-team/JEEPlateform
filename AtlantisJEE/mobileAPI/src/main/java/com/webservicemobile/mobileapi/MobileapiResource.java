package com.webservicemobile.mobileapi;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.webservicemobile.domain.Device;
import com.webservicemobile.domain.Metrics;
import com.webservicemobile.domain.Users;
import com.webservicemobile.service.DeviceServiceLocal;
import com.webservicemobile.service.MetricServiceLocal;
import com.webservicemobile.service.UsersServiceLocal;
import com.webservicemobile.utils.JWTProvider;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
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
    
    @Inject
    MetricServiceLocal mService;
    
    public MobileapiResource() 
    {
        
    }
    
    //Lister device
    @POST
    @Path("getDevices")
  //  @Produces(MediaType.APPLICATION_JSON)
    public /*DeviceListModel*/Response getDevicesList(String token) 
    {
       
        System.out.println("[ON] get devices list : " + token);
        
        Gson gson = new Gson();
        TokenModel tokenModel = gson.fromJson(token, TokenModel.class);
      
        JWTProvider jwt = new JWTProvider();
        try {
            
            String id = jwt.getUserIdFromToken(tokenModel.getToken());
            JsonObject json = jwt.decodeJWT(tokenModel.getToken());
            Users u = CheckToken(id, json);
            List<Device> devices = dService.select(id);
            
            DeviceListModel dlm = new DeviceListModel();
            dlm.devices = devices;
            dlm.firstname = u.getFirstName();
            dlm.lastname = u.getLastName();
            dlm.userId = u.getOid();
            
            System.out.println(gson.toJson(dlm));
         
            return Response.status(200)
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                    .header("Access-Control-Allow-Credentials", "true")
                    .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                    .header("Access-Control-Max-Age", "1209600")
                    .entity(gson.toJson(dlm))
                    .build();
            //return dlm;
       } catch(Exception e) {
            return null;
        }
    }
    
    @GET
    @Path("hey")
    public String Hello() {
        return "Comment tu vas";
    }
    
    /*
    
    @OPTIONS
    @Path("{path: .*}")
    public Response options() {
        System.out.println("OPTIONSSS");
        return Response.ok("")
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                    .header("Access-Control-Allow-Credentials", "true")
                    .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                    .header("Access-Control-Max-Age", "1209600")
                    .build();
    }
    
    */
    
    //get calculated metric
    @POST
    @Path("getDeviceCalcMetrics")
    @Produces(MediaType.APPLICATION_JSON)
    public CalculatedMetricsModel getCalculatedMetrics(RequestCalculatedMetricsModel request) {
        //Get calculated metrics
        JWTProvider jwt = new JWTProvider();
        
        try {
            
            String id = jwt.getUserIdFromToken(request.getToken());
            JsonObject json = jwt.decodeJWT(request.getToken());
            CheckToken(id, json);
            CalculatedMetricsModel cl = new CalculatedMetricsModel();
            //return u;
            float[] d = { 1 , 2, 3, 4};
            cl.Metrics = d;
            return cl;
        } catch(Exception e) {
            return null;
        }
    }
    
    //get last raw metrics
    @POST
    @Path("getDeviceRawMetrics")
    public /*List<Metrics>*/Response GetRawMetrics(String request) {
        //RequestRawMetricsModel
        System.out.println("[ON] get raw metrics (3) : " + request);
        
        JWTProvider jwt = new JWTProvider();
        
        Gson gson = new Gson();
        RequestRawMetricsModel requestRM = gson.fromJson(request, RequestRawMetricsModel.class);
        
        try {
            
            String id = jwt.getUserIdFromToken(requestRM.getToken());
            JsonObject json = jwt.decodeJWT(requestRM.getToken());
            CheckToken(id, json);
            List<Metrics> allMetrics = mService.selectLastMetrics(requestRM.getDeviceId());
            System.out.println("Metrics found for device (" + requestRM.getDeviceId());
            for(int i=0; i<allMetrics.size(); i++)
                System.out.println(allMetrics.get(i).toString());
            List<Metrics> lastThreeMetrics = new ArrayList();
            for(int i=0; i<allMetrics.size(); i++)
                lastThreeMetrics.add(allMetrics.get(i));
            
            return Response.status(200)
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                    .header("Access-Control-Allow-Credentials", "true")
                    .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                    .header("Access-Control-Max-Age", "1209600")
                    .entity(gson.toJson(lastThreeMetrics))
                    .build();
        } catch(Exception e) {
            System.out.println("Exception : " + e.getMessage());
            return null;
        }
    }
    
    //send command
    @POST
    @Path("sendMessageToDevice")
    public CommandReturnModel SendMessageToDevice(SendCommandModel command) {
        JWTProvider jwt = new JWTProvider();
        try {
            
            String id = jwt.getUserIdFromToken(command.getToken());
            JsonObject json = jwt.decodeJWT(command.getToken());
            CheckToken(id, json);
            
            //com.google.gson.JsonSerializer<SendCommandModel> serializer = new JsonSerializer<SendCommandModel>();
            Gson gson = new Gson();
            String jsonCommand = gson.toJson(command);
            
            System.out.println("Le fammeux json : " + jsonCommand);
            
            String s = PostRequest("192.168.43.62", command.toString());
            
            CommandReturnModel crm = new CommandReturnModel();
            crm.setMessage(jsonCommand);
            
            return crm;
            
        } catch(Exception e) {
            System.out.println("Exception : " + e.getMessage());
            return null;
        }
    }
    
    public String PostRequest(String path, String json) {
        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-type", "application/json");
            
            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes());
            os.flush();
            
            if(conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                return conn.getInputStream().toString();
            }
            
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String outputLine;
            String output = "";
            System.out.println("Output from server... \n");
            while((outputLine = br.readLine()) != null)
                output += outputLine + "\n";
            
            conn.disconnect();
            
            return output;
            
        } catch(MalformedURLException e) {
            return e.getMessage();
        } catch(IOException e) {
            return e.getMessage();
        }
        
    }
    
    //Fonction that create user if he doesn't exist
    public Users CheckToken(String token, JsonObject json) {
        //Possible creation of a user
        Users user = new Users();
        //TODO : Care for expired token
        user.setOid(token);
        user.setFirstName(json.get("given_name").getAsString());
        user.setLastName(json.get("family_name").getAsString());
        if(! uService.IsUserInBD(token))
            uService.save(user);
        return user;
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
    
    
    //POST - SendCommande
  
}

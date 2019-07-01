package com.webservicejms.service;

import com.webservicejms.domain.Users;
import com.webservicejms.dao.UsersDAO;
import java.util.List;
import javax.ejb.Remove;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author cesi
 */
@Stateless
public class UsersService implements UsersServiceLocal
{
    private Users users = new Users();
    
    @Inject
    UsersDAO usersDAO;
    
    public void addUsers(String firstname, String lastname) 
    {
        users.setFirstName(firstname);
        users.setLastName(lastname);
        System.out.println("user identity: "+firstname+" "+lastname);
    }
    
    public Boolean IsUserInBD(String oid) {
        return usersDAO.IsUserInDB(oid);
    }
    
/*    @Override
    public void addAuthenticationInformations(String email, String pwd) 
    {
        users.setEmail(email);
        users.setPassword(pwd);
        System.out.println("ajout des informations d'authentification : "+email+" -"+pwd);
    }
*/  
    @Remove
    public void save(Users users) 
    {
        usersDAO.insert(users);
        System.out.println("user saved");
    }
}


package ch.lab.unil.eventwebsite.beans;

import ch.lab.unil.eventwebsite.Database.database;
import ch.lab.unil.eventwebsite.models.Event;
import ch.lab.unil.eventwebsite.models.User;
import ch.lab.unil.eventwebsite.Exceptions.AlreadyExistException;
import ch.lab.unil.eventwebsite.Exceptions.DoesNotExistExeeption;
import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
/**
 *
 * @author valerie
 */
@Named(value = "registerBean")
@SessionScoped
public class RegisterBeans implements Serializable {
        private  String firstname="";
        private  String lastname="";
        private  String username="";
        private  String email="";
        private  String password="";
        private  String  phonenumber="";
        private  String userRole="";
        private   ArrayList<Event> saleTicketList= new ArrayList<>();
    

    public String createNewUser()throws DoesNotExistExeeption,AlreadyExistException  {
        
            if (!emailExists() && !usernameExists()) {
                 boolean result = database.getInstance().insertUser(new User(firstname,lastname,username,email,password,phonenumber,userRole));
                 if(result == true){
                     return "/main page/Login.xhtml?param1=registered&faces-redirect=true";
                 }else{
                     return "/main page/Signup.xhtml?param1=notregistered&faces-redirect=true";
                 }
            }else{
                 return "/main page/Signup.xhtml?param1=notregistered&faces-redirect=true";
            }
       
    }
    
    public User getUserbyUsername(String username){
        
        User targetUser  = new User();
        if (!username.equals(""))
        { 
             targetUser =  database.getInstance().getUserByHisUserName(username.trim());
        }
        return targetUser;
    }
    
    private boolean usernameExists() throws DoesNotExistExeeption {
        for (User user : database.getInstance().getUsers()) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
 
    private boolean emailExists() throws AlreadyExistException {
        for (User user : database.getInstance().getUsers()) {
            if (user.getEmail().equals(email)) {
                throw new AlreadyExistException("The email " + email + " already in use.");
            }
        }
        return false;
    }
   

    public  String getFirstname() {
        return firstname;
    }

    public  void setFirstname(String _firstname) {
       this.firstname = _firstname;
    }

    public String getLastname() {
        return lastname;
    }


    public void setLastname(String lastname) {
         this.lastname = lastname;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
         this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public  void setEmail(String _email) {
       this.email = _email;
    }

    public  String getPassword() {
        return password;
    }


    public void setPassword(String _password) {
        this.password = _password;
    }

   
    public  String getPhonenumber() {
        return phonenumber;
    }

    
    public  void setPhonenumber(String _phonenumber) {
        this.phonenumber = _phonenumber;
    }

    public  String getUserRole() {
        return this.userRole;
    }

    public  void setUserRole(String _userRole) {
        this.userRole = _userRole;
    }
    public ArrayList<Event> getSaleTicketList() {
        return saleTicketList;
    }

    public void setSaleTicketList(ArrayList<Event> _saleTicketList) {
         this.saleTicketList = _saleTicketList;
    }
}



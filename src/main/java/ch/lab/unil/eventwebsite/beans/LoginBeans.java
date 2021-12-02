package ch.lab.unil.eventwebsite.beans;
import ch.lab.unil.eventwebsite.Exceptions.DoesNotExistExeeption;
import ch.lab.unil.eventwebsite.Database.database;
import ch.lab.unil.eventwebsite.models.User;
import java.io.Serializable;
//import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/** 
 *
 * @author valer
 
@Named(value = "loginBean")
@SessionScoped
public class LoginBeans implements Serializable {
    
    private String username="";
    private String password="";
    private User currentUser;
    
   // defaut constructor
    
    public String logUserIn() {
       
            database db = database.getInstance();
            User user = db.getUserByHisUserName(getUsername());
            if(user != null && user.isPasswordCorrect(getPassword())){
                // success log in ; user in the session 
                setCurrentUser(user);

                if(user.getUserRole().equalsIgnoreCase("seller")){
                    return "/seller page/SellerHomePage.xhtml?faces-redirect=true";

                }else{
                    return "/customer page/CustomerHomePage.xhtml?faces-redirect=true";

                }
            }else{
                return "/main page/Login.xhtml?faces-redirect=true"; 
            }
    }

    
   
     public String logUserOut() {
        setCurrentUser(null);
        return "/main page/Login.xhtml?faces-redirect=true"; 
    }

    
    public String getUsername() {
        return username;
    }

   
    public void setUsername(String username) {
        this.username = username;
    }

   
    public  String getPassword() {
        return password;
    }

    
    public void setPassword(String password) {
        this.password = password;
    }

    
    public  User getCurrentUser() {
        return database.getInstance().getUserByHisUserName(username);
    }

    
    public void setCurrentUser(User _currentUser) {
        this.currentUser = _currentUser;
    }


    public String resetPassword(){
      User user = database.getInstance().getUserByHisUserName(username);
        if(user != null){
            if(database.getInstance().updateUserList(user, password) == true){
               return "/main page/ResetPassword.xhtml?param=true&faces-redirect=true";
            }else{
                return "/main page/ResetPassword.xhtml?param=false&faces-redirect=true";
            }
     
        }else{
            return "/main page/ResetPassword.xhtml?param=false&faces-redirect=true";
        }    
            
        
    }
}
*/
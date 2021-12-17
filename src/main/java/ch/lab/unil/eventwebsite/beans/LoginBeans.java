
package ch.lab.unil.eventwebsite.beans;
import ch.lab.unil.eventwebsite.Exceptions.DoesNotExistExeeption;
import ch.lab.unil.eventwebsite.models.User;
import ch.lab.unil.eventwebsite.client.PersistenceClient;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

/** 
 *
 * @author valer
 */
        
@Named(value = "loginBean")
@SessionScoped
public class LoginBeans implements Serializable {
    
   

    private static User currentUser;
    private String username = "";
    private String password = "";
    
   // defaut constructor
    public String userLogsIn() {
        try {
            User u = PersistenceClient.getInstance().checkPassword(username, password);
            if (u != null) {
                currentUser = u;
                if(getCurrentUser().getUserRole().equalsIgnoreCase("seller"))
                   return "/seller page/SellerHomePage.xhtml?faces-redirect=true";
                else
                   return "/customer page/CustomerHomePage.xhtml?faces-redirect=true";
            }else{
                return "/main page/Login.xhtml?param='user=null'faces-redirect=true";
            }
        } catch (DoesNotExistExeeption ex) {
            System.out.println(ex.getMessage());
        }
        return "/MainPage/LoginPage.xhtml?faces-redirect=true";
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

    
    public User getCurrentUser(){
        return currentUser;
    }

    
    public void setCurrentUser(User _currentUser) {
        this.currentUser = _currentUser;
    }

    @Transactional
    public String resetPassword() throws  DoesNotExistExeeption{
        
        Boolean result = PersistenceClient.getInstance().updatePassword(username, password);
        if (result == true) {
            return "/main page/ResetPassword.xhtml?param=true&faces-redirect=true";
        }else{
            return "/main page/ResetPassword.xhtml?param=false&faces-redirect=true";
        }
    }
}



package ch.lab.unil.eventwebsite.beans;
import ch.lab.unil.eventwebsite.Exceptions.DoesNotExistExeeption;
import ch.lab.unil.eventwebsite.Database.database;
import ch.lab.unil.eventwebsite.models.User;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author valer
 */
@Named(value = "loginBean")
@RequestScoped
public class LoginBeans implements Serializable {
    
    private String username="";
    private String password="";
    private static User currentUser ;
    
   // defaut constructor

    /**
     *@param
     */
    public LoginBeans(){
        username = "";
        password = "";
        currentUser = new User();
    }
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

    
    /**
     * 
     * @return a false after setting the current user in the session out
     */
     public String logUserOut() {
        setCurrentUser(null);
        return "/main page/Login.xhtml?faces-redirect=true"; 
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public  String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the currentUser
     */
    public static User getCurrentUser() {
        return currentUser;
    }

    /**
     * @param currentUser the currentUser to set
     */
    public static void setCurrentUser(User currentUser) {
        LoginBeans.currentUser = currentUser;
    }
     
    /**
     *
     * @param _email
     * @param db
     */
    public String resetPassword(String _email,database db){
        //database db = new database();
        User user = db.getUserByUserEmail(_email);
        if(user != null){
            if(password.length()> 0){
                if(db.updateUserList(user, password) == true){
                    //
                }
            }
        }
        return "/main page/Login.xhtml?faces-redirect=true";
    }
}


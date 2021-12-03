package ch.lab.unil.eventwebsite.beans;
import ch.lab.unil.eventwebsite.Exceptions.DoesNotExistExeeption;
import ch.lab.unil.eventwebsite.models.User;
import java.io.Serializable;
import java.util.List;
//import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/** 
 *
 * @author valer
 */
        
@Named(value = "loginBean")
@SessionScoped
public class LoginBeans implements Serializable {
    
    @PersistenceContext(unitName = "ET_PU")
    private EntityManager em;

    private static User currentUser;
    private String username = "";
    private String password = "";
    
   // defaut constructor
    
    public String logUserIn() {
        try {
            User user = findByUsername();
            if (user != null && user.isPasswordCorrect(password)) {
                currentUser = user;
                if(currentUser.getUserRole().equalsIgnoreCase("seller"))
                   return "/seller page/SellerHomePage.xhtml?faces-redirect=true";
                else
                   return "/customer page/CustomerHomePage.xhtml?faces-redirect=true";
            }else{
                return "/main page/Login.xhtml?param='user=null'faces-redirect=true";
            }
        } catch (DoesNotExistExeeption ex) {
            System.out.println(ex.getMessage());
            return "/main page/LoginPage.xhtml?faces-redirect=true";
        }
        
    }

    protected User findByUsername() throws DoesNotExistExeeption {
        Query query = em.createNamedQuery("User.findByUsername", User.class);
        List<User> users = query.setParameter("username", username).getResultList();
        if (users.size() > 0) {
            return users.get(0);
        }
        throw new DoesNotExistExeeption("The user " + username + " does not exist.");
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

    
    public User getCurrentUser() {
        return currentUser;
    }

    
    public void setCurrentUser(User _currentUser) {
        this.currentUser = _currentUser;
    }


    public String resetPassword() throws  DoesNotExistExeeption{
        
        User user = findByUsername();
        if (user != null) {
            if(password.length()>0){
                user.setPassword(password);
                return "/main page/ResetPassword.xhtml?param=true&faces-redirect=true";
            }else{
                return "/main page/ResetPassword.xhtml?param=false&faces-redirect=true";
            }
        }else{
            return "/main page/ResetPassword.xhtml?param=false&faces-redirect=true";
            } 
        }
    }



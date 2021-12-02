package ch.lab.unil.eventwebsite.beans;

import ch.lab.unil.eventwebsite.models.Event;
import ch.lab.unil.eventwebsite.models.User;
import ch.lab.unil.eventwebsite.Exceptions.AlreadyExistException;
import ch.lab.unil.eventwebsite.Exceptions.DoesNotExistExeeption;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
/**
 *
 * @author valerie
 */
@Named(value = "registerBean")
@SessionScoped

public class RegisterBeans implements Serializable {

    @PersistenceContext(unitName = "ET_PU")
    private EntityManager em;
    
    private  String firstname="";
    private  String lastname="";
    private  String username="";
    private  String email="";
    private  String password="";
    private  String  phonenumber = "";
    private  String userRole="";
    private  List<Event> saleTicketList = new ArrayList<>();
    
    @Transactional
    public String createNewUser() throws AlreadyExistException, DoesNotExistExeeption  {
      
            if (!emailExists() && !usernameExists()) {
                    User newUser = new User();
                    newUser.setUsername(username);
                    newUser.setFirstname(firstname);
                    newUser.setLastname(lastname);
                    newUser.setEmail(email);
                    newUser.setPassword(password);
                    newUser.setPhonenumber(phonenumber);
                    newUser.setUserRole(userRole); 
                    em.persist(newUser);
                    
                    //empty
                    svuota();
                   return "/main page/Login.xhtml?param1=registered&faces-redirect=true";
            }else{
                svuota();
                return "/main page/Signup.xhtml?param1=notregistered&faces-redirect=true";
            }
    
    }
    
    private boolean usernameExists() throws DoesNotExistExeeption {
        Query query = em.createNamedQuery("User.findByUsername");
        List<User> users = query.setParameter("username", username).getResultList();
        return users.size() > 0;
    }
 
    private boolean emailExists() throws AlreadyExistException {
       Query query = em.createNamedQuery("User.findByEmail");
        List<User> users = query.setParameter("email",email).getResultList();
        return users.size() > 0; 
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

   
    public String getPhonenumber() {
        return phonenumber;
    }

    
    public void setPhonenumber(String phonenumber){
        this.phonenumber = phonenumber;
    }

    public String getUserRole() {
        return this.userRole;
    }

    public  void setUserRole(String _userRole) {
        this.userRole = _userRole;
    }
    public List<Event> getSaleTicketList() {
        return saleTicketList;
    }

    public void setSaleTicketList(List<Event> _saleTicketList) {
         this.saleTicketList = _saleTicketList;
    }

    private void svuota() {
        this.firstname="";
        this.lastname="";
        this.username="";
        this.email="";
        this. password="";
        this.phonenumber = "";
        this.userRole="";
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

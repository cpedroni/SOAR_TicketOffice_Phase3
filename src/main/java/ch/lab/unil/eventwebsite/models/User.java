package ch.lab.unil.eventwebsite.models;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author valer
 */
@XmlRootElement
public class User{
   
    
    private Integer userId;
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String password;
    private String phonenumber;
    private String userRole;
    private List<Event> saleTicketList;
    
 public User() {
    }
    
    public int getUserId() {
        return userId;
    }
    
    public void setUserId(Integer UserId) {
        this.userId = UserId;
    }
    
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
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
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String _password) {
        this.password = _password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    public String getUserRole() {
        return userRole;
    }
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
    public List<Event> getSaleTicketList() {
        return saleTicketList;
    }
    public void setSaleTicketList(Event Ticket) {
        this.saleTicketList.add(Ticket);
    }

   
    public boolean isPasswordCorrect(String _password){
        //return Integer.toString(password.hashCode()).equals(this.password);
        return this.password.equals(_password);
    }
 
}



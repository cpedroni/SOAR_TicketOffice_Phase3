package ch.lab.unil.eventwebsite.models;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author valer
 */

@Entity
@Table(name = "USER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "User.findByFirstName", query = "SELECT u FROM User u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "User.findByLastName", query = "SELECT u FROM User u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name= "User.findByPhonenumber", query = "SELECT u FROM User u WHERE u.phonenumber = :phonenumber"),
    @NamedQuery(name = "User.findByUserRole", query = "SELECT u FROM User u WHERE u.userRole = :userRole"),
    @NamedQuery(name = "User.findBySaleticketlist", query = "SELECT u FROM User u WHERE u.saleTicketList = :saleTicketList")})

public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FIRST_NAME")
    private String firstname;
    @Size(max = 50)
    @Column(name = "LAST_NAME")
    private String lastname;
    @Column(name = "USERNAME")
    private String username;
    @Size(max = 50)
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PASSWORD")
    private String password;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PHONE NUMBER")
    private String phonenumber;
    @Column(name = "ROLE")
    private String userRole;
    @Column(name = "TICKETS SOLD")
    private ArrayList<Event> saleTicketList;
    



/**public class User {
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String password;
    private String  phonenumber;
    private  String userRole;
    private ArrayList<Event> saleTicketList; 
    */
    
    
    /**
     *@param
     */
    public User(){}
    
    // param constructor to initialize the attribute

    /**
     *
     * @param _firstname
     * @param _lastname
     * @param _username
     * @param _email
     * @param _pass
     * @param _phoneN
     * @param _userRole
     */
    /*public User(String _firstname, String _lastname,String _username, String _email,String _pass,String _phoneN , String _userRole){
        firstname = _firstname;
        lastname = _lastname;
        username = _username;
        email = _email;
        password = _pass;
        phonenumber = _phoneN;
        userRole = _userRole;
        this.saleTicketList = new ArrayList<Event>();
    }
    /*

    // get the users' firstname

    /**
     *
     * @return
     */
    public String getFirstname() {
        return firstname;
    }

   // set  users' firstname

    /**
     *
     * @param firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    //get the users' lastname

    /**
     *
     * @return
     */
    public String getLastname() {
        return lastname;
    }

   //set the users' lastname

    /**
     *
     * @param lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    //get  the users' username

    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    // set the users' usertname

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    // get the users' email

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    //set the users' email

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    // get the users' password

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

   // set the users' password

    /**
     *
     * @param _password
     */
    public void setPassword(String _password) {
        this.password = _password;
    }

    // get the users' phoneNumber

    /**
     *
     * @return
     */
    public String getPhonenumber() {
        return phonenumber;
    }

    //set the users'phoneNumber

    /**
     *
     * @param phonenumber
     */
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    // get the users'role

    /**
     *
     * @return
     */
    public String getUserRole() {
        return userRole;
    }

   // set the users' role

    /**
     *
     * @param userRole
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    // get the list of sale ticket 

    /**
     *
     * @return
     */
    public ArrayList<Event> getSaleTicketList() {
        return saleTicketList;
    }

    // set the list of sale ticket

    /**
     *
     * @param Ticket
     */
    public void setSaleTicketList(Event Ticket) {
        this.saleTicketList.add(Ticket);
    }

    /**
     *
     * @param _password
     * @return
     */
    public boolean isPasswordCorrect(String _password){
        //return Integer.toString(password.hashCode()).equals(this.password);
        return this.password.equals(_password);
    }
 
}



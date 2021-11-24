
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
        private static String firstname;
        private static String lastname;
        private static String username;
        private static String email;
        private static String password;
        private static String  phonenumber;
        private static String userRole;
        private static  ArrayList<Event> saleTicketList;
        private  static database db ;
    
    // default constructor

    /**
     *@param
     */
    public  RegisterBeans(){
        firstname = "";
        lastname = "";
        username = "";
        email = "";
        password = "";
        phonenumber = "";
        userRole = "";
        saleTicketList = new ArrayList<Event>();
        db = new database();
    }
    
    // parameter constructor

    /**
     *
     * @param f
     * @param l
     * @param u
     * @param e
     * @param p
     * @param pho_N
     * @param Ur
     */
    public  RegisterBeans( String f, String l, String u, String e, String p, String pho_N, String Ur){
        firstname = f;
        lastname = l;
        username = u;
        email = e;
        password = p;
        phonenumber = pho_N;
        userRole = Ur;
        saleTicketList = new ArrayList<Event>();
        db = new database();
        
    }


    /**
     * this method create a new user only if he does not exist on the database otherwise it generate an  exception
     * @param db
    **/
    public static String createNewUser(database db) {
        // db = getDb();
        try {
            if (!checkIfEmailExist(getEmail()) && !checkIfUsernameExist(getUsername())) {
                db.insertUser(new User(getFirstname(),getLastname(),getUsername(),getEmail(),getPassword(),getPhonenumber(),getUserRole()));
            }
        } catch (AlreadyExistException | DoesNotExistExeeption ex) {
            System.out.println(ex.getMessage());
        }
        return "/main page/Login.xhtml?faces-redirect=true";
    }
    
    /**
     * search in the database a user by username and return the user if found o null if not
     * @param username
     * @return 
    **/
    public User getUserbyUsername(String username){
        
        User targetUser  = new User();
        if (!username.equals(""))
        { 
             targetUser =  db.getUserByHisUserName(username.trim());
        }
        return targetUser;
    }
    
    /**
     * check if there is a user in the database with the specify email 
     * return true if doesn't and false otherwise
     * @param email
     * @return 
     * @throws ch.lab.unil.eventwebsite.Exceptions.AlreadyExistException 
    **/
    protected static boolean checkIfEmailExist(String email) throws AlreadyExistException {
        
        if(db.getUserByUserEmail(email) == null)
        {
            return true;
        }else
        {
            return false;
        }
            
       
    }
    /**
     * check if there is a user in the database with the specify username 
     * return true if doesn't and false otherwise
     * @param username
     * @return 
     * @throws ch.lab.unil.eventwebsite.Exceptions.DoesNotExistExeeption
    **/
    protected static boolean checkIfUsernameExist(String username) throws DoesNotExistExeeption {
        database db = new database();
        if(db.getUserByHisUserName(username) == null)
        {
            return true;
        }else
        {
            return false;
        }
    }
   
    // return the actual database Object

    /**
     *
     * @return
     */
    public static database getDb(){
     return db;
    }
    
    // set the database 

    /**
     *
     * @param _db
     */
    public static void setDb(database _db){
         RegisterBeans.db = _db;
       }
   
    /*
    * get the firstname
    */

    /**
     *
     * @return
     */

    public  static String getFirstname() {
        return firstname;
    }

    /*
     * set  firstname 
     */

    /**
     *
     * @param _firstname
     */

    public  static void setFirstname(String _firstname) {
       firstname = _firstname;
    }

    /*
     * @return the lastname
     */

    /**
     *
     * @return
     */

    public static String getLastname() {
        return lastname;
    }

    /*
     * @param  lastname to set
     */

    /**
     *
     * @param lastname
     */

    public static void setLastname(String lastname) {
         RegisterBeans.lastname = lastname;
    }

    /*
     * @return the username
     */

    /**
     *
     * @return
     */

    public static String getUsername() {
        return username;
    }

    /*
     * @param  username to set
     */

    /**
     *
     * @param username
     */

    public static void setUsername(String username) {
         RegisterBeans.username = username;
    }

    /*
     * @return the email
     */

    /**
     *
     * @return
     */

    public static String getEmail() {
        return email;
    }

    /*
     * @param email the email to set
     */

    /**
     *
     * @param _email
     */

    public static void setEmail(String _email) {
       email = _email;
    }

    /**
     * @return the password
     */
    public static String getPassword() {
        return password;
    }

    /*
     * @param password the password to set
     */

    /**
     *
     * @param _password
     */

    public static void setPassword(String _password) {
        password = _password;
    }

    /*
     * @return the phonenumber
     */

    /**
     *
     * @return
     */

    public static String getPhonenumber() {
        return phonenumber;
    }

    /*
     * @param phonenumber the phonenumber to set
     */

    /**
     *
     * @param _phonenumber
     */

    public static void setPhonenumber(String _phonenumber) {
        phonenumber = _phonenumber;
    }

    /*
     * @param  get the userRole
     */

    /**
     *
     * @return
     */

    public static String getUserRole() {
        return  RegisterBeans.userRole;
    }

    /**
     *
     * @param _userRole
     */

    public static void setUserRole(String _userRole) {
        userRole = _userRole;
    }

    /*
     * @return the saleTicketList
     */

    /**
     *
     * @return
     */

    public static ArrayList<Event> getSaleTicketList() {
        return saleTicketList;
    }

    /**
     *
     * @param _saleTicketList
     */

    public static void setSaleTicketList(ArrayList<Event> _saleTicketList) {
         RegisterBeans.saleTicketList = _saleTicketList;
    }
}



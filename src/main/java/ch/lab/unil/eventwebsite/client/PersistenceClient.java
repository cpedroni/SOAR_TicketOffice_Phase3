package ch.lab.unil.eventwebsite.client;

import ch.lab.unil.eventwebsite.Exceptions.AlreadyExistException;
import ch.lab.unil.eventwebsite.Exceptions.DoesNotExistExeeption;
import ch.lab.unil.eventwebsite.models.Event;
import ch.lab.unil.eventwebsite.models.User;
import java.util.List;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * 
 *
 * @author pecat
 */

public class PersistenceClient {

    private static final String EVENT_URL = "http://localhost:8080/eventwebsite/resources/ch.lab.unil.eventwebsite.models.Event";
    private static final String USER_URL = "http://localhost:8080/eventwebsite/resources/ch.lab.unil.eventwebsite.models.user";

    private static Client client;
    private static WebTarget target;
    private static PersistenceClient instance;

    private PersistenceClient() {
        PersistenceClient.client = ClientBuilder.newClient();
    }

    public static PersistenceClient getInstance() {
        if (instance == null) {
            instance = new PersistenceClient();
        }
        return instance;
    }
    
    public void createUser(User user) {
        client.target(USER_URL + "/create").request().post(Entity.entity(user, "application/xml"));
    }
    
    public void updateUser(User user) {
        client.target(USER_URL + "/edit/" + user.getUserId()).request().put(Entity.entity(user, "application/xml"));
    }
    
    public User checkPassword(String username, int password) throws DoesNotExistExeeption {
        User u = getUserByName(username);
        if (u.getUsername().equals(username) & u.getPassword() == password) {
            return u;
        }
        throw new DoesNotExistExeeption("User " + username + " does not exist.");
    }
    
    public boolean emailExists(String email) throws AlreadyExistsException {
        return client.target(USERS_URL + "/emailExists/" + email).request().get().readEntity(Boolean.class);
    }
    
    public Users getUserById(int id) {
        return parseUser(client.target(USER_URL + "/find/" + id).request().get().readEntity(String.class));
    }

    public Users getUserByName(String username) {
        Users u = parseUser(client.target(USER_URL + "/findByName/" + username).request().get(String.class));
        return u;
    }

    public List<User> getAllUsers() {
        return parseUserList(client.target(USER_URL).request().get(String.class));
    }

    private List<User> parseUserList(String xml) {
        List<User> userList = new ArrayList<>();
        NodeList list = parseDocument(xml).getElementsByTagName("user");
        for (int i = 0; i < list.getLength(); i++) {
            Element e = (Element) list.item(i);

            User user = new User();
            user.setEmail(e.getElementsByTagName("email").item(0).getTextContent());
            user.setFirstName(e.getElementsByTagName("firstName").item(0).getTextContent());
            user.setLastName(e.getElementsByTagName("lastName").item(0).getTextContent());
            user.setPassword(Integer.valueOf(e.getElementsByTagName("password").item(0).getTextContent()));
            user.setUserId(Integer.valueOf(e.getElementsByTagName("userId").item(0).getTextContent()));
            user.setUsername(e.getElementsByTagName("username").item(0).getTextContent());

            userList.add(user);
        }
        return userList;
    }

    private User parseUser(String xml) {
        if (xml.length() == 0) {
            return null;
        }
        Element e = (Element) parseDocument(xml).getElementsByTagName("user").item(0);

        Users user = new Users();
        user.setEmail(e.getElementsByTagName("email").item(0).getTextContent());
        user.setFirstName(e.getElementsByTagName("firstName").item(0).getTextContent());
        user.setLastName(e.getElementsByTagName("lastName").item(0).getTextContent());
        user.setPassword(Integer.valueOf(e.getElementsByTagName("password").item(0).getTextContent()));
        user.setUserId(Integer.valueOf(e.getElementsByTagName("userId").item(0).getTextContent()));
        user.setUsername(e.getElementsByTagName("username").item(0).getTextContent());

        return user;
    }
    
    private Document parseDocument(String xml) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse(new InputSource(new StringReader(xml)));
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

}

package ch.lab.unil.eventwebsite.client;

import ch.lab.unil.eventwebsite.Exceptions.AlreadyExistException;
import ch.lab.unil.eventwebsite.Exceptions.DoesNotExistExeeption;
import ch.lab.unil.eventwebsite.models.Event;
import ch.lab.unil.eventwebsite.models.User;
import java.util.List;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
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
    
    public boolean emailExists(String email) throws AlreadyExistException {
        return client.target(USER_URL + "/emailExists/" + email).request().get().readEntity(Boolean.class);
    }
    
    public User getUserById(int id) {
        return parseUser(client.target(USER_URL + "/find/" + id).request().get().readEntity(String.class));
    }

    public User getUserByName(String username) {
        User u = parseUser(client.target(USER_URL + "/findByName/" + username).request().get(String.class));
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
            user.setFirstname(e.getElementsByTagName("firstName").item(0).getTextContent());
            user.setLastname(e.getElementsByTagName("lastName").item(0).getTextContent());
            user.setPassword(e.getElementsByTagName("password").item(0).getTextContent());
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

        User user = new User();
        user.setEmail(e.getElementsByTagName("email").item(0).getTextContent());
        user.setFirstname(e.getElementsByTagName("firstName").item(0).getTextContent());
        user.setLastname(e.getElementsByTagName("lastName").item(0).getTextContent());
        user.setPassword(e.getElementsByTagName("password").item(0).getTextContent());
        user.setUserId(Integer.valueOf(e.getElementsByTagName("userId").item(0).getTextContent()));
        user.setUsername(e.getElementsByTagName("username").item(0).getTextContent());

        return user;
    }
    
    public void createEvent(Event event) {
        client.target(EVENT_URL + "/create").request().post(Entity.entity(event, "application/xml"));
    }

    public void updateEvent(Event event) {
        client.target(EVENT_URL + "/edit/" + event.getEventId()).request().put(Entity.entity(event, "application/xml"));
    }

    public void removeEvent(int id) {
        client.target(EVENT_URL + "/remove/" + id).request().get().readEntity(String.class);
    }

    public Event getEventById(int id) {
        return parseEvent(client.target(EVENT_URL + "/find/" + id).request().get().readEntity(String.class));
    }

    public Event getEventByName(String eventName) throws DoesNotExistExeeption {
        Event e = parseEvent(client.target(EVENT_URL + "/findByName/" + eventName).request().get(String.class));
        if (e != null) {
            return e;
        }
        throw new DoesNotExistExeeption("Event " + eventName + " does not exist.");
    }

    public List<Event> getAllEvents() {
        return parseEventList(client.target(EVENT_URL).request().get(String.class));
    }

    private List<Event> parseEventList(String xml) {
        List<Event> eventList = new ArrayList<>();
        NodeList list = parseDocument(xml).getElementsByTagName("events");
        for (int i = 0; i < list.getLength(); i++) {
            Element e = (Element) list.item(i);

            Event event = new Event();
            event.setEventId(Integer.valueOf(e.getElementsByTagName("eventId").item(0).getTextContent()));
            event.setName(e.getElementsByTagName("eventName").item(0).getTextContent());
            event.setImg(e.getElementsByTagName("eventImg").item(0).getTextContent());
            event.setDate(Date.valueOf(e.getElementsByTagName("eventDate").item(0).getTextContent()));
            event.setLocation(e.getElementsByTagName("eventLocation").item(0).getTextContent());
            event.setDescription(e.getElementsByTagName("eventDescription").item(0).getTextContent());
            event.setPrice(Double.valueOf(e.getElementsByTagName("eventPrice").item(0).getTextContent()));
            event.setNbPlace(Integer.valueOf(e.getElementsByTagName("eventNbPlace").item(0).getTextContent()));
            event.setSecurity(e.getElementsByTagName("eventName").item(0).getTextContent());
            event.setStatus(e.getElementsByTagName("eventName").item(0).getTextContent());

            eventList.add(event);
        }
        return eventList;
    }

    private Event parseEvent(String xml) {
        if (xml.length() == 0) {
            return null;
        }
        Element e = (Element) parseDocument(xml).getElementsByTagName("events").item(0);

        Event event = new Event();
        event.setEventId(Integer.valueOf(e.getElementsByTagName("eventId").item(0).getTextContent()));
        event.setName(e.getElementsByTagName("eventName").item(0).getTextContent());
        event.setImg(e.getElementsByTagName("eventImg").item(0).getTextContent());
        event.setDate(Date.valueOf(e.getElementsByTagName("eventDate").item(0).getTextContent()));
        event.setLocation(e.getElementsByTagName("eventLocation").item(0).getTextContent());
        event.setDescription(e.getElementsByTagName("eventDescription").item(0).getTextContent());
        event.setPrice(Double.valueOf(e.getElementsByTagName("eventPrice").item(0).getTextContent()));
        event.setNbPlace(Integer.valueOf(e.getElementsByTagName("eventNbPlace").item(0).getTextContent()));
        event.setSecurity(e.getElementsByTagName("eventName").item(0).getTextContent());
        event.setStatus(e.getElementsByTagName("eventName").item(0).getTextContent());

        return event;
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

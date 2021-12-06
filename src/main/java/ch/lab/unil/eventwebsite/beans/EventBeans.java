package ch.lab.unil.eventwebsite.beans;

import ch.lab.unil.eventwebsite.Exceptions.DoesNotExistExeeption;
import ch.lab.unil.eventwebsite.models.Event;
import java.io.Serializable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;


/**
 *
 * @author valer
 */
@Named(value = "eventBean")
@SessionScoped
public class EventBeans implements Serializable  {
    
    @PersistenceContext(unitName = "ET_PU")
    private EntityManager em;

    private Event targetEvent = new Event();
    private String element = "";
    
     // this method has been implemented
    @Transactional
    public String getOneEvent (Event _e){
         Event event= new Event();
        try{
            Event e = findByEventIdInDb(_e.getEventId());
            event = e;
        } catch (DoesNotExistExeeption ex) {
            System.out.println(ex.getMessage());
        } 
         if(event != null){
             setTargetEvent(event);
             return "/seller page/SeeOneEvent.xhtml?param1="+targetEvent+"&faces-redirect=true";
         }else{
             return "/seller page/SellerHomePage.xhtml?faces-redirect=true";
         }

    }
    // this method has been implemented
    @Transactional
     public String getOneEventCustomer(Event _e){
         Event event = new Event();
        try{
            Event e = findByEventIdInDb(_e.getEventId());
            event = e;
        } catch (DoesNotExistExeeption ex) {
            System.out.println(ex.getMessage());
        } 
         if(event != null){
             setTargetEvent(event);
             return "/customer page/CustomerSeeOneEvent.xhtml?param1="+targetEvent+"&faces-redirect=true";
         }else{
             return "/seller page/CustomerHomePage.xhtml?faces-redirect=true";
         }
    }
     
     // this method has been implemented 
    @Transactional
    public ArrayList<Event> getListOfAllEvents(){
         Query query = em.createNamedQuery("Event.findAll");
          return new ArrayList<Event>(query.getResultList());
    }
    
    // this method is ok
    @Transactional
    public void deleteEvent(Event e){
        // delete e from list  
        try {
            if (doesEventExistInDb(e.getEventId())) {
                Event event = findByEventIdInDb(e.getEventId());
                em.remove(event);
            }
        } catch (DoesNotExistExeeption ex) {
            System.out.println(ex.getMessage());
        }
    }
    // this method is ok
    
    @Transactional
    public String addEvent() throws DoesNotExistExeeption{

            if(doesEventExistInDb(targetEvent.getEventId()) == false){ 
                 // problem with datetime object 
                //targetEvent.setDate(null);
                em.persist(targetEvent);
                return "/seller page/SellerHomePage.xhtml?param =insertok&faces-redirect=true";
            }else{
                return "/seller page/SellerHomePage.xhtml?param=fail&faces-redirect=true";
        }
        
         
    }
     
    @Transactional
    public String buyTicket(Event target){ 
        return "/seller page/BuyTicket.xhtml?param1="+target+"&faces-redirect=true";
    }
    // done
    @Transactional
    public String confirmticket(Event target){
            if (doesEventExistInDb(target.getEventId())) {
                int newqta = target.getNbPlace() - 1;
                String sqlq = "UPDATE Event x SET x.nbplace = '"+newqta+"'" + " WHERE x.eventId =:eventId";
                Query query = em.createQuery(sqlq);
                query.setParameter("eventId",target.getEventId());
                query.executeUpdate(); 
                return "/seller page/BuyTicket.xhtml?param1=success&faces-redirect=true";  
            }else{
                return "/seller page/SellerHomePage.xhtml?param1=error&faces-redirect=true";
            }    
    }
    // done
   @Transactional 
   public List<Event> search(){
       try{
            List<Event> e = findByEventNameInDb(element);
            return e;
    
        } catch (DoesNotExistExeeption ex) {
            return new ArrayList<Event>();
        }
   }
   
    // private method 
    private boolean doesEventExistInDb(Integer eventId) {
         try {
            return findByEventIdInDb(eventId) != null;
        } catch (DoesNotExistExeeption ex) {
            System.out.println(ex.getMessage());
        }
        return false;
        
    }
    private boolean doesEventNotExistInDb(Integer eventId) throws DoesNotExistExeeption {
          if(findByEventIdInDb(eventId) == null){
              return true;
          }else{
              return false;
          }    
    }
    
    private Event findByEventIdInDb(Integer _eventId) throws DoesNotExistExeeption {
        Query query = em.createNamedQuery("Event.findByEventId");
        List<Event> events = query.setParameter("eventId", _eventId).getResultList();
        if (events.size() > 0) {
            return events.get(0);
        }
        throw new DoesNotExistExeeption("Food " + _eventId + " does not exist.");
        
    }
    
    private List<Event> findByEventNameInDb(String element)throws DoesNotExistExeeption {
        Query query = em.createNamedQuery("Event.findByEventName");
        List<Event> events = query.setParameter("name", element).getResultList();
        if (events.size() > 0) {
            return events;
        }
        throw new DoesNotExistExeeption("Aucun Resultat pour :"+element); //To change body of generated methods, choose Tools | Templates.
    }
    
    private String getDateTime(Date date) {
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    return dateFormat.format(date);
}
    
   
    // getter and setter
     public void setTargetEvent(Event e){
        this.targetEvent = e;
    }
    public Event getTargetEvent(){
        return this.targetEvent;
    }
     public void setElement(String e){
        this.element = e;
    }
    public String getElement(){
        return element;
    }

   

    

   
   


       

}


    





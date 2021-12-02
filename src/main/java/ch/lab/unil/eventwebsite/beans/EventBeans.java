package ch.lab.unil.eventwebsite.beans;

import ch.lab.unil.eventwebsite.Exceptions.DoesNotExistExeeption;
import ch.lab.unil.eventwebsite.models.Event;
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
    // TODO  define first in the event model the method to call
    /**
    public ArrayList<Event> getListOfAvailableEventsInSold(){
        return database.getInstance().getEventInSold();
}


    public ArrayList<Event> getListOfAvailableEvents(){
        return database.getInstance().getAllAvailableEvent();
    }
  
  **/
    
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
    public String addEvent(){
        
        try {
            if (doesEventNotExistInDb(targetEvent.getEventId())) { 
                em.persist(targetEvent);
            }
        } catch (DoesNotExistExeeption ex) {
            return "/seller page/SellerHomePage.xhtml?param ="+ex.getMessage()+"fail&faces-redirect=true";
        }
        return "/seller page/SellerHomePage.xhtml?param =insertok&faces-redirect=true";
         
    }
     
    
    public String buyTicket(Event target){ 
        return "/seller page/BuyTicket.xhtml?param1="+target+"&faces-redirect=true";
    }
    // done
    @Transactional
    public String confirmticket(Event target){
            if (doesEventExistInDb(target.getEventId())) { 
                em.merge(target); // the merge does nsert and update
                return "/seller page/SellerHomePage.xhtml?param1=error&faces-redirect=true";
            }else{
               return "/seller page/BuyTicket.xhtml?param1=error&faces-redirect=true";
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


    





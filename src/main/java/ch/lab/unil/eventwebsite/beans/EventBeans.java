package ch.lab.unil.eventwebsite.beans;

import ch.lab.unil.eventwebsite.Exceptions.DoesNotExistExeeption;
import ch.lab.unil.eventwebsite.client.PersistenceClient;
import ch.lab.unil.eventwebsite.models.Event;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author valer
 */

@Named(value = "eventBean")
@SessionScoped
public class EventBeans implements Serializable {
    
    private Event targetEvent = new Event();
    private String element = "";
    
    public String getOneEvent (Event _e){
         Event event = PersistenceClient.getInstance().getEventById(_e.getEventId());
         if(event != null){
             setTargetEvent(event);
             return "/seller page/SeeOneEvent.xhtml?param1="+targetEvent+"&faces-redirect=true";
         }else{
             return "/seller page/SellerHomePage.xhtml?faces-redirect=true";
         }
    }

     public String getOneEventCustomer(Event _e){
        Event event = PersistenceClient.getInstance().getEventById(_e.getEventId());
         if(event != null){
             setTargetEvent(event);
             return "/customer page/CustomerSeeOneEvent.xhtml?param1="+targetEvent+"&faces-redirect=true";
         }else{
             return "/customer page/CustomerHomePage.xhtml?faces-redirect=true";
         }
    }
     
    public List<Event> getListOfAllEvents(){
          return PersistenceClient.getInstance().getAllEvents();
    }
    
    public void deleteEvent(Event e){
        // delete e from list  
        List<Event> eventlist = PersistenceClient.getInstance().getAllEvents();
        if(eventlist.size()>0){
            for(Event item : eventlist ){
                if (item.getName().equals(e.getName())) {
                    PersistenceClient.getInstance().removeEvent(e.getEventId());
                }
            }
        }
  
    }
    public String addEvent() throws DoesNotExistExeeption{
        if(targetEvent != null){
            PersistenceClient.getInstance().createEvent(targetEvent);
            // check if event has been created
            Event newE = PersistenceClient.getInstance().getEventByName(targetEvent.getName());
            if(newE != null){
                return "/seller page/SellerHomePage.xhtml?param =insertok&faces-redirect=true";  
            }else{
                return "/seller page/SellerHomePage.xhtml?param=fail&faces-redirect=true";   
            }
        }else{
            return "/seller page/SellerHomePage.xhtml?param=fail&faces-redirect=true";    
        }   
    }
     
    public String buyTicket(Event target){ 
        return "/seller page/BuyTicket.xhtml?param1="+target+"&faces-redirect=true";
    }

    public String confirmticket(Event target){
         Event event = PersistenceClient.getInstance().getEventById(target.getEventId());
            if (event != null) {
                PersistenceClient.getInstance().updateEventQta(event);
                return "/seller page/BuyTicket.xhtml?param1=success&faces-redirect=true";  
            }else{
                return "/seller page/SellerHomePage.xhtml?param1=error&faces-redirect=true";
            }    
    }
   public List<Event> search(){
    List<Event> evtList = new ArrayList<>();
    List<Event> eventlist = PersistenceClient.getInstance().getAllEvents();
        if(eventlist.size()>0){
            for(Event item : eventlist ){
                if (item.getName().contains(element) || item.getDescription().contains(element)) {
                    evtList.add(item);
                }
            }
        }
        return evtList;       
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


    





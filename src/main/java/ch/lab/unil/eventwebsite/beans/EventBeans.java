
package ch.lab.unil.eventwebsite.beans;

import ch.lab.unil.eventwebsite.Database.database;
import ch.lab.unil.eventwebsite.models.Event;
import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


/**
 *
 * @author valer
 */
@Named(value = "eventBean")
//@ManagedBean(value = "eventBean")
@SessionScoped
public class EventBeans implements Serializable  {

    private Event targetEvent = new Event();
    private String element = "";
    
    public String getOneEvent(Event _e){
        
        //targetEvent = database.getInstance().getSpecifyEvent(_e);
        setTargetEvent(database.getInstance().getSpecifyEvent(_e));
         if(database.getInstance().getSpecifyEvent(_e) != null){
             return "/seller page/SeeOneEvent.xhtml?param1="+targetEvent+"&faces-redirect=true";
         }else{
             return "/seller page/SellerHomePage.xhtml?faces-redirect=true";
         }    
         

    }
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
    
    
    public ArrayList<Event> getListOfAllEvents(){
            return database.getInstance().getAllEvent();
    }
   
    public ArrayList<Event> getListOfAvailableEventsInSold(){
        return database.getInstance().getEventInSold();
}


    public ArrayList<Event> getListOfAvailableEvents(){
        return database.getInstance().getAllAvailableEvent();
    }
  
  
    public void deleteEvent(Event e){
        // delete e from list
       database.getInstance().deleteEventByObj(e);
    }

    public String addEvent(){     
        //database.getInstance().insertEvent(new Event(name,date, location, description, price, nbplace, security, status));
        database.getInstance().insertEvent(targetEvent);
        ArrayList<Event>  loc = database.getInstance().getAllEventByLocation(targetEvent.getLocation());
        if(loc.size() > 0){
            return "/seller page/SellerHomePage.xhtml?param ="+loc.get(0)+"&faces-redirect=true";
        }
        else{
            return "/seller page/SellerHomePage.xhtml?param =fail&faces-redirect=true";
        }  
    }
   
    
   
    
    public String buyTicket(Event target){ 
        return "/seller page/BuyTicket.xhtml?param1="+target+"&faces-redirect=true";
    }
    
    public String confirmticket(Event target){
        boolean result = database.getInstance().updatePlacesNumber(target);
        if(result == true){
            return "/seller page/BuyTicket.xhtml?param1=success&faces-redirect=true";
        }else{
            return "/seller page/SellerHomePage.xhtml?param1=error&faces-redirect=true";
        }

       
    }
   public ArrayList<Event> search(){
       if(element.length() > 0){
       return database.getInstance().searchElement(element);
       }else{
           return new ArrayList<Event>();
       }
   }
   


       

}


    





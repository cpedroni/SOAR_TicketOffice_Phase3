
package ch.lab.unil.eventwebsite.beans;

import ch.lab.unil.eventwebsite.Database.database;
import ch.lab.unil.eventwebsite.models.Event;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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

   
   
    private Event targetEvent;
    
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
    
    
    public ArrayList<Event> getListOfAllEvents(){
            return database.getInstance().getAllEvent();
    }
   
    public ArrayList<Event> getListOfAvailableEventsInSold(){
        return database.getInstance().getEventInSold();
}

    public ArrayList<Event> getListOfEventByLocation(String location){
        if(database.getInstance().getAllEventByLocation(location).size() > 0){
            return database.getInstance().getAllEventByLocation(location);
        }else{
            //System.out.println("Not found");
            return null;
        }
         
    }

    

    public ArrayList<Event> getListOfAvailableEvents(){
        return database.getInstance().getAllAvailableEvent();
    }
   /**
    public Event  getEventByEventName(){
        String eventName = "";
        return database.getInstance().getAllEventByLocation(eventName);
    }
    * **/
  
    public void deleteEvent(Event e){
        // delete e from list
       database.getInstance().deleteEventByObj(e);
    }

    /**
     *@param
     */
    public void deleteAllExpiredEvent(){
        // delete e from list
        int itemDeleted = database.getInstance().deleteAllExpiredEventObj();
        if(itemDeleted == 0){
            // return a negative message
        }else{
            //return positive message
        }
    }

    /**
     *@param
     */
    public  void addEvent(Event _e){
        database.getInstance().insertEvent(_e);
        
    }
   
    
   
    
    public String buyTicket(Event target){ 
        return "/seller page/BuyTicket.xhtml?param1="+target+"&faces-redirect=true";
    }
    public String confirmticket(Event target){
        
        boolean result = database.getInstance().updatePlacesNumber(target);
        if(result == true){
            return "success";
        }else{
            return "error";
        }

       
    }
    

    

}



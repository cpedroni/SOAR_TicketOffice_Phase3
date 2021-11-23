
package ch.lab.unil.eventwebsite.beans;

import ch.lab.unil.eventwebsite.Database.database;
import ch.lab.unil.eventwebsite.models.Event;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


/**
 *
 * @author valer
 */
@Named(value = "eventBean")
@RequestScoped
public class EventBeans implements Serializable  {

   
    private Event targetEvent = null;

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
   // public Event  getEventByEventName(){
        //String eventName = "";
        //return db.RetriveEventByName(eventName);
   // }

    public void DeleteEvent(Event e){
        // delete e from list
       database.getInstance().DeleteEventByObj(e);
    }

    public void DeleteAllExpiredEvent(){
        // delete e from list
        int itemDeleted = database.getInstance().DeleteAllExpiredEventObj();
        if(itemDeleted == 0){
            // return a negative message
        }else{
            //return positive message
        }
    }

    public  void AddEvent(Event _e){
        database.getInstance().insertEvent(_e);
        
    }
    public String getOneEvent(Event _e){
        if(database.getInstance().getSpecifyEvent(_e)!= null){
            setTargetEvent(_e);
          return "SeeOneEvent.xhtml?faces-redirect=true";
        }else{
                return "SellerHomePage.xhtml?faces-redirect=true";
            }
        
    }
    public void setTargetEvent(Event e){
       this.targetEvent = e;
    }
     public Event getTargetEvent(){
       return this.targetEvent;
    }
   
    public void BuyTicket(){
      //
    }
   

    

}



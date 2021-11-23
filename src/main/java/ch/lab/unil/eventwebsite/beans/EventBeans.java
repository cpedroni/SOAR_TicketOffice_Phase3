
package ch.lab.unil.eventwebsite.beans;

import ch.lab.unil.eventwebsite.Database.database;
import ch.lab.unil.eventwebsite.models.Event;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


/**
 *
 * @author valer
 */
@Named(value = "eventBean")
//@ManagedBean(value = "eventBean")
@RequestScoped
public class EventBeans implements Serializable  {

   
    private String  eventname="";
    /**
     *
     * @return
     */


    public ArrayList<Event> getListOfAllEvents(){
            return database.getInstance().getAllEvent();
    }
    /**
     *
     * @return
     */
    public ArrayList<Event> getListOfAvailableEventsInSold(){
        return database.getInstance().getEventInSold();
}

    /**
     *
     * @param location
     * @return
     */

    public ArrayList<Event> getListOfEventByLocation(String location){
        if(database.getInstance().getAllEventByLocation(location).size() > 0){
            return database.getInstance().getAllEventByLocation(location);
        }else{
            //System.out.println("Not found");
            return null;
        }
         
    }

    /**
     *
     * @return
     */

    public ArrayList<Event> getListOfAvailableEvents(){
        return database.getInstance().getAllAvailableEvent();
    }
    /**
     *
     * @return
     */

   // public Event  getEventByEventName(){
        //String eventName = "";
        //return db.RetriveEventByName(eventName);
   // }
    /**
     *
     * @param e
     */

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
    public  void addEvent( Event _e){
        database.getInstance().insertEvent(_e);
        
    }
   
    
 
    /**
     *
     * @param e
     */
    public void buyTicket(){
      //
    }
     /*
    *
    */
   

    

}



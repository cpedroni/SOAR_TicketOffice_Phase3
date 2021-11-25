
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
    private String name = "";
    private Date date = new Date();
    private String location = "";
    private String description = "";
    private double price = 0.0;
    private int nbplace= 0;
    private ArrayList<String>security = new ArrayList<>();    
    private ArrayList<String>status = new ArrayList<>() ;
    
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
        // delete e from lists
        int itemDeleted = database.getInstance().deleteAllExpiredEventObj();
        if(itemDeleted == 0){
            // return a negative message
        }else{
            //return positive message
        }
    }

    public String addEvent(){     
        database.getInstance().insertEvent(new Event(name,date, location, description, price, nbplace, security, status));

        Event  loc = database.getInstance().getAllEventByLocation(location).get(0);
        if(loc!= null){
            return "/seller page/SellerHomePage.xhtml?param ="+loc+"&faces-redirect=true";
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
    
    public String getName() {
        return name;
    }

    public void setEventName(String name ){
        this.name = name;
    }
    public Date getDate() {
        
        return this.date;
    }
    public void setEventDate(Date dateandtime){
        this.date = dateandtime;
    }
    public String getLocation() {
        return this.location;
    }
    public void setEventLocation(String location){
        this.location = location;
    }
    public String getDescription() {
        return this.description;
    }

    public void setEventDescription(String description){
        this.description = description;
    }

  
    public double getPrice() {
        return this.price;
    }

   
    public void setEventPrice(double price){
        this.price = price;
    }
  
    public int  getNbPlace(){
        return this.nbplace;
    }
   
     public void setNbPlace(int _nbplace){
        this.nbplace = _nbplace;
    }

    
    /*public String getSecurity(){
        String list = "";
        for(String item : security){
           list = list +" , "+ item;
        }
        return list;
    }*/
     
    public ArrayList getSecurity(){
        return security;
    }
    public void setEventSecurity(ArrayList<String> security){
        this.security = security;
    }

    public ArrayList<String> getStatus(){
        return this.status;
    }

    public void setEventStatus(ArrayList<String> status){
        this.status = status;
    }
    


       

}


    





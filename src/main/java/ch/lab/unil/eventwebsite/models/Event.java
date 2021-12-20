package ch.lab.unil.eventwebsite.models;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author valer
 */
@XmlRootElement
public class Event{
  
    private int eventId;
    private String name;
    private Date date;
    private String location;
    private String description;
    private String img;
    private Double price;
    private int nbplace;
    private String security;
    private String status;
  
    public Event() {
        this.name = "";
        this.date = new Date();
        this.description = "";
        this.img = "";
        this.nbplace = 0;
        this.security = "";
        this.status = "";
        this.price = 0.0;
    }

    public Event(Integer eventId) {
        this.eventId= eventId;
    }

    public Integer getEventId() {
        return eventId;
    }
    
    
    public void setEventId(Integer eId) {
        this.eventId = eId;
    }
 
    public String getName() {
        return name;
    }

    public void setName(String name ){
        this.name = name;
    }
    public String getImg() {
        return img;
    }

    public void setImg(String img ){
        this.img = img;
    }
    public Date getDate() {
        
        return this.date;
    }
    public void setDate(Date dateandtime){
        this.date = dateandtime;
    }
    public String getLocation() {
        return this.location;
    }
    public void setLocation(String location){
        this.location = location;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

  
    public double getPrice() {
        return this.price;
    }

   
    public void setPrice(double price){
        this.price = price;
    }
  
    public int  getNbPlace(){
        return this.nbplace;
    }
   
     public void setNbPlace(int _nbplace){
        this.nbplace = _nbplace;
    }

    
    public String getSecurity(){
        return security;
    }
    
    public void setSecurity(String security){
        this.security = security;
    }

    public String getStatus(){
        return status;
        
    }

    public void setStatus(String _status){
        this.status = _status;
    }
       

}




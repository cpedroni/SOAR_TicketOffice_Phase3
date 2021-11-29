/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.lab.unil.eventwebsite.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 *
 * @author valer
 */

@Entity
@Table(name = "EVENTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Events.findAll", query = "SELECT e FROM Events e"),
    @NamedQuery(name = "Events.findByEventName", query = "SELECT e FROM Events e WHERE e.name = :name"),
    @NamedQuery(name = "Events.findByEventDate", query = "SELECT e FROM Events e WHERE e.date = :date"),
    @NamedQuery(name = "Events.findByEventLocation", query = "SELECT e FROM Events e WHERE e.location = :location"),
    @NamedQuery(name = "Events.findByEventDescription", query = "SELECT e FROM Events e WHERE e.description =:description"),
    @NamedQuery(name = "Events.findByEventPrice", query = "SELECT e FROM Events e WHERE e.price = :price"),
    @NamedQuery(name = "Events.findByEventNbplace", query = "SELECT e FROM Events e WHERE e.nbplace = :nbplace"),
    @NamedQuery(name = "Events.findByEventSecurity", query = "SELECT e FROM Events e WHERE e.security = :security"),
    @NamedQuery(name = "Events.findByEventStatus", query = "SELECT e FROM Events e WHERE e.status = :status")})


/*public class Event {
    
    private String name = "";
    private String img = "";
    private Date date = new Date();
    private String location = "";
    private String description = "";
    private double price = 0;
    private int nbplace = 0;
    private String security = "";    
    private String status = ""; */

public class Event implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "EVENT_NAME")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "IMG")
    private String img;
    @Column(name = "EVENT_DATE")
    private Date date;
    @Size(max = 255)
    @Column(name = "LOCATION")
    private String location;
    @Column(name= "DESCRIPTION")
    private String description;
    @Column(name = "PRICE")
    private Integer price;
    @Column(name ="NBPLACE")
    private Integer nbplace;
    @Column(name="SECURITY")
    private String security;
    @Column(name="STATUS")
    private String status;

    
    public Event(String name,String img, Date _date, String location, String description, double price,int _nbplace,String securityList,String statusList) {
        this.name = name;
        this.img = img;
        this.date = _date;
        this.location = location;
        this.description = description;
        this.price = price;
        this.nbplace = _nbplace;
        this.security = securityList;
        this.status = statusList;       
        
    }
    
    public Event() {
        this.name = "";
        this.img = "";
        this.date = null;
        this.location = "";
        this.description = "";
        this.price = 0;
        this.nbplace = 0;
        this.security ="";
        this.status = "";       
        
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




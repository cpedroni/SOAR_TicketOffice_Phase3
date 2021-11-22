/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.lab.unil.eventwebsite.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author valer
 */
public class Event {
    
    private String name;
    private Date date;
    private String location;
    private String description;
    private double price;
    private int nbplace;
    private ArrayList<String>security;    
    private ArrayList<String>status;
    
    /**
     *@param
     */
   

    
    public Event(String name, Date _date, String location, String description, double price,int _nbplace, ArrayList<String> securityList, ArrayList<String> statusList) {
        this.name = name;
        this.date = _date;
        this.location = location;
        this.description = description;
        this.price = price;
        this.nbplace = _nbplace;
        this.security = new ArrayList<>();
        this.status = new ArrayList<>();

        security.addAll(securityList);
        status.addAll(statusList);       
        
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

    
    public ArrayList<String> getSecurity(){
        return this.security;
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
    @Override
     public boolean equals(Object obj) {
        if (obj instanceof Event) {
            Event f = (Event) obj;
            return f.toString().equals(this.toString());
        }
        return false;
    }


       

}




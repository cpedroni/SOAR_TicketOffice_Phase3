
package ch.lab.unil.eventwebsite.Database;

import ch.lab.unil.eventwebsite.models.Event;
import ch.lab.unil.eventwebsite.models.User;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author valer
 */
public class database {
    
    private ArrayList<User> userList = new ArrayList<User>();
    private ArrayList<Event> eventList = new ArrayList<Event>() ;
    private static database instance = null;
   

    /**
     * initialize  database with some users and some events 
     * by adding users and event in the corresponding list
     */

    public database(){
        userList.add(new User("Firstuser1", "Lastuser1", "user1", "user1@mail.ch","user1","458487484","seller"));
        userList.add(new User("Firstuser2", "Lastuser2", "user2", "user2@mail.ch","user2","621548545","seller"));
        userList.add(new User("Firstuser3", "Lastuser3", "user3", "user3@mail.ch","user3","658575875","customer"));
        eventList.add(new Event("Golf",new Date(),"UNIL Chamberonne","Manoirs de Tourgeville / Le Grand Rex / Musée Grévin",85.0,200,
            new ArrayList<String>(){
              {
                    add("Covid Certificate");
                    add("Mask");
              }
            },
            new ArrayList<String>(){
                {
                    add("Sold out");
                }
            }
        ));
        eventList.add(new Event("Brunch",new Date(),"Renens Gare"," ateliers de styliste d’artistes",23.0,3,
            new ArrayList<String>(){
                {
                    add("Covid Certificate");
                    add("Mask");
                    add("ID Card");
                   
                }
            },
            new ArrayList<String>(){
                {
                    add("Sold out");
                   
                }
            }
       ));

        eventList.add(new Event("Peinture",new Date(),"Musée Picasso"," anciens ateliers d’artistes",50.0,200,
            new ArrayList<String>(){
                {
                    add("Covid Certificate");
                    add("Mask");
                    add("ID Card");
                    add("No Food");
                }
            },
            new ArrayList<String>(){
                {
               
                    add("Canceled");
              
                 }
            }
       ));
       eventList.add(new Event("Museo night",new Date(),"Bern","all museums",10.0,10000,
       new ArrayList<String>(){
           {
               add("Covid Certificate");
               add("Mask");
               add("ID Card");
               add("No Food");
           }
       },
       new ArrayList<String>(){
           {
               add("to come");
           }
       }
  ));
      eventList.add(new Event("Football match",new Date(),"Zurich Stadium","Sankt Gallen vs. Lausanne",25.0,1300,
       new ArrayList<String>(){
           {
               add("Covid Certificate");
               add("Mask");
               add("ID Card");
               add("Snakcs");
           }
       },
       new ArrayList<String>(){
           {
               add("to come");
           }
       }
  ));
     
    eventList.add(new Event("Aquatique sports",new Date(),"Bains de Paquis","Stand up Paddle",20.0,50,
       new ArrayList<String>(){
           {
               add("Covid Certificate");
               add("Mask no obligatory");
               add("ID Card");
               add("No Food");
           }
       },
       new ArrayList<String>(){
           {
               add("to come");
           }
       }
  ));
     
     eventList.add(new Event("Musique concert",new Date(),"Basel Stadium","Led Zeppelin",50.0,200,
       new ArrayList<String>(){
           {
               add("Covid Certificate");
               add("Mask");
               add("ID Card");
               add("No Food");
           }
       },
       new ArrayList<String>(){
           {
               add("Canceled");
           }
       }
  ));
     
     eventList.add(new Event("Jeux Olypmiques",new Date(),"La Pontaise Olympique Stadium"," anciens ateliers d’artistes",50.0,1000,
       new ArrayList<String>(){
           {
               add("Covid Certificate");
               add("Mask no Obligatory");
               add("ID Card");
               add("No Food");
           }
       },
       new ArrayList<String>(){
           {
               add("to come");
           }
       }
  ));
     
     eventList.add(new Event("Theather",new Date(),"Opera Theather","The fanthome of the opera",40.0,300,
       new ArrayList<String>(){
           {
               add("Covid Certificate");
               add("Mask");
               add("ID Card");
               add("No Food");
           }
       },
       new ArrayList<String>(){
           {
               add("to come");
               
           }
       }
  ));
     
     eventList.add(new Event("Restaurant",new Date(),"Cafe Grutli Lausanne","Fondue night",20.0,20,
       new ArrayList<String>(){
           {
               add("Covid Certificate");
               add("Mask");
               add("ID Card");
           }
       },
       new ArrayList<String>(){
           {
               add("Sold out");
               
           }
       }
  ));
     
     eventList.add(new Event("Dance",new Date(),"Club Hype","White New years party",20.0,300,
       new ArrayList<String>(){
           {
               add("Covid Certificate");
               add("ID Card");
               add("Drinks");
           }
       },
       new ArrayList<String>(){
           {
               add("to come");
      
           }
       }
  ));
     
     eventList.add(new Event("Circus",new Date(),"Geneve","Circus Soleil",70.0,500,
       new ArrayList<String>(){
           {
               add("Covid Certificate");
               add("Mask");
               add("ID Card");
               add("Snacks");
           }
       },
       new ArrayList<String>(){
           {
               add("to come");
             
           }
       }
  ));
     eventList.add(new Event("Comedie Show",new Date(),"Irish Pub","Holy Moly",50.0,200,
       new ArrayList<String>(){
           {
               add("Covid Certificate");
               add("Mask");
               add("ID Card");
               add("No Food");
           }
       },
       new ArrayList<String>(){
           {
               add("Sold out");
           }
       }
  ));
     
     eventList.add(new Event("Volleyball",new Date(),"Pyramides de Vidy","Beach Volley",15.0,300,
       new ArrayList<String>(){
           {
               add("Covid Certificate");
               add("Mask no obligatory");
               add("ID Card");
               add("No Food");
           }
       },
       new ArrayList<String>(){
           {
               add("Past");
           }
       }
  ));
     
     eventList.add(new Event("Icehockey",new Date(),"PostFinance-Arena","Lausanne HC vs.SC Bern",20.0,2000,
       new ArrayList<String>(){
           {
               add("Covid Certificate");
               add("Mask");
               add("ID Card");
               add("Snacks and drinks");
           }
       },
       new ArrayList<String>(){
           {
               add("to come");

           }
       }
  ));
     
     eventList.add(new Event("Basketball",new Date(),"Vidy","Red Bull half court",30.0,1000,
       new ArrayList<String>(){
           {
               add("Covid Certificate");
               add("Mask no obligatory");
               add("ID Card");
               add("No Food");
           }
       },
       new ArrayList<String>(){
           {
               add("Canceled");
               add("Past");
           }
       }
  ));
     
     eventList.add(new Event("Ballet",new Date(),"Zurich Opera House","Snowhite",50.0,300,
       new ArrayList<String>(){
           {
               add("Covid Certificate");
               add("Mask");
               add("ID Card");
               add("Apero");
           }
       },
       new ArrayList<String>(){
           {
               add("to come");
           }
       }
  ));
     
     eventList.add(new Event("Aquarium",new Date(),"Aquatis Aquarium Vivati","Kid`s day",10.0,500,
       new ArrayList<String>(){
           {
               add("Covid Certificate");
               add("Mask");
               add("ID Card");
               add("No Food");
           }
       },
       new ArrayList<String>(){
           {
               add("Sold out");
           }
       }
  ));
     
     eventList.add(new Event("Art evening",new Date(),"Basel Museum","atelier",10.0,200,
       new ArrayList<String>(){
           {
               add("Covid Certificate");
               add("Mask");
               add("ID Card");
               add("No Food");
           }
       },
       new ArrayList<String>(){
           {
               add("Past");
           }
       }
  ));
     
     eventList.add(new Event("Musical",new Date(),"Bern Casino","Abba Show",20.0,400,
       new ArrayList<String>(){
           {
               add("Covid Certificate");
               add("Mask");
               add("ID Card");
               add("Apero");
           }
       },
       new ArrayList<String>(){
           {
               add("to come");
           }
       }
  ));
        
       
}
    public static database getInstance() {
        if (instance == null) {
            instance = new database();
        }
        return instance;
    }

  
    public  void insertUser(User user) {
        userList.add(user);
    }
    public void insertEvent(Event e) {
        eventList.add(e);
    }
   
    public  boolean UpdateUserList(User _user, String pass){
        boolean d = false; 
        for (int i = 0; i < userList.size(); i++) {
            if(userList.get(i) == _user){
                userList.get(i).setPassword(pass);
                d = true;
                break;
            }else{
                d = false;
            }
           
        }
    return d;
   }

    public boolean UpdateEventList(Event _e){
       Boolean d = false;
    return d;
   }
   
   
    public void DeleteEventByObj(Event e) {
        
            eventList.remove(e);

     }
    
    public User getUserByUserEmail(String email){
    User newUser = new User();  
        // check if email is correct (not null and contails  @ )  and it exist in the db then return the user
        if(email != ""  &&  email.contains("@")) 
        {
           for(User user:userList){
               if(user.getEmail().equalsIgnoreCase(email))
               { 
                 newUser =  user;
               }
           }
        }else{
            //System.out.println("User not found please check the email"); 
        }
         return newUser;
    }

    public User getUserByHisUserName(String username){
    
    User newUser = new User();  
    // check if email is correct (not null and contails  @ )  and it exist in the db then return the user
    if(username.length() > 0) 
    {
       for(User user:userList){
           if(user.getUsername().equalsIgnoreCase(username))
           { 
             newUser =  user;
             break;
           }
       }
    }return newUser;
    }
            
    
    /**
    public Event RetriveEventByName(String eventName) {
   
 

        if(!eventName.equals("") && eventName.length() > 0){
           for( Event e : this.eventList){
                if(e.getName().equalsIgnoreCase(eventName))
                   return e;
           }
        }
    }
    **/
    
    /**
     *
     * @return
     */
    public ArrayList<Event> getAllEvent(){
       return eventList;
    }
     
    /**
     * return a list of expired event by searching into the db those which are in the status expired
     * @return 
     */
    public ArrayList<Event> getEventInSold() {
        ArrayList<Event> availableEvents = new ArrayList<Event>() ;
        for(Event event:eventList)
        {
            if(event.getStatus().get(0).equalsIgnoreCase("expired"))
            { availableEvents.add(event);
            }
        }
        return availableEvents;
    }
    
     /**
     * Return the list of all availables event ( the ones in the status 'to come' ...)
     * @return 
     */
    public ArrayList<Event> getAllAvailableEvent() {
        ArrayList<Event> events_InSold= new ArrayList<Event>() ;
        for(Event event:eventList)
        {
            if(event.getStatus().get(0).equalsIgnoreCase("Sold out") || event.getStatus().get(0).equalsIgnoreCase("to come") )
            { events_InSold.add(event);
            }
        }
        return events_InSold;
    }

   
     /**
     *Return the list of all availaible event in a specify location
     * @param location
     * @return 
     */
    public ArrayList<Event> getAllEventByLocation( String location) {
        ArrayList<Event> Events = new ArrayList<Event>() ;
        for(Event event:eventList)
        {
            if(event.getLocation().equalsIgnoreCase(location)) { 
                Events.add(event);
            }
        }
        return Events ;
    }

    public boolean UpdatePlacesNumber( Event e){
        int newNbPlaces = 0;
        if(e != null && e.getNbPlace() > 0){
                newNbPlaces = e.getNbPlace()-1;
                e.setNbPlace(newNbPlaces);
            return true;
        }else{
            return false;
        }
    }

    /*
    *Delete from eventList all those with in the status expired
    */

    /**
     *
     * @return
     */

    public int  DeleteAllExpiredEventObj() {
        int count = 0;
        if (!eventList.isEmpty()){
             for (Event e : eventList) {
                 for (String status : e.getStatus()) {
                     if(status.equalsIgnoreCase("Canceled")){
                         eventList.remove(e);
                         count++;
                     }
                     
                 }
                 
             }
        }
        return count;
    }

    
}


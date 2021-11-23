
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
        eventList.add(new Event("Avengers: Infinity War",new Date(),"Pathé Flon",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment, the fate of Earth and existence has never been more uncertain.",
                85.0,200,
            new ArrayList<String>(){
              {
                    add("Covid Certificate");
                    add("Mask");
              }
            },
            new ArrayList<String>(){
                {
                    add("Selling");
                }
            }
        ));
        eventList.add(new Event("Dune",new Date(),
                "Capitole Lausanne",
                "A mythic and emotionally charged hero's journey, \"Dune\" tells the story of Paul Atreides, a brilliant and gifted young man born into a great destiny beyond his understanding, who must travel to the most dangerous planet in the universe to ensure the future of his family and his people. As malevolent forces explode into conflict over the planet's exclusive supply of the most precious resource in existence-a commodity capable of unlocking humanity's greatest potential-only those who can conquer their fear will survive.",
                23.0,3,
            new ArrayList<String>(){
                {
                    add("Covid Certificate");
                    add("Mask");
                    add("ID Card");
                   
                }
            },
            new ArrayList<String>(){
                {
                    add("Selling");
                   
                }
            }
       ));

        eventList.add(new Event("No Time to Die",new Date(),
                "Casino Martigny",
                "Bond has left active service and is enjoying a tranquil life in Jamaica. His peace is short-lived when his old friend Felix Leiter from the CIA turns up asking for help. The mission to rescue a kidnapped scientist turns out to be far more treacherous than expected, leading Bond onto the trail of a mysterious villain armed with dangerous new technology.",
                50.0,200,
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
       eventList.add(new Event("Shang-Chi and the Legend of the Ten Rings",
               new Date(),
               "Alphas Fribourg",
               "Shang-Chi, the master of weaponry-based Kung Fu, is forced to confront his past after being drawn into the Ten Rings organization.",
               10.0,10000,
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
      eventList.add(new Event("Spider-Man : No Way Home",
              new Date(),
              "Apollo Neuchâtel",
              "With Spider-Man's identity now revealed, Peter asks Doctor Strange for help. When a spell goes wrong, dangerous foes from other worlds start to appear, forcing Peter to discover what it truly means to be Spider-Man.",
              25.0,1300,
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
               add("Selling");
           }
       }
  ));
     
    eventList.add(new Event("The French Dispatch",
            new Date(),
            "Casino Cossonay",
            "A love letter to journalists set in an outpost of an American newspaper in a fictional twentieth century French city that brings to life a collection of stories published in \"The French Dispatch Magazine\".",
            20.0,50,
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
           }
       },
       new ArrayList<String>(){
           {
               add("Selling");
           }
       }
  ));
     
     eventList.add(new Event("Ghostbusters : Afterlife",
             new Date(),
             "Rex Aubonne",
             "When a single mom and her two kids arrive in a small town, they begin to discover their connection to the original Ghostbusters and the secret legacy their grandfather left behind.",
             50.0,1000,
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
               add("To come");
           }
       }
  ));
     
     eventList.add(new Event("House of Gucci",new Date(),
             "Rex Aubonne",
             "House of Gucci is inspired by the family empire behind the Italian fashion house of Gucci. When Patrizia Reggiani (Lady Gaga), an outsider from humble beginnings, marries into the Gucci family, her unbridled ambition begins to unravel the family legacy and triggers a reckless spiral of betrayal, decadence, revenge, and ultimately...murder.",
             40.0,300,
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
               add("To come");
               
           }
       }
  ));
     
     eventList.add(new Event("The suicide squad",
             new Date(),
             "Capitole Nyon",
             "In exchange for lighter sentences, just like the anti-hero team in Suicide Squad (2016), a new batch of Belle Reve's meta-humans strike a deal with the cold head of Task Force X, Amanda Waller. This time, her ragtag band of super-powered convicts--Harley Quinn, Bloodsport, Peacemaker, King Shark, Polka-Dot Man, and Ratcatcher 2--venture into the peril-laden South American island nation of Corto Maltese to find the Thinker: the evil scientist in charge of the mysterious Project Starfish. But, as the band joins forces with an old leader of the notorious team, humankind is on the verge of extinction. Can the expendable Suicide Squad stop the new menace that could mean the end of the world as we know it?",
             20.0,20,
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
     
     eventList.add(new Event("Belfast",new Date(),
             "Pathé Flon",
             "A young boy and his working class family experience the tumultuous late 1960s."
             ,20.0,300,
       new ArrayList<String>(){
           {
               add("Covid Certificate");
               add("ID Card");
               add("No Food");
           }
       },
       new ArrayList<String>(){
           {
               add("Selling");
      
           }
       }
  ));
     
     eventList.add(new Event("Harry Potter and the Sorcerer's Stone",
             new Date(),
             "Pathé Flon",
             "This is the tale of Harry Potter (Daniel Radcliffe), an ordinary eleven-year-old boy serving as a sort of slave for his aunt and uncle who learns that he is actually a wizard and has been invited to attend the Hogwarts School for Witchcraft and Wizardry. Harry is snatched away from his mundane existence by Rubeus Hagrid (Robbie Coltrane), the groundskeeper for Hogwarts, and quickly thrown into a world completely foreign to both him and the viewer. Famous for an incident that happened at his birth, Harry makes friends easily at his new school. He soon finds, however, that the wizarding world is far more dangerous for him than he would have imagined, and he quickly learns that not all wizards are ones to be trusted.",
             70.0,500,
       new ArrayList<String>(){
           {
               add("Covid Certificate");
               add("Mask");
               add("ID Card");
           }
       },
       new ArrayList<String>(){
           {
               add("Selling");
             
           }
       }
  ));
     eventList.add(new Event("Spectre",
             new Date(),
             "Capitole Nyon",
             "A cryptic message from the past sends James Bond (Daniel Craig) on a rogue mission to Mexico City and eventually Rome, where he meets Lucia Sciarra (Monica Belluci), the beautiful and forbidden widow of an infamous criminal. Bond infiltrates a secret meeting and uncovers the existence of the sinister organisation known as S.P.E.C.T.R.E. Meanwhile, back in London, Max Denbigh (Andrew Scott), the new head of the Centre of National Security, questions Bond's actions and challenges the relevance of MI6, led by M (Ralph Fiennes). Bond covertly enlists Miss Eve Moneypenny (Naomie Harris) and Q (Ben Whishaw) to help him seek out Dr. Madeleine Swann (Léa Seydoux), the daughter of his old nemesis Mr. White (Jesper Christensen), who may hold the clue to untangling the web of S.P.E.C.T.R.E. As the daughter of the assassin, she understands Bond in a way most others cannot. As Bond ventures towards the heart of S.P.E.C.T.R.E., he learns a chilling connection between him and the enemy he seeks.",
             50.0,200,
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
     
     eventList.add(new Event("Cruella",
             new Date(),
             "Rex Aubonne",
             "Before she becomes Cruella de Vil, teenage Estella has a dream. She wishes to become a fashion designer, having been gifted with talent, innovation, and ambition all in equal measures. But life seems intent on making sure her dreams never come true. Having wound up penniless and orphaned in London at 12, 10 years later Estella runs wild through the city streets with her best friends and partners-in-(petty)-crime, Horace and Jasper, two amateur thieves. When a chance encounter vaults Estella into the world of the young rich and famous, however, she begins to question the existence she's built for herself in London and wonders whether she might, indeed, be destined for more after all.",
             15.0,300,
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
     
     eventList.add(new Event("Interstellar",
             new Date(),
             "Rex Aubonne",
             "Earth's future has been riddled by disasters, famines, and droughts. There is only one way to ensure mankind's survival: Interstellar travel. A newly discovered wormhole in the far reaches of our solar system allows a team of astronauts to go where no man has gone before, a planet that may have the right environment to sustain human life.",
             20.0,2000,
       new ArrayList<String>(){
           {
               add("Covid Certificate");
               add("Mask");
               add("ID Card");
           }
       },
       new ArrayList<String>(){
           {
               add("Selling");

           }
       }
  ));
     
     eventList.add(new Event("Home Alone",
             new Date(),
             "Pathé Flon",
             "It is Christmas time and the McCallister family is preparing for a vacation in Paris, France. But the youngest in the family, Kevin (Macaulay Culkin), got into a scuffle with his older brother Buzz (Devin Ratray) and was sent to his room, which is on the third floor of his house. Then, the next morning, while the rest of the family was in a rush to make it to the airport on time, they completely forgot about Kevin, who now has the house all to himself. Being home alone was fun for Kevin, having a pizza all to himself, jumping on his parents' bed, and making a mess. Then, Kevin discovers about two burglars, Harry (Joe Pesci) and Marv (Daniel Stern), about to rob his house on Christmas Eve. Kevin acts quickly by wiring his own house with makeshift booby traps to stop the burglars and to bring them to justice.",
             30.0,1000,
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
     
     eventList.add(new Event("The King",
             new Date(),
             "Rex Aubonne",
             "Hal (Timothée Chalamet), wayward prince and reluctant heir to the English throne, has turned his back on royal life and is living among the people. But when his tyrannical father dies, Hal is crowned King Henry V and is forced to embrace the life he had previously tried to escape. Now the young king must navigate the palace politics, chaos and war his father left behind, and the emotional strings of his past life - including his relationship with his closest friend and mentor, the aging alcoholic knight, John Falstaff (Joel Edgerton).",
             50.0,300,
       new ArrayList<String>(){
           {
               add("Covid Certificate");
               add("Mask");
               add("ID Card");
           }
       },
       new ArrayList<String>(){
           {
               add("Selling");
           }
       }
  ));
     
     eventList.add(new Event("Blade Runner 2049",
             new Date(),
             "Rex Aubonnne",
             "Thirty years after the events of Blade Runner (1982), a new Blade Runner, L.A.P.D. Officer \"K\" (Ryan Gosling), unearths a long-buried secret that has the potential to plunge what's left of society into chaos. K's discovery leads him on a quest to find Rick Deckard (Harrison Ford), a former L.A.P.D. Blade Runner, who has been missing for thirty years.",
             10.0,500,
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
     
     eventList.add(new Event("Avengers Endgame",
             new Date(),
             "Rex Aubonne",
             "After the devastating events of Avengers: Infinity War (2018), the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo Thanos's actions and undo the chaos to the universe, no matter what consequences may be in store, and no matter who they face...",
             10.0,200,
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
     
     eventList.add(new Event("The Matrix Resurrections",
             new Date(),
             "Capitole Nyon",
             "The plot is currently unknown.",
             20.0,400,
       new ArrayList<String>(){
           {
               add("Covid Certificate");
               add("Mask");
               add("ID Card");
           }
       },
       new ArrayList<String>(){
           {
               add("To come");
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
   
    public  boolean updateUserList(User _user, String pass){
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

    public boolean updateEventList(Event _e){
       Boolean d = false;
    return d;
   }
   
   
    public void deleteEventByObj(Event e) {
        
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
            if(event.getStatus().get(0).equalsIgnoreCase("Past"))
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
            if(event.getStatus().get(0).equalsIgnoreCase("Selling") || event.getStatus().get(0).equalsIgnoreCase("To come") )
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

    public boolean updatePlacesNumber( Event e){
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

    public int  deleteAllExpiredEventObj() {
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


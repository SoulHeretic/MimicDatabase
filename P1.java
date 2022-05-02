import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;//Going to import ArrayList
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class P1 {

	ArrayList<Team> teams;
    ArrayList<Coach> coaches;
    ArrayList<Coach> coachesClone;	//ArrayList I will be using
		
/*The data structure ArrayList will be used. */


    public P1() {
        /* initialize the data structures */
    	
    	teams = new ArrayList<Team>();
    	coaches = new ArrayList<Coach>();
    	coachesClone = new ArrayList<Coach>();
    	
    	//The data structures for holding the data will be the ArrayList

    }

    public class Coach{
	    String COACH_ID;
	    String SEASON;
	    String FIRST_NAME;
	    String LAST_NAME;
	    int SEASON_WIN;
	    int SEASON_LOSS;
	    int PLAYOFF_WIN;
	    int PLAYOFF_LOSS;
	    String TEAM;
	    
	    @Override
	    public String toString() {
	    	return COACH_ID + " " + SEASON + " " + FIRST_NAME + " " + LAST_NAME + " " + SEASON_WIN + " " + SEASON_LOSS + " " + PLAYOFF_WIN + " " + PLAYOFF_LOSS + " " + TEAM;
	      }//This override will allow to to print strings
	    
	    public Coach(String COACH_ID, String SEASON, String FIRST_NAME, String LAST_NAME, int SEASON_WIN, int SEASON_LOSS, int PLAYOFF_WIN, int PLAYOFF_LOSS, String TEAM){
	           this.COACH_ID = COACH_ID;
	           this.SEASON = SEASON;
	           this.FIRST_NAME = FIRST_NAME;
	           this.LAST_NAME = LAST_NAME;
	           this.SEASON_WIN = SEASON_WIN;
	           this.SEASON_LOSS = SEASON_LOSS;
	           this.PLAYOFF_WIN = PLAYOFF_WIN;
	           this.PLAYOFF_LOSS = PLAYOFF_LOSS;
	           this.TEAM = TEAM;
	    }//Typical class set up with getters.
	    public Coach get(int index){
	    	return coaches.get(index);
	    }
	    public String getCOACH_ID(){
	    	return COACH_ID;
	    }
	      
	    public String getSEASON(){
	    	return SEASON;
	    }
	      
	    public String getFIRST_NAME(){
	    	return FIRST_NAME;
	    }

	    public String getLAST_NAME(){
	    	return LAST_NAME;
	    }

	    public int getSEASON_WIN(){
	    	return SEASON_WIN;
	    }

	    public int getSEASON_LOSS(){
	           return SEASON_LOSS;
	    }

	    public int getPLAYOFF_WIN(){
	    	return SEASON_LOSS;
	    }

	    public int getPLAYOFF_LOSS(){
	    	return PLAYOFF_LOSS;
	    }

	    public String getTEAM(){
	    	return TEAM;
	    }
	    //This stuff will allow to me to clone the arraylist and use contain.
	    public boolean contains(CharSequence sequence)
	    {
	       return indexOf(sequence.toString()) > -1;
	    }
	    public int indexOf(String str) {


	        for (int i = 0; i < coaches.size(); i++) {
	            if(coaches.get(i).equals(str)) {
	                return i; 
	            }
	        }

	        return -1;
	    }
	    
	    public Coach clone() {
	        Coach newObj = new Coach(this.COACH_ID, this.SEASON, this.FIRST_NAME, this.LAST_NAME, this.SEASON_WIN, this.SEASON_LOSS, this.PLAYOFF_WIN, this.PLAYOFF_LOSS, this.TEAM);
	        return newObj;
	    }


	}
    
    public class Team//Nothing new here.
    {
        String team_ID;
        String Location ;
        String Name;
        String League;
       
        public Team(String team_ID, String Location, String Name, String League)
        {
            this.team_ID = team_ID;
            this.Location = Location;
            this.Name = Name;
            this.League = League;
        }
	    
	    @Override
	    public String toString() {
	    	return team_ID + " " + Location + " " + Name + " " + League ;
	      }
	    
	    public Team get(int index){
	    	return teams.get(index);
	    }
	    public String getteam_ID(){
	    	return team_ID;
	    }
	      
	    public String getLocation(){
	    	return Location;
	    }
	      
	    public String getName(){
	    	return Name;
	    }

	    public String getLeague(){
	    	return League;
	    }
	    
	    public boolean contains(CharSequence sequence)
	    {
	       return indexOf(sequence.toString()) > -1;
	    }
	    public int indexOf(String str) {

	        /* Getting and return the index of the first 
	         * occurrence of the specified String. Return 
	         * -1 if string not in the list
	         */

	        for (int i = 0; i < teams.size(); i++) {
	            if(teams.get(i).equals(str)) {
	                // If we get here, it means that the item for position `i` is equal to `str`.
	                return i; // just return `i` 
	            }
	        }

	        return -1;
	    }
    }
    
    
    
   


    public void run() {
        CommandParser parser = new CommandParser();

        System.out.println("The mini-DB of NBA coaches and teams");
        System.out.println("Please enter a command.  Enter 'help' for a list of commands.");
        System.out.println();
        System.out.print("> ");

        Command cmd = null;
        while ((cmd = parser.fetchCommand()) != null) {

            boolean result=false;

            if (cmd.getCommand().equals("help")) {
                result = doHelp();

        } else if (cmd.getCommand().equals("add_coach")) {

        	String param[] = cmd.getParameters();
        	param[1] = param[1].replace("+","");
       
        	coaches.add(new Coach((param[0]), (param[1]),param[2],param[3],Integer.parseInt(param[4]),Integer.parseInt(param[5]),Integer.parseInt(param[6]),Integer.parseInt(param[7]),param[8]));
        	
        	param[2] = param[2].replace("+","");
	    	} else if (cmd.getCommand().equals("add_team")) {
	    		String param[] = cmd.getParameters();
	    	       
	        	teams.add(new Team(param[0], param[1], param[2],param[3]));
	    		

				} else if (cmd.getCommand().equals("remove_coach")) {
					String param[] = cmd.getParameters();
		            String[] name = param[0].split("=");
		            String value = name[1];
		            
		            Iterator<Coach> iterator = coaches.iterator();
		            while(iterator.hasNext()) {
		               Coach next = iterator.next();
		               if(next.getCOACH_ID().equals(value)) {
		                   iterator.remove();
		               }
		            }


				}	else if (cmd.getCommand().equals("remove_team")) {
					String param[] = cmd.getParameters();
		            String[] name = param[0].split("=");
		            String value = name[1];
		            
		            Iterator<Team> iterator = teams.iterator();
		            while(iterator.hasNext()) {
		               Team next = iterator.next();
		               if(next.getteam_ID().equals(value)) {
		                   iterator.remove();
		               }
		            }

				}	else if (cmd.getCommand().equals("print_coaches")) {
		               for(int i = 0; i < coaches.size(); i++){
		            	   System.out.println(coaches.get(i));
		               }

	  		} else if (cmd.getCommand().equals("print_teams")) {
	  			for(int i = 0; i < teams.size(); i++){
	            	   System.out.println(teams.get(i));
	               }

				} else if (cmd.getCommand().equals("coaches_by_name")) {
					String param[] = cmd.getParameters();
					String holder = param[0];
					for(int i = 0; i < coaches.size(); i++){
						if(coaches.get(i).getFIRST_NAME().contains(holder)){	//If any Coaches_id matches parameter 0 then remove.
							System.out.println(coaches.get(i));
						}
					}
					
				} else if (cmd.getCommand().equals("teams_by_city_league")) {
					String param[] = cmd.getParameters();
					String holder = param[0];
					String holder2 = param[1];
					
					holder = holder.replace("+","");
					
					for(int i = 0; i < teams.size(); i++){
						if((teams.get(i).getLocation().contains(holder)) && (teams.get(i).getLeague().contains(holder2))){	//If any Coaches_id matches parameter 0 then remove.
							System.out.println(teams.get(i));
						}
					}
					

				} else if (cmd.getCommand().equals("load_coaches")) {
					String param[] = cmd.getParameters();   
					
		               Scanner infile;
		               try
		               {
		                   infile = new Scanner(new File(param[0]));
		                  
		                   String lines;
		                   String[] reading;
		                       lines = infile.nextLine();               
		                                  
		                   while (infile.hasNextLine())
		                   {
		                       lines = infile.nextLine();
		                       reading = lines.split(",");
		                    	   coaches.add(new Coach((reading[0]), (reading[1]),reading[2],reading[3],Integer.parseInt(reading[4]),Integer.parseInt(reading[5]),Integer.parseInt(reading[6]),Integer.parseInt(reading[7]),reading[8]));                      
		                   }
		                   infile.close();      
		               }
		               catch(FileNotFoundException e)
		               {
		                   System.out.println("File does not exist!");
		               }

    		} else if (cmd.getCommand().equals("load_teams")) {
    			String param[] = cmd.getParameters();   
				
	               Scanner infile;
	               try
	               {
	                   infile = new Scanner(new File(param[0]));
	                  
	                   String lines;
	                   String[] reading;
	                       lines = infile.nextLine();               
	                                  
	                   while (infile.hasNextLine())
	                   {
	                       lines = infile.nextLine();
	                       reading = lines.split(",");
	                    	   teams.add(new Team((reading[0]), (reading[1]), (reading[2]), (reading[3])));                      
	                   }
	                   infile.close();      
	               }
	               catch(FileNotFoundException e)
	               {
	                   System.out.println("File does not exist!");
	               }

				} else if (cmd.getCommand().equals("best_coach")) {
					
					String param[] = cmd.getParameters();
		            String value = param[0];
		            int max = 1;
		            int m = 0;
		            int nIndex = 0;
					
					for(int i = 0; i < coaches.size(); i++){
						if((coaches.get(i).getSEASON().contains(value))){	//If any Coaches_id matches parameter 0 then remove.
							m = (coaches.get(i).getSEASON_WIN() - coaches.get(i).getSEASON_LOSS()) + (coaches.get(i).getPLAYOFF_WIN() - coaches.get(i).getPLAYOFF_LOSS());
							if(m > max) {
								max = m;
								nIndex = i;
							}
						}
					}
					
					System.out.println(coaches.get(nIndex));
					

				} else if (cmd.getCommand().equals("search_coaches")) {
					
					String[] param = cmd.getParameters();
					
					coachesClone.clear();
					
					
					Iterator<Coach> iterator = coaches.iterator();				 
					while(iterator.hasNext())	//This iterator  will clone the ArrayList
					{
					    //Add the object clones
					    coachesClone.add((Coach) iterator.next().clone());  
					}
					
					for(int i = 0; i < param.length; i++) {
						
						param[i] = param[i].replace("+","");
						
			            String[] tokens = param[i].split("=");
			            String field = tokens[0];
			            String value = tokens[1];
			            tokens = null;	//Split the parameters into token then assign to values, then set to null for reuse later.
			            
			            for(int k = 0; k < coachesClone.size(); k++){            
			            
			            if(field.equals("coach_id") && value.equals(coachesClone.get(k).getCOACH_ID())){
			            	Iterator<Coach> iterator2 = coachesClone.iterator();
				            while(iterator2.hasNext()) {
				               Coach next = iterator2.next();
				               if(!(next.getCOACH_ID().equals(value))) {
				                   iterator2.remove();
				               }
				            }
		                }
		                  
			            if(field.equals("season") && value.equals(coachesClone.get(k).getSEASON())){
			            	Iterator<Coach> iterator2 = coachesClone.iterator();
				            while(iterator2.hasNext()) {
				               Coach next = iterator2.next();
				               if(!(next.getSEASON().equals(value))) {
				                   iterator2.remove();
				               }
				            }
			            }
		                  
			            if(field.equals("first_name") && value.equals(coachesClone.get(k).getFIRST_NAME())){
			            	Iterator<Coach> iterator2 = coachesClone.iterator();
				            while(iterator2.hasNext()) {
				               Coach next = iterator2.next();
				               if(!(next.getFIRST_NAME().equals(value))) {
				                   iterator2.remove();
				               }
				            }
			            }
		                  
			            if(field.equals("last_name") && value.equals(coachesClone.get(k).getLAST_NAME())){
			            	Iterator<Coach> iterator2 = coachesClone.iterator();
				            while(iterator2.hasNext()) {
				               Coach next = iterator2.next();
				               if(!(next.getLAST_NAME().equals(value))) {
				                   iterator2.remove();
				               }
				            }
			            }
		                  
			            if(field.equals("season_win") && Integer.parseInt(value) == (coachesClone.get(k).getSEASON_WIN())){
			            	Iterator<Coach> iterator2 = coachesClone.iterator();
				            while(iterator2.hasNext()) {
				               Coach next = iterator2.next();
				               if(!(next.getSEASON_WIN() == Integer.parseInt(value))){
				                   iterator2.remove();
				               }
				            }
			            }
		                  
			            if(field.equals("season_loss") && Integer.parseInt(value) == (coachesClone.get(k).getSEASON_LOSS())){
			            	Iterator<Coach> iterator2 = coachesClone.iterator();
				            while(iterator2.hasNext()) {
				               Coach next = iterator2.next();
				               if(!(next.getSEASON_LOSS() == Integer.parseInt(value))){
				                   iterator2.remove();
				               }
				            }
			            }
		                  
			            if(field.equals("playoff_win") && Integer.parseInt(value) == (coachesClone.get(k).getPLAYOFF_WIN())){
			            	Iterator<Coach> iterator2 = coachesClone.iterator();
				            while(iterator2.hasNext()) {
				               Coach next = iterator2.next();
				               if(!(next.getPLAYOFF_WIN() == Integer.parseInt(value))){
				                   iterator2.remove();
				               }
				            }
			            }
		                  
			            if(field.equals("playoff_loss") && Integer.parseInt(value) == (coachesClone.get(k).getPLAYOFF_LOSS())){
			            	Iterator<Coach> iterator2 = coachesClone.iterator();
				            while(iterator2.hasNext()) {
				               Coach next = iterator2.next();
				               if(!(next.getPLAYOFF_LOSS() == Integer.parseInt(value))){
				                   iterator2.remove();
				               }
				            }
			            }
		                  
			            if(field.equals("team") && value.equals(coachesClone.get(k).getTEAM())){
			            	Iterator<Coach> iterator2 = coachesClone.iterator();
				            while(iterator2.hasNext()) {
				               Coach next = iterator2.next();
				               if(!(next.getTEAM().equals(value))) {
				                   iterator2.remove();
				               }
				            }
			            }
					}
			            }
						
					
					for(int j = 0; j < coachesClone.size(); j++){
		            	   System.out.println(coachesClone.get(j));
					}
					

					

				} else if (cmd.getCommand().equals("exit")) {
					System.out.println("Leaving the database, goodbye!");
					break;
				} else if (cmd.getCommand().equals("")) {
				} else {
					System.out.println("Invalid Command, try again!");
		           	}

			    if (result) {
		                // ...
		            }

		            System.out.print("> ");
		        }
		    }

    private boolean doHelp() {
        System.out.println("add_coach ID SEASON FIRST_NAME LAST_NAME SEASON_WIN ");
	System.out.println("          EASON_LOSS PLAYOFF_WIN PLAYOFF_LOSS TEAM - add new coach data");
        System.out.println("add_team ID LOCATION NAME LEAGUE - add a new team");
        System.out.println("print_coaches - print a listing of all coaches");
        System.out.println("print_teams - print a listing of all teams");
				System.out.println("remove_coach coach_ID - remove an existing record in coaches by ID");
				System.out.println("remove_team team_ID - remove an existing record in teams by ID");
        System.out.println("coaches_by_name NAME - list info of coaches with the specified name");
        System.out.println("teams_by_city CITY - list the teams in the specified city");
	    System.out.println("load_coach FILENAME - bulk load of coach info from a file");
        System.out.println("load_team FILENAME - bulk load of team info from a file");
        System.out.println("best_coach SEASON - print the name of the coach with the most netwins in a specified season");
        System.out.println("search_coaches field=VALUE - print the name of the coach satisfying the specified conditions");
		System.out.println("exit - quit the program");
        return true;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        new P1().run();
    }



}

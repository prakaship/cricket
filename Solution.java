package ph;
import java.util.*;
import java.io.*;
 class Game
{    public  Random r=new Random();
	 public  HashMap<Integer,String> countries=new HashMap<Integer,String>();
	 String players[][]= {{"Rohit Sharma","Shikar Dhawan","Virat Kohli(c)","Manish Pandey","MS Dhoni","Hardik Pandya","Dinesh Karthik","Axar Patel","Jasprit Bumrah","Bhuvaneshwar Kumar","Mohammed Shami"},
			 {"David Warner","Aaron Finch","Steven Smith(c)","Glenn Maxwell","Travis Head","Marcus Stoinis","Peter Handscomb","Ashton Agar","Pat Cummins","Nathan Coulter-Nile","Kane Richardson"},
			 {"Faf du Plessis(c)", "Kyle Abbott", "Hashim Amla", "Quinton de Kock", "Jean-Paul Duminy", "Imran Tahir", "David Miller", "Wayne Parnell", "Kagiso Rabada", "Rilee Rossouw", "Dale Steyn"},
	         {"Jason Roy","Jonny Bairstow","Joe Root(c)","Eoin Morgan","Jos Buttler","Sam Billings","Moeen Ali","Liam Plunkett","Adil Rashid","Jake Ball", "Tom Curran"},
	         {"Jason Mohammed", "Shannon Gabriel", "Chris Gayle", "Kyle Hope", "Shai Hope", "Evin Lewis", "Jason Holder(c)","Nikita Miller","Rovman Powell", "Kesrick Williams", "Sheldon Cottrell"},
	         {"Danushka Gunathilaka","Upul Tharanga","Lahiru Thirimanne","Angelo Mathews(c)","Niroshan Dickwella","Asela Gunaratne","Thisara Perera","Sachith Pathirana","Suranga Lakmal","Akila Dananjaya","Nuwan Pradeep"},
	 };
	 String bowlers[][]= { {"Hardik Pandya","Axar Patel","Jasprit Bumrah","Bhuvaneshwar Kumar","Mohammed Shami"},
			 {"Marcus Stoinis","Ashton Agar","Pat Cummins"," Nathan Coulter-Nile","Kane Richardson"},	
			 {"Imran Tahir","Wayne Parnell", "Kagiso Rabada", "Rilee Rossouw", "Dale Steyn"},
			 {"Moeen Ali","Liam Plunkett","Adil Rashid","Jake Ball","Tom Curran"},
			 {"Jason Holder","Evin Lewis","Rovman Powell", "Kesrick Williams", "Sheldon Cottrell"},
			 {"Angelo Mathews","Sachith Pathirana","Suranga Lakmal","Akila Dananjaya","Nuwan Pradeep"}
			
			 };
	 String caption[]= {"Virat Kohli","Steven Smith","Faf du Plessis","Joe Root","Jason Holder","Angelo Mathews"};
	public static  String line="-------------------------------";
	void  displayPlayers(int team)
	 {  
		System.out.println(countries.get(team)+"  players ");
		System.out.println(line);
		 for(int i=0;i<11;i++)
			 System.out.println(players[team-1][i]);
	 }
			 
			 
 Game()              // teams put into hashmap
	{
		 countries.put(1,"India");
         countries.put(2,"Australia");
         countries.put(3,"South Africa");
         countries.put(4,"England");
         countries.put(5,"West Indies");
         countries.put(6,"Srilanka");
	}
    public void displayCountry()  {           // for displaying the country list
	
    	System.out.println("choose any two countrys to start the match");
		Set s=countries.entrySet();
		Iterator i=s.iterator();
		while(i.hasNext())
		{
			Map.Entry country = (Map.Entry)i.next();
			System.out.println(country.getKey()+" "+country.getValue());
			      
		}
		System.out.println("choose any two countrys to start the match");	
	
	}
   public int tosstime(int team_1,int team_2) {// tossing 
    	 int a=r.nextInt(4);
    	 System.out.println(caption[team_1-1]+" toss with "+caption[team_2-1]);
    	 switch(a) {
    	 case 0:
    		 System.out.println(  countries.get(team_1)+" won the toss  and deciated to bat");
    		 break;
    	 case 1:
    		 System.out.println(  countries.get(team_2)+" won the toss  and deciated to bat");
    		 break;
    	 case 2:
    		 System.out.println(  countries.get(team_2)+" won the toss  and deciated to bowel first");
    		 break;
    	 case 3:
    		 System.out.println(  countries.get(team_1)+" won the toss  and deciated to bowel first");
    		 break;
    	 }
    	 return a;  // for which team bat first
    }

 
public  void overs(int t1,int t2,int over,int innings,int target) {
	int wicket=0,run=0,striker=0,nonstriker=1,next=2,rvalue,extras=0;
	boolean switchflag=false;
	System.out.println(players[t1-1][striker]+" and "+players[t1-1][nonstriker]+"coming to play");
	
	for(int i=0;i<over;i++)
	{  
		System.out.println("bowler : " +bowlers[t2-1][r.nextInt(5)]+"  "+"overs :"+(i+1)+"over");
		System.out.println("\n");
		for(int ball=1;ball<=6;ball++)
		{
			System.out.print("BALL "+ball+"\t:");
            switchflag = false;
			int f=r.nextInt(7);
			
			switch(f)
			{
			case 0:
				  System.out.println(players[t1-1][striker] + " tactfully leaves the ball..");
				  break;
			
			case 1:
                System.out.println(players[t1-1][striker] + " takes a single ");
                run+=1;
                break;
            case 2:
                System.out.println(players[t1-1] [striker] + " takes a two runs ");
                run+=2;
                break;
            case 3:
                System.out.println(players[t1-1] [striker] + " take three run ");
                run+=3;
                break;
            case 4:
                System.out.println(players[t1-1] [striker] + " hits a magneficient four  ");
                run+=4;
                break;
            case 5:
            	rvalue= r.nextInt(3);
            	
                if (rvalue == 0) {
                    System.out.println("Wide ball");
                    run += 1;
                    extras += 1;
                    ball--;
                }
                else if (rvalue == 1) {
                    System.out.println("No ball");
                    run += 1;
                    extras += 1;
                    ball--;
                } 
                else {
                    int bye_runs = r.nextInt(2)+1;
                    System.out.println("Batsman take " + bye_runs + " runs as byes");
                    if (bye_runs % 2 == 1)
                        switchflag = true;
                        run += bye_runs;
                        extras += bye_runs;
	            
			}
                break;
            case 6:
            	System.out.println(players[t1-1] [striker]+"hit a huge six");
            	run += 6;
            	break;
            case 7:
            
            	
		}
			if(f%2==1 && f!=5)
				switchflag = true;
				
		if(switchflag)
		{
		int	temp= striker;
		  striker= nonstriker;
		  nonstriker= temp;
		}
		  
			
	}
	
}
	}
}

 
 






public class Solution {
	
	public static void main(String []args) throws Exception{
		
		System.out.println("welcome to the game of cricket");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Game c=new Game();
		c.displayCountry();
		int team_1;
		int team_2;
		while(true)
		{
			team_1=Integer.parseInt(br.readLine());
			team_2=Integer.parseInt(br.readLine());
			
			if(team_1!=team_2 && team_1<=c.countries.size()  && team_2<=c.countries.size()) {
				System.out.println("enter the number of overs");
				break;
			}
			
			else if(team_1==team_2)
				System.out.println("enter the differnt countries");
			
			else if(team_1>c.countries.size() ||team_2>c.countries.size())
				System.out.println("enter a valid country number");
		}
		int over=Integer.parseInt(br.readLine());
		
		c.displayPlayers(team_1);
		System.out.println("\n \n");
		Thread.sleep(500);
		c.displayPlayers(team_2);
		System.out.println("\n\n");
		int a=c.tosstime(team_1,team_2);
		System.out.println("\n");
		if(a%2==0)
			c.overs(team_1,team_2,over,0,0);
		else 
			c.overs(team_2,team_1,over,0,0);
		
			
	}
}

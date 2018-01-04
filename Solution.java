import java.util.*;
 class Game
{
	public HashMap<Integer,String> countries=new HashMap<Integer,String>();
	Game(){
	
	 countries.put(1,"India");
         countries.put(2,"Australia");
         countries.put(3,"South Africa");
         countries.put(4,"New Zealand");
         countries.put(5,"West Indies");
         countries.put(6,"Srilanka");
	}

    public void displayCountry() {                                           // for displaying the country list
            
	   	Set s=countries.entrySet();
		Iterator i=s.iterator();
		while(i.hasNext()){

			Map.Entry country = (Map.Entry)i.next();
			System.out.println(country.getKey()+" "+country.getValue());
		       
		}
			
	}
}


public class Solution {
	public static void main(String [] args) {
		
		System.out.println("welcome to the game of cricket");
		Scanner sc=new Scanner(System.in);
		Game c=new Game();
		c.displayCountry();
	
	}
}
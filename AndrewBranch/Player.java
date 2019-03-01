package AndrewBranch;
import java.util.Scanner;


public class Player {
	
	
	private int health = 100;
	//private Item items;
	private Location location;
	
	public Player(Location loc) {
		Location playerLoc = new Location(loc.getX(), loc.);
		//
	}
	
	public Location getLocation(){
		return location;
	}
	public void setLoc(Location loc){
		location = loc;
	}
	
	public Direction getDirection() {
		
		//scanner takes in user input which can be assigned to variables
		Scanner input = new Scanner(System.in);
		// variable it gets assigned to, so it can be used in if statements
		char move = input.next().charAt(0);
		//if statements to return direction based on move variable
		if(move=='w'){
			return Direction.UP;
		}
		if(move=='a'){
			return Direction.LEFT;
		}
		if(move=='s'){
			return Direction.DOWN;
		}
		if(move=='d'){
			return Direction.RIGHT;
		}
		else{
			return Direction.NONE;
		}
	}
	
	public AttackType getMove(Enemy enemy) {
		return AttackType.KICK;
	}
	
	
	
	
	
}
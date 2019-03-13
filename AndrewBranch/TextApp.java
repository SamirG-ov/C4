public class TextApp {

	private Direction playerDirection;
	private Location playerLocation;
	private Player user;

	//main for the game
	public static void main(String[] args){
		TextApp ta = new TextApp();
		ta.playgame();
	}


	private void playgame(){
		System.out.println("Recover the treasure! It's our only hope of escaping the life of poor students everywhere! ");
		//creats new gamemap with parameters as the players start location and calls
		//draw map to draw map before player makes an input
		Gamemap1 gamemap= new Gamemap1(2,2);
		gamemap.drawMap();

		// @param smallalmostboolean is the 3 case output from isValid in gamemap1
		// @param bigBoolean used to indefinetly run while loop until switched to false due to colliding with $
		int smallAlmostBoolean;
		boolean bigBoolean = true;
		while(bigBoolean == true){

		// @param playerDirection(from player.java) and playerLocation(from gamemap1.java) get the input from player
		// and location to be inputed as parameters into moving() which is called on at the end of this method
		playerDirection = gamemap.getPlayer().getDirection();
		playerLocation = gamemap.getPlayer().getLocation();

		//@param smallAlmostBoolean is the return int from isValid()(from gamemap1.java) which is used here now
		//to determine if the player wins or loses by closing while loop
		smallAlmostBoolean = gamemap.isValid(playerLocation, playerDirection);
		if (smallAlmostBoolean == 0) {
			System.out.println("That is an invalid move, please stay within the boundary. Try again: ");
			continue;
		} else if (smallAlmostBoolean == 1) {
			System.out.println("Congratulations! You recovered the treasure!");
			bigBoolean = false;
		}

		//moving() moves the player on the board behind the scenes and drawMap() prints the new board with the players
		//new location as a parameter to know where to place the 'P' visually in console
		gamemap.moving(playerDirection, playerLocation);
		gamemap.drawMap(playerLocation);
		}
	}





}

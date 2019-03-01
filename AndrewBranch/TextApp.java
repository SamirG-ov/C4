public class TextApp {

	private Direction playerDirection;
	private Location playerLocation;
	private Player user;
	
	public static void main(String[] args){
		TextApp ta = new TextApp();
		ta.playgame();
	}
	
	private void playgame(){
		System.out.println("Recover the treasure! It's our only hope of escaping the life of poor students everywhere! ");
		Gamemap1 gamemap= new Gamemap1(2,2);
		gamemap.drawMap();
		
		
		int smallAlmostBoolean;
		boolean bigBoolean = true;
		while(bigBoolean == true){
			
		
		playerDirection = gamemap.getPlayer().getDirection();
		playerLocation = gamemap.getPlayer().getLocation();
		smallAlmostBoolean = gamemap.isValid(playerLocation, playerDirection);
		if (smallAlmostBoolean == 0) {
			System.out.println("That is an invalid move, please stay within the boundary. Try again: ");
			continue;
		} else if (smallAlmostBoolean == 1) {
			System.out.println("Congratulations! You recovered the treasure!");
			bigBoolean = false;
		}
		
		gamemap.moving(playerDirection, playerLocation);
		gamemap.drawMap(playerLocation); 
		}
	}
	
	
	
	
	
}

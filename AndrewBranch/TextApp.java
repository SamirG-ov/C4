public class TextApp {

	private Direction playerDirection;
	private Location playerLocation;
	private Player user;
	
	public static void main(String[] args){
		TextApp ta = new TextApp();
		ta.playgame();
	}
	
	private void playgame(){
		Gamemap1 gamemap= new Gamemap1(2,2);
		gamemap.drawMap();
		
		
		boolean bigBoolean = true;
		while(bigBoolean == true){
			
		
		playerDirection = gamemap.getPlayer().getDirection();
		playerLocation = gamemap.getPlayer().getLocation();
		
		gamemap.drawMap(playerLocation);
		gamemap.moving(playerDirection, playerLocation);
		}
	}
	
	
	
	
	
}


public class TextApp {

	public static void main(String[] args){
		TextApp ta = new TextApp();
		//ta.playgame();
	}
	
	private void playgame(){
		Gamemap1 gamemap= new Gamemap1(2,2);
		Player user = new Player();
		boolean bigBoolean = true;
		while(bigBoolean == true){
			
		Direction playerDirection;
		Location playerLocation;
		playerDirection = user.getDirection();
		playerLocation = user.getLocation();
		
		gamemap.drawMap();
		gamemap.moving(playerDirection, playerLocation);
		}
	}
	
	
	
	
	
}

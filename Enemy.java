 public class Enemy {
	
	private Location enemyLoc;
	private Player user;
	private int health = 100;
	
	public Enemy(int x, int y) {
		enemyLoc = new Location(x, y);
	}
	
	public Location getLocation() {
		return enemyLoc;
	}
	
	public Direction getMove(Player user) {
		Location playerLoc = user.getLocation();
		int playerX = playerLoc.getX();
		int playerY = playerLoc.getY();
		if (playerX > enemyLoc.getX()) {
			if (playerY < enemyLoc.getY()) {
				return Direction.UP;
			} else {
				return Direction.RIGHT;
			}
		} else if (playerX < enemyLoc.getX()){
			if (playerY < enemyLoc.getY()) {
				return Direction.UP;
			} else {
				return Direction.LEFT;
			}
		} else {
			return Direction.DOWN;
		}
		
		
	}
	
	
}

package AndrewBranch;
public class Gamemap1{
//game map

private static char[][] map = new char[][] {
	{'X','X','X','X','X'},
	{'X',' ',' ',' ','X'},
	{'X',' ',' ',' ','X'},
	{'X',' ',' ',' ','X'},
	{'X',' ',' ',' ','X'},
	{'X',' ',' ',' ','X'},
	{'X','X','X','X','X'}
};
public Gamemap1(int playerLocX, int playerLocY){
	Location playerLoc = new Location();
	playerLoc.setY(playerLocY);
	playerLoc.setX(playerLocX);
	
	Player user = new Player(playerLoc);
	map[playerLoc.getY()][playerLoc.getX()] = 'P';
	
}
//print for game map
public static void drawMap(){
System.out.println();
for (int row=0; row<  map.length; row++)
{
	for(int col=0; col< map[row].length; col++){
		System.out.print(map[row][col] + "  ");
	}
	System.out.println();
}
System.out.println();
}

public void moving(Direction x, Location loc){
	// sets start position
	// replaces last spot with an empty spot
	// sets new player spot too
	char temp = map[loc.getY()][loc.getX()];
	map[loc.getY()][loc.getX()] = ' ';


	if (x == Direction.LEFT){
		loc.setX(loc.getX()-1);
	}
	else if( x == Direction.DOWN){
		loc.setY(loc.getY()+1);
	}
	else if (x == Direction.RIGHT){
		loc.setX(loc.getX()+1);
	}
	else if( x == Direction.UP){
		loc.setY(loc.getY()-1);
	}
	map[loc.getY()][loc.getX()] = temp;
}

}

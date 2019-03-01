package actualone;

public class Gamemap1{
//game map
public static void main(String[] args){
	Gamemap1 gamemap = new Gamemap1();
	gamemap.drawMap();
}

private static char[][] map = new char[][] {
	{'X','X','X','X','X'},
	{'X',' ',' ',' ','X'},
	{'X',' ',' ',' ','X'},
	{'X',' ',' ',' ','X'},
	{'X',' ',' ',' ','X'},
	{'X',' ',' ',' ','X'},
	{'X','X','X','X','X'}
};
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
	map[2][2]= 'P';
	// replaces last spot with an empty spot
	// sets new player spot too
	if (x == Direction.LEFT){
		loc.setX(loc.getX()-1);
		map[loc.getY()][loc.getX()+1] = ' ';
		map[loc.getY()][loc.getX()] = 'P';
	}
	else if( x == Direction.DOWN){
		loc.setY(loc.getY()+1);
		map[loc.getY()-1][loc.getX()] = ' ';
		map[loc.getY()][loc.getX()] = 'P';
	}
	else if (x == Direction.RIGHT){
		loc.setX(loc.getX()+1);
		map[loc.getY()][loc.getX()-1] = ' ';
		map[loc.getY()][loc.getX()] = 'P';
	}
	else if( x == Direction.UP){
		loc.setY(loc.getY()-1);
		map[loc.getY()+1][loc.getX()] = ' ';
		map[loc.getY()][loc.getX()] = 'P';
	}
}

}

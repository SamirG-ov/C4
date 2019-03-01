import java.util.Random;
public class Gamemap1{
//game map

private Location playerLoc;
private Player user;
private static char[][] map = new char[][] {
    {'X','X','X','X','X','X','X','X'},
    {'X',' ',' ',' ',' ',' ',' ','X'},
    {'X',' ',' ',' ',' ',' ',' ','X'},
    {'X',' ',' ',' ',' ',' ',' ','X'},
    {'X',' ',' ',' ',' ',' ',' ','X'},
    {'X',' ',' ',' ',' ',' ',' ','X'},
    {'X','X','X','X','X','X','X','X'}
};

public Gamemap1(int playerLocX, int playerLocY){
    playerLoc = new Location(playerLocX, playerLocY);
    user = new Player(playerLoc);

    Random randomObj = new Random();
    int randomX = randomObj.nextInt((7 - 1)) + 1;
    int randomY = randomObj.nextInt((6 - 1)) + 1;

    map[playerLoc.getY()][playerLoc.getX()] = 'P';
    map[randomY][randomX] = '$';


}


public Player getPlayer() {
	return user;
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


public static void drawMap(Location loc){
//System.out.println();
map[loc.getY()][loc.getX()] = 'P'; 
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

public int isValid(Location loc, Direction x){
    /*
     * checks if the direction inputed has a wall, or an object, if it does, returns false
     */

    if (x == Direction.LEFT){
        if(map[loc.getY()][loc.getX()-1] == 'X'){
            return 0;
        }
        else if(map[loc.getY()][loc.getX()-1] == '$'){
            return 1;
        }
       
    }
    if (x == Direction.RIGHT){
        if(map[loc.getY()][loc.getX()+1] == 'X'){
            return 0;
        }
        else if(map[loc.getY()][loc.getX()+1] == '$'){
            return 1;
        }

    }
    if (x == Direction.UP){
        if(map[loc.getY()-1][loc.getX()] == 'X'){
            return 0;
        }
        else if(map[loc.getY()-1][loc.getX()] == '$'){
            return 1;
        }
       
    }
    if (x == Direction.DOWN){
        if(map[loc.getY()+1][loc.getX()] == 'X'){
            return 0;
        }
        else if(map[loc.getY()+1][loc.getX()] == '$'){
            return 1;
        }
        
    }
    return 2;
}

}

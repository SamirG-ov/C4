import java.util.Random;
public class Gamemap1{
//game map

private Player user;
private Enemy enemy;
private Location playerLoc = new Location(2, 2);

//private int xcoord; //not less than 0 or bigger than 1280 +/- width of avatar
//private int ycoord; //not less than not bigger than 720 +/- height of the avatar

private static char[][] map = new char[][] {
    {'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X'},
    {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
    {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
    {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
    {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
    {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
    {'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X'}
};

public Gamemap1(){

    user = new Player(playerLoc);
    enemy = new Enemy(18, 8);

    Random randomObj = new Random();
    int randomX = randomObj.nextInt((20)) + 1;
    int randomY = randomObj.nextInt((10)) + 1;

    map[playerLoc.getY()][playerLoc.getX()] = 'P';
    //map[enemy.getLocation().getX()][enemy.getLocation().getY()] = 'E';
    //map[randomY][randomX] = '$';


}


public Player getPlayer() {
	return user;
}

public Enemy getEnemy() {
	return enemy;
}

public void setLootLocation(int x, int y) {
	map[y][x] = '$';
}


//CONSOLE BASED CONTROLS RENDERED OBSOLETE
//public void moving(Direction x, Location loc){
//	// sets start position
//	// replaces last spot with an empty spot
//	// sets new player spot too
//	char temp = map[loc.getY()][loc.getX()];
//	map[loc.getY()][loc.getX()] = ' ';
//
//
//	if (x == Direction.LEFT){
//		loc.setX(loc.getX()-1);
//	}
//	else if( x == Direction.DOWN){
//		loc.setY(loc.getY()+1);
//	}
//	else if (x == Direction.RIGHT){
//		loc.setX(loc.getX()+1);
//	}
//	else if( x == Direction.UP){
//		loc.setY(loc.getY()-1);
//	}
//	map[loc.getY()][loc.getX()] = temp;
//}

public void moving(Direction i) {
	int x = playerLoc.getX();
	int y = playerLoc.getY();

  if (i == Direction.UP) {
      user.getLocation().setY(y - 1);
  }
  else if (i==Direction.DOWN){
      user.getLocation().setY(y + 1);
  }
  else if (i==Direction.LEFT){
      user.getLocation().setX(x - 1);
  }
  else if (i==Direction.RIGHT){
      user.getLocation().setX(x + 1);
  }


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

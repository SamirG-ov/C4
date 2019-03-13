import java.util.Random;
public class Gamemap1{
//game map

/*
*REFERENCES:
*General coding knowledge: Used information learn in Nathaly Verwaal's Lectures and powerpoints
*General coding knowledge: Java programming tutorials by "Absolute Zero" https://www.youtube.com/playlist?list=PLbjOkfqIeibi_rJSoDBKHFWxxVyJHj1Sa
*Citation in inside gamemap1 constructor used for generating a random integer between a range https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
*Citation for drawmap used method 1 listed in link to print our 2D array https://www.geeksforgeeks.org/print-2-d-array-matrix-java/
*Citation in method moving
*/


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

//Citation for generating random numbers in java https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java

//CONSTRUCTOR
public Gamemap1(int playerLocX, int playerLocY){
    playerLoc = new Location(playerLocX, playerLocY);
    user = new Player(playerLoc);


// generates random number for game map size, and uses that number to play $
    Random randomObj = new Random();
    int randomX = randomObj.nextInt((7 - 1)) + 1;
    int randomY = randomObj.nextInt((6 - 1)) + 1;
//gets where ever the player location is behind the scenes and sets it to P
    map[playerLoc.getY()][playerLoc.getX()] = 'P';
    map[randomY][randomX] = '$';


}

public Player getPlayer() {
	return user;
}

// Citation for method drawMap: https://www.geeksforgeeks.org/print-2-d-array-matrix-java/
// print for game map used at the start of playgame() in text app
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

//draw map that takes a location as a parameter for when the map is drawn again the 2nd time,
//this is because the P location needs to be updated visually in console everytime player moves, used at the end of playgame() in text app
public static void drawMap(Location loc){
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

//method is used to update the location behind the scenes everytime a move is made
public void moving(Direction x, Location loc){
	//Coding knowledge and code inspisred from pervious computer science course

  //temporary map is made
  char temp = map[loc.getY()][loc.getX()];
  //current spot player is on is set as an empty spot on the temporary map
	map[loc.getY()][loc.getX()] = ' ';

  //reads which direction the player moves in and sets the new player location as in given direction
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
  //old map is set to the temporary map
	map[loc.getY()][loc.getX()] = temp;
}

public int isValid(Location loc, Direction x){

     //isValid takes the players input in console and players location and determines if its
     //a valid move or a game winning one, used in textApp
     //if method returns 0 there is a wall, if 1 there is the money, if 2 there is no obstacle

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

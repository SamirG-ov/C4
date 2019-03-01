//Gamemap1  & char[] [] = map
package AndrewBranch;
public class Location {
	
	private int xcoord;
	private int ycoord;
	
	public Location(int x, int y) {
		xcoord = x;
		ycoord = y;
	}
	
	public int getX() {
		return xcoord;
	}
	
	public int getY() {
		return ycoord;
	}
	public void setX(int x){
		xcoord = x; 
		
	}
	public void setY(int y){
		ycoord = y;
	}
	
}
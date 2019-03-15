//Gamemap1  & char[] [] = map
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
		if (x > 0 && x < 20) {
			xcoord = x;
		}

	}
	public void setY(int y){
		if (y > 0 && y < 10) {
			ycoord = y;
		}
	}

}

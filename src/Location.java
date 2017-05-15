
public class Location {
	private int x;
	private int y;
	private boolean populated;
	
	public Location(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setPopulated(boolean same){
		populated = same;
	}
	
	public boolean populated(){
		return populated;
	}
}

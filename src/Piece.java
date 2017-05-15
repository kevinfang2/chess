import java.util.ArrayList;

public class Piece {
	private String side;
	private Location coordinate = new Location(0, 0);
	private ArrayList<Location> possibleMoves = new ArrayList<Location>();
	private boolean firstClick = false;
	
	public Piece (Location coordinate, String side){
		this.coordinate = coordinate;
		this.side = side;
	}
	
	public ArrayList<Location> getPossibleMoves(){
		return possibleMoves;
	}
	
	public void setPossibleMoves(ArrayList<Location> locs){
		this.possibleMoves = locs;
	}
	
	public String getSide(){
		return this.side;
	}
	
	public Location getCoordinate(){
		return coordinate;
	}

	public boolean getClickNumber(){
		return firstClick;
	}
	
	public void setClickNumber(boolean check){
		firstClick = check;
	}
	
	public String getPath(){
		// http://stackoverflow.com/questions/6271417/java-get-the-current-class-name
		
		String className = this.getClass().getSimpleName();
		System.out.println("classname is " + className);
		return className;
	}
	
	
}

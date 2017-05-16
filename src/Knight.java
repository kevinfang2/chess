import java.util.ArrayList;

public class Knight extends Piece{
	private boolean hasMoved = false;
	private String side;
	private Location coordinate;
	
	public Knight(Location coordinate, String side) {
		super(coordinate, side);
		this.side = getSide();
		this.coordinate = getCoordinate();
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Location> getMoves(){
		ArrayList<Location> possibleMoves = new ArrayList<Location>();
		
		return possibleMoves;
	}
	
	public ArrayList<Location> canCapture(){
		return null;
	}
	
	public void Move(){
		
	}

	
}

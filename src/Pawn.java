import java.util.ArrayList;

public class Pawn extends Piece{
	private boolean hasMoved = false;
	private String side;
	private Location coordinate;
	
	public Pawn(Location coordinate, String side) {
		super(coordinate, side);
		this.side = getSide();
		this.coordinate = getCoordinate();
		// TODO Auto-generated constructor stub
	}
	
	public void getMoves(){
		ArrayList<Location> possibleMoves = new ArrayList<Location>();
		if(side == "white"){
			if(hasMoved == false){
				possibleMoves.add(new Location(coordinate.getX(), coordinate.getY() + 2));
				hasMoved = true;
			}
			possibleMoves.add(new Location(coordinate.getX(), coordinate.getY() + 1));
		}
		else {
			if(hasMoved == false){
				possibleMoves.add(new Location(coordinate.getX(), coordinate.getY() - 2));
				hasMoved = true;
			}
			possibleMoves.add(new Location(coordinate.getX(), coordinate.getY() - 1));
		}
	}
	
	public ArrayList<Location> canCapture(){
		return null;
	}
	
	public void Move(){
		
	}

	
}
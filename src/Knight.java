import java.util.ArrayList;

public class Knight extends Piece{
	private boolean hasMoved = false;
	private String side;
	private Location coordinate;
	
	public Knight(Location coordinate, String side) {
		super(coordinate, side);
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Location> getMoves(){
		ArrayList<Location> allPossibleMoves = new ArrayList<Location>();
		ArrayList<Location> returnedMoves = new ArrayList<Location>();
		int x = coordinate.getX();
		int y = coordinate.getY();
		Location upRight1 = new Location(x - 2, y + 1);
		Location upRight2 = new Location(x - 1, y + 2);
		Location upLeft1 = new Location(x - 2, y - 1);
		Location upLeft2 = new Location(x - 1, y - 2);
		Location downRight1 = new Location(x + 2, y + 1);
		Location downRight2 = new Location(x + 1, y + 2);
		Location downLeft1 = new Location(x + 2, y - 1);
		Location downLeft2 = new Location(x + 1, y - 2);
		allPossibleMoves.add(upRight1);
		allPossibleMoves.add(upRight2);
		allPossibleMoves.add(upLeft1);
		allPossibleMoves.add(upLeft2);
		allPossibleMoves.add(downRight1);
		allPossibleMoves.add(downRight2);
		allPossibleMoves.add(downLeft1);
		allPossibleMoves.add(downLeft2);
		for(int i=0; i<allPossibleMoves.size(); i++){
			Location checked = allPossibleMoves.get(i);
			if(check(checked)){
				if(Main.getLocations().contains(checked)){
					returnedMoves.add(checked);
				}
			}
		}
	
		return returnedMoves;
	}
	
	public ArrayList<Location> canCapture(){
		return null;
	}
	
	public void Move(){
		
	}

	
}

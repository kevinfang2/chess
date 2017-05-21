import java.util.ArrayList;

public class King extends Piece{
	
	public King(Location coordinate, String side) {
		super(coordinate, side);
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Location> getMoves(){
		ArrayList<Location> allPossibleMoves = new ArrayList<Location>();
		ArrayList<Location> returnedMoves = new ArrayList<Location>();
		
		int x = coordinate.getX();
		int y = coordinate.getY();
		
		allPossibleMoves.add(new Location(x+1, y));
		allPossibleMoves.add(new Location(x+1, y+1));
		allPossibleMoves.add(new Location(x+1, y-1));
		allPossibleMoves.add(new Location(x-1, y));
		allPossibleMoves.add(new Location(x-1, y+1));
		allPossibleMoves.add(new Location(x-1, y-1));
		allPossibleMoves.add(new Location(x, y-1));
		allPossibleMoves.add(new Location(x, y+1));
		
		for(int i=0; i<allPossibleMoves.size(); i++){
			Location check = allPossibleMoves.get(i);
			int a = check.getX();
			int b = check.getY();
			
			if(a>=0 && a<8 && b>=0 && b<8){
				returnedMoves.add(check);
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

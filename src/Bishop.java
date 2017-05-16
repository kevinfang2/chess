import java.util.ArrayList;

public class Bishop extends Piece{
	private boolean hasMoved = false;
	private String side;
	private Location coordinate;
	
	public Bishop(Location coordinate, String side) {
		super(coordinate, side);
		this.side = getSide();
		this.coordinate = getCoordinate();
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Location> getMoves(){
		ArrayList<Location> allPossibleMoves = new ArrayList<Location>();
		ArrayList<Location> returnedMoves = new ArrayList<Location>();
		int x = coordinate.getX();
		int y = coordinate.getY();
		int min;
		if(x>y){
			min = x;
		}
		else{
			min = y;
		}
		for(int i=x; i<8; i++){
			Location temp = new Location(x+i,y+i);
			allPossibleMoves.add(temp);
		}
		for (int j=x; j>0; j--){
			Location temp = new Location(x+j,y+j);
			allPossibleMoves.add(temp);
		}

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

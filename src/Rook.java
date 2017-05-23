import java.util.ArrayList;

public class Rook extends Piece{
	public Rook(Location coordinate, String side) {
		super(coordinate, side);
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Location> getMoves(){
		ArrayList<Location> leftPossibleMoves = new ArrayList<Location>();
		ArrayList<Location> rightPossibleMoves = new ArrayList<Location>();
		ArrayList<Location> upPossibleMoves = new ArrayList<Location>();
		ArrayList<Location> downPossibleMoves = new ArrayList<Location>();
		
		ArrayList<Location> returnedMoves = new ArrayList<Location>();
		
		int x = coordinate.getX();
		int y = coordinate.getY();
		System.out.println(coordinate);
		
		for(int i=1; i<8; i++){
			Location temp = new Location(x+i,y);
			Location temp2 = new Location(x-i,y);
			Location temp3 = new Location(x, y+i);
			Location temp4 = new Location(x, y-i);
			
			leftPossibleMoves.add(temp);
			rightPossibleMoves.add(temp2);
			upPossibleMoves.add(temp3);
			downPossibleMoves.add(temp4);
		}

		for(int i=0; i<leftPossibleMoves.size(); i++){
			Location checked = leftPossibleMoves.get(i);
			int a = checked.getX();
			int b = checked.getY();
			if(a >= 0 && a < 8 && b >= 0 && b < 8){
				returnedMoves.add(checked);
			}
		}
		
		for(int i=0; i<rightPossibleMoves.size(); i++){
			Location checked = rightPossibleMoves.get(i);
			int a = checked.getX();
			int b = checked.getY();
			
			if(a >= 0 && a < 8 && b >= 0 && b < 8){
				returnedMoves.add(checked);
			}
		}
		
		for(int i=0; i<upPossibleMoves.size(); i++){
			Location checked = upPossibleMoves.get(i);
			int a = checked.getX();
			int b = checked.getY();

			if(a >= 0 && a < 8 && b >= 0 && b < 8){
				returnedMoves.add(checked);
			}
		}
		
		for(int i=0; i<downPossibleMoves.size(); i++){
			Location checked = downPossibleMoves.get(i);
			int a = checked.getX();
			int b = checked.getY();
		
			if(a >= 0 && a < 8 && b >= 0 && b < 8){
				returnedMoves.add(checked);
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

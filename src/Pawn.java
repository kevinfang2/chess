import java.util.ArrayList;

public class Pawn extends Piece{
	private String side;
	public Pawn(Location coordinate, String side) {
		super(coordinate, side);
		this.side = side;
		// TODO Auto-generated constructor stub
	}
	
//	public ArrayList<Location> getMoves(){
//		ArrayList<Location> possibleMoves = new ArrayList<Location>();
//		if(side == "white"){
//			if(hasMoved == false){
//				possibleMoves.add(new Location(coordinate.getX(), coordinate.getY() + 2));
//				hasMoved = true;
//			}
//			possibleMoves.add(new Location(coordinate.getX(), coordinate.getY() + 1));
//		}
//		else {
//			if(hasMoved == false){
//				possibleMoves.add(new Location(coordinate.getX(), coordinate.getY() - 2));
//				hasMoved = true;
//			}
//			possibleMoves.add(new Location(coordinate.getX(), coordinate.getY() - 1));
//		}
//		return possibleMoves;
//	}
	
	public ArrayList<Location> checkCapture(){
		ArrayList<Location> returnMoves = new ArrayList<Location>();
		if(side == "black"){
			Location one = new Location(this.coordinate.getX() + 1, this.getCoordinate().getY() + 1);
			Location two = new Location(this.coordinate.getX() + 1, this.getCoordinate().getY() - 1);
			int x1 = one.getX();
			int x2 = two.getX();
			int y1 = one.getY();
			int y2 = two.getY();
			
			Unit u1 = Main.getGrid().get(x1*8 + y1);
			Unit u2 = Main.getGrid().get(x2*8 + y2);

			if(u1.hasPiece() && u1.getPiece().getSide() != this.side){
				returnMoves.add(one);
			}
			if(u2.hasPiece() && u2.getPiece().getSide() != this.side){
				returnMoves.add(two);
			}
		}
		else{
			Location one = new Location(this.coordinate.getX() - 1, this.getCoordinate().getY() + 1);
			Location two = new Location(this.coordinate.getX() - 1, this.getCoordinate().getY() - 1);
			int x1 = one.getX();
			int x2 = two.getX();
			int y1 = one.getY();
			int y2 = two.getY();
			
			Unit u1 = Main.getGrid().get(x1*8 + y1);
			Unit u2 = Main.getGrid().get(x2*8 + y2);

			if(u1.hasPiece() && u1.getPiece().getSide() != this.side){
				returnMoves.add(one);
			}
			if(u2.hasPiece() && u2.getPiece().getSide() != this.side){
				returnMoves.add(two);
			}
		}
		return returnMoves;
	}
	
	public ArrayList<Location> canCapture(){
		return null;
	}
	
	public void Move(){
		
	}

	
}

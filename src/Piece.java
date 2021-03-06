import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class Piece{
	private String side;
	protected Location coordinate = new Location(0, 0);
	private ArrayList<Location> possibleMoves = new ArrayList<Location>();
	private boolean selected = false;
	boolean hasMoved = false;
	
	public Piece (Location coordinate, String side){
		this.coordinate = coordinate;
		this.side = side;
	}
	
	public String getSide(){
		return this.side;
	}
	
	public Location getCoordinate(){
		return coordinate;
	}

	public void setCoordinate(Location newCoor){
		this.coordinate = newCoor;
	}
	
	public boolean getSelected(){
		return selected;
	}
	
	public void setSelected(boolean check){
		selected = check;
	}
	
	public ArrayList<Location> getMoves(){
		ArrayList<Location> possibleMoves = new ArrayList<Location>();
		if(this.side == "white"){
			Location temp = new Location(this.coordinate.getX() - 1, this.coordinate.getY());
			Unit unit = Main.getGrid().get(temp.getX() * 8 + temp.getY());
			
			if(this.coordinate.getX() == 6 && !unit.hasPiece()){
				Location doubleMove = new Location(coordinate.getX() - 2, coordinate.getY());
				possibleMoves.add(doubleMove);
			}
			Location singleMove = new Location(coordinate.getX() - 1, coordinate.getY());
			possibleMoves.add(singleMove);
//			possibleMoves.addAll(checkCapture());
		}
		else {
			Location temp = new Location(this.coordinate.getX() + 1, this.coordinate.getY());
			Unit unit = Main.getGrid().get(temp.getX() * 8 + temp.getY());

			if(this.coordinate.getX() == 1 && !unit.hasPiece()){
				Location doubleMove = new Location(coordinate.getX() + 2, coordinate.getY());
				possibleMoves.add(doubleMove);
			}
			Location singleMove = new Location(coordinate.getX() + 1, coordinate.getY());
			possibleMoves.add(singleMove);
//			possibleMoves.addAll(checkCapture());
		}

		return possibleMoves;
	}
	
	public String getPath(){
		// http://stackoverflow.com/questions/6271417/java-get-the-current-class-name
		String className = this.getClass().getSimpleName();
		return className;
	}
}

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class Piece{
	private String side;
	private Location coordinate = new Location(0, 0);
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
	
	public boolean check(Location loc){
		int index = loc.getX() * 8 + loc.getY();
		if(!Main.getGrid().contains(loc)){
			return false;
		}
		Piece piece = Main.getGrid().get(index).getPiece();
		if(piece != null){
			return false;
		}
		return true;
	}
	
	public ArrayList<Location> getMoves(){
		ArrayList<Location> possibleMoves = new ArrayList<Location>();

		if(this.side == "white"){
			System.out.println(this.coordinate.getX());
			if(this.coordinate.getX() == 6){
				
				Location doubleMove = new Location(coordinate.getX() - 2, coordinate.getY());
				if(check(doubleMove)){
					possibleMoves.add(doubleMove);
				}
			}
			Location singleMove = new Location(coordinate.getX() - 1, coordinate.getY());
			if(check(singleMove)){
				possibleMoves.add(new Location(coordinate.getX() - 1, coordinate.getY()));
			}
		}
		else {
			if(this.coordinate.getX() == 1){
				possibleMoves.add(new Location(coordinate.getX() + 2, coordinate.getY()));
				hasMoved = true;
			}
			possibleMoves.add(new Location(coordinate.getX() + 1, coordinate.getY()));
		}
		return possibleMoves;
	}
	
	public String getPath(){
		// http://stackoverflow.com/questions/6271417/java-get-the-current-class-name
		String className = this.getClass().getSimpleName();
		System.out.println("classname is " + className);
		return className;
	}
}

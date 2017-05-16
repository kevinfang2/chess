import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class Piece{
	private String side;
	private Location coordinate = new Location(0, 0);
	private ArrayList<Location> possibleMoves = new ArrayList<Location>();
	private boolean selected = false;
	
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

	public boolean getSelected(){
		return selected;
	}
	
	public void setSelected(boolean check){
		selected = check;
	}
	
	public ArrayList<Location> getMoves(){
		ArrayList<Location> possibleMoves = new ArrayList<Location>();
//		System.out.println(this.side);
		boolean hasMoved = true;
		if(this.side == "white"){
			if(this.coordinate.getY() != 7){
				hasMoved = false;
			}
		}
		else{
			if(this.coordinate.getY() != 2){
				hasMoved = false;
			}
		}

		if(this.side == "white"){
			if(hasMoved == false){
				possibleMoves.add(new Location(coordinate.getX() - 2, coordinate.getY()));
				hasMoved = true;
			}
			possibleMoves.add(new Location(coordinate.getX() - 1, coordinate.getY()));
		}
		else {
			if(hasMoved == false){
				possibleMoves.add(new Location(coordinate.getX() + 2, coordinate.getY()));
				hasMoved = true;
			}
			possibleMoves.add(new Location(coordinate.getX() + 1, coordinate.getY()));
		}
//		System.out.println("hallo");
//		System.out.println(possibleMoves.size());
		return possibleMoves;
	}
	
	public String getPath(){
		// http://stackoverflow.com/questions/6271417/java-get-the-current-class-name
		String className = this.getClass().getSimpleName();
		System.out.println("classname is " + className);
		return className;
	}
}

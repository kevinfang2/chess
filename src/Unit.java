import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Unit extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Piece p;
	private Location loc;
	private int x;
	private int y;
	private boolean firstClick = false;
	private JButton button = new JButton();

	public Unit(Location l){
		this.loc = l;

		this.x = loc.getX();
		this.y = loc.getY();
		if((x+y) % 2 == 1){
    		this.setBackground(Color.white);
    	}
    	this.setOpaque(true);
        button.addActionListener(this);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        this.add(button);
	}

	public void setPiece(Piece p){
		this.p = p;
		try {
			Image img = ImageIO.read(getClass().getResource(p.getSide() + p.getPath() + ".png"));
			System.out.println(p.getPath() + ".png");
		    button.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
		    System.out.println(ex);
		}
		this.add(button);
	}
	
	public void removePiece(){
		this.p = null; 
		button.setIcon(null);
	}

	private Result checkSelect(ArrayList<Piece> pieces){
		for(int x=0; x<pieces.size(); x++){
			Piece temp = pieces.get(x);
			if(temp.getSelected() == true){
				Result returnValue = new Result(temp, true);
				return returnValue;
			}
		}
		Result returnValue = new Result(false);
		return returnValue;
	}
	
	public void actionPerformed(ActionEvent e) {
		String turn = Main.getTurn();
		ArrayList<Piece> pieces = new ArrayList<Piece>();
		if(turn == "white"){
			pieces = Main.getWhitePieces();
		}
		else{
			pieces = Main.getBlackPieces();
		}
		
		Result check = checkSelect(pieces);
		
		if(check.getClick() == false){
			if(p != null){
				p.setSelected(true);
				System.out.println("selected");
			}
			else{
				System.out.println("no piece nothing selected");
			}
		}
		else{
			Piece temp = check.getPiece();
			check.getPiece().setSelected(false);

			ArrayList<Location> moves = temp.getMoves();
			
			System.out.println(loc);

			for(int x=0; x<moves.size(); x++){
				System.out.println(moves.get(x));
				if(moves.get(x).equals(loc)){
					System.out.println("index is");
					if(Main.getTurn() == "white"){
						System.out.println(Main.getWhitePieces().indexOf(temp));
						int index = Main.getWhitePieces().indexOf(temp);
						Piece selected = Main.getWhitePieces().get(index);
						Location temp1 = selected.getCoordinate();
						
						selected.setCoordinate(loc);
						Main.getGrid().get(loc.getX()*8 + loc.getY()).setPiece(selected);
						
						Main.getGrid().get(temp1.getX()*8 + loc.getY()).removePiece();
						
						Main.setTurn("black");
					}
					else{
						System.out.println(Main.getBlackPieces().indexOf(temp));
						int index = Main.getBlackPieces().indexOf(temp);
						Piece selected = Main.getBlackPieces().get(index);
						Location temp1 = selected.getCoordinate();
						
						selected.setCoordinate(loc);
						Main.getGrid().get(loc.getX()*8 + loc.getY()).setPiece(selected);
						
						Main.getGrid().get(temp1.getX()*8 + loc.getY()).removePiece();
						
						Main.setTurn("white");
					}
				}
			}
		}
	}
}

class Result{
	Piece p;
	boolean clickNumber;

	public Result(Piece p, boolean clickNumber){
		this.p = p;
		this.clickNumber = clickNumber;
	}
	
	public Result(boolean clickNumber){
		this.clickNumber = clickNumber;
	}
	
	public Piece getPiece(){
		return p;
	}
	
	public boolean getClick(){
		return clickNumber;
	}
}

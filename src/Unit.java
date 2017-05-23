import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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
        button.setPreferredSize(new Dimension(63,63));
        this.add(button);
	}

	public void setPiece(Piece p){
		this.p = p;
		try {
			Image img = ImageIO.read(getClass().getResource(p.getSide() + p.getPath() + ".png"));
		    button.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
		    System.out.println(ex);
		}
		this.add(button);
	}
	
	public Piece getPiece(){
		return p;
	}
	
	public boolean hasPiece(){
		if(this.p == null){
			return false;
		}
		return true;
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
	
	private void clear(ArrayList<Piece> pieces){
		for(int x=0; x<pieces.size(); x++){
			Piece temp = pieces.get(x);
			if(temp.getSelected() == true){
				temp.setSelected(false);
			}
		}
	}
	
	public boolean check(Piece p2){
		int index = loc.getX() * 8 + loc.getY();
		if(index < 0 || index >= 64){
			return false;
		}
		
		Unit unit = Main.getGrid().get(index);
		Piece piece = unit.getPiece();
		if(unit.hasPiece()){
			System.out.println(piece.getSide());
			if(piece.getSide() == p2.getSide()){
				return false;
			}
			if(piece.getSide() != p2.getSide()){
				System.out.println(p2.getSide());
				if(p2.getClass().getSimpleName() != "Pawn"){
					System.out.println(p2.getClass().getSimpleName());
					if(piece.getSide() == "black"){
						if(piece.getClass() == King.class){
							Main.gameOver(piece.getSide());
						}
						int index2 = Main.getBlackPieces().indexOf(piece);
						Main.getBlackPieces().remove(index2);
					}
					else{
						if(piece.getClass() == King.class){
							Main.gameOver(piece.getSide());
						}
						int index2 = Main.getWhitePieces().indexOf(piece);
						Main.getWhitePieces().remove(index2);
					}
				}
				else{
					return false;
				}
				
			}
		}

		return true;
	}
	
	public void actionPerformed(ActionEvent e) {
		ArrayList<Piece> pieces = new ArrayList<Piece>();
		
		if(Main.getTurn() == "white"){
			pieces = Main.getWhitePieces();
		}
		else{
			pieces = Main.getBlackPieces();
		}
		Result check = checkSelect(pieces);

		if(check.getClick() == false){
			if(p != null && p.getSide() == Main.getTurn()){
				clear(pieces);
				p.setSelected(true);
			}
		}
		else{
			Piece temp = check.getPiece();
			check.getPiece().setSelected(false);
			ArrayList<Location> moves = temp.getMoves();
			if(temp.getClass() == Pawn.class){
				Pawn pawn = (Pawn)temp;
				ArrayList<Location> locs = pawn.checkCapture();
				for(int x=0; x<locs.size(); x++){
					if(this.loc.equals(locs.get(x))){
						if(Main.getTurn() == "white"){
							ArrayList<Piece> whitePieces = Main.getWhitePieces();
							int index = whitePieces.indexOf(temp);
							Piece selected = whitePieces.get(index);
							Location temp1 = selected.getCoordinate();
						
							selected.setCoordinate(loc);
							Piece tempStore = p;
							
							Main.getGrid().get(loc.getX()*8 + loc.getY()).setPiece(selected);
							Main.getGrid().get(temp1.getX()*8 + temp1.getY()).removePiece();
						
							if(tempStore.getClass() == King.class){
								Main.gameOver(tempStore.getSide());
							}
							int removeIndex = Main.getBlackPieces().indexOf(tempStore);
							Main.getBlackPieces().remove(removeIndex);
							
							clear(whitePieces);
							Main.setTurn("black");	
						}
						else{
							ArrayList<Piece> blackPieces = Main.getBlackPieces();
							int index = blackPieces.indexOf(temp);
							Piece selected = blackPieces.get(index);
							Location temp1 = selected.getCoordinate();
						
							selected.setCoordinate(loc);
							Piece tempStore = p;
							
							Main.getGrid().get(loc.getX()*8 + loc.getY()).setPiece(selected);
							Main.getGrid().get(temp1.getX()*8 + temp1.getY()).removePiece();
						
							if(tempStore.getClass() == King.class){
								Main.gameOver(tempStore.getSide());
							}
							
							int removeIndex = Main.getWhitePieces().indexOf(tempStore);
							Main.getBlackPieces().remove(removeIndex);
							
							clear(blackPieces);
							Main.setTurn("white");	
						}
					}
				}
			}

			for(int x=0; x<moves.size(); x++){
				if(moves.get(x).equals(loc)){
					if(Main.getTurn() == "white"){
						ArrayList<Piece> whitePieces = Main.getWhitePieces();
						int index = whitePieces.indexOf(temp);
						Piece selected = whitePieces.get(index);
						Location temp1 = selected.getCoordinate();
						if(check(selected)){
							selected.setCoordinate(loc);
							Main.getGrid().get(loc.getX()*8 + loc.getY()).setPiece(selected);

							Main.getGrid().get(temp1.getX()*8 + temp1.getY()).removePiece();
							
							clear(whitePieces);
							Main.setTurn("black");
						}
					}
					else{
						ArrayList<Piece> blackPieces = Main.getBlackPieces();
						int index = blackPieces.indexOf(temp);
						Piece selected = blackPieces.get(index);
						Location temp1 = selected.getCoordinate();
												
						if(check(selected)){
							selected.setCoordinate(loc);
							Main.getGrid().get(loc.getX()*8 + loc.getY()).setPiece(selected);

							Main.getGrid().get(temp1.getX()*8 + temp1.getY()).removePiece();
							
							clear(blackPieces);
							Main.setTurn("white");	
						}
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

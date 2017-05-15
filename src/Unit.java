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
import javax.swing.JPanel;

public class Unit extends JPanel implements ActionListener, MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Piece p;
	private Location loc;
	private int x;
	private int y;
	private boolean firstClick = false;
	
	public Unit(Location l){
		this.loc = l;

		this.x = loc.getX();
		this.y = loc.getY();
		if((x+y) % 2 == 0){
			this.setBackground(new Color(99,60,3));
    	}
    	else{
    		this.setBackground(Color.white);
    	}
    	this.setOpaque(true);
	}

	public void setPiece(Piece p){
		JButton button = new JButton();
		this.p = p;
		try {
			Image img = ImageIO.read(getClass().getResource(p.getSide() + p.getPath() + ".png"));
			System.out.println(p.getPath() + ".png");
		    button.setIcon(new ImageIcon(img));
	        button.setBorderPainted(false); 
	        button.addActionListener(this);
		} catch (Exception ex) {
		    System.out.println(ex);
		}
		this.add(button);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("action is performed");
	}
	
	private boolean checkClickCount(ArrayList<Piece> pieces){
		for(int x=0; x<pieces.size(); x++){
			Piece temp = pieces.get(x);
			if(temp.getClickNumber() == true){
				return true;
			}
		}
		return false;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if(p.getSide() == "white"){
			ArrayList<Piece> whitePieces = Main.getWhitePieces();
			boolean clickNumber = checkClickCount(whitePieces);
		}
		else{
			ArrayList<Piece> blackPieces = Main.getBlackPieces();
			boolean clickNumber = checkClickCount(blackPieces);
		}
		if(p.getClickNumber() == false){
			p.setClickNumber(true);
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;



public class Main extends JPanel {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ArrayList<Piece> blackPieces = new ArrayList<Piece>();
	private static ArrayList<Piece> whitePieces = new ArrayList<Piece>();
  
	public static void main(String[] args){
		JFrame frame = new JFrame();
    
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JPanel chessBoard = new JPanel(new GridLayout(0, 8));

				chessBoard.setPreferredSize(new Dimension(500, 500));
            
            	frame.add(chessBoard, BorderLayout.CENTER);
            	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // EDIT
            	frame.setResizable(false);
            	frame.pack();
            	frame.setVisible(true);

            	for (int i = 0; i < 8; i++)
            	{
                	for (int j = 0; j < 8; j++)
                	{
                		Location loc = new Location(i, j);
                		Unit square = new Unit(loc);
                		if(i==1){
                			Pawn blackPawn = new Pawn(loc, "black");
                			square.setPiece(blackPawn);
                			blackPieces.add(blackPawn);
                		}
                		else if(i==6){
                			Pawn whitePawn = new Pawn(loc, "white");
                			square.setPiece(whitePawn);
                			whitePieces.add(whitePawn);
                		}
                		else if(i==0){
                			//add black pieces
                			String side = "black";
                		}
                		else if(i==7){
                			//add white pieces
                			String side = "white";
                		}

                    	chessBoard.add(square);
                	}
            	}
			}
		}); 
	}
	
	public static ArrayList<Piece> getBlackPieces(){
		return blackPieces;
	}
	
	public static ArrayList<Piece> getWhitePieces(){
		return whitePieces;
	}
	

}

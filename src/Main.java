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
	private static String turn = "white"; 
	private static ArrayList<Unit> grid = new ArrayList<Unit>();
	public static ArrayList<Location> locations = new ArrayList<Location>();
	
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
                			if(j==0 || j == 7){
                				Rook blackRook = new Rook(loc, "black");
                    			square.setPiece(blackRook);
                    			whitePieces.add(blackRook);
                			}
                			if(j==1 || j == 6){
                				Knight blackKnight = new Knight(loc, "black");
                    			square.setPiece(blackKnight);
                    			blackPieces.add(blackKnight);
                			}
                			if(j==2 || j == 5){
                				Bishop blackBishop = new Bishop(loc, "black");
                    			square.setPiece(blackBishop);
                    			blackPieces.add(blackBishop);
                			}
                			if(j==3){
                				King blackKing = new King(loc, "black");
                    			square.setPiece(blackKing);
                    			whitePieces.add(blackKing);
                			}
                			if(j==4){
                				Queen blackQueen = new Queen(loc, "black");
                    			square.setPiece(blackQueen);
                    			whitePieces.add(blackQueen);
                			}

                		}
                		else if(i==7){
                			//add white pieces
                			String side = "white";
                			if(j==0 || j == 7){
                				Rook whiteRook = new Rook(loc, "white");
                    			square.setPiece(whiteRook);
                    			whitePieces.add(whiteRook);
                			}
                			if(j==1 || j == 6){
                				Knight whiteKnight = new Knight(loc, "white");
                    			square.setPiece(whiteKnight);
                    			whitePieces.add(whiteKnight);
                			}
                			if(j==2 || j == 5){
                				Bishop whiteBishop = new Bishop(loc, "white");
                    			square.setPiece(whiteBishop);
                    			whitePieces.add(whiteBishop);
                			}
                			if(j==3){
                				King whiteKing = new King(loc, "white");
                    			square.setPiece(whiteKing);
                    			whitePieces.add(whiteKing);
                			}
                			if(j==4){
                				Queen whiteQueen = new Queen(loc, "white");
                    			square.setPiece(whiteQueen);
                    			whitePieces.add(whiteQueen);
                			}
                		}
                		grid.add(square);
                		locations.add(loc);
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
	
	public static String getTurn(){
		return turn;
	}

	public static void setTurn(String newTurn){
		turn = newTurn;
	}
	
	public static ArrayList<Unit> getGrid(){
		return grid;
	}
	
	public static ArrayList<Location> getLocations(){
		return locations;
	}
	
	
}

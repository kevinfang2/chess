import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;



public class Main extends JPanel implements MouseListener{
  private JButton[][] chessBoardSquares = new JButton[8][8];
  private Grid board = new Grid();
  
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
                	}
                	else if(i==6){
                		Pawn whitePawn = new Pawn(loc, "white");
                		square.setPiece(whitePawn);
                	}

                    chessBoard.add(square);
                }
            }

        }
    }); 
  }

  
  
@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	
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

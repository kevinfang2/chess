
public class Grid {
	public Location[][] grid = new Location[8][8];
	
	public Grid(){
		for (int x=0; x<8; x++){
			for (int y=0; y<8; y++){
				grid[x][y] = new Location(x,y);
			}
		}
	}
	
}

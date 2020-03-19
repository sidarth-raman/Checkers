package checkers;

public class pieces {
	int xcoor;
	int ycoor;
	Boolean king;
	String player;
	
	public pieces(int a, int b, Boolean c, String d) {
		xcoor = a;
		ycoor = b;
		king = c;
		player = d;
	}
	public int getXcoor() {
		return xcoor;
	}
	public int getYcoor() {
		return ycoor;
	}
	public Boolean getKing() {
		return king;
	}
	public String getPlayer() {
		return player;
	}
	public void setXcoor(int a) {
		xcoor = a;
	}
	public void setYcoor(int b) {
		ycoor = b;
	}
	public void setKing(Boolean c) {
		king = c;
	}
	public void setPlayer(String d) {
		player = d;
	}
	public String toString() {
		if(player=="W" | player =="B" |  player =="K" |  player =="Q") {
			
			return player + " ";
			
		}else{
			return "- ";
		}
	
		
	}
	
		
}

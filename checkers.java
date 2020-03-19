//Sidarth Raman

package checkers;

import java.util.*;

public class checkers {
	
	public static int whitepieces = 12;
	public static int blackpieces = 12;


	public static void main (String [] args) {
		
		Scanner Input = new Scanner(System.in);
		
		pieces[][] board = new pieces[8][8];
		
		for(int a = 1; a<=7; a+=2) {
			board[0][a] = new pieces(a, 0, false, "W");
			board[0][a-1] = new pieces(a, 0, false, "-");
			board[2][a] = new pieces(a, 2, false, "W");
			board[2][a-1] = new pieces(a, 2, false, "-");
		}
		for(int a = 1; a<=7; a+=2) {
			board[1][a-1] = new pieces(a, 1, false, "W");
			board[1][a] = new pieces(a, 1, false, "-");
		}
		for(int a = 1; a<=7; a+=2) {
			board[6][a] = new pieces(a, 6, false, "B");
			board[6][a-1] = new pieces(a, 6, false, "-");
		}
		for(int a = 1; a<=7; a+=2) {
			board[5][a-1] = new pieces(a, 5, false, "B");
			board[5][a] = new pieces(a, 5, false, "-");
			board[7][a-1] = new pieces(a, 7, false, "B");
			board[7][a] = new pieces(a, 7, false, "-");
		}
		for(int b=0; b<=7; b++) {
			board[3][b] = new pieces(b, 3, false, "- ");
			board[4][b] = new pieces(b, 4, false, "- ");
			
		}

				board[3][4] = new pieces(4, 3, false, "B");

		
		System.out.println("Player W: Start the game!");
		printboard(board, -1, -1);

		
	}public static void printboard(pieces[][] board, int defaultX, int defaultY) {
		
		Scanner Input = new Scanner(System.in);
		
			
		System.out.println("  0 1 2 3 4 5 6 7" + '\n' + "0 " + board [0][0]+ board[0][1]+board[0][2]+board[0][3]+board[0][4]+board[0][5]+board[0][6]+board[0][7]
				+ '\n' + "1 " + board [1][0]+ board[1][1]+board[1][2]+board[1][3]+board[1][4]+board[1][5]+board[1][6]+board[1][7]
				+ '\n' + "2 " + board [2][0]+ board[2][1]+board[2][2]+board[2][3]+board[2][4]+board[2][5]+board[2][6]+board[2][7]
				+ '\n' + "3 " + board [3][0]+ board[3][1]+board[3][2]+board[3][3]+board[3][4]+board[3][5]+board[3][6]+board[3][7]
				+ '\n' + "4 " + board [4][0]+ board[4][1]+board[4][2]+board[4][3]+board[4][4]+board[4][5]+board[4][6]+board[4][7]
				+ '\n' + "5 " + board [5][0]+ board[5][1]+board[5][2]+board[5][3]+board[5][4]+board[5][5]+board[5][6]+board[5][7]
				+ '\n' + "6 " + board [6][0]+ board[6][1]+board[6][2]+board[6][3]+board[6][4]+board[6][5]+board[6][6]+board[6][7]
				+ '\n' + "7 " + board [7][0]+ board[7][1]+board[7][2]+board[7][3]+board[7][4]+board[7][5]+board[7][6]+board[7][7]);
			int x = defaultX;
			int y = defaultY;
			if(x == -1 && y == -1){
				System.out.println("What are the coordinates of the piece you want to move(x,y)?");
				x = Input.nextInt();
				y = Input.nextInt();
				if(x>7 | x<0 | y>7 | y<0) {
					System.out.println("Not a valid piece.");
					printboard(board, -1, -1);
				
				}
				if(board[y][x].getPlayer()!="W" && board[y][x].getPlayer()!="B" && board[y][x].getPlayer()!="K" && board[y][x].getPlayer()!="Q"){
					System.out.println("Not a valid piece.");
					printboard(board, -1, 1);
				}
			}

			System.out.println("Where do you want to move this piece(x,y)?");
			int xf = Input.nextInt();
			int yf = Input.nextInt();
			if(xf>7 | xf<0 | yf>7 | yf<0) {
				System.out.println("Out of bounds");
				printboard(board, -1, -1);
			
			}
			System.out.println(board[yf][xf].getYcoor());
			System.out.println(board[yf][xf].getPlayer());
			System.out.println(board[y][x].getPlayer());
			if(yf == 0 && board[y][x].getPlayer() == "B") {
				board[y][x].setKing(true);
				board[y][x].setPlayer("K");
				System.out.println("K represents a King piece for the B team");
			}

			if(yf == 7 && board[y][x].getPlayer() == "W") {
				board[y][x].setKing(true);
				board[y][x].setPlayer("Q");
				System.out.println("Q represents a King piece for the W team");
			}

			move(x, y, xf, yf, board);

	}
	
	public static void move(int x, int y, int xf, int yf, pieces[][] board){
	
		Scanner Input = new Scanner(System.in);
		
		if (Math.abs(xf-x) != 1) {
			if(Math.abs(yf-y)!=Math.abs(xf-x)) {
				System.out.println("This move is invalid try again");
				printboard(board, -1, -1);
			}
			

			if (Math.abs(xf-x) != 2) {
				System.out.println("This move is invalid, try again.");
				printboard(board, -1, -1);
			}
			else {
				if(board[yf][xf].getPlayer() == "W" | board[yf][xf].getPlayer() == "B") {
					System.out.println("Not a valid move, try again!");
					printboard(board, -1, -1);
				}
				if(board[y][x].getPlayer()=="W"){
				if(board[((yf+y)/2)][((xf+x)/2)].getPlayer()=="B" ) {
					blackpieces--;
					if(blackpieces <= 0){
						System.out.println("The white team wins! GAME OVER");
					}else{
					board[((yf+y)/2)][((xf+x)/2)].setPlayer("- ");
					board[yf][xf].setPlayer(board[y][x].getPlayer());
					board[y][x].setPlayer("- ");
					int a = xf;
					int b = yf;
					King(x, y, xf, yf, board);
					System.out.println("Would you like to move the same piece again? 1 - Yes 2 - No");
					int answer = Input.nextInt();
					if(answer==1) {
						System.out.println("Your turn again!");
						King(x, y, xf, yf, board);
						printboard(board, xf, yf);
						if(board[((yf+y)/2)][((xf+x)/2)].getPlayer()!="W"|board[((yf+y)/2)][((xf+x)/2)].getPlayer()!="B" | Math.abs(yf-y)!=2 | Math.abs(xf-x)!=2) {
							System.out.println("This move does not work. Next player's turn");
							printboard(board, -1, -1);
							if(x!=a | y!=b) {
								System.out.println("Invalid move, next player's turn");
								printboard(board, -1, -1);
							}
						}
						
						if(x!=a && y!=b) {
							System.out.println("This move is invalid.");
							System.out.println("Would you like to move the same piece again? 1 - Yes 2 - No");
							if(answer==1) {
								System.out.println("Your turn again!");
								King(x, y, xf, yf, board);
								printboard(board, xf, yf);
								if(x!=a | y!=b) {
									System.out.println("Invalid move, next player's turn");
									printboard(board, -1, -1);
								}
								if(board[((yf+y)/2)][((xf+x)/2)].getPlayer()!="W"|board[((yf+y)/2)][((xf+x)/2)].getPlayer()!="B" | Math.abs(yf-y)!=2 | Math.abs(xf-x)!=2) {
									System.out.println("This move does not work. Next player's turn");
									printboard(board, -1, -1);
								}
								}
							else {
								System.out.println("Next players turn!");
								King(x, y, xf, yf, board);
								printboard(board, -1, -1);
							}
							
						}
						
						
					}else {
						System.out.println("Next players turn!");
						King(x, y, xf, yf, board);
						printboard(board, -1, -1);
					}
					printboard(board, -1, -1);
				}
				}else {
					System.out.println("This move is invalid");
				}
				}
				if(board[y][x].getPlayer()=="B") {
					if(board[((yf+y)/2)][((xf+x)/2)].getPlayer()=="W" ) {
						whitepieces--;
						if(whitepieces <= 0){
							System.out.println("The black team wins! GAME OVER");
						} else {
						board[((yf+y)/2)][((xf+x)/2)].setPlayer("- ");
						board[yf][xf].setPlayer(board[y][x].getPlayer());
						board[y][x].setPlayer("- ");
						int a = x;
						int b = y;
						King(x, y, xf, yf, board);
						System.out.println("Would you like to move the same piece again? 1 - Yes 2 - No");
						int answer = Input.nextInt();
						if(answer==1) {
							
							System.out.println("Your turn again!");
							King(x, y, xf, yf, board);
							printboard(board, xf, yf);
							if(x!=a | y!=b) {
								System.out.println("Invalid move, next player's turn");
								printboard(board, -1, -1);
								if(board[((yf+y)/2)][((xf+x)/2)].getPlayer()!="W"|board[((yf+y)/2)][((xf+x)/2)].getPlayer()!="B" | Math.abs(yf-y)!=2 | Math.abs(xf-x)!=2) {
									System.out.println("This move does not work. Next player's turn");
									printboard(board, -1, -1);
								}
							}
							
							
							if(x!=a && y!=b) {
								System.out.println("This move is invalid.");
								
								System.out.println("Would you like to move the same piece again? 1 - Yes 2 - No");
								if(answer==1) {
									System.out.println("Your turn again!");
									King(x, y, xf, yf, board);
									printboard(board, xf, yf);
									if(x!=a | y!=b) {
										System.out.println("Invalid move, next player's turn");
										printboard(board, -1, -1);
									}
									if(board[((yf+y)/2)][((xf+x)/2)].getPlayer()!="W"|board[((yf+y)/2)][((xf+x)/2)].getPlayer()!="B" | Math.abs(yf-y)!=2 | Math.abs(xf-x)!=2) {
										System.out.println("This move does not work. Next player's turn");
										printboard(board, -1, -1);
									}
									}
								else {
									System.out.println("Next players turn!");
									King(x, y, xf, yf, board);
									printboard(board, -1, -1);
								}
								
							}
							
							
						}else {
							System.out.println("Next player's turn.");
						printboard(board, -1, -1);
						}
					}
					}else {
						System.out.println("This move is invalid.  Next player's turn.");
						printboard(board, -1, -1);
					}
					
				}
			}
		}
		else {
			if(Math.abs(yf-y)!=Math.abs(xf-x)) {
				System.out.println("This move is invalid try again");
				printboard(board, -1, -1);
			}
			if(board[y][x].getPlayer()=="W") {
				if(board[y][x].getKing()==false) {
					if(yf<y) {
						System.out.println("This move is invalid, try again.");
						printboard(board, -1, -1);
					}
			}
			
			}
			if(board[y][x].getPlayer()=="B") {
				if(board[y][x].getKing()==false) {
					if(yf>y) {
						System.out.println("This move is invalid, try again.");
						printboard(board, -1, -1);
					}
			}
			
			}
			
			if (Math.abs(yf-y) != 1) {
				
				if (Math.abs(yf-y) == 2) {
					System.out.println("This move is invalid");
					printboard(board, -1, -1);
				}
			
				}
			else {
				
				board[yf][xf].setPlayer(board[y][x].getPlayer());
				board[y][x].setPlayer("- ");
				King(x, y, xf, yf, board);
				printboard(board, -1, -1);
				
				}
			}
		
		
		
	}
			public static void King(int x, int y, int xf, int yf, pieces board[][]){
				
				
				if(board[yf][xf].getPlayer()=="W") {
					System.out.println(board[yf][xf].getYcoor());
					if(board[yf][xf].getYcoor()==7) {
						System.out.println("This is it");
						board[yf][xf].setKing(true);
						board[yf][xf].setPlayer("K");
						
						System.out.println("K represents a King piece for the W team");
					}
						
				if(board[yf][xf].getPlayer()=="B") {
					System.out.println(board[yf][xf].getYcoor());
					if(board[yf][xf].getYcoor()==0) {
						System.out.println("This is it");
						board[yf][xf].setKing(true);
						board[yf][xf].setPlayer("Q");
						System.out.println("Q represents King piece for the B team");
					}
				}
					}

				}
			
}


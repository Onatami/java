package Battleship;
import java.util.Scanner;
import java.util.Arrays;	
import java.util.Random;



public class Battleship_class {
	private static Scanner input;
	public static int NUMBER_OF_PLAYERS = 2;
	public static int NUMBER_OF_SHIPS = 6;
	public static int SIZE_OF_SHIPS = 5;
	public static int NUMBER_OF_COLUMNS = 20;
	public static int NUMBER_OF_ROW = 20;
	public static int EMPTY = -1;
	public static int MISS = 0;
	public static int HIT = 1;
	public static int SHIP = 2;
	public static int SHOTS = 100;
	public static int CARRIER = 5;
	public static int BATTLESHIP = 4;
	public static int SUBMARRINE = 2;
	
	
	// Main method for describing the board, ships, and shot method
	public static void main(String[] args) {
		int[][] board = new int[NUMBER_OF_ROW][NUMBER_OF_COLUMNS];
		int[][] ships = new int[NUMBER_OF_SHIPS][NUMBER_OF_PLAYERS];
		int[] shoot = new int[2];
		int attempts=0,
			shotHit=0;
	
		initBoard(board);
		initShips(ships);
		
		System.out.print("\n");
		
		
	//Displays board, ship locations, shot outcome, until all ships are hit	
		do {
			showBoard(board);
			shoot(shoot);
			attempts++;
			SHOTS--;
			System.out.println("You have " + SHOTS + " left. Don't mess up.");
			
			if(hit(shoot,ships)) {
				hint(shoot,ships,attempts);
			}
			else
				hint(shoot,ships,attempts);
			
			if(SHOTS == 0)
			break;
			
			changeboard(shoot,ships,board);
			
		}while(shotHit!=5);
		
		if(SHOTS == 0)
			System.out.println("Why you lose??");
		else
			
		System.out.print("\n\n\nBattleship Java game finished! You hit 5 ships in "+attempts+" attempts");
		showBoard(board);
	}
	
	
	
	
	// Nested For Loop. Populating all columns and rows. Creates new game.
	public static void initBoard(int[][] board) {
		for(int row=0 ; row < NUMBER_OF_ROW ; row++)
			for(int column=0 ; column < NUMBER_OF_COLUMNS ; column++ )
				board[row][column]=EMPTY;
	}
	
	
	// Details on on the board ( how many columns, what inhabits each space)
	public static void showBoard(int[][] board) {
		System.out.print("   1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20");
		System.out.print("\n");
		
		for(int row=0 ; row < NUMBER_OF_ROW ; row++) {
			System.out.print((row+1));
			for(int column=0 ; column < NUMBER_OF_COLUMNS ; column++) {
				if(board[row][column]==EMPTY) {
					System.out.print("  "+"-");
				}else if(board[row][column]==MISS) {
					System.out.print("  "+"*");
				}else if(board[row][column]==HIT) {
					System.out.print("  "+"X");
				} else if(board[row][column]==SHIP) {
					System.out.print("  "+"S");
				}
			}
			System.out.print("\n");
		}
	}
	
	//Method for spawning X amount of ships in x,y location
	public static void initShips(int[][] ships) {
		Random random = new Random();
		
		for(int ship=0 ; ship < NUMBER_OF_SHIPS ; ship++) {
			ships[ship][0]=random.nextInt(NUMBER_OF_ROW);
			ships[ship][1]=random.nextInt(NUMBER_OF_COLUMNS);
			
			for(int last=0 ; last < ship ; last++) {
				if( (ships[ship][0] == ships[last][0])&&(ships[ship][1] == ships[last][1]) )
					do {
						ships[ship][0]=random.nextInt(NUMBER_OF_ROW);
						ships[ship][1]=random.nextInt(NUMBER_OF_COLUMNS);
					}while( (ships[ship][0] == ships[last][0])&&(ships[ship][1] == ships[last][1]) );
				
				}
			}
		}
	
	//Method for user input for shot location.
	public static void shoot(int[] shoot) {
		input = new Scanner(System.in);
		
		System.out.print("Row:  ");
		shoot[0] = input.nextInt();
		shoot[0]--;
		
		System.out.print("Column:  ");
		shoot[1] = input.nextInt();
		shoot[1]--;
		
	}
	
	//Method for showing your shot and whether you hit the ship or missed.
	public static boolean hit(int[] shoot, int[][] ships) {
		
		for(int ship=0 ; ship<ships.length ; ship++) {
			if( shoot[0]==ships[ship][0] && shoot[1]==ships[ship][1]) {
				System.out.printf("You hit a ship located in (%d,%d)\n",shoot[0]+1,shoot[1]+1);
				return true;
			}
		}
		return false;
	}
	
	//Method for showing a hint if you miss on your shot.
	public static void hint(int[] shoot, int[][] ships, int attempt) {
		int row=0,
			column=0;
		
		for(int line=0 ; line < ships.length ; line++) {
			if(ships[line][0]==shoot[0])
				row++;
			if(ships[line][1]==shoot[1])
				column++;
		}
		
		System.out.printf("\nHint %d: \nRow %d -> %d ships\n" + "Column %d -> %d ships\n",attempt,shoot[0]+1,row,shoot[1]+1,column);
	}
	
	//Method for re-drawing the board after a shot has been taken.
	private static void changeboard (int[] shoot, int[][] ships, int[][] board) {
		if(hit(shoot,ships))
			board[shoot[0]][shoot[1]]=HIT;
		else
			board[shoot[0]][shoot[1]]=MISS;
		
	}
		
}



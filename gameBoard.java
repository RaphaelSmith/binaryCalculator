import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class gameBoard {
	//global variable to store the number of rows and columns on the board
	int gridColumn, gridRow = 0;
	//global variables to store the boat position
	int boatColumn, boatRow = 0; 
	//global variable to store the grid elements
	String [][] grid;
	int [] realBoat= new int [gridColumn/3];
	//Board letters for the rows
	String [] rowLetters = {" 1"," 2"," 3"," 4"," 5"," 6"," 7"," 8"," 9","10","11","12","13",
							"14","15","16","17","18","19","20","21","22","23","24","25","26"};
	player P1 = new player();
	player P2 = new player();
	player P3 = new player();
	player P4 = new player();
	public gameBoard(){
		
		//createPlayers();
		askUser();
		createGrid();
		createBoat();
		runningGame();
		//check score and print it out
		
	}
	public void askUser() {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String tempRow ="";
		String tempCol ="";
		
		do {
			try {
		System.out.println("Type the number of rows: ");
			tempRow = input.readLine();
		}catch (Exception e) { System.out.println("Invalid Input " +  e );}
			}while(!tempRow.matches("[0-9]+"));
			gridRow = Integer.parseInt(tempRow);
		
		do {
			try {
		System.out.println("Type the number of columns: ");
			tempCol = input.readLine();
		}catch (Exception e) { System.out.println("Invalid Input " +  e );}
			}while(!tempCol.matches("[0-9]+"));
			gridColumn = Integer.parseInt(tempCol);
		
		grid = new String[gridRow][gridColumn];
		
	}
	
	public void createGrid() {
				
		for(int i = 0;i<gridRow;i++) {
			// add number to rows	toPrint+= (i+1); 
			for(int j = 0;j<gridColumn;j++) {
				grid [i][j] =  "_|";			
				 
				} 
	}
		printGrid();
	}
	
	@Override //probably not gonna use this one
	public String toString() {
				
		String toPrint = "";
		
	for(int i = 0;i<gridRow;i++) {
		
		for(int j = 0;j<gridColumn;j++) {
			grid [i][j]= "_|";			
			toPrint = toPrint + grid[i][j];
			} 
		toPrint+="\n";
			}
		return toPrint;	
		
	}
	
public boolean checkFire(int a, int b) {
	if((a - 1)== boatRow && (b - 1)==boatColumn) {
		return true;
	}else {
	return false;}
	
}
public void printGrid() {
	
	System.out.print("  ");
	
	for (int n = 0; n<gridColumn;n++) {
		System.out.print(rowLetters[n]);
	}
	System.out.print("\n");
	for(int i = 0;i<gridRow;i++) {
		 // add number to rows	toPrint+= (i+1); 
		System.out.print(this.rowLetters[i]+ "|");
		for(int j = 0;j<gridColumn;j++) {
			System.out.print(grid [i][j]);			
		} 	
		System.out.print("\n");
	}
}
//################### WORK IN PROGRESS #####################
	public void createPlayers() {
	
	System.out.println("Please choose the number of players (1-4): ");
	Scanner input = new Scanner(System.in);
	int players = input.nextInt();
	
	
	if (players == 1) {
			P1.newPlayer();
			System.out.println("Player One: " + P1.getName());
	
		}else if(players==2){
			P1.newPlayer();
			P2.newPlayer();
			System.out.println("Player One: " + P1.getName() + "\n" + "Player Two: " + P2.getName());
				
		}else if(players==3) {
			P1.newPlayer();
			P2.newPlayer();
			P3.newPlayer();
			System.out.println("Player One: " + P1.getName());
			System.out.println("Player Two: " + P2.getName());
			System.out.println("Player Three: " + P3.getName());

		}else if(players==4) {
			P1.newPlayer();
			P2.newPlayer();
			P3.newPlayer();
			P4.newPlayer();
			System.out.println("Player One: " + P1.getName());
			System.out.println("Player Two: " + P2.getName());
			System.out.println("Player Three: " + P3.getName());
			System.out.println("Player Four: " + P4.getName());
	}else {
	System.out.println("Wrong number of players!");
	createPlayers();
}
}
	public void createBoat() {
		
		Random random = new Random();//create random object
		
		int randColumn = random.nextInt(gridColumn);//generate a random column number
		boatColumn =randColumn;
		
		int randRow = random.nextInt(gridRow);//generate a random row number
		boatRow = randRow;
		
		
	}
	
	public void runningGame() {
				
		do {
		P1.playerFire();
		System.out.println("You selected row " +P1.getRow()  + " and column " + P1.getColumn() + "!");
		
			checkFire(P1.getRow(), P1.getColumn());
			if (grid[P1.getRow()-1][P1.getColumn()-1].contains("M")) {
				System.out.println("Already fired there. Try again!");
				runningGame();
			}
			if (checkFire(P1.getRow(), P1.getColumn()) == true) {
				System.out.println("You've hit the boat!");
				grid[boatRow][boatColumn] = "H|";
				
			} 
			else {
				System.out.println("Miss!");
				grid[P1.getRow() - 1][P1.getColumn() - 1] = "M|";
			}
			printGrid();
		} while ((P1.row -1 != boatRow) || (P1.column -1 != boatColumn));
	}
	// HAVE TO CREATE SCORE COUNTING AND HAVE TO CHECK FOR REPEATED PLAY
	
	//################ TEMPORARY MAIN METHOD - FOR TEST ONLY###########3
	

}

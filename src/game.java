import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
class game {
	
	static ArrayList<Integer>playerpositions =new ArrayList<Integer>();
	
	static ArrayList<Integer>cpupositions =new ArrayList<Integer>();
	
	public static void placePiece(int x,char[][] gameboard,String user) {                 // for placing "x" on gameboard
		char i=' ';
		if (user.equals("player")) {
			i='x';
			playerpositions.add(x);
		}else if (user.equals("cpu")) {
			i='o';
			cpupositions.add(x);
			
		}
		switch(x) {
		case 1:
			gameboard[0][0]=i;
			break;
		case 2:
			gameboard[0][2]=i;
			break;
		case 3:
			gameboard[0][4]=i;
			break;
		case 4:
			gameboard[2][0]=i;
			break;
		case 5:
			gameboard[2][2]=i;
			break;
		case 6:
			gameboard[2][4]=i;
		case 7:
			gameboard[4][0]=i;
			break;
		case 8:
			gameboard[4][2]=i;
			break;
		case 9:
			gameboard[4][4]=i;
			break;
		default:
			break;
			
	
	}
		
	}
	
	public static void printGameBoard(char[][] array) {               //for printing out the board
		for (char[] row:array) {
			for (char c:row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
	
	public static String checkWinner() {
		List topRow = Arrays.asList(1,2,3);
		List midRow = Arrays.asList(4,5,6);
		List BottomRow = Arrays.asList(7,8,9);
		List leftCol = Arrays.asList(1,4,7);
		List midCol = Arrays.asList(2,5,8);
		List rightCol = Arrays.asList(3,6,9);
		List rightDiagonal = Arrays.asList(1,5,9);
		List leftDiagonal = Arrays.asList(7,5,3);
		
		List<List> winning = new ArrayList<List>();
		winning.add(topRow);
		winning.add(midRow);
		winning.add(BottomRow);
		winning.add(leftCol);
		winning.add(midCol);
		winning.add(rightCol);
		winning.add(rightDiagonal);
		winning.add(leftDiagonal);
		for(List l:winning) {
			if (playerpositions.containsAll(l)){
				return "congrats!! you won.\n\n\n";
			}else if (cpupositions.containsAll(l)){
				return "CPU wins, better luck next time :( \n";
			}else if (   (cpupositions.size()+playerpositions.size()) ==9   ){
				return "its a tie \n";
			}	
		}
		return "";
		
	}
	
	public static void main(String[] args) {

		char[][] gameboard= {{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '}
				};
		
	printGameBoard(gameboard);
	while(true) {
		Scanner var = new Scanner(System.in);
		System.out.println("enter your placement(1-9)");
		int playerplayerPos = var.nextInt();
		while(playerpositions.contains(playerplayerPos)|| cpupositions.contains(playerplayerPos)) {
			System.out.println("position taken ,enter correct position!");
			playerplayerPos = var.nextInt();
			
		}
		placePiece(playerplayerPos,gameboard,"player");
		
		if (checkWinner().length()>0) {
			printGameBoard(gameboard);
			System.out.print(checkWinner());
			break;
		}
		Random rand = new Random();
		int cpuplayerPos= 1+rand.nextInt(9);
		while(playerpositions.contains(cpuplayerPos)|| cpupositions.contains(cpuplayerPos)) {
			cpuplayerPos= 1+rand.nextInt(9);
			
		}
		placePiece(cpuplayerPos,gameboard,"cpu");

		if (checkWinner().length()>0) {
			printGameBoard(gameboard);
			System.out.print(checkWinner());
			break;
		}
		printGameBoard(gameboard);
		System.out.println("cpu placed it at "+cpuplayerPos);
		System.out.print(checkWinner());
		
		}
	}

}

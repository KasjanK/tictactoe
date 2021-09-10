package tictactoe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// creates a board
		char[][] gameBoard = {{' ', ' ', ' '},
						  {' ', ' ', ' '},
						  {' ', ' ', ' '}};
		
		// prints the blank board
		printBoard(gameBoard);
		
		while (true) {
			// player takes a turn
			playerTurn(gameBoard, scanner);	
			
			if (isGameFinished(gameBoard)) {
				System.out.println("Do you want to play again? Press 1 to reset or any key to exit.");
				int option = scanner.nextInt();
				if (option == 1) {
					for (int i = 0; i < gameBoard.length; i++) {
						for (int j = 0; j < gameBoard[i].length; j++) {
							gameBoard[i][j] = ' ';
						}
					}
				} else {
					break;
				}
			};
			
			// computer takes a turn
			computerTurn(gameBoard);
			
			if (isGameFinished(gameBoard)) {
				System.out.println("Do you want to play again? Press 1 to reset or any key to exit.");
				int option = scanner.nextInt();
				if (option == 1) {
					for (int i = 0; i < gameBoard.length; i++) {
						for (int j = 0; j < gameBoard[i].length; j++) {
							gameBoard[i][j] = ' ';
						}
					}
				} else {
					break;
				}
			};
			
			// print the board again after the moves
			printBoard(gameBoard);
		}
		
		}
	private static boolean isGameFinished(char[][] gameBoard) {
		if (hasPlayerWon(gameBoard, 'X')) {
			printBoard(gameBoard);
			System.out.println("Player wins!");
			return true;
		}
		
		if (hasPlayerWon(gameBoard, 'O')) {
			printBoard(gameBoard);
			System.out.println("Computer wins!");
			return true;
		}
		
		
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				if (gameBoard[i][j] == ' ') {
					return false;
				}
			}
		}
		printBoard(gameBoard);
		System.out.println("It's a draw!");
		return true;
	}

	private static boolean hasPlayerWon(char[][] gameBoard, char symbol) {
		if ((gameBoard[0][0] == symbol && gameBoard[0][1] == symbol && gameBoard[0][2] == symbol) ||
			(gameBoard[1][0] == symbol && gameBoard[1][1] == symbol && gameBoard[1][2] == symbol) ||
			(gameBoard[2][0] == symbol && gameBoard[2][1] == symbol && gameBoard[2][2] == symbol) ||
			
			(gameBoard[0][0] == symbol && gameBoard[1][0] == symbol && gameBoard[2][0] == symbol) ||
			(gameBoard[0][1] == symbol && gameBoard[1][1] == symbol && gameBoard[2][1] == symbol) ||
			(gameBoard[0][2] == symbol && gameBoard[1][2] == symbol && gameBoard[2][2] == symbol) ||
			
			(gameBoard[0][0] == symbol && gameBoard[1][1] == symbol && gameBoard[2][2] == symbol) ||
			(gameBoard[0][2] == symbol && gameBoard[1][1] == symbol && gameBoard[2][0] == symbol)) {
			return true;
		}
		return false;
	}

	// random computer turn
	private static void computerTurn(char[][] gameBoard) {
		Random rand = new Random();
		int computerTurn;
		while (true) {
			computerTurn = rand.nextInt(9) + 1;
			if (isValidMove(gameBoard, Integer.toString(computerTurn))) {
				break;
			}
		}
		placeTurn(gameBoard, Integer.toString(computerTurn), 'O');
	}
	
	// checks if the space is available
	private static boolean isValidMove(char[][] gameBoard, String pos) {
		switch(pos) {
		case "1":
			return (gameBoard[0][0] == ' ');
		case "2":
			return (gameBoard[0][1] == ' ');
		case "3":
			return (gameBoard[0][2] == ' ');
		case "4":
			return (gameBoard[1][0] == ' ');
		case "5":
			return (gameBoard[1][1] == ' ');
		case "6":
			return (gameBoard[1][2] == ' ');
		case "7":
			return (gameBoard[2][0] == ' ');
		case "8":
			return (gameBoard[2][1] == ' ');
		case "9":
			return (gameBoard[2][2] == ' ');
		default:
			return false;
		}
	}
		
	// takes player input and puts it on the board
	private static void playerTurn(char[][] gameBoard, Scanner scanner) {
		String input;
		while (true) {
			System.out.println("What is your move? (1-9)");
			input = scanner.nextLine();
			if (isValidMove(gameBoard, input)) {
				break;
			}
			System.out.println(input);
		}
		
		
		placeTurn(gameBoard, input, 'X');
	}

	// places computers turn
	private static void placeTurn(char[][] gameBoard, String pos, char symbol) {
		switch(pos) {
			case "1":
				gameBoard[0][0] = symbol;
				break;
			case "2":
				gameBoard[0][1] = symbol;
				break;
			case "3":
				gameBoard[0][2] = symbol;
				break;
			case "4":
				gameBoard[1][0] = symbol;
				break;
			case "5":
				gameBoard[1][1] = symbol;
				break;
			case "6":
				gameBoard[1][2] = symbol;
				break;
			case "7":
				gameBoard[2][0] = symbol;
				break;
			case "8":
				gameBoard[2][1] = symbol;
				break;
			case "9":
				gameBoard[2][2] = symbol;
				break;
			default:
				System.out.println(":(");
		}
	}

	// prints the board 
	private static void printBoard(char[][] board) {
		System.out.println(" " + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
		System.out.println("-----------");
		System.out.println(" " + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
		System.out.println("-----------");
		System.out.println(" " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
	}
}

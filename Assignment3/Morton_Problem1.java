//Thomas Morton - Tic-Tac-Toe
//Sets text on Jbuttons on a GridLayout as an approach to create a playable game of Tic-Tac-Toe
//Logic for the opponent checks for the first unoccupied tile when the boolean for the opponent's turn is true
//Then sets that tile to the letter not chosen by the player in the dialog window

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Requires PlayerOptions.java for window prompts

public class Morton_Problem1 extends JFrame implements ActionListener {
	boolean opponentsTurn = false;
	String playerLetter;
	String opponentLetter;
	JPanel gameBoard;
	JButton[][] gameTiles;
	int count;

	@Override
	public void actionPerformed(ActionEvent e){} //This is implemented when setting up the buttons

	public void oppTurn(){
		//Checks for the next available tile and fills it with the opponent's letter
		for (int i = 0; i < gameTiles.length; ++i){
			for (int j = 0; j < gameTiles[i].length; ++j){
				if (!gameTiles[i][j].getText().equals(opponentLetter) && !gameTiles[i][j].getText().equals(playerLetter) && opponentsTurn){
					gameTiles[i][j].setText(opponentLetter);
					opponentsTurn = false;
				}
			}
		}
		count++;
	}

	public String checkMoves(){
		String checkTile;

		//Alternates between opponent and player to verify the win
		if (opponentsTurn){
			checkTile = playerLetter;
		}
		else{
			checkTile = opponentLetter;
		}
	
		//This section is gross, but it checks the 8 possible winning conditions
		//I could have used some for loops, but it would have been the same amount of code regardless
		if (gameTiles[0][0].getText().equals(checkTile) && gameTiles[0][1].getText().equals(checkTile) && gameTiles[0][2].getText().equals(checkTile) ||
			gameTiles[1][0].getText().equals(checkTile) && gameTiles[1][1].getText().equals(checkTile) && gameTiles[1][2].getText().equals(checkTile) ||
			gameTiles[2][0].getText().equals(checkTile) && gameTiles[2][1].getText().equals(checkTile) && gameTiles[2][2].getText().equals(checkTile) ||

			gameTiles[0][0].getText().equals(checkTile) && gameTiles[1][0].getText().equals(checkTile) && gameTiles[2][0].getText().equals(checkTile) ||
			gameTiles[0][1].getText().equals(checkTile) && gameTiles[1][1].getText().equals(checkTile) && gameTiles[2][1].getText().equals(checkTile) ||
			gameTiles[0][2].getText().equals(checkTile) && gameTiles[1][2].getText().equals(checkTile) && gameTiles[2][2].getText().equals(checkTile) ||

			gameTiles[0][0].getText().equals(checkTile) && gameTiles[1][1].getText().equals(checkTile) && gameTiles[2][2].getText().equals(checkTile) ||
			gameTiles[2][0].getText().equals(checkTile) && gameTiles[1][1].getText().equals(checkTile) && gameTiles[0][2].getText().equals(checkTile)) {

			return checkTile;	
		}

		if (count == 9){
			return "Cat";
		}

		//Take opponent's turn
		if (opponentsTurn){
			oppTurn();
		}			
		return "";
	}

	//Clears the tile counter, prompts for a new letter selection, then resets the game board
	public void resetGame(){
		count = 0;
		letterSelection();
		remove(gameBoard);
		createBoard();
	}

	public void letterSelection(){
		//Prompts the player for their letter of choice
		PlayerOptions letterDialog = new PlayerOptions();
		playerLetter = letterDialog.getPlayerOption();

		if (playerLetter.equals("X")){
			opponentLetter = "O";
		}
		else {
			opponentLetter = "X";
		}
	}

	public void playAgain(String winner){
		//Prompts the user for another game on completion of the current game
		PlayerOptions newGame = new PlayerOptions();
		boolean playingGame = newGame.winnerDialog(winner);

		if (playingGame == false){
			System.exit(0);
		}
		resetGame();
	}

	public void createBoard() {
		//generates a new game. Revalidates the panel when starting again
		gameBoard = new JPanel();
		gameTiles = new JButton[3][3];
		gameBoard.setLayout(new GridLayout(3,3,1,1));
		add(gameBoard);
		gameBoard.revalidate();

		//creates the buttons for the game and registers their action listeners
		for (int i = 0; i < 3; ++i){
			for (int j = 0; j < 3; ++j){
				final int stubborn_i = i;
				final int stubborn_j = j;
				gameTiles[i][j] = new JButton("");
				gameTiles[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						// If a tile is not occupied by a letter, allows the player to play on that tile
						if (!gameTiles[stubborn_i][stubborn_j].getText().equals(opponentLetter) &&		//This would not let me use a nonfinal int to assign an action listener
							!gameTiles[stubborn_i][stubborn_j].getText().equals(playerLetter)){			//So my solution is to create a temporary final int.
							
							gameTiles[stubborn_i][stubborn_j].setText(playerLetter);				
							
							//tracks the number of times a tile has been selected to end the game after 9 selections
							count++;
							
							//Provides some buffer time to fix a bug with the opponent move not registering
							try {
								Thread.sleep(100);
							}
							catch (InterruptedException exception){
								System.out.println("Something went wrong...\n" +  exception);
							}

							opponentsTurn = true;

							//Calls checkMoves() to verify if a move won the game
							//Calls playAgain() if the game has been won
							if (checkMoves().equals(playerLetter)){
								playAgain(playerLetter);
							}
							else if (checkMoves().equals(opponentLetter)){
								playAgain(opponentLetter);
							}
							else if (checkMoves().equals("Cat")){
								playAgain("Cat");
							}
							
						} 
					}
				});
				//Adds the buttons to the JPanel
				gameBoard.add(gameTiles[i][j]);
			}
		}
	}

	public Morton_Problem1(){
		createBoard();
		checkMoves();
		letterSelection();
	}

	public static void main(String[] args){
		Morton_Problem1 mainWindow = new Morton_Problem1();

		mainWindow.setTitle("Tic-Tac-Toe");
		mainWindow.setSize(300,300);
		mainWindow.setLocationRelativeTo(null);
		mainWindow.setVisible(true);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
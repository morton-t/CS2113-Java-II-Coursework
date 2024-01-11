//Thomas Morton - Sudoku
//Uses a series of textfields in a GridLayout each set into their own GridLayout to allow the player to play Sudoku
//Two for loops randomly remove up to a maximum number of tiles, remaining tiles are set as non-editable
//Game is checked for completion by comparing the player's textfields to the values stored in SudokuQuestion

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Morton_Problem2 extends JFrame{
	final boolean solvePuzzle = false;
	final int[][] sudokuQuestion = new int[][]	{{	4,3,5,6,8,2,1,9,7},			
												{	2,6,9,5,7,1,8,3,4},
												{	7,8,1,4,9,3,5,6,2},
												{	8,2,6,3,7,4,9,5,1},
												{	1,9,5,6,8,2,7,4,3},
												{	3,4,7,9,1,5,6,2,8},
												{	5,1,9,2,4,8,7,6,3},
												{	3,2,6,9,5,7,4,1,8},
												{	8,7,4,1,3,6,2,5,9}};

	public Morton_Problem2(){
		createBoard();
	}

	public void createBoard(){
		//Set panels/textfields/button
		JPanel mainPanel = new JPanel();
		JPanel checkGameProgress = new JPanel();
		JPanel[] gridSubPanels = new JPanel[9];
		JTextField answerField = new JTextField();
		JTextField[][] textFields = new JTextField[9][9];
		JButton checkButton = new JButton("Check");

		GridLayout mainGrid = new GridLayout(3,3,4,4);
		GridLayout subGrid = new GridLayout(3,3,1,1);
		mainPanel.setLayout(mainGrid);
		
		answerField.setHorizontalAlignment(JTextField.CENTER);
		answerField.setEditable(false);

		checkGameProgress.setLayout(new GridLayout(1,2));
		checkGameProgress.add(checkButton);
		checkGameProgress.add(answerField);

		add(mainPanel, BorderLayout.CENTER);
		add(checkGameProgress, BorderLayout.SOUTH);

		//Build text fields for gameboard		
		for (int i = 0; i < 9; ++i){
			gridSubPanels[i] = new JPanel();
			gridSubPanels[i].setLayout(subGrid);
			mainPanel.add(gridSubPanels[i]);

			for (int j = 0; j < 9; ++j){
				textFields[i][j] = new JTextField(12);
				textFields[i][j].setHorizontalAlignment(JTextField.CENTER);
				gridSubPanels[i].add(textFields[i][j]);
			}
		}


		//Register listener for check button
		checkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkBoard(sudokuQuestion, textFields)){
					answerField.setText("You got it!");
				}
				else{
					answerField.setText("Try again!");
				}
			}
		});

		//Ensures the board has at least 21 tiles. Can double as a difficulty setting later.
		int maxTiles = 0;
		while (maxTiles < 21){	
			
			//Fill in tiles at random on the gameboard & disable editing for those tiles
			for(int i = 0; i < 9; ++i){
				for (int j = 0; j < 9; j++){
					maxTiles++;

					textFields[i][j].setText("" + sudokuQuestion[i][j]);
					textFields[i][j].setEditable(false);


					if (!solvePuzzle){//This is for testing the completed board options. Set solvePuzzle to true to autofill the entire board.
						
						//Randomly increments/decrements indices to fill with numbers
						if (Math.random() < .2){			
							i++;
						}
						else if (Math.random() < .3){
							i--;
							j++;
						}
						else if (Math.random() < .6){
							i++;
							j--;
						}
						else if (Math.random() < .8){
							j++;
						}
					}

					//Prevents out-of-bounds due to randomization
					if (i > 8){								
						i = 8;
					}
					if (i < 0){								
						i = 0;
					}
					if (j < 0){
						j = 0;
					}
				}
			}
		}
	}

	//Verifies whether the player solution matches the sudoku question
	public boolean checkBoard(int[][] sudokuQuestion, JTextField[][] textFields){ 
		boolean correct = true;
		for (int i = 0; i < 9; ++i){
			for (int j = 0; j < 9; ++j){
				String checkQ = "" + sudokuQuestion[i][j];
				String checkFields = textFields[i][j].getText();
				if (!checkQ.equals(checkFields)){
					correct = false;
				}
			}
		}
		return correct;
	}

	public static void main(String[] args){
		Morton_Problem2 mainWindow = new Morton_Problem2();

		mainWindow.setTitle("Sudoku");
		mainWindow.setSize(450,450);
		mainWindow.setLocationRelativeTo(null);
		mainWindow.setVisible(true);
		mainWindow.setResizable(false);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
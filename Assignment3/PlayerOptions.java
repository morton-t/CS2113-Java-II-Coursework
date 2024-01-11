import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//This file provides the additional window functionality for problem 1

public class PlayerOptions{
	public String getPlayerOption(){
		String option;
		Object[] choice = new Object[] {"   X   ","   O   "};
		int selection = JOptionPane.showOptionDialog(null, 
													"Which letter would you like to play as?", 
													"Player Select", 
													JOptionPane.DEFAULT_OPTION, 
													JOptionPane.QUESTION_MESSAGE, 
													null, 
													choice, 
													choice[0]);
		
		if (selection == 0){
			option = "X";
		}
		else{
			option = "O";
		}
		return option;
	}

	public boolean winnerDialog(String winner){
		int newGame;
		Object[] choice = new Object[] {"Yes","No"};
		String winnerDialog = winner + " Won! Would you like to play again?";

		int selection = JOptionPane.showOptionDialog(null, 
													 winnerDialog, 
													 "New Game?", 
													 JOptionPane.DEFAULT_OPTION, 
													 JOptionPane.QUESTION_MESSAGE, 
													 null, 
													 choice, 
													 choice[0]);

		if (selection == 0){
			return true;
		}
		return false;
	}
}
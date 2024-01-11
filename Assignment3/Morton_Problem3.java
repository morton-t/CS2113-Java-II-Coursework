//Thomas Morton - Calculator
//Creates a calculator using a series of JButtons on a GridLayout, along with a JTextField as a display window
//Reads the values from a specific button when pressed and writes that value to the textfield
//Parses data from the textfield to a Double to perform the math operations - more details in comments

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Morton_Problem3 extends JFrame implements ActionListener{


	JTextField displayWindow = new JTextField();
	String textDisplay = "";
	String currentNum = "";
	String lastAction = "";
	Double mathOperation = 0.0;
	Double result = 0.0;
	boolean usedDec = false;
	boolean usedSymb = false;
	boolean isNegative = false;

	public void actionPerformed(ActionEvent event){
		//Performs the numeric button actions. It's pretty gross.
		//Stores text output for displayWindow textbox in a string
		//Stores number in a string which is later parsed to a double
		if (event.getActionCommand().equals("9")){
			currentNum += "9";
			textDisplay += "9";
			displayWindow.setText(textDisplay);
		}
		else if (event.getActionCommand().equals("8")){
			currentNum += "8";
			textDisplay += "8";
			displayWindow.setText(textDisplay);
		}
		else if (event.getActionCommand().equals("7")){
			currentNum += "7";
			textDisplay += "7";
			displayWindow.setText(textDisplay);
		}
		else if (event.getActionCommand().equals("6")){
			currentNum += "6";
			textDisplay += "6";
			displayWindow.setText(textDisplay);
		}
		else if (event.getActionCommand().equals("5")){
			currentNum += "5";
			textDisplay += "5";
			displayWindow.setText(textDisplay);
		}
		else if (event.getActionCommand().equals("4")){
			currentNum += "4";
			textDisplay += "4";
			displayWindow.setText(textDisplay);
		}
		else if (event.getActionCommand().equals("3")){
			currentNum += "3";
			textDisplay += "3";
			displayWindow.setText(textDisplay);
		}
		else if (event.getActionCommand().equals("2")){
			currentNum += "2";
			textDisplay += "2";
			displayWindow.setText(textDisplay);
		}
		else if (event.getActionCommand().equals("1")){
			currentNum += "1";
			textDisplay += "1";
			displayWindow.setText(textDisplay);
		}
		else if (event.getActionCommand().equals("0")){
			currentNum += "0";
			textDisplay += "0";
			displayWindow.setText(textDisplay);
		}

		//If a decimal is used, sets a boolean to prevent another decimal from being used
		else if (event.getActionCommand().equals(".")){
			if (!usedDec){
				usedDec = true;	
				currentNum += ".";
				textDisplay += ".";
				displayWindow.setText(textDisplay);
			}
		}

		//Makes the current or next input a negative number; then sets a boolean for the negative sign
		else if (event.getActionCommand().equals("+/-")){
			if (!isNegative){		
				isNegative = true;
				currentNum =  "-" + currentNum;
				if (usedSymb){
					textDisplay = textDisplay + currentNum;
				}
				else {
					textDisplay = currentNum;
				}
				displayWindow.setText(textDisplay);
			}
		}
		//Sets a boolean when a math operation is performed to prevent multiple symbols and unflags the decimal boolean
		//parses the number written in the currentNum string and stores it as Double under mathOperation
		//prints textDisplay to textbox and saves the action performed as a string for the equals button to use in a switch statement
		else if (event.getActionCommand().equals("+")){
			if (!usedSymb && textDisplay.length() > 0){
				usedSymb = true;
				usedDec = false;
				isNegative = false;
				lastAction = "add";

				mathOperation = Double.parseDouble(currentNum);
				currentNum = "";

				textDisplay += " + ";
				displayWindow.setText(textDisplay);
			}
		}
		else if (event.getActionCommand().equals("-")){
			if (!usedSymb && textDisplay.length() > 0){
				usedSymb = true;
				isNegative = false;
				usedDec = false;
				lastAction = "sub";
				
				mathOperation = Double.parseDouble(currentNum);
				currentNum = "";

				textDisplay += " - ";
				displayWindow.setText(textDisplay);
			}
		}
		else if (event.getActionCommand().equals("×")){
			if (!usedSymb && textDisplay.length() > 0){
				usedSymb = true;
				isNegative = false;
				usedDec = false;
				lastAction = "mult";

				mathOperation = Double.parseDouble(currentNum);
				currentNum = "";

				textDisplay += " × ";
				displayWindow.setText(textDisplay);
			}
		}
		else if (event.getActionCommand().equals("÷")){
			if (!usedSymb && textDisplay.length() > 0){
				usedSymb = true;
				usedDec = false;
				isNegative = false;
				lastAction = "div";

				mathOperation = Double.parseDouble(currentNum);
				currentNum = "";

				textDisplay += " ÷ ";
				displayWindow.setText(textDisplay);
			}
		}

		//Unflags the booleans for math operations and decimals
		//Uses the stored string for lastAction to determine which operation to perform
		//Parses the number stored in currentNum as a Double and performs the action stored in lastAction
		//Prints answer to displayWindow textbox and updates the strings that store the input
		else if (event.getActionCommand().equals("=") && !currentNum.equals("")){
			usedSymb = false;
			switch (lastAction){
				case "add":
					result = mathOperation + Double.parseDouble(currentNum);
					currentNum = "" + result;
					break;
				case "sub":
					result = mathOperation - Double.parseDouble(currentNum);
					currentNum = "";
					break;
				case "mult":
					result = mathOperation * Double.parseDouble(currentNum);
					currentNum = "";
					break;
				case "div":
					result = mathOperation / Double.parseDouble(currentNum);
					currentNum = "";
					break;
				default:
					result = Double.parseDouble(currentNum);
					break;
			}
			lastAction = "";
			displayWindow.setText(result.toString());
			currentNum = "" + result;
			textDisplay = "" + result;

			if (result < 0){
				isNegative = true;
			}
		}

		//Clears all stored values in the calculator
		else if (event.getActionCommand().equals("C")){
			mathOperation = 0.0;
			currentNum = "";
			textDisplay = "";
			lastAction = "";
			usedSymb = false;
			usedDec = false;
			isNegative = false;
			displayWindow.setText(textDisplay);
		}
		else if (event.getActionCommand().equals("CE")){
			currentNum = "";
			textDisplay = "";
			lastAction = "";
			usedSymb = false;
			usedDec = false;
			isNegative = false;
			displayWindow.setText(textDisplay);
		}
	}
	

	public void createDisplay(){
		JPanel gridPanel = new JPanel();

		gridPanel.setLayout(new GridLayout(5,4,1,1));

		//Create calculator buttons
		JButton btn9 = new JButton("9");
		JButton btn8 = new JButton("8");
		JButton btn7 = new JButton("7");
		JButton btn6 = new JButton("6");
		JButton btn5 = new JButton("5");
		JButton btn4 = new JButton("4");
		JButton btn3 = new JButton("3");
		JButton btn2 = new JButton("2");
		JButton btn1 = new JButton("1");
		JButton btn0 = new JButton("0");
		JButton btnC = new JButton("C");
		JButton btnEQ = new JButton("=");
		JButton btnAdd = new JButton("+");
		JButton btnSub = new JButton("-");
		JButton btnMult = new JButton("×");
		JButton btnDiv = new JButton("÷");
		JButton btnDec = new JButton(".");
		JButton btnNeg = new JButton("+/-");
		JButton btnCE = new JButton("CE");

		//Add buttons to grid
		gridPanel.add(btnDiv);
		gridPanel.add(btn9);
		gridPanel.add(btn8);
		gridPanel.add(btn7);

		gridPanel.add(btnMult);
		gridPanel.add(btn6);
		gridPanel.add(btn5);
		gridPanel.add(btn4);

		gridPanel.add(btnAdd);
		gridPanel.add(btn3);
		gridPanel.add(btn2);
		gridPanel.add(btn1);
		
		gridPanel.add(btnSub);
		gridPanel.add(btnDec);
		gridPanel.add(btn0);
		gridPanel.add(btnNeg);		

		gridPanel.add(btnEQ);
		gridPanel.add(btnC);
		gridPanel.add(btnCE);
		
		//Add listeners to buttons
		btn9.addActionListener(this);
		btn8.addActionListener(this);
		btn7.addActionListener(this);
		btn6.addActionListener(this);
		btn5.addActionListener(this);
		btn4.addActionListener(this);
		btn3.addActionListener(this);
		btn2.addActionListener(this);
		btn1.addActionListener(this);
		btn0.addActionListener(this);
		btnAdd.addActionListener(this);
		btnSub.addActionListener(this);
		btnMult.addActionListener(this);
		btnDiv.addActionListener(this);
		btnC.addActionListener(this);
		btnEQ.addActionListener(this);
		btnDec.addActionListener(this);
		btnNeg.addActionListener(this);
		btnCE.addActionListener(this);

		//Change displayWindow settings
		Font font = new Font("Calibri", Font.BOLD, 36);
		displayWindow.setHorizontalAlignment(JTextField.RIGHT);
		displayWindow.setFont(font);
		displayWindow.setEditable(false);
		displayWindow.setPreferredSize(new Dimension(50, 70));

		//Add gridPanel and displayWindow to mainWindow
		add(displayWindow, BorderLayout.NORTH);
		add(gridPanel, BorderLayout.CENTER);
		add(displayWindow, BorderLayout.NORTH);
	}
	
	public Morton_Problem3(){
		createDisplay();
	}

	public static void main(String[] args){
		Morton_Problem3 mainWindow = new Morton_Problem3();

		mainWindow.setTitle("Calculator");
		mainWindow.setSize(400,500);
		mainWindow.setVisible(true);
		mainWindow.setResizable(false);
		mainWindow.setLocationRelativeTo(null);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
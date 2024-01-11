//Thomas Morton - Simple GUI
//Creates two textfields, one non-editable, to prompt the user for input
//Uses ActionListener to open a new window titled with the text from the input field

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Morton_Problem4 implements ActionListener{
	

	public Morton_Problem4(){
		JFrame mainWindow = new JFrame("Morton_Problem4");
		JButton nameWindow = new JButton("Open Window");
		JTextField nameField = new JTextField();
		JTextField userPrompt = new JTextField();

		userPrompt.setText("Enter a name:");
		userPrompt.setEditable(false);

		nameWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event){
				openWindow(nameField.getText());
			}
		});

		mainWindow.add(userPrompt, BorderLayout.WEST);
		mainWindow.add(nameWindow, BorderLayout.SOUTH);
		mainWindow.add(nameField, BorderLayout.CENTER);

		mainWindow.setSize(300,100);
		mainWindow.setLocationRelativeTo(null);
		mainWindow.setVisible(true);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainWindow.revalidate();
	}
	@Override
	public void actionPerformed(ActionEvent event){}

	public void openWindow(String name){
		String inputText = name;
		JFrame newWindow = new JFrame(inputText);
		newWindow.setSize(300,200);
		newWindow.setLocationRelativeTo(null);
		newWindow.setVisible(true);
		newWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args){
		new Morton_Problem4();
	}
}
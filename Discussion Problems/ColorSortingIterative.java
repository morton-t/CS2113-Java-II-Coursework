/*
While loop replaces the recursive calls by iteratively checking the 0th entry of list.
As long as there are still Strings in the given ArrayList, the 0th element will be retrieved
from the ArrayList after each pass of the while loop and then added to the proper ArrayList for sorted colors
*/


import java.util.ArrayList;
import java.util.Scanner;

public class ColorSortingIterative {
	
	//Create public ArrayLists for each color of toy
	public static ArrayList<String> toysRed = new ArrayList<String>();
	public static ArrayList<String> toysOrange = new ArrayList<String>();
	public static ArrayList<String> toysYellow = new ArrayList<String>();
	public static ArrayList<String> toysGreen = new ArrayList<String>();
	public static ArrayList<String> toysBlue = new ArrayList<String>();
	public static ArrayList<String> toysPurple = new ArrayList<String>();

	public static void main(String[] args) {
		
		//Create Scanner for user input
		Scanner keyboard = new Scanner(System.in);
		
		//Create a new ArrayList of Strings to hold all the toy colors
		ArrayList<String> toysUnsorted = new ArrayList<String>();
		
		//Fill the toysUnsorted ArrayList with random colors of toys
		for(int i = 0; i<12; ++i)
			toysUnsorted.add(getColor((int)Math.ceil(Math.random()*6)));
		
		//Prompt
		System.out.println("Welcome to Color Sorter. Your list of colors is: " + toysUnsorted.toString() + ".\nPlease press Enter to sort.");
		keyboard.nextLine();
		
		//Sort the toys into separate ArrayLists
		sortColors(toysUnsorted);
		
		//Print the result
		System.out.println("Your colors have been sorted:");
		System.out.println("Red toys: " + toysRed);
		System.out.println("Orange toys: " + toysOrange);
		System.out.println("Yellow toys: " + toysYellow);
		System.out.println("Green toys: " + toysGreen);
		System.out.println("Blue toys: " + toysBlue);
		System.out.println("Purple toys: " + toysPurple);
		System.out.println("Unsorted toys remaining: " + toysUnsorted);
		//Close the scanner
		keyboard.close();
	}
	
	//This returns a color depending on the value of the given number.
	//When called in conjunction with a random number generator, returns a random color.
	public static String getColor(int num) {
		if(num == 1)
			return "Red";
		else if(num == 2)
			return "Orange";
		else if(num == 3)
			return "Yellow";
		else if(num == 4)
			return "Green";
		else if(num == 5)
			return "Blue";
		else
			return "Purple";
	}
	
	//This recursive method sorts a given ArrayList of colors into separate ArrayLists for each color.
	//It only sorts the first element in the list, so it must call itself after an element is deleted.
	//The base case is when the given ArrayList is empty.
	public static void sortColors(ArrayList<String> list) {
		
		/*
		While loop replaces the recursive calls by iteratively checking the 0th entry of list.
		As long as there are still Strings in the given ArrayList, the 0th element will be retrieved
		from the ArrayList after each pass of the while loop and then added to the proper ArrayList for sorted colors
		*/

		while (!list.isEmpty()) { 
			if(list.get(0).equals("Red")) {
				toysRed.add(list.get(0));
				list.remove(0);
			}
			else if(list.get(0).equals("Orange")) {
				toysOrange.add(list.get(0));
				list.remove(0);
			}
			else if(list.get(0).equals("Yellow")) {
				toysYellow.add(list.get(0));
				list.remove(0);
			}
			else if(list.get(0).equals("Green")) {
				toysGreen.add(list.get(0));
				list.remove(0);
			}
			else if(list.get(0).equals("Blue")) {
				toysBlue.add(list.get(0));
				list.remove(0);
			}
			else if(list.get(0).equals("Purple")) {
				toysPurple.add(list.get(0));
				list.remove(0);
			}
		}
		
	}
	
}

import java.io.*;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.ArrayIndexOutOfBoundsException;
import java.lang.NullPointerException;

public class Morton_Problem5{

	public static void displayReview(ReviewEntry[] reviews){
		int indexSearch = -1;
		Scanner scnr = new Scanner(System.in);

		//Prompt the user until 0 is entered
		while (indexSearch != 0){

			//try catch block catches invalid inputs and null data
			try{
				String sentiment;
				System.out.printf("\nSearch for a review entry's SentenceID between 1 and %d or input 0 to exit:", reviews.length);
				indexSearch = scnr.nextInt();

				if (indexSearch == 0){ break;}

				//Outputs data for the selected entry
				System.out.printf("Sentence ID " + reviews[indexSearch - 1].getID() + 
									" has " + reviews[indexSearch - 1].getNumPhrases() +
									" phrases with an average rating of %.3f" +
									". The overall sentiment is " + ReviewEntry.getSentiment(reviews[indexSearch - 1].getScore()) + 
									".\n", reviews[indexSearch - 1].getScore());
			
			}
			catch(ArrayIndexOutOfBoundsException wrongInput){
				System.out.printf("Invalid entry! Please select a number between 0 and %d.\n", reviews.length);
				scnr.nextLine();
			}
			catch(InputMismatchException wrongInput){
				System.out.printf("Invalid entry! Please input a number between 0 and %d.\n", reviews.length);
				scnr.nextLine();
			}
			catch(NullPointerException nullPtr){
				System.out.println("The index you have chosen is empty!");
				scnr.nextLine();
			}
		}
	}

	//Builds the array that stores review data
	public static void buildReviewEntry() throws IOException{
		ReviewEntry[] reviews = new ReviewEntry[8544];

		String filePath = "movieReviews.tsv";					//Filepath for movieReviews goes in this String

		File inputFile = new File(filePath);

		Reader fileIn = new FileReader(inputFile);
		Scanner readInput = new Scanner(fileIn);
		


		//skips the first column of data as it does not contain review information
		readInput.nextLine();


		//Defines the variables that will be used to track and store data in the array
		int previousSentenceID = 1;
		double totalSentiment = 0;
		int numPhrases = 1;
		

		//Iterates through movieReviews until there are no lines to read in
		while (readInput.hasNext()){
			String currentLine = readInput.nextLine();

			//Parses the current line using tabs as a delimiter, then stores each substring into a temporary array
			String[] lineTokens = currentLine.split("\t");

			//Assigns each index to its relevent column name. (Thank you for letting these match up)
			int phraseID = Integer.parseInt(lineTokens[0]);
			int sentenceID = Integer.parseInt(lineTokens[1]);
			String review = lineTokens[2];
			int sentiment = Integer.parseInt(lineTokens[3]);

			
			//If there are no more lines, this block will handle the last line of data
			if (!readInput.hasNext()){

				//If sentence ID's match, then we are looking at the same film review; increment phrases and sum sentiment
				if (previousSentenceID == sentenceID){
					numPhrases++;
					totalSentiment += sentiment;
				}

				//If not, we're looking at a new review; reset sentiment to current review and phrases to 1
				else{
					totalSentiment = sentiment;
					numPhrases = 1;
				}

				//Average the sentiment and append to the array
				totalSentiment /= numPhrases;
				reviews[sentenceID - 1] = new ReviewEntry(sentenceID, totalSentiment, numPhrases);
				break;
			}	

			//If sentence ID's match, then we are looking at the same film review; increment phrases and sum sentiment
			if (previousSentenceID == sentenceID){
				numPhrases++;
				totalSentiment += sentiment;
			}

			//If not, we're looking at a new review; take the stored sentiment total and average it
			//Then append the data to the array and reset values to the new review's sentiment and 1 phrase
			else{
				totalSentiment /= numPhrases;
				reviews[previousSentenceID - 1] = new ReviewEntry(previousSentenceID, totalSentiment, numPhrases);
				totalSentiment = sentiment;
				numPhrases = 1;

			}
			
			//Finished parsing review info; assign current ID to previous and move to the next iteration in the tsv
			previousSentenceID = sentenceID;
		}
		
		//Close our file stream and scanner, then run displayReview() with our built array
		fileIn.close();
		readInput.close();
		displayReview(reviews);
	}
	
	public static void main(String[] args) throws IOException{
		buildReviewEntry();

	}
}
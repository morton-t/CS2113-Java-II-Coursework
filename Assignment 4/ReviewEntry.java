public class ReviewEntry{
	private int sentenceID;
	private double totalScore;
	private int numPhrases;

	ReviewEntry(){
		//Assign obvious false values for default constructor
		this(-999, -999, -999);
	}

	ReviewEntry(int sentenceID, double totalScore, int numPhrases){
		this.sentenceID = sentenceID;
		this.totalScore = totalScore;
		this.numPhrases = numPhrases;
	}

	//Fetch review sentiment
	public static String getSentiment(double totalScore){
		if ( totalScore >= 0 && totalScore < 2){
			return "negative";
		}

		else if (totalScore < 3){
			return "neutral";
		}

		else if (totalScore <= 4){
			return "positive";
		}

		return "not given";
	}


	//Accessors
	public int getID(){
		return sentenceID;
	}
	public double getScore(){
		return totalScore;
	}
	public int getNumPhrases(){
		return numPhrases;
	}
}
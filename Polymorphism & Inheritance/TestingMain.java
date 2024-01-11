public class TestingMain{
	public static void main(String [] args){
		Radio mySystem = new Radio();

		System.out.println("Speaker Brand: " + mySystem.getSpeakerBrandName());
		System.out.println("Radio Volume: " + mySystem.currentVolume());
		System.out.println("Number of Speakers: " + mySystem.getNumSpeakers());
		mySystem.registerSurroundSound();
		System.out.println("Number of Speakers: " + mySystem.getNumSpeakers());
	}
}
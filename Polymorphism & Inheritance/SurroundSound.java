public class SurroundSound extends SpeakerSystem{
	public SurroundSound(){
		this("default", 0.0F, 5);
	}

	public SurroundSound(String speakerName, float volume, int numSpeakers){
		super(speakerName, volume, numSpeakers);
	}
}
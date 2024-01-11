public class SpeakerSystem{
	private String brandName;
	private float volume;
	private int numSpeakers;
	SpeakerSystem speakers;

	public SpeakerSystem(){
		this("default", 0.0F, 0);
	}

	public SpeakerSystem(String brandName, float volume, int numSpeakers){
		this.brandName = brandName;
		this.volume = volume;
		this.numSpeakers = numSpeakers;
	}

	public String getSpeakerBrandName(){
		return brandName;
	}

	public float currentVolume(){
		return volume;
	}

	public int getNumSpeakers(){
		return numSpeakers;
	}

	public float increaseVolume(float volume){
		if (volume >= 95.0F) {
			this.volume = 100.0F;
			return volume;
		}
		volume += 5.0F;
		return volume;
	}

	public float decreaseVolume(float volume){
		if (volume <= 5.0F){
			this.volume = 0.0F;
			return volume;
		}
		volume -= 5.0F;
		return volume;
	}
}
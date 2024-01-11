public class Radio{
	private boolean poweredOn;
	private boolean playingMusic;
	private float currentStation;
	
	SpeakerSystem speakers;
	
	public Radio(){
		this(false, false, 0.0F);
	}

	public Radio(boolean powerState, boolean musicState, float channel){
		this.poweredOn = powerState;
		this.playingMusic = musicState;
		this.currentStation = channel;
		if (speakers == null){
			registerSpeakers();
		}
	}

	public void registerSpeakers(){
		this.speakers = new DefaultSpeakers();
	}

	public void registerSurroundSound(){
		this.speakers = new SurroundSound();
	}

	public String getSpeakerBrandName(){
		String brandName = speakers.getSpeakerBrandName();
		return brandName;
	}

	public int getNumSpeakers(){
		int numSpeakers = speakers.getNumSpeakers();
		return numSpeakers;
	}

	public float currentVolume(){
		float volumeLevel = speakers.currentVolume();
		return volumeLevel;
	}
}
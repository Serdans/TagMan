package controller;

import java.io.File;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundPlayer {

	public SoundPlayer() {
	}
	
	public void playSound(String soundType) {
		String soundDir = "";
		if (soundType.equals("dead")) {
			soundDir = "resources/death.wav";
		} else {
			soundDir = "resources/finished.wav";
		}
		
		Clip clip = null;
		File sound = new File(soundDir);
		
		try {
			// Get the audio inputstream of the sound file.
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(sound);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

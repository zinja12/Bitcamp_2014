package com.bitcamp_2014.sound;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class Sound {
	private AudioClip sound;
	private URL songPath;
	
	public Sound(String fileName){
		try{
			songPath = new URL(fileName);
			sound = Applet.newAudioClip(songPath);
		} catch(Exception e){
			//Do nothing
			e.printStackTrace();
		}
	}
	
	public void playSound(){
		sound.loop();
	}
	
	public void stopSound(){
		sound.stop();
	}
	
	public void playSoundOnce(){
		sound.play();
	}
}

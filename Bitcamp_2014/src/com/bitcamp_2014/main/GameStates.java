package com.bitcamp_2014.main;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics2D;
import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

import com.bitcamp_2014.level.Level;
import com.bitcamp_2014.menus.EndMenu;
import com.bitcamp_2014.menus.StartMenu;

public class GameStates {
	public enum GameState{
		TITLE,
		GAME,
		END
	}
	
	public static GameState current_state;
	
	Level level;
	StartMenu startMenu;
	EndMenu endMenu;
	
	public GameStates(){
		current_state = GameState.TITLE;
		
		level = new Level();
		startMenu = new StartMenu();
		endMenu = new EndMenu();
		
		try {
		    File yourFile = new File("res/gameAudio_01.wav");
		    AudioInputStream stream;
		    AudioFormat format;
		    DataLine.Info info;
		    Clip clip;

		    stream = AudioSystem.getAudioInputStream(yourFile);
		    format = stream.getFormat();
		    info = new DataLine.Info(Clip.class, format);
		    clip = (Clip) AudioSystem.getLine(info);
		    clip.open(stream);
		    clip.loop(Clip.LOOP_CONTINUOUSLY);
		}
		catch (Exception e) {
		    //Do not do anything
			e.printStackTrace();
		}
	}
	
	public void update(){
		if(current_state == GameState.TITLE){
			startMenu.update();
		}
		
		if(current_state == GameState.GAME){
			level.update();
		}
		
		if(current_state == GameState.END){
			endMenu.update();
		}
	}
	
	public void render(Graphics2D g){
		if(current_state == GameState.TITLE){
			startMenu.render(g);
		}
		
		if(current_state == GameState.GAME){
			level.render(g);
		}
		
		if(current_state == GameState.END){
			endMenu.render(g);
		}
	}
}

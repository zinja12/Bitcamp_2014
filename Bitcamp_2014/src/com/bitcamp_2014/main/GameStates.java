package com.bitcamp_2014.main;

import java.awt.Graphics2D;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

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
	
	public Clip sound = loadClip("res/gameAudio_01.wav");
	
	public GameStates(){
		current_state = GameState.TITLE;
		
		level = new Level();
		startMenu = new StartMenu();
		endMenu = new EndMenu();
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
	
	public Clip loadClip(String filename){
		Clip clip = null;
		
		try{
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(getClass().getResource(filename));
			clip = AudioSystem.getClip();
			clip.open(audioIn);
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return clip;
	}
	
	
}

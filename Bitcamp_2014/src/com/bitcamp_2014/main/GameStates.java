package com.bitcamp_2014.main;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics2D;

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
	
	private AudioClip clip;
	
	public GameStates(){
		current_state = GameState.TITLE;
		
		level = new Level();
		startMenu = new StartMenu();
		endMenu = new EndMenu();
		
		try{
			clip = Applet.newAudioClip(getClass().getResource("/gameAudio_01.wav"));
			clip.loop();
		} catch(Exception e){
			//Do nothing
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

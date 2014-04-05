package com.bitcamp_2014.main;

import java.awt.Graphics2D;

import com.bitcamp_2014.level.Level;

public class GameStates {
	public enum GameState{
		TITLE,
		GAME,
		END
	}
	
	public static GameState current_state;
	
	Level level;
	
	public GameStates(){
		current_state = GameState.GAME;
		
		level = new Level();
	}
	
	public void update(){
		if(current_state == GameState.TITLE){
			
		}
		
		if(current_state == GameState.GAME){
			level.update();
		}
		
		if(current_state == GameState.END){
			
		}
	}
	
	public void render(Graphics2D g){
		if(current_state == GameState.TITLE){
			
		}
		
		if(current_state == GameState.GAME){
			level.render(g);
		}
		
		if(current_state == GameState.END){
			
		}
	}
}

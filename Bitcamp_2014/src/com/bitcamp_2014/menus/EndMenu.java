package com.bitcamp_2014.menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import com.bitcamp_2014.input.Input;
import com.bitcamp_2014.level.Level;
import com.bitcamp_2014.main.GameStates;

public class EndMenu {
	
	public EndMenu(){
		
	}
	
	public void update(){
		if(Input.space){
			Level.reset();
			GameStates.current_state = GameStates.GameState.TITLE;
		}
	}
	
	public void render(Graphics2D g){
		//Fill the background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 650, 550);
		
		//Draw the text
		g.setColor(Color.WHITE);
		
		g.setFont(new Font("Serif", Font.PLAIN, 24));
		g.drawString("Thanks for playing!", 65, 100);
		
		g.setFont(new Font("Serif", Font.BOLD, 30));
		g.drawString("{Score}={" + Level.score + "}", 80, 150);
		
		g.setFont(new Font("Serif", Font.PLAIN, 14));
		g.drawString("Press any <SPACE> to play again", 60, 190);
	}
}

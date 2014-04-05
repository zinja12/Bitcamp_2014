package com.bitcamp_2014.menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import com.bitcamp_2014.input.Input;
import com.bitcamp_2014.main.GameStates;

public class StartMenu {
	
	public StartMenu(){
		
	}
	
	public void update(){
		if(Input.up || Input.down || Input.left || Input.right) 
			GameStates.current_state = GameStates.GameState.GAME;
	}
	
	public void render(Graphics2D g){
		//Fill the background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 650, 550);
		
		//Draw the text
		g.setColor(Color.WHITE);
		
		g.setFont(new Font("Serif", Font.BOLD, 30));
		g.drawString("Color Sprint", 80, 100);
		
		g.setFont(new Font("Serif", Font.PLAIN, 12));
		g.drawString("A game made for Bitcamp 2014", 80, 150);
		
		g.setFont(new Font("Serif", Font.PLAIN, 10));
		g.drawString("Use the arrow keys to align the colors", 80, 160);
		g.drawString("Made by Jada Washington and Shaan Verma", 70, 185);
		
		g.setFont(new Font("Serif", Font.BOLD, 24));
		g.drawString("Press any arrow key to start", 20, 225);
	}
}

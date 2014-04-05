package com.bitcamp_2014.level;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

import com.bitcamp_2014.entities.Player;
import com.bitcamp_2014.entities.PuzzlePiece;

public class Level {
	
	//Init
	Player player;
	PuzzlePiece piece1;
	
	Random random;
	
	public Level(){
		player = new Player();
		random = new Random();
	}
	
	public void update(){
		player.update();
		
		if(piece1 == null){
			
			piece1 = new PuzzlePiece(random.nextInt(4) + 1);
		} else {
			piece1.update();
		}
	}
	
	public void render(Graphics2D g){
		//Fill the background color
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 650, 550);
		
		piece1.render(g);
		player.render(g);
	}
}

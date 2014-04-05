package com.bitcamp_2014.level;

import java.awt.Graphics;

import com.bitcamp_2014.entities.Player;
import com.bitcamp_2014.entities.PuzzlePiece;

public class Level {
	
	//Init
	Player player;
	PuzzlePiece[] puzzlepieces;
	
	public Level(){
		player = new Player();
		puzzlepieces = new PuzzlePiece[3];
	}
	
	public void update(){
		
	}
	
	public void render(Graphics graphics){
		
	}
}

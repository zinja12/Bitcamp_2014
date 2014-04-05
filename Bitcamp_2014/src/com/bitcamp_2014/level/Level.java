package com.bitcamp_2014.level;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.bitcamp_2014.entities.Player;
import com.bitcamp_2014.entities.PuzzlePiece;

public class Level {
	
	//Init
	Player player;
	ArrayList<PuzzlePiece> puzzlePieces;
	
	Random random;
	
	public static boolean loseGame = false;
	
	public Level(){
		player = new Player();
		puzzlePieces = new ArrayList<PuzzlePiece>();
		random = new Random();
		puzzlePieces.add(new PuzzlePiece(random.nextInt(3) + 1));
	}
	
	public void update(){
		player.update();
		
		for(PuzzlePiece puzzlePiece : puzzlePieces){
			puzzlePiece.update();
		}
		
		for(int i = 0; i < puzzlePieces.size(); i++){
			PuzzlePiece puzzlePiece = puzzlePieces.get(i);
			if(puzzlePiece.collision_Rect.intersects(Player.winCollision_Rect)){
				puzzlePiece.active = false;
				puzzlePieces.remove(i);
				puzzlePieces.add(new PuzzlePiece(random.nextInt(4) + 1));
			}
			
			if(puzzlePiece.collision_Rect.contains(Player.loseCollision_Point)){
				System.out.println("YOU LOSE");
				Level.loseGame = true;
				puzzlePiece.active = false;
				puzzlePieces.remove(i);
			}
		}
	}
	
	public void render(Graphics2D g){
		//Fill the background color
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 650, 550);
		
		for(PuzzlePiece puzzlePiece : puzzlePieces){
			puzzlePiece.render(g);
		}
		player.render(g);
	}
}

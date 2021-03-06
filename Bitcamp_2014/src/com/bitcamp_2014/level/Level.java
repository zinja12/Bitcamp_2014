package com.bitcamp_2014.level;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

import com.bitcamp_2014.entities.Player;
import com.bitcamp_2014.entities.PuzzlePiece;
import com.bitcamp_2014.main.GameStates;

public class Level {
	
	//Init
	Player player;
	ArrayList<PuzzlePiece> puzzlePieces;
	
	Random random;
	
	public static int score;
	public static boolean loseGame = false;
	public static boolean reset = false;
	
	public Level(){
		score = 0;
		player = new Player();
		puzzlePieces = new ArrayList<PuzzlePiece>();
		random = new Random();
		puzzlePieces.add(new PuzzlePiece(random.nextInt(3) + 1));
	}
	
	public void update(){
		if(reset){
			score = 0;
			player = new Player();
			puzzlePieces = new ArrayList<PuzzlePiece>();
			puzzlePieces.add(new PuzzlePiece(random.nextInt(3) + 1));
			reset = false;
		}
		
		player.update();
		
		for(PuzzlePiece puzzlePiece : puzzlePieces){
			puzzlePiece.update();
		}
		
		for(int i = 0; i < puzzlePieces.size(); i++){
			PuzzlePiece puzzlePiece = puzzlePieces.get(i);
			if(puzzlePiece.collision_Rect.intersects(Player.winCollision_Rect) && player.direction == puzzlePiece.state){
				puzzlePiece.active = false;
				puzzlePieces.remove(i);
				score++;
				puzzlePieces.add(new PuzzlePiece(random.nextInt(4) + 1));
			}
			
			if(puzzlePiece.collision_Rect.contains(Player.loseCollision_Point)){
				Level.loseGame = true;
				puzzlePiece.active = false;
				puzzlePieces.remove(i);
				GameStates.current_state = GameStates.GameState.END;
			}
		}
	}
	
	public static void reset(){
		reset = true;
	}
	
	public void render(Graphics2D g){
		//Fill the background color
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 650, 550);
		
		for(PuzzlePiece puzzlePiece : puzzlePieces){
			puzzlePiece.render(g);
		}
		player.render(g);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Serif", Font.PLAIN, 18));
		g.drawString("|" + score + "|", 155, 145);
	}
}

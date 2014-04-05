package com.bitcamp_2014.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;

import com.bitcamp_2014.level.Level;

public class PuzzlePiece {
	
	public Point position;
	public Rectangle collision_Rect;
	public int state;
	public static float speed;
	public boolean active;
	
	Random random;
	
	public PuzzlePiece(int state){
		this.state = state;
		active = true;
		speed = 1f;
		
		random = new Random();
		
		if(this.state == 1){
			position = new Point(150, 0);
		}
		if(this.state == 2){
			position = new Point(300, 130);
		}
		if(this.state == 3){
			position = new Point(150, 250);
		}
		if(this.state == 4){
			position = new Point(0, 135);
		}
		
		collision_Rect = new Rectangle(position.x, position.y, 20, 20);
	}
	
	public void update(){
		
		speed = (float)random.nextInt(3) + 1;
		
		if(state == 1){
			position.y += speed;
		}
		if(state == 2){
			position.x -= speed;
		}
		if(state == 3){
			position.y -= speed;
		}
		if(state == 4){
			position.x += speed;
		}
		
		collision_Rect = new Rectangle(position.x, position.y, 20, 20);
	}
	
	public static void incrementSpeed(){
		speed++;
	}
	
	public void render(Graphics g){
		if(state == 1){
			g.setColor(Color.RED);
		}
		if(state == 2){
			g.setColor(Color.GREEN);
		}
		if(state == 3){
			g.setColor(Color.BLUE);
		}
		if(state == 4){
			g.setColor(Color.YELLOW);
		}
		g.fillRect(position.x, position.y, 20, 20);
	}
}

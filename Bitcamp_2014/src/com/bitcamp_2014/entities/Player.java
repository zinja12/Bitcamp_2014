package com.bitcamp_2014.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import com.bitcamp_2014.input.Input;


public class Player {
	public Point position;
	public static Rectangle loseCollision_Rect;
	public static Rectangle winCollision_Rect;
	public int direction;

	public Player(){
		position = new Point(135, 115);
		direction = 1;
		loseCollision_Rect = new Rectangle(position.x, position.y, 50, 50);
		winCollision_Rect = new Rectangle(position.x, position.y, 50, 50);
	}

	public void update(){
		if(Input.up){
			direction = 1;
			loseCollision_Rect = new Rectangle(position.x + 12, position.y, 50, 38);
			winCollision_Rect = new Rectangle(position.x, position.y, 50, 12);
		} else if(Input.right){
			direction = 2;
			loseCollision_Rect = new Rectangle(position.x, position.y, 38, 50);
			winCollision_Rect = new Rectangle(position.x + 38, position.y, 12, 50);
		} else if(Input.down){
			direction = 3;
			loseCollision_Rect = new Rectangle(position.x, position.y, 50, 38);
			winCollision_Rect = new Rectangle(position.x, position.y + 38, 50, 12);
		} else if(Input.left){
			direction = 4;
			loseCollision_Rect = new Rectangle(position.x + 12, position.y, 38, 50);
			winCollision_Rect = new Rectangle(position.x, position.y, 12, 50);
		}
	}

	public void render(Graphics2D g){
		g.setColor(Color.GRAY);
		g.drawRect(position.x, position.y, 50, 50);
		
		switch(direction){
		case 1:
			g.setColor(Color.RED);
			g.fillRect(position.x, position.y, 51, 12);
			break;
		case 2:
			g.setColor(Color.GREEN);
			g.fillRect(position.x + 38, position.y, 13, 51);
			break;
		case 3:
			g.setColor(Color.BLUE);
			g.fillRect(position.x, position.y + 38, 51, 13);
			break;
		case 4:
			g.setColor(Color.YELLOW);
			g.fillRect(position.x, position.y, 12, 51);
			break;
		}
	}
}

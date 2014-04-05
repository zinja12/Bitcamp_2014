package com.bitcamp_2014.entities;

import java.awt.Graphics2D;
import java.awt.Point;

import com.bitcamp_2014.input.Input;


public class Player {
	Point position;
	int angle = 180;

	public Player(){
		position = new Point(0,0);

	}

	public void update(){
		if(Input.left){
			angle--;
			
		} else if (Input.right){
			angle++;

		}

	}

	public void render(Graphics2D g){
		g.drawRect(position.x, position.y, 50, 50);
		g.rotate(angle);
		

	}
}

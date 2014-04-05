package com.bitcamp_2014.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener{
	public static boolean left;
	public static boolean right;
	public static boolean up;
	public static boolean down;
	public static boolean space;
	
	public Input(){
		
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		switch(key){
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_A:
			left = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_D:
			right = true;
			break;
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_W:
			up = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;
		case KeyEvent.VK_S:
			down = true;
			break;
		case KeyEvent.VK_SPACE:
			space = true;
			break;
		}
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		switch(key){
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_A:
			left = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_D:
			right = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_W:
			up = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		case KeyEvent.VK_S:
			down = false;
			break;
		case KeyEvent.VK_SPACE:
			space = false;
			break;
		}
	}
	
	public void keyTyped(KeyEvent e){
		
	}
}

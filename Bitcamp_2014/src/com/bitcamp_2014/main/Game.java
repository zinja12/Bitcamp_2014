package com.bitcamp_2014.main;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JApplet;
import javax.swing.JFrame;

import com.bitcamp_2014.input.Input;

public class Game extends JApplet implements Runnable{
	private static final long serialVersionUID = 1L;
	
	public static int pixelSize = 2;
	
	public static double moveFromBorder = 0;
	public static double sX = moveFromBorder, sY = moveFromBorder;
	
	public static Dimension size = new Dimension(650, 550);
	public static Dimension pixel = new Dimension(size.width / pixelSize, size.height / pixelSize);
	
	public static final String TITLE = "Bitcamp 2014";
	
	public static BufferedImage screen = new BufferedImage(Game.size.width, Game.size.height, BufferedImage.TYPE_INT_ARGB);
	
	private boolean running = false;
	
	GameStates gameStates;
	
	public Game(){
		addKeyListener(new Input());
	}
	
	public void start(){
		//Initialization
		gameStates = new GameStates();
		
		running = true;
		new Thread(this).start();
	}
	
	public void run(){
		while(running){
			requestFocus();
			update();
			render();
			
			try{
				Thread.sleep(5);
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public void stop(){
		running = false;
	}
	
	public void update(){
		
		gameStates.update();
	}
	
	public void render(){
		Graphics2D g = (Graphics2D)screen.getGraphics();
		
		//Render things here
		gameStates.render(g);
		
		g = (Graphics2D)getGraphics();
		g.drawImage(screen, 0, 0, size.width, size.height, 0, 0, pixel.width, pixel.height, null);
		g.dispose();
	}
	
	public static void main(String args[]){
		Game game = new Game();
		game.setPreferredSize(size);
		game.setMaximumSize(size);
		game.setMinimumSize(size);
		
		JFrame frame = new JFrame();
		frame.add(game);
		frame.setTitle(TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
		game.start();
	}
}
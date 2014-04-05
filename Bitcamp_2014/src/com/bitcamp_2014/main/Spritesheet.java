package com.bitcamp_2014.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Spritesheet {
	
	public static BufferedImage player_Sprite = null;
	public static BufferedImage piece_Sprite1 = null;
	public static BufferedImage piece_Sprite2 = null;
	public static BufferedImage piece_Sprite3 = null;
	public static BufferedImage piece_Sprite4 = null;
	
	public Spritesheet(){
		try{
			player_Sprite = ImageIO.read(new File("res/player_Sprite.png"));
			piece_Sprite1 = ImageIO.read(new File("res/piece_Sprite1.png"));
			piece_Sprite2 = ImageIO.read(new File("res/piece_Sprite2.png"));
			piece_Sprite3 = ImageIO.read(new File("res/piece_Sprite3.png"));
			piece_Sprite4 = ImageIO.read(new File("res/piece_Sprite4.png"));
		} catch(Exception e){
			System.out.println("Cannot load files");
			e.printStackTrace();
		}
	}
	
	public BufferedImage getSprite(BufferedImage image, int x, int y, int width, int height){
		return image.getSubimage(x, y, width, height);
	}
}

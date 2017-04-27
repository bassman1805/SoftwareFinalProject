package GUI;

import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JTextField;

import Game.NumberGen;

public class GameDisplay extends JFrame{
	static Graphics g;
	
	private BinaryPanel binPanel;
	private LevelBar progress;
	private JMenuBar menus;
	private JTextField textBase10, lvlCounter;
	private JButton submit;
	private JFrame game;
	
	private NumberGen generator;
	
	GameDisplay() {
		game = new JFrame();
		game.setSize(300,500);
		//game.add(menus);
		//game.add(textBase10);
		//game.add(lvlCounter);
		//game.add(submit);
		
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		GameDisplay g = new GameDisplay();
		g.setVisible(true);
	}

}

package GUI;

import java.awt.BorderLayout;
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
	
	private NumberGen generator;
	
	GameDisplay() {
		setName("Binary game"); //TODO: Make a better name
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,300);
		
		binPanel = new BinaryPanel();
		add(binPanel, BorderLayout.CENTER);
		
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

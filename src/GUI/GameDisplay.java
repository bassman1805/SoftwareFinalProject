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
	
	private NumberGen generator;

}

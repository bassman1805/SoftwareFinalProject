package GUI;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,500);
		menus = new JMenuBar();
		setJMenuBar(menus);
		menus.add(createFileMenu());

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




	private JMenu createFileMenu() {
		JMenu menu = new JMenu("File");
		menu.add(createFileExitItem());
		return menu;
	}

	private JMenuItem createFileExitItem() {
		JMenuItem item = new JMenuItem("Exit");
		class MenuItemListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);

			}
		}
		item.addActionListener(new MenuItemListener());
		return item;
	}




	public static void main(String[] args) {
		GameDisplay g = new GameDisplay();
		g.setVisible(true);
	}

}

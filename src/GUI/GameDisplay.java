package GUI;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Game.NumberGen;

public class GameDisplay extends JFrame{
	static Graphics g;

	private BinaryPanel binPanel;
	private JProgressBar progress;
	private JMenuBar menus;
	private JTextField textBase10;
	private JButton submit;
	private final int INC =10;
	private int lvl=1;

	private NumberGen generator;

	GameDisplay() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,300);
		menus = new JMenuBar();
		setJMenuBar(menus);
		menus.add(createFileMenu());
		
		JPanel panel = new JPanel();
		panel.setSize(500,200);
		panel.setLayout(new GridLayout(0,1));

		setName("Binary game"); //TODO: Make a better name

		textBase10 = new JTextField(10);
		textBase10.setHorizontalAlignment(JTextField.CENTER);
		panel.add(textBase10);
		
		
		binPanel = new BinaryPanel();
		panel.add(binPanel);
		
		add(panel, BorderLayout.CENTER);
		
		JButton submit = new JButton("SUBMIT");
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println(textBase10.getText());
				if(Integer.parseInt(textBase10.getText())==	binPanel.getValue()){
					System.out.println("they are the sdame");
					progress.setValue(progress.getValue()+INC);
					if(progress.getValue()>=99){
						progress.setValue(0);
						lvl++;
						progress.setString("Level "+lvl);
					}
				}
				else{
					System.out.println("not the same");
				}
				
			}
		
		});
		
		add(submit, BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,300);

		//binPanel = new BinaryPanel();
		//add(binPanel, BorderLayout.CENTER);
		
		progress = new JProgressBar();
		add(progress, BorderLayout.NORTH);
		progress.setString("Level "+lvl);
		progress.setStringPainted(true);


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

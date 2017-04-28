package GUI;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Game.NumberGen;

public class GameDisplay extends JFrame{
	static GameDisplay g;

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
				try{
					
				
				//System.out.println(textBase10.getText());
				if(Integer.parseInt(textBase10.getText())==	binPanel.getValue()){
					//System.out.println("they are the same");
					progress.setValue(progress.getValue()+INC);
					if(progress.getValue()>=99){
						progress.setValue(0);
						lvl++;
						if(lvl>=7){
							JOptionPane.showMessageDialog(g,
								    "You won.  The game will close now",
								    "Binary Game",
								    JOptionPane.INFORMATION_MESSAGE);
							System.exit(0);
						}
						generator.setLevel(lvl);
						progress.setString("Level "+lvl);
					}
					doOneRound();
				}
				else{
					//TODO: Error message when you get it wrong
					JOptionPane.showMessageDialog(g,
						    "The decimal number is: " + textBase10.getText() + "\nThe binary number is: " + binPanel.getValue() + ".",
						    "Incorrect",
						    JOptionPane.ERROR_MESSAGE);
				}
				
			}
				catch(NumberFormatException er){
					//System.out.println("???");
					textBase10.setText("Enter your number Here, in this box, after you delete this message");
				}
		}
		
		});
		
		add(submit, BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,300);
		
		progress = new JProgressBar();
		add(progress, BorderLayout.NORTH);
		progress.setString("Level "+lvl);
		progress.setStringPainted(true);

		generator = new NumberGen();
		generator.setLevel(lvl);

		doOneRound();
	}




	private JMenu createFileMenu() {
		JMenu menu = new JMenu("File");
		menu.add(createFileExitItem());
		menu.add(createHelpItem());
		return menu;
	}
	private JMenuItem createHelpItem(){
		JMenuItem item = new JMenuItem("Help");
		class helpListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("help");
				JOptionPane.showMessageDialog(g,
					    "Welcome, enter in the binary number or decimal\n"
						+"If the binary buttons are orange, type in the decimal version in the text box above it\n"
					    +"If the text feild has a number, click the binary buttons on and off to make the binary representation of that number\n"
						+"\nWhen you think the numbers are mathcing, click submit\n"
					    +"There are six levels, each has ten questions"
						+"\n Level | Decimal Range | Max Binary Digits"
						+"\n  1    |        0-7      |       3"
						+"\n  2    |       0-15     |       4"
						+"\n  3    |       0-31     |       5"
						+"\n  4    |       0-63     |       6"
						+"\n  5    |      0-127    |       7"
						+"\n  6    |      0-255    |       8"
						
						+"\n\nAuthors: Josh Hoskinson, Robert Lewis, Nick Smith, Jess Wolf",
					    "Binary Game",
					    JOptionPane.PLAIN_MESSAGE);

			}
		}
		item.addActionListener(new helpListener());
		return item;
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

	////////// Game Actions \\\\\\\\\\
	
	public void doOneRound(){
		if(new Random().nextBoolean()){ //flip a coin to decide if we do a decimal or binary number
			//give them a decimal
			
			//Write the goal number in the text box
			textBase10.setEditable(true);
			Integer goal = generator.generateDecimal();
			textBase10.setText(goal.toString());			
			textBase10.setEditable(false);
			binPanel.setEditable(true);
			binPanel.setValue(0);
		}
		else{
			//give them a binary number
			
			binPanel.setEditable(true);
			Integer goal = generator.generateBinary();
			binPanel.setValue(goal);
						
			textBase10.setEditable(true);
			textBase10.setText("");
			binPanel.setEditable(false);
		}
		binPanel.repaint();
	}


	public static void main(String[] args) {
		g = new GameDisplay();
		g.setVisible(true);
		g.setTitle("Super Awsome Binary Game");
		JOptionPane.showMessageDialog(g,
			    "Welcome, enter in the binary number or decimal\nOnly one feild will be editable at a time.\nFor more help, File->Help",
			    "Binary Game",
			    JOptionPane.PLAIN_MESSAGE);
	}

}

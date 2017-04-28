package GUI;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class BinaryPanel extends JPanel implements MouseListener{
	public final int NUM_BUTTONS = 8;
	private DigitButton buttons[];
	private boolean editable;
	
	public BinaryPanel(){
		editable = true;
		// set up the buttons
		buttons = new DigitButton[NUM_BUTTONS];
		for(int i=0; i < NUM_BUTTONS; i++){
			buttons[i] = new DigitButton(i);
		}
		
		setBorder(BorderFactory.createTitledBorder("Binary Number"));
		
		addMouseListener(this);
	}
	
	////////// Getters \\\\\\\\\\
	
	public int getValue() {
		int retVal = 0;
		//System.out.println("Getting Panel Value...");
		for(DigitButton button : buttons){
			//System.out.println(button);
			retVal += button.getValue();
		}
		//System.out.println("");
		return retVal;
	}
	
	public boolean isEditable(){
		return editable;
	}
	
	////////// Setters \\\\\\\\\\

	public void setZero() {
		for(DigitButton button : buttons){
			button.setOn(false);
		}
	}

	public void setButton(int i, boolean b) {
		buttons[i].setOn(b);
	}
	
	public void setEditable(boolean edit){
		editable = edit;
		for(DigitButton button : buttons){
			button.setEditable(edit);
		}
	}
	
	////////// GUI and Drawing \\\\\\\\\\
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}

	public void draw(Graphics g) {
		for(DigitButton button : buttons){
			button.paintComponent(g);
		}
	}
	
	////////// Mouse Listener \\\\\\\\\\

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		DigitButton clicked = null;
		
		for(DigitButton button : buttons){
			if(button.containsClick(e.getX(), e.getY())) clicked = button;
		}
		
		if(clicked != null) clicked.toggle();
		this.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

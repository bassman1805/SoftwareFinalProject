package GUI;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DigitButton extends JPanel{
	
	private boolean on;
	private int digit;
	private int myXpos;
	private int myYpos;
	
	public static final int BUTTON_SIZE = 30;
	
	public DigitButton(int myDigit){
		on = false;
		digit = myDigit;
		
		myYpos = 0;
		myXpos = 50 + (7-digit)*BUTTON_SIZE*11/10;
	}
	
	////////// Getters \\\\\\\\\\
	
	public int getValue(){
		if(on){
			return (int) Math.pow(2, digit);
		}
		return 0;
	}
	
	////////// Setters \\\\\\\\\\
	
	public void setOn(boolean newVal){
		on = newVal;
	}
	
	////////// Drawing/GUI \\\\\\\\\\

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}

	public void draw(Graphics g) {
		if(on) g.setColor(Color.CYAN);
		else g.setColor(Color.YELLOW);
		
		g.fillRect(myXpos, myYpos, BUTTON_SIZE, BUTTON_SIZE);
		g.setColor(Color.BLACK);
		g.drawRect(myXpos, myYpos, BUTTON_SIZE, BUTTON_SIZE);
	}

	
	////////// Other \\\\\\\\\\
	
	@Override
	public String toString() {
		return "DigitButton [Digit = " + digit + ", On = " + on + ", Value = " + this.getValue() + "]";
	}
}

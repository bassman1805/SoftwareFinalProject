package GUI;

import java.awt.Graphics;

import javax.swing.JPanel;

public class DigitButton extends JPanel{
	
	private boolean on;
	private int digit;
	
	public DigitButton(int myDigit){
		on = false;
		digit = myDigit;
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
		
	}

	
	////////// Other \\\\\\\\\\
	
	@Override
	public String toString() {
		return "DigitButton [Digit = " + digit + ", On = " + on + ", Value = " + this.getValue() + "]";
	}
}

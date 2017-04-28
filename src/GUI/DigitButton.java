package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class DigitButton extends JPanel{
	
	private boolean on;
	private int digit;
	private int myXpos;
	private int myYpos;
	private boolean editable;
	
	public static final int BUTTON_SIZE = 30;
	
	public DigitButton(int myDigit){
		on = false;
		digit = myDigit;
		
		myYpos = 35;
		myXpos = 100 + (7-digit)*BUTTON_SIZE*12/10;
		
		editable = true;
	}
	
	////////// Getters \\\\\\\\\\
	
	public int getValue(){
		if(on){
			return (int) Math.pow(2, digit);
		}
		return 0;
	}
	
	////////// Setters \\\\\\\\\\
	
	public void setEditable(boolean edit){
		editable = edit;
	}
	
	public void setOn(boolean newVal){
		if(editable) on = newVal;
	}
	
	public void toggle(){
		if(editable) on = !on;
	}
	
	////////// Drawing/GUI \\\\\\\\\\

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}

	public void draw(Graphics g) {
		if(editable) g.setColor(Color.YELLOW);
		else g.setColor(Color.ORANGE);
		g.fillRect(myXpos, myYpos, BUTTON_SIZE, BUTTON_SIZE);
		
		g.setColor(Color.BLACK);
		g.drawRect(myXpos, myYpos, BUTTON_SIZE, BUTTON_SIZE);
		
		
		String text;
		if(on) text = "1";
		else text = "0";
		g.setFont(new Font("Courier New", 1, 18));
		//Strange constants are to make the numbers centered on the button
		g.drawString(text, myXpos+(BUTTON_SIZE/3), myYpos+(BUTTON_SIZE*2/3));
	}

	
	////////// Other \\\\\\\\\\
	
	@Override
	public String toString() {
		return "DigitButton [Digit = " + digit + ", On = " + on + ", Value = " + this.getValue() + "]";
	}

	public boolean containsClick(int mouseX, int mouseY) {
		Rectangle rect = new Rectangle(myXpos, myYpos, BUTTON_SIZE, BUTTON_SIZE);
		if (rect.contains(mouseX, mouseY)) 
			return true;
		return false;
	}
}

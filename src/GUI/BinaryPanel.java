package GUI;

public class BinaryPanel {
	public final int NUM_BUTTONS = 8;
	private DigitButton buttons[];
	private boolean editable;
	
	public BinaryPanel(){
		// set up the buttons
		buttons = new DigitButton[NUM_BUTTONS];
		for(int i=0; i < NUM_BUTTONS; i++){
			buttons[i] = new DigitButton(i);
		}
		editable = true;
	}
	
	////////// Getters \\\\\\\\\\
	
	public int getValue() {
		int retVal = 0;
		System.out.println("Getting Panel Value...");
		for(DigitButton button : buttons){
			System.out.println(button);
			retVal += button.getValue();
		}
		System.out.println("");
		return retVal;
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

}

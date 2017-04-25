package Game;

import java.util.Random;

public class NumberGen {
	private int level=1;
	Random rand = new Random();

	public void setLevel(int i) {
		// TODO Auto-generated method stub
		i--;
		level=(int) (8*Math.pow(2, i));
		//System.out.println("level: "+(i+1)+ "  Range:0-"+level);
		
	}

	public int generateDecimal() {
		// TODO Auto-generated method stub
					
		int randomNum = rand.nextInt(level);
		return randomNum;
	}

	public int generateBinary() {
		// TODO Auto-generated method stub
		int randomNum = rand.nextInt(level);
		return randomNum;
		
	}

}

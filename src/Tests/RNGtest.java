package Tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import Game.NumberGen;

public class RNGtest {
	static NumberGen rng;

	@BeforeClass
	public static void setUp(){
		rng = new NumberGen();
	}

	@Test
	public void testLevel1Decimal() {
		//level 1 should generate numbers from 0-7 (only 3 digits in Bin)
		rng.setLevel(1);

		int[] counters = new int[8];
		int temp; //to store random number

		for(int i=0; i < 1000; i++){
			temp = rng.generateDecimal();
			counters[temp]++;
		}
		
		for(int i:counters){
			assertEquals(125, i, 30);
			//System.out.println(i);
		}
	}

	@Test
	public void testLevel1Binary(){
		//level 1 should generate numbers from 0-7 (only 3 digits in Bin)
		rng.setLevel(1);

		int[] counters = new int[8];
		int temp; //to store random number

		for(int i=0; i < 1000; i++){
			temp = rng.generateBinary();
			counters[temp]++;
		}

		for(int i:counters){
			assertEquals(125, i, 30);
		}
	}
	
	@Test
	public void testLevel2Decimal() {
		//level 1 should generate numbers from 0-7 (4 digits in Bin)
		rng.setLevel(2);

		int[] counters = new int[16];
		int temp; //to store random number

		for(int i=0; i < 10000; i++){
			temp = rng.generateDecimal();
			counters[temp]++;
		}
		

		for(int i:counters){
			assertEquals(625, i, 80);
		}
	}

	@Test
	public void testLevel2Binary(){
		//level 1 should generate numbers from 0-7 (4 digits in Bin)
		rng.setLevel(2);

		int[] counters = new int[16];
		int temp; //to store random number

		for(int i=0; i < 10000; i++){
			temp = rng.generateBinary();
			counters[temp]++;
		}

		for(int i:counters){
			assertEquals(625, i, 80);
		}
	}
	
	@Test
	public void testLevel6Decimal() {
		//level 1 should generate numbers from 0-255 (8 digits in Bin)
		rng.setLevel(6);

		int[] counters = new int[256];
		int temp; //to store random number

		for(int i=0; i < 100000; i++){
			temp = rng.generateDecimal();
			counters[temp]++;
	
		}
		for(int i:counters){
			assertEquals(390, i, 90);
		}
	}

	@Test
	public void testLevel6Binary(){
		//level 1 should generate numbers from 0-255 (8 digits in Bin)
		rng.setLevel(6);

		int[] counters = new int[256];
		int temp; //to store random number

		for(int i=0; i < 100000; i++){
			temp = rng.generateBinary();
			counters[temp]++;
		}
		for(int i=0;i<100;i++){
			
		}
			

		for(int i:counters){
			System.out.println(Integer.toBinaryString(i));
			assertEquals(390, i, 90);
		}
	}

}

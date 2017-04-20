package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import GUI.BinaryPanel;

public class BinaryPanelTest {
	private static BinaryPanel panel;
	
	@BeforeClass
	public static void setUp(){
		panel = new BinaryPanel();
	}
	
	@Before
	public void clearNumbers(){
		panel.setZero();
	}
	
	//Test no buttons

	@Test
	public void test0() {
		assertEquals(0, panel.getValue());
	}
	
	//Test single button presses
	
	@Test
	public void test1(){
		panel.setButton(0,true);
		assertEquals(1,panel.getValue());
	}
	
	@Test
	public void test2(){
		panel.setButton(1,true);
		assertEquals(2,panel.getValue());
	}
	
	@Test
	public void test4(){
		panel.setButton(2,true);
		assertEquals(4,panel.getValue());
	}
	
	@Test
	public void test8(){
		panel.setButton(3,true);
		assertEquals(8,panel.getValue());
	}
	
	@Test
	public void test64(){
		panel.setButton(6,true);
		assertEquals(64,panel.getValue());
	}
	
	@Test
	public void test128(){
		panel.setButton(7,true);
		assertEquals(128,panel.getValue());
	}
	
	//Test multiple pressed buttons
	
	@Test
	public void test7(){
		panel.setButton(0,true);
		panel.setButton(1,true);
		panel.setButton(2,true);
		assertEquals(7,panel.getValue());
	}
	
	@Test
	public void test28(){
		panel.setButton(2,true);
		panel.setButton(3,true);
		panel.setButton(4,true);
		assertEquals(28,panel.getValue());
	}
	
	@Test
	public void test35(){
		panel.setButton(5,true);
		panel.setButton(1,true);
		panel.setButton(0,true);
		assertEquals(35,panel.getValue());
	}

}

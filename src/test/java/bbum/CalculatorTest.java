package bbum;
import static org.junit.Assert.*;

import java.security.InvalidParameterException;
import java.text.ParseException;

import org.junit.Test;

import bbum.services.calculator.Calculator;


public class CalculatorTest {
	
	@Test
	public void plusTest () throws ParseException {
		Calculator calc = new Calculator("1+1");
		assertEquals(2, calc.apply());
	}
	
	@Test
	public void minusTest () throws ParseException {
		Calculator calc = new Calculator("1-1");
		assertEquals(0, calc.apply());
	}
	
	
	@Test
	public void multTest () throws ParseException {
		Calculator calc = new Calculator("2*3");
		assertEquals(6, calc.apply());
	}
	
	@Test
	public void multFloatTest () throws ParseException {
		Calculator calc = new Calculator("2*0.2");
		assertEquals(new Float(0.4), calc.apply());
	}
	
	@Test
	public void divTest () throws ParseException {
		Calculator calc = new Calculator("9/3");
		assertEquals(3, calc.apply());
	}
	
	@Test
	public void divFloatTest () throws ParseException {
		Calculator calc = new Calculator("9/2");
		assertEquals(new Float(4.5), calc.apply());
	}
	
	@Test
	public void emptyStringTest () throws ParseException {
		assertThrows(InvalidParameterException.class, () -> new Calculator(""));
	}
	
	@Test
	public void nullTest () throws ParseException {
		assertThrows(InvalidParameterException.class, () -> new Calculator(null));
	}
	
	@Test
	public void notSupportedActionTest () throws ParseException {
		assertThrows(InvalidParameterException.class, () -> new Calculator("9^2"));
	}
}

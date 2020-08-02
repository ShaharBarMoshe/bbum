package bbum.services.calculator;

import java.security.InvalidParameterException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map	;
import java.util.function.BiFunction;

import bbum.services.IServerService;

/**
 * Server service for calculate expression 
 * @author shaharb
 *
 */
public class Calculator implements IServerService<Number>{
	
	private static ThreadLocal<NumberFormat> numberFormatter = ThreadLocal
			.withInitial(() -> new DecimalFormat("00000"));
	private static Map<String, BiFunction<Number, Number, Float>> actions = new HashMap<String, BiFunction<Number, Number, Float>>();
	private float left;
	private float right;
	private String operator;
	
	static {
		// init the action map
		actions.put("+", (a, b) -> a.floatValue() + b.floatValue());
		actions.put("-", (a, b) -> a.floatValue() - b.floatValue());
		actions.put("/", (a, b) -> a.floatValue() / b.floatValue());
		actions.put("*", (a, b) -> a.floatValue() * b.floatValue());
	}

	public Calculator(String message) throws ParseException {
		String[] expNumbers = getNumberArray(message);
		left = numberFormatter.get().parse(expNumbers[0]).floatValue();
		right = numberFormatter.get().parse(expNumbers[1]).floatValue();
		operator = message.chars().mapToObj(i -> (char) i).filter(c -> actions.containsKey(c.toString())).findFirst()
				.orElseThrow(() -> new InvalidParameterException("the given operator is not supported")).toString();
	}

	/**
	 * 
	 * @param expression
	 * @return array of strings of the numbers in the expression, 
	 */
	private String[] getNumberArray(String expression) {
		if (expression == null) {
			throw new InvalidParameterException("The input cannot be null");
		}
		String[] expNumbers = expression.split("[^0-9 .]");
		if (expNumbers.length < 2) {
			throw new InvalidParameterException("The input must contain 2 numbers and operator");
		}
		return expNumbers;
	}

	/**
	 * Do the calculation on the given expression. 
	 * and return the answer. 
	 * If the answer is integer - return int value
	 * otherwise will return float value   
	 */
	@Override
	public Number apply() {
		Float floatValue = actions.get(operator).apply(left, right);
		int intValue = floatValue.intValue();
		if (floatValue == Math.round(floatValue)) {
			return intValue;
		} else {
			return floatValue;
		}
	}

}
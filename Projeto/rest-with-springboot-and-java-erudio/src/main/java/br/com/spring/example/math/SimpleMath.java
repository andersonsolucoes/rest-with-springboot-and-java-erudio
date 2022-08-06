package br.com.spring.example.math;

import br.com.spring.example.converters.NumberConverter;
import br.com.spring.example.exceptions.UnsupportedMathOperationException;

public class SimpleMath {
	
	public static Double sum(String numberOne, String numberTwo) throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return NumberConverter.convertToDouble(numberOne) + NumberConverter.convertToDouble(numberTwo); 
	}
	
	public static Double subtraction(String numberOne, String numberTwo) throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return NumberConverter.convertToDouble(numberOne) - NumberConverter.convertToDouble(numberTwo); 
	}
	
	public static Double division(String numberOne, String numberTwo) throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return NumberConverter.convertToDouble(numberOne) / NumberConverter.convertToDouble(numberTwo); 
	}
	
	public static Double multiplication(String numberOne, String numberTwo) throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return NumberConverter.convertToDouble(numberOne) * NumberConverter.convertToDouble(numberTwo); 
	}
	
	public static Double mean(String numberOne, String numberTwo) throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return (NumberConverter.convertToDouble(numberOne) + NumberConverter.convertToDouble(numberTwo))/2; 
	}
	
	public static Double squareRoot(String number) throws Exception {
		
		if(!NumberConverter.isNumeric(number)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return Math.sqrt(NumberConverter.convertToDouble(number)); 
	}
}

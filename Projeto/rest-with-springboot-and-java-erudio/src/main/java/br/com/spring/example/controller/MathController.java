package br.com.spring.example.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.spring.example.math.SimpleMath;

@RestController
public class MathController {
		
		@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
		public Double sum(
						@PathVariable(value="numberOne") String numberOne,
						@PathVariable(value="numberTwo") String numberTwo
					) throws Exception {
			return SimpleMath.sum(numberOne,numberTwo); 
		}
		
		@RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method=RequestMethod.GET)
		public Double subtraction(
						@PathVariable(value="numberOne") String numberOne,
						@PathVariable(value="numberTwo") String numberTwo
					) throws Exception {
			return SimpleMath.subtraction(numberOne,numberTwo); 
		}
		
		@RequestMapping(value = "/division/{numberOne}/{numberTwo}", method=RequestMethod.GET)
		public Double division(
						@PathVariable(value="numberOne") String numberOne,
						@PathVariable(value="numberTwo") String numberTwo
					) throws Exception {	
			return SimpleMath.division(numberOne,numberTwo); 
		}
		
		@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method=RequestMethod.GET)
		public Double multiplication(
						@PathVariable(value="numberOne") String numberOne,
						@PathVariable(value="numberTwo") String numberTwo
					) throws Exception {	
			return SimpleMath.multiplication(numberOne,numberTwo); 
		}
		
		@RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method=RequestMethod.GET)
		public Double mean(
						@PathVariable(value="numberOne") String numberOne,
						@PathVariable(value="numberTwo") String numberTwo
					) throws Exception {	
			return SimpleMath.mean(numberOne,numberTwo); 
		}
		
		@RequestMapping(value = "/squareRoot/{number}", method=RequestMethod.GET)
		public Double squareRoot(@PathVariable(value="number") String number) throws Exception {	
			return SimpleMath.squareRoot(number); 
		}
}

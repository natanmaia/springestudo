package br.com.natanmaia.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.natanmaia.exception.UnsuportedMathOperationException;
import br.com.natanmaia.math.SimpleMath;
import br.com.natanmaia.request.converters.MathConverter;

@RestController
public class MathController {
	
	private SimpleMath math = new SimpleMath();
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(
			@PathVariable("numberOne") String numberOne, 
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!MathConverter.isNumeric(numberOne) || !MathConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Por favor, defina valores numérico!");
		}
		return math.sum(MathConverter.convertToDouble(numberOne), MathConverter.convertToDouble(numberTwo));
		
	}
	
	@RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sub(
			@PathVariable("numberOne") String numberOne, 
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!MathConverter.isNumeric(numberOne) || !MathConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Por favor, defina valores numérico!");
		} 
		return math.sub(MathConverter.convertToDouble(numberOne), MathConverter.convertToDouble(numberTwo));
		
	}
	
	@RequestMapping(value = "/multi/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multi(
			@PathVariable("numberOne") String numberOne, 
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!MathConverter.isNumeric(numberOne) || !MathConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Por favor, defina valores numérico!");
		} 
		return math.multi(MathConverter.convertToDouble(numberOne), MathConverter.convertToDouble(numberTwo));
		
	}
	
	@RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double div(
			@PathVariable("numberOne") String numberOne, 
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!MathConverter.isNumeric(numberOne) || !MathConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Por favor, defina valores numérico!");
		}
		return math.div(MathConverter.convertToDouble(numberOne), MathConverter.convertToDouble(numberTwo));
		
	}
	
	@RequestMapping(value = "/mid/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double mid(
			@PathVariable("numberOne") String numberOne, 
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!MathConverter.isNumeric(numberOne) || !MathConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Por favor, defina valores numérico!");
		}
		return math.mid(MathConverter.convertToDouble(numberOne), MathConverter.convertToDouble(numberTwo));
		
	}
	
	@RequestMapping(value = "/raiz2/{numberOne}", method = RequestMethod.GET)
	public Double raiz2(
			@PathVariable("numberOne") String numberOne) throws Exception {
		if(!MathConverter.isNumeric(numberOne)) {
			throw new UnsuportedMathOperationException("Por favor, defina valores numérico!");
		}
		return math.raiz2(MathConverter.convertToDouble(numberOne));
		
	}
	

	
}

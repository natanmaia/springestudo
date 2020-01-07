package br.com.natanmaia.math;

public class SimpleMath {

	public Double sum(Double numberOne, Double numberTwo) {
		return numberOne + numberTwo;
	}

	public Double sub(Double numberOne, Double numberTwo) {
		return numberOne - numberTwo;
	}
	
	public Double multi(Double numberOne, Double numberTwo) {
		return numberOne * numberTwo;
	}
	
	public Double div(Double numberOne, Double numberTwo) {
		return numberOne / numberTwo;
	}
	
	public Double mid(Double numberOne, Double numberTwo) {
		return (numberOne + numberTwo)/2;
	}
	
	public Double raiz2(Double numberOne) {
		return (Double) Math.sqrt(numberOne);
	}
	
}

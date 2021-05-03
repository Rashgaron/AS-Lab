package com.junit.demo;


public class Calculator {
		  
		 public double multiply(double a, double b) {
		  return a * b;
		 }
		  
		 public double divide(double a, double b) { 
		  if(b == 0) {
		   throw new ArithmeticException();
		  }
		  return a / b;
		 }
		 public double suma(double a, double b){
		 	return a + b;
		 }

		 public double resta(double a, double b) throws NoEsPotRestar {
		 	if(a > b) return a-b;
		 	throw new NoEsPotRestar("La resta no se puede calcular");
		 }

		 public int factorial(double a) throws nEsNegatiu {

		 	int result = 1;

		 	if(a < 0) throw new nEsNegatiu("El parametro es negativo y no se puede hacer el factorial");
		 	else if(a == 0) return 1;
		 	else{
		 		for(int i = 1; i < a +1 ; i++)
		 			result *= i;
			}
		 	return result;
		 }
		}

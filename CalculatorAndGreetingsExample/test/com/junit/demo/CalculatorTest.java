package com.junit.demo;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

public class CalculatorTest {
 
 private Calculator calc;
  
 @Before
 public void setUp() throws Exception {
  calc = new Calculator();
 }
 
 @After
 public void tearDown() throws Exception {
  calc = null;
 }
 
 @Test
 public void testMultiply() {
  double result = calc.multiply(2.5, 100);
  assertEquals(250, result, 0);
 }
 
 @Test
 public void testDivide() {
  double result = calc.divide(100, 10);
  assertEquals(10, result, 0);
 }
 
 @Test
 public void testDivideWithTolerance() {
  double result = calc.divide(345, 100);
  assertEquals(3.4, result, 0.1);

 }


 @Test
 public void TestSuma_VariosValores_DebeDarSumaCorrecta() {
  double v1 = 10;
  double v2 = 20;
  double expected = 30;

  double result = calc.suma(v1, v2);

  Assert.assertEquals("La suma de 10 + 20 deberia ser 30", expected, result, 0);
 }

@Test
 public void TestResta_PrimerValorMasGrande_ResultadoResta() throws NoEsPotRestar {
  double v1 = 20;
  double v2 = 10;
  double expected = 10;

  double result = calc.resta(20,10);

  Assert.assertEquals("El resultado de restar 20 - 10 deberia ser 10", expected, result, 0);

 }

 @Test(expected = NoEsPotRestar.class)

 public void TestResta_PrimerValorMasPequeOIgual_ThrowException() throws NoEsPotRestar {
  double v1 = 10;
  double v2 = 20;

  calc.resta(10,20);
 }

 @Test(expected = nEsNegatiu.class)
 public void TestFactorial_ValorNegativo_ThrowExceptionNEsNegatiu() throws nEsNegatiu {
  int v1 = -1;

  calc.factorial(v1);
 }
 @Test
 public void TestFactorial_ValorPositivoMayorQueZero_ResultCorrecto() throws nEsNegatiu {
  int v1 = 5;
  int expected = 120;

  int actual = calc.factorial(5);

  Assert.assertEquals("Factorial de 5 deberia ser 120", expected, actual, 0);
 }

 @Test
 public void TestFactorial_ValorZero_ResultZero() throws nEsNegatiu {
  int v1 = 0;
  int expected = 1;

  int actual = calc.factorial(v1);

  Assert.assertEquals("El factorial deberia ser 0", expected, actual, 0);
 }



 @Test(expected = ArithmeticException.class)
 public void testDivideByZero() {
  calc.divide(100.5, 0);
 }
}







package com.junit.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class CalculatorParamsTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {0,1,1},{1,1,2},{3,3,6}
        });
    }
    private double v1;
    private double v2;
    private double result;

    public CalculatorParamsTest(double v1, double v2, double result){
        this.v1 = v1;
        this.v2 = v2;
        this.result = result;
    }

    @Test
    public void TestSum_VariosValores_DebeHacerLaSumaCorrecta(){
        Calculator calc = new Calculator();
        double expected = result;
        double actual = calc.suma(v1, v2);
        Assert.assertEquals("La suma de " +v1+ "+" + v2 + " deberia ser: " + result, actual, expected ,0);
    }


}

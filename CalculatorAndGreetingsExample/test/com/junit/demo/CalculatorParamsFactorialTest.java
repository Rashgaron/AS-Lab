package com.junit.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CalculatorParamsFactorialTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {5,120},{0,1},{1,1}
        });

    }
    private int vInitial;
    private int result;

    public CalculatorParamsFactorialTest(int vInitial, int result){
        this.vInitial = vInitial;
        this.result = result;
    }

    @Test
    public void TestFactorial_VariosValores_DebeDarFactorialCorrecto() throws nEsNegatiu {
        Calculator calc = new Calculator();

        int actual = calc.factorial(vInitial);

        Assert.assertEquals(actual, result, 0);
    }
}


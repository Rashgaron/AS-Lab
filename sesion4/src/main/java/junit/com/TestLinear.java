package junit.com;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestLinear {
    public PayStationImpl ps;
    public IRateStrategy RateStrategy;
    @Before
    public void setUp() {
        RateStrategy = new LiniearRateStrategy();

        ps = new PayStationImpl(RateStrategy);
    }


    @Test
    public void LinearRateStrategy_Insert25_Return10() throws IllegalCoinException {

        int actual = RateStrategy.calculaTime(25);

        Assert.assertEquals(10, actual);

    }


    @Test
    public void LinearRate_Insert25_Return10() throws IllegalCoinException {
        ps.addPayment(25);

        int actual = ps.readDisplay();

        int expected = 10;

        Assert.assertEquals(expected,actual);

    }


}

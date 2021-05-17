package junit.com;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestProgressiveRate {
    public PayStationImpl ps;
    IRateStrategy RateStrategy;
    @Before
    public void setUp() {
        RateStrategy = new ProgressiveRate();

        ps = new PayStationImpl(RateStrategy);
    }

    @Test
    public void ProgressiveRateStrategy_Insert150Cents_Result60Min() throws IllegalCoinException {

        int actual = RateStrategy.calculaTime(150);

        Assert.assertEquals(60, actual);

    }


    @Test
    public void ProgressiveRateStrategy_Insert350Cents_Return120Min() throws IllegalCoinException {

        int actual = RateStrategy.calculaTime(350);

        Assert.assertEquals(120, actual);

    }
    @Test
    public void ProgressiveRateStrategy_Insert650_Return180Min() throws IllegalCoinException {

        int actual = RateStrategy.calculaTime(650);

        Assert.assertEquals(180, actual);


    }


    @Test
    public void ProgressiveRate_Insert150Cents_Result60Min() throws IllegalCoinException {
        int expected = 60;

        IRateStrategy RateStrategy = new ProgressiveRate();

        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);

        int actual = ps.readDisplay();


        Assert.assertEquals(expected,actual);


    }

    @Test
    public void ProgressiveRate_Insert350Cents_Return120Min() throws IllegalCoinException {
        int expected = 120;

        for(int i = 0; i < 14; i++) {
            ps.addPayment(25);
        }
        int actual = ps.readDisplay();


        Assert.assertEquals(expected, actual);

    }

    @Test
    public void ProgressiveRate_Insert650_Return180Min() throws IllegalCoinException {

        int expected = 180;

        for(int i = 0; i < 26; i++)
            ps.addPayment(25);


        int actual = ps.readDisplay();


        Assert.assertEquals(expected, actual);

    }


}

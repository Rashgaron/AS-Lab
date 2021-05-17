package junit.com;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class TestIntegration {


    @Test
    public void IntegrationPayStation_NovaYork_Return() throws IllegalCoinException {

        IRateStrategy RateStrategy = new One2OneStrategy();
        PayStationImpl ps = new PayStationImpl(RateStrategy);

        ps.addPayment(25);

        int actual = ps.readDisplay();

        int expected = 25;

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void IntegrationPayStation_Boston_Return() throws IllegalCoinException {
        IRateStrategy RateStrategy = new One2OneStrategy();
        PayStationImpl ps = new PayStationImpl(RateStrategy);

        ps.addPayment(25);

        int actual = ps.readDisplay();

        int expected = 25;

        Assert.assertEquals(expected, actual);

    }



}

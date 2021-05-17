package junit.com;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;


public class TestIntegration {

    @Test
    public void IntegrationPayStation_NovaYork_Return() throws IllegalCoinException {

        int time = 25;


        IRateStrategy RateStrategy = mock(ProgressiveRate.class);
        when(RateStrategy.calculaTime(anyInt())).thenAnswer(invocation -> invocation.getArguments()[0]);
        PayStationImpl ps = new PayStationImpl(RateStrategy);

        ps.addPayment(25);

        int actual = ps.readDisplay();

        int expected = time;

        Assert.assertEquals(expected, actual);

    }


}

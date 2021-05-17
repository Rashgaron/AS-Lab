package junit.com;

import junit.com.IllegalCoinException;
import junit.com.PayStation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestPayStation {
    junit.com.PayStation ps;
    /** Fixture for pay station testing. */
    @Before
    public void setUp() {
        IRateStrategy RateStrategy = new LiniearRateStrategy();

        ps = new PayStationImpl(RateStrategy);
    }

    /**
     * Entering 5 cents should make the display report 2 minutes
     * parking time.
     */
    @Test
    public void shouldDisplay2MinFor5Cents() throws junit.com.IllegalCoinException {
        ps.addPayment( 5 );
        Assert.assertEquals( "Should display 2 min for 5 cents",
                5 / 5 * 2, ps.readDisplay() );
    }

    /**
     * Entering 25 cents should make the display report 10 minutes
     * parking time.
     */
    @Test
    public void shouldDisplay10MinFor25Cents() throws junit.com.IllegalCoinException {
        ps.addPayment( 25 );
        Assert.assertEquals( "Should display 10 min for 25 cents",
                25 / 5 * 2, ps.readDisplay() );
        // 25 cent in 5 cent coins each giving 2 minutes parking
    }

    /**
     * Verify that illegal coin values are rejected.
     */
    @Test(expected= junit.com.IllegalCoinException.class)
    public void shouldRejectIllegalCoin() throws junit.com.IllegalCoinException {
        ps.addPayment(17);
    }

    /**
     * Entering 10 and 25 cents should be valid and
     * return 14 minutes parking
     */
    @Test
    public void shouldDisplay14MinFor10And25Cents()
            throws junit.com.IllegalCoinException {
        ps.addPayment( 10 );
        ps.addPayment( 25 );
        Assert.assertEquals( "Should display 14 min for 10+25 cents",
                (10+25) / 5 * 2, ps.readDisplay() );
    }

    /**
     * Buy should return a valid receipt of the
     * proper amount of parking time
     */
    @Test
    public void shouldReturnCorrectReceiptWhenBuy()
            throws junit.com.IllegalCoinException {
        ps.addPayment(5);
        ps.addPayment(10);
        ps.addPayment(25);
        junit.com.Receipt receipt;
        receipt = ps.buy();
        Assert.assertNotNull( "Receipt reference cannot be null",
                receipt );
        Assert.assertEquals( "Receipt value must be 16 min.",
                (5+10+25) / 5 * 2 , receipt.value() );
    }

    /**
     * Receipts must be able to store parking time values
     */
    @Test
    public void shouldStoreTimeInReceipt() {
        junit.com.Receipt receipt = new junit.com.ReceiptImpl(30);
        Assert.assertEquals( "Receipt can store 30 minute value",
                30, receipt.value() );
    }

    /**
     * Buy for 100 cents and verify the receipt
     */
    @Test
    public void shouldReturnReceiptWhenBuy100c()
            throws junit.com.IllegalCoinException {
        ps.addPayment(10);
        ps.addPayment(10);
        ps.addPayment(10);
        ps.addPayment(10);
        ps.addPayment(10);
        ps.addPayment(25);
        ps.addPayment(25);

        junit.com.Receipt receipt;
        receipt = ps.buy();
        Assert.assertEquals((5*10+2*25) / 5 * 2 , receipt.value() );
    }
    /**
     * Verify that the pay station is cleared after a buy scenario
     */
    @Test
    public void shouldClearAfterBuy()
            throws junit.com.IllegalCoinException {
        ps.addPayment(25);
        ps.buy(); // I do not care about the result
        // verify that the display reads 0
        Assert.assertEquals( "Display should have been cleared",
                0 , ps.readDisplay() );
        // verify that a following buy scenario behaves properly
        ps.addPayment(10); ps.addPayment(25);
        Assert.assertEquals( "Next add payment should display correct time",
                (10+25) / 5 * 2, ps.readDisplay() );
        junit.com.Receipt r = ps.buy();
        Assert.assertEquals( "Next buy should return valid receipt",
                (10+25) / 5 * 2, r.value() );
        Assert.assertEquals( "Again, display should be cleared",
                0 , ps.readDisplay() );
    }
    /**
     * Verify that cancel clears the pay station
     */
    @Test
    public void shouldClearAfterCancel()
            throws junit.com.IllegalCoinException {
        ps.addPayment(10);
        ps.cancel();
        Assert.assertEquals( "Cancel should clear display",
                0 , ps.readDisplay() );
        ps.addPayment(25);
        Assert.assertEquals( "Insert after cancel should work",
                25/5*2 , ps.readDisplay() );
    }


}
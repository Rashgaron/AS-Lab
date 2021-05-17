package junit.com;

import junit.com.IRateStrategy;

public class LiniearRateStrategy implements IRateStrategy {
    @Override
    public int calculaTime(int insertedSoFar) {
        return  insertedSoFar/5 * 2;
    }
}

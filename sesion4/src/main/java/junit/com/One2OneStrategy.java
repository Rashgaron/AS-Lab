package junit.com;

public class One2OneStrategy implements IRateStrategy{
    @Override
    public int calculaTime(int insertedSoFar) {
        return insertedSoFar;
    }
}

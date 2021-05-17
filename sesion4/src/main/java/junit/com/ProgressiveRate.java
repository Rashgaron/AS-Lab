package junit.com;

public class ProgressiveRate  implements IRateStrategy{
    @Override
    public int calculaTime(int insertedSoFar) {
        int total = 0;


        if(insertedSoFar > 150 + 200){
            insertedSoFar -= 350;
            total = 120 + (insertedSoFar / 5);

        }
        else if(insertedSoFar >= 150){

            insertedSoFar -=150;
            total = 60 + (insertedSoFar * 3 / 10);



        }else{

            total = insertedSoFar / 5 * 2;

        }




        return total;
    }
}

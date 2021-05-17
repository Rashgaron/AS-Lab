package junit.com;

import junit.com.IRateStrategy;

/** Implementation of the pay station.

 Responsibilities:

 1) Accept payment;
 2) Calculate parking time based on payment;
 3) Know earning, parking time bought;
 4) Issue receipts;
 5) Handle buy and cancel events.

 This source code is from the book
 "Flexible, Reliable Software:
 Using Patterns and Agile Development"
 published 2010 by CRC Press.
 Author:
 Henrik B Christensen
 Department of Computer Science
 Aarhus University

 Please visit http://www.baerbak.com/ for further information.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.

 */

public class PayStationImpl implements junit.com.PayStation {
    private int insertedSoFar;
    private int timeBought;
    IRateStrategy RateStrategy;

    public PayStationImpl(IRateStrategy RateStrategy){
        this.RateStrategy = RateStrategy;
    }

    public void addPayment( int coinValue )
            throws junit.com.IllegalCoinException {
        switch ( coinValue ) {
            case 5: break;
            case 10: break;
            case 25: break;
            default:
                throw new junit.com.IllegalCoinException("Invalid coin: "+coinValue);
        }
        insertedSoFar += coinValue;
        timeBought = RateStrategy.calculaTime(insertedSoFar);
    }


    public int readDisplay() {
        return timeBought;
    }

    public junit.com.Receipt buy() {
        junit.com.Receipt r = new junit.com.ReceiptImpl(timeBought);
        reset();
        return r;
    }
    public void cancel() {
        reset();
    }
    private void reset() {
        timeBought = insertedSoFar = 0;
    }
}


import java.time.LocalDateTime;
import java.util.List;

public class ChangePriceThread extends Thread {

    private List<Share> shares;

    public ChangePriceThread(List<Share> shares) {
        this.shares = shares;
    }

    //    public void run() {
//        LocalDateTime timeOfStart = LocalDateTime.now();
//        timeOfStart = timeOfStart.plusMinutes(10);
//
//        int i;
//        for (; ; ) {
//            for (i = 0; i < 3; i++) {
//
//                int priceAfterChange;
//                int priceAfterChange1;
//                int priceAfterChange2;
//
//
//                try {
//                    Thread.sleep(30000);
//
//                } catch (
//                        InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//
//                int randomNumber;
//                randomNumber = (int) (Math.random() * 2);
//
//                if (randomNumber == 0) {
//                    int price = 141;
//                    priceAfterChange = (int) (price + 4.23);
//                } else {
//                    int price = 141;
//                    priceAfterChange = (int) (price - 4.23);
//                }
//
//                int randomNumber1;
//                randomNumber1 = (int) (Math.random() * 2);
//
//                if (randomNumber1 == 0) {
//                    int price1 = 387;
//                    priceAfterChange1 = (int) (price1 + 11.61);
//                } else {
//                    int price1 = 387;
//                    priceAfterChange1 = (int) (price1 - 11.61);
//                }
//
//                int randomNumber2;
//                randomNumber2 = (int) (Math.random() * 2);
//
//                if (randomNumber2 == 0) {
//                    int price1 = 137;
//                    priceAfterChange2 = (int) (price1 + 4.23);
//                } else {
//                    int price1 = 137;
//                    priceAfterChange2 = (int) (price1 - 4.23);
//                }
//
//                System.out.println("The current price of COKE : " + priceAfterChange1 + "," + timeOfStart);
//                System.out.println("The current price of APPL : " + priceAfterChange + "," + timeOfStart);
//                System.out.println("The current price of IBM : " + priceAfterChange2 + "," + timeOfStart);
//
//                LocalDateTime timeOfEnd = LocalDateTime.now();
//
//                if (timeOfEnd.isAfter(timeOfStart)) {
//                    interrupt();
//                }
//            }
//        }
//    }
    public void run() {

        LocalDateTime timeOfStart = LocalDateTime.now();
        timeOfStart = timeOfStart.plusMinutes(10);


        for (; ; ) {
            for (int i = 0; i < shares.size(); i++) {
                try {
                    Thread.sleep(30000);

                } catch (
                        InterruptedException e) {
                    throw new RuntimeException(e);
                }

                int randomNumber;
                randomNumber = (int) (Math.random() * 2);

                for (Share share : shares) {
                    if (randomNumber == 0) {

                        share.setPrice(share.getPrice() + 10);
                        System.out.println("The price have changed:" + share);
                    } else {
                        share.setPrice(share.getPrice() - 10);
                        System.out.println("The price have changed:" + share);
                    }
                    LocalDateTime timeOfEnd = LocalDateTime.now();

                    if (timeOfEnd.isAfter(timeOfStart)) {
                        interrupt();
                    }
                }
            }
        }
    }
}



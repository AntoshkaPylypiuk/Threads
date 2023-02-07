
import java.time.LocalDateTime;
import java.util.List;

public class ChangePriceThread extends Thread {

    private List<Share> shares;

    public ChangePriceThread(List<Share> shares) {
        this.shares = shares;
    }
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



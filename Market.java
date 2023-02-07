import java.time.LocalDateTime;
import java.util.List;

public class Market extends Thread {


    private List<Customer> customers;
    private List<Share> shares;

    public Market(List<Customer> customers, List<Share> shares) {
        this.customers = customers;
        this.shares = shares;
    }

    public void run() {

        for (; ; ) {
            for (int i = 0; i < shares.size(); i++) {
                try {
                    Thread.sleep(5000);

                } catch (
                        InterruptedException e) {
                    throw new RuntimeException(e);
                }

                LocalDateTime start = LocalDateTime.now();
                start = start.plusMinutes(10);

                for (Share shares : shares) {
                    for (Customer customer : customers) {
                        for (Share targetShare : customer.getTarget()) {

                            if (shares.getName().equals(targetShare.getName()) && shares.getPrice() <= targetShare.getPrice()) {
                                int i1 = shares.getAmount() - targetShare.getAmount();
                                System.out.println("The purchase attempt was successful for:" + customer.getName() + targetShare.getName());
                                System.out.println("The amount after purchase :" + shares.getName() + i1);
                            } else {
                                System.out.println("The purchase attempt for " + customer.getName() + " was unsuccessful");

                            }
                        }
                    }
                }
            }
        }
    }
}

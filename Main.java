import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Share apple = new Share("APPLE", 141, 100);
        Share ibm = new Share("IBM", 137, 200);
        Share coke = new Share("COKE",387, 1000);

        List<Share> shares = new ArrayList<>();
        shares.add(apple);
        shares.add(ibm);
        shares.add(coke);

        Share appleAlice = new Share("APPLE", 100, 10);
        Share cokeAlice = new Share("COKE", 390, 20);

        Share appleBob = new Share("APPLE", 140, 10);
        Share ibmBob = new Share("IBM", 135, 20);

        Share cokeCharlie = new Share("COKE", 370, 300);

        List<Share> targetAlice = new ArrayList();
        targetAlice.add(appleAlice);
        targetAlice.add(cokeAlice);

        List<Share> targetBob = new ArrayList<>();
        targetBob.add(appleBob);
        targetBob.add(ibmBob);

        List<Share> targetCharlie = new ArrayList<>();
        targetCharlie.add(cokeCharlie);

        Customer alice = new Customer( targetAlice,"Alice");
        Customer bob = new Customer( targetBob,"Bob");
        Customer charlie = new Customer(targetCharlie,"Charlie");

        List<Customer> customers = new ArrayList<>();
        customers.add(alice);
        customers.add(bob);
        customers.add(charlie);

        new ChangePriceThread(shares).start();
        new Market(customers, shares).start();
    }
}

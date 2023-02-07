import java.util.List;

public class Customer {
    private List<Share> target;
    private String name;

    public Customer(List<Share> target, String name) {
        this.target = target;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public List<Share> getTarget() {
        return target;
    }

    public void setTarget(List<Share> target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "target=" + target +
                ", name='" + name + '\'' +
                '}';
    }
}

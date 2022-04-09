import java.util.ArrayList;

public class Order {
    // adding member variables
    public String name;
    public double total;
    public boolean ready;

    // assign an instance to items, otherwise would have to create each individual instance in TestOrders
    public ArrayList<Item> items = new ArrayList<Item>();
}
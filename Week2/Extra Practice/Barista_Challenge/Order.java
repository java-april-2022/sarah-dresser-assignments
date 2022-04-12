import java.util.ArrayList;

public class Order {
    // private member variables
    private String name;
    private boolean ready;
    private ArrayList<Item> items;

    // constructor w/ no params, sets name = "Guest"
    public Order(){
        this.name = "Guest";
        this.items = new ArrayList<Item>();
    }

    // overloaded constructor w/ name param
    public Order(String name){
        this.name = name;
        this.items = new ArrayList<Item>();
    }
}

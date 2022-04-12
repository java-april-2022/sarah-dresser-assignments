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
        this.ready = false;
    }

    // overloaded constructor w/ name param
    public Order(String name){
        this.name = name;
        this.items = new ArrayList<Item>();
        this.ready = false;
    }

    // getters(accessors) and setters(mutators)
    // getters:
    public String getName() {
        return name;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public boolean getReady(){
        return ready;
    }

    // setters:
    public void setName(String name) {
        this.name = name;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }
    
}

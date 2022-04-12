import java.util.ArrayList;

public class Order {
    // MEMBER VARIABLES
    private String name;
    private boolean ready;
    private ArrayList<Item> items;

    // CONSTRUCTOR w/ no params, sets name = "Guest"
    public Order(){
        this.name = "Guest";
        this.items = new ArrayList<Item>();
        this.ready = false;
    }

    // OVERLOADED CONSTRUCTOR w/ name param
    public Order(String name){
        this.name = name;
        this.items = new ArrayList<Item>();
        this.ready = false;
    }

    // METHODS
    public void addItems(Item item){
        this.items.add(item);
    }

    public String getStatusMessage(){
        if(this.ready == true){
            return "Your order is ready!";
        }
        else{
            return "Sorry, not ready yet.";
        }
    }

    // method for getting order total for each customer
    public double getOrderTotal(){
        double total = 0;
        for(Item i: this.items){
            total += i.getPrice();
        }
        return total;
    }

    // display name, items, and total for each order
    public void display(){
        System.out.printf("Customer name: %s\n", this.name);
        for(Item i: this.items){
            System.out.printf("%s - $%.2f\n", i.getName(), i.getPrice());
        }
        System.out.printf("Total: %.2f", this.getOrderTotal());
    }

    // getters(accessors) and setters(mutators)
    // GETTERS
    public String getName() {
        return name;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public boolean getReady(){
        return ready;
    }

    // SETTERS
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

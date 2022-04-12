
public class Item {
    // private member variables
    private String name;
    private double price;

    // constructor w/ name & price as arguments:
    public Item(String name, double price){
        // pointing to this w/ parameters
        this.name = name;
        this.price = price;
    }

    //setters and getters:
    public String getName(){
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}

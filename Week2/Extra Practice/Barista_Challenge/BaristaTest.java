public class BaristaTest {
    public static void main(String[] args) {
        // creating instances of items
        Item item1 = new Item("drip coffee", 2.5);
        Item item2 = new Item("latte", 4.0);
        Item item3 = new Item("mocha", 4.5);
        Item item4 = new Item("cappuccino", 3.5);

        System.out.println("item1: " + item1.getName());

        // creating instances of orders
        Order order1 = new Order();
        Order order2 = new Order("Sarah");

        order2.addItems(item1);
        order2.addItems(item2);
        // checking for items
        // System.out.println("Order2: " + order2.getItems());
        
        System.out.println(order2.getStatusMessage());
    }
}

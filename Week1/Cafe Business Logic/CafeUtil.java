import java.util.ArrayList;

public class CafeUtil {

    // number of coffees required to meet streak in 10 weeks
    // numWeeks = variable for number of weeks of streak
    public int getStreakGoal(int numWeeks) {
        int sum = 0;
        for (int i=0; i<= numWeeks; i++) {
            sum += i;
        }
        return sum;
    }

    public double getOrderTotal(double[] prices) {
        double total = 0;
        for(double price : prices){
            total += price;
        }
        return total;
    }

    public void displayMenu(ArrayList<String> menuItems){
        for(int i=0; i<=menuItems.size()-1; i++){
            String item = menuItems.get(i);
            System.out.printf("%d %s\n", i, item);
        }
    }
    // overloading displayMenu w/ price list
    public boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices){
        if(menuItems.size() != prices.size()){
            return false;
        }
        for(int i=0; i<=menuItems.size()-1; i++){
            System.out.printf("\n%d %s -- %d", i, menuItems.get(i), prices.get(i));
        }
        return true;
    }

    public void addCustomer(ArrayList<String> customers){
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.printf("Hello, %s!\n", userName);
        System.out.printf("There are %d people in front of you\n", customers.size());
        customers.add(userName);
        System.out.println("---Customer Line---");
        for(String customer : customers){
            System.out.println(customer);
        }
    }

    public void printPriceChart(String product, double price, int maxQuantity){
        System.out.printf("%S", product);
        for(int i=1; i<=maxQuantity; i++){
            System.out.printf("\n%d - $%.2f", i, i*price);
        }
    }
    // senpai challenge: $0.50 discount from original price per quantity
    public void printPriceChartDiscount(String product, double price, int maxQuantity){
        System.out.printf("\n\n%S", product);
        for(int i=1; i<=maxQuantity; i++){
            double discount = 0;
            if(i>1){
                discount = 0.5*(i-1);
            }
            System.out.printf("\n%d - $%.2f", i, i*(price - discount));
        }
    }
}

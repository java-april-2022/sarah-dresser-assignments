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
    
}

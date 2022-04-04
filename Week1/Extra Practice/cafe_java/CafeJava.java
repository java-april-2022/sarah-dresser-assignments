public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.50;
        double dripCoffeePrice = 1;
        double lattePrice = 4;
        double cappuccinoPrice = 4.50;
        double DripCoffeePrice = 2.50;
        double LattePrice = 4.50;
        double CappuccinoPrice = 4.50;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = true;
        boolean isReadyOrder2 = false;
        boolean isReadyOrder3 = true;
        boolean isReadyOrder4 = false;
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
    	// ** Your customer interaction print statements will go here ** //

        // Customer interactions:

        // Cindhuri order:
        System.out.println(generalGreeting + customer1);
        if (isReadyOrder1 == true) {
            System.out.println(customer1 + readyMessage);
        }
        else {
            System.out.println(customer1 + pendingMessage);
        }

        // Noah ordered a cappuccino
        // if order is ready, print total $
        System.out.println(generalGreeting + customer4);
        if (isReadyOrder4 == true) {
            System.out.println(customer4 + readyMessage);
            System.out.println(displayTotalMessage + CappuccinoPrice);
        }
        else {
            System.out.println(customer4 + pendingMessage);
        }

        // Sam ordered 2 lattes
        System.out.println(generalGreeting + customer2);
        System.out.println("Two lattes cost " + lattePrice*2);
        if (isReadyOrder2 == true) {
            System.out.println(customer2 + readyMessage);
            // System.out.println(displayTotalMessage + lattePrice*2);
        }
        else {
            System.out.println(customer2 + pendingMessage);
        }

        // Jimmy was charged for a coffee but ordered a latte
        System.out.println("Oops, your new total is " + (lattePrice - dripCoffeePrice));
    }
}

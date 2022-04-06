import java.util.ArrayList;
import java.util.Arrays;
public class TestCafe {
    public static void main(String[] args) {
        
    /* 
    of the CafeUtil class. 
    Hint: it will need to correspond with the variable name used below..
    You will need add 1 line to this file to create an instance 
    */
    CafeUtil appTest = new CafeUtil();

        /* ============ App Test Cases ============= */
    
        System.out.println("\n----- Streak Goal Test -----");
        System.out.printf("Purchases needed by week 10: %s \n\n", appTest.getStreakGoal(10));
    
        System.out.println("----- Order Total Test-----");
        double[] lineItems = {3.5, 1.5, 4.0, 4.5};
        System.out.printf("Order total: %s \n\n",appTest.getOrderTotal(lineItems));
        
        System.out.println("----- Display Menu Test-----");
        
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("drip coffee");
        menu.add("cappuccino");
        menu.add("latte");
        menu.add("mocha");

        Double[] prices = {1.5, 3.5, 4.0, 4.5};
        ArrayList<Double> priceList = new ArrayList<Double>(Arrays.asList(prices));


        // ArrayList<Double> priceList = new ArrayList<Double>();
        // priceList.add(2.0);
        // priceList.add(3.0);
        // priceList.add(3.5);
        // priceList.add(4.0);

        appTest.displayMenu(menu);

        // ERROR: Exception in thread "main" java.util.IllegalFormatConversionException: d != java.lang.Double
        appTest.displayMenu(menu, priceList);
    
        System.out.println("\n----- Add Customer Test-----");
        ArrayList<String> customers = new ArrayList<String>();
        // --- Test 4 times ---
        for (int i = 0; i < 4; i++) {
            appTest.addCustomer(customers);
            System.out.println("\n");
        }

        // Testing printPriceChart
        System.out.println("\n-----Display Price Chart Test-----");
        appTest.printPriceChartDiscount("Columbian Coffee Grounds", 15.00, 3);
        appTest.printPriceChartDiscount("Kona Coffee Beans", 18.5, 4);
    }
}

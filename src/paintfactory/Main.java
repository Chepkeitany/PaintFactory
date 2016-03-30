package paintfactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author luke
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Main m = new Main();
        m.getOrders(m.readFile("orders.txt"));

    }

    public void getOrders(List a) {
        if (a != null) {
            int numTestCases = (int) a.get(0);
            int index = 0;
            for (int i = 0; i < numTestCases; i++) {//each test case
                index++;
                int numPaintColors = (int) a.get(index);
                index++;
                int numCustomers = (int) a.get(index);
                Factory factory = new Factory(numPaintColors, numCustomers);
                int paintCount = 0;//reset for each test case
                for (int j = 0; j < numCustomers; j++) {//each customer
                    Customer customer = new Customer();
                    index++;
                    int numPaintPairs = (int) a.get(index);
                    paintCount += numPaintPairs;//calculates number of pairs for each test case
                    for (int k = 0; k < numPaintPairs; k++) {//each paint pair
                        index++;
                        int color = (int) a.get(index);
                        index++;
                        int type = (int) a.get(index);
                        customer.setNumPaintsLiked(numPaintPairs);
                        Paint paint = new Paint(color, type);
                        customer.addPaint(paint);
                    }
                    factory.addCustomer(customer);
                }
                int numRemainingColors = numPaintColors - paintCount;
                List types = factory.getAllPaintTypes();//all types for this case
                String myCase = "";
                for (int l = 0; l < types.size(); l++) {
                    if (l == 0) {
                        myCase = "Case #" + (i + 1) + ": " + types.get(l);
                    } else {
                        myCase += " " + types.get(l);//add on next type
                    }
                }
                factory.isPossible(numTestCases, myCase);
            }
        }
    }

    public List readFile(String o) {//reads input file
        try {
            File f = new File(o);// create new file
            List<Integer> list = new ArrayList<>();
            try (Scanner scanner = new Scanner(f);) {
                while (scanner.hasNextInt()) {
                    list.add(scanner.nextInt());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();// if any error
        }
        return null;
    }

}

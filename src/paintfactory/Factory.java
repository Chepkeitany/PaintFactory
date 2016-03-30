package paintfactory;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luke
 */
public class Factory {

    private int numOfPaintColors;
    private int numOfCustomers;
    private ArrayList<Customer> customers;
    private ArrayList<Paint> paints;

    public Factory() {
        numOfPaintColors = 0;
        numOfCustomers = 0;
        customers = new ArrayList<Customer>();
        paints = new ArrayList<Paint>();
    }

    public Factory(int numOfPaintColors, int numOfCustomers) {
        this.numOfPaintColors = numOfPaintColors;
        this.numOfCustomers = numOfCustomers;
        customers = new ArrayList<Customer>();
        paints = new ArrayList<Paint>();
    }

    public int[] getAllTypes() {
        if (paints != null) {
            int[] type = new int[paints.size()];
            for (int i = 0; i < paints.size(); i++) {
                type[i] = paints.get(i).getType();
            }
            return type;
        }
        return null;
    }

    public void addCustomer(Customer c) {
        customers.add(c);
    }

    public boolean checkDataSet(int cases) {//checks dataset limits
        if (cases <= 100) {//small dataset
            if (this.numOfPaintColors > 0 && this.numOfPaintColors <= 10 && this.numOfCustomers > 0 && this.numOfCustomers <= 100) {
                return true;
            }
        } else if (cases == 5) {//large dataset
            if (this.numOfPaintColors > 0 && this.numOfPaintColors <= 2000 && this.numOfCustomers > 0 && this.numOfCustomers <= 2000) {
                return true;
            }
        }
        return false;
    }

    public void addPaint(Paint p) {
        paints.add(p);
        p.setFactory(this);
    }

    public ArrayList<Paint> getPaints() {
        return paints;
    }

    public int getNumOfPaintColors() {
        return numOfPaintColors;
    }

    public void setNumOfPaintColors(int numOfPaintColors) {
        this.numOfPaintColors = numOfPaintColors;
    }

    public int getNumOfCustomers() {
        return numOfCustomers;
    }

    public void setNumOfCustomers(int numOfCustomers) {
        this.numOfCustomers = numOfCustomers;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public void printOutput(String myCase) {
        System.out.print(myCase);
        System.out.print("\n");
    }

    public void isPossible(int cases, String myCase) {
        boolean uniquePaintResult = this.isAllPaintUnique();
        boolean datasetResult = this.checkDataSet(cases);
        boolean oneTypeResult = this.isColorsOneType();

        if (uniquePaintResult && datasetResult && oneTypeResult) {
            printOutput(myCase);
        } else {
            int colonIndex = myCase.lastIndexOf(':');
            myCase = myCase.substring(0, colonIndex);
            printOutput(myCase + " IMPOSSIBLE");
        }
    }

    public boolean isPaintUnique(List p) {//by each customer
        if (p.size() > 1) {
            for (int i = 0; i < p.size(); i++) {//for each paint
                for (int j = i + 1; j < p.size(); j++) {
                    if (p.get(i).equals(p.get(j))) {
                        return false;//not unique
                    }
                }
            }
            return true;
        }
        return true;
    }

    public boolean isAllPaintUnique() {//true for valid case
        List p = new ArrayList();
        for (int i = 0; i < customers.size(); i++) {//for each customer
            if (isPaintUnique(customers.get(i).getAllPaint()) == false) {//if paint not unique
                return false;
            }
        }
        return true;
    }

    public boolean isColorsOneType() {
        List<Paint> p = this.getAllPaint();//gets all paint
        int colors = this.getNumOfPaintColors();
        for (int i = 1; i <= colors; i++) {//for each color
            int type = -1;//reset for each color
            for (int j = 0; j < p.size(); j++) {//each paint
                int color = p.get(j).getColor();
                if (color == i) {
                    if (type != -1 && p.get(j).getType() != type) {//if types are different
                        return false;
                    } else {//first time a color is matched it sets the type
                        type = p.get(j).getType();
                    }
                }
            }
        }
        return true;//all colors are 1 type
    }

    public List getAllPaint() {
        List p = new ArrayList();
        for (int i = 0; i < customers.size(); i++) {//for each customer
            p.add(customers.get(i).getAllPaint());
        }
        List ft = flattenPaint(p);
        return ft;
    }

    public List getAllPaintTypes() {
        List p = new ArrayList();
        for (int i = 0; i < customers.size(); i++) {//for each customer
            p.add(customers.get(i).getAllPaintTypes());
        }
        List ft = flatten(p);
        return ft;
    }

    public List flattenPaint(List nested) {//flattens all paint into one list
        if (nested == null) {
            return null;
        }
        List<Paint> flattened = new ArrayList<>();
        for (Object element : nested) {
            if (element instanceof Paint) {
                flattened.add((Paint) element);
            } else {
                flattened.addAll(flattenPaint((List) element));
            }
        }
        return flattened;
    }

    public List flatten(List nestedNumbers) {//flattens list before output
        if (nestedNumbers == null) {
            return null;
        }
        List<String> flattenedNumbers = new ArrayList<>();
        for (Object element : nestedNumbers) {
            if (element instanceof String) {
                flattenedNumbers.add((String) element);
            } else {
                flattenedNumbers.addAll(flatten((List) element));
            }
        }
        return flattenedNumbers;
    }
}

package paintfactory;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luke
 */
public class Customer {

    private int numPaintsLiked;
    private ArrayList<Paint> paints;

    public Customer() {
        paints = new ArrayList<Paint>();
    }

    public Customer(int numPaintsLiked, Factory f) {
        this.numPaintsLiked = numPaintsLiked;
        paints = new ArrayList<Paint>();
    }

    public int getNumPaintsLiked() {
        return numPaintsLiked;
    }

    public void setNumPaintsLiked(int numPaintsLiked) {

        this.numPaintsLiked = numPaintsLiked;
    }

    public ArrayList<Paint> getPaints() {
        return paints;
    }

    public void setPaints(ArrayList<Paint> paints) {
        this.paints = paints;
    }

    public boolean isPaintValid(Paint p) {
        if (p.getColor() >= 1) {
            if (p.getType() == 1 || p.getType() == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean isNumPaintPairsValid(int t) {
        if (t >= 1) {
            return true;
        }
        return false;
    }

    public void addPaint(Paint p) {
        paints.add(p);
        p.setCustomer(this);
    }

    public List<Paint> getAllPaint() {
        return this.paints;
    }

    public List<String> getAllPaintTypes() {
        List<String> t = new ArrayList();
        for (int i = 0; i < paints.size(); i++) {//for each paint
            t.add(paints.get(i).getTypeAsString());
        }
        return t;
    }

}

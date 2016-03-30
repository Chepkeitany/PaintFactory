package paintfactory;

/**
 *
 * @author luke
 */
public class Paint {

    private int color;
    private int type;
    private Factory f;
    private Customer c;

    public Paint() {
    }

    public Paint(int color, int type) {
        this.color = color;
        this.type = type;

    }

    public Factory getFactory() {
        return f;
    }

    public Customer getCustomer() {
        return c;
    }

    public void setCustomer(Customer c) {
        this.c = c;
    }

    public void setFactory(Factory f) {
        this.f = f;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getType() {
        return type;
    }

    public String getTypeAsString() {
        return Integer.toString(type);
    }

    public void setType(int type) {
        this.type = type;
    }

}

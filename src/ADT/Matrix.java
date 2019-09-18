package ADT;

public class Matrix {
    private final int width;
    private final int height;
    private final String name;

    public Matrix (int width, int height, String name) {
        this.height = height;
        this.width = width;
        this.name = name;
    }

    public void print() {
        System.out.println(name +" width = " + Integer.toString(this.width) + " height = " + Integer.toString(this.height));
    }

    public int getW () {
        return this.width;
    }

    public int getH () {
        return this.height;
    }

    public String getName() { return this.name; }
}

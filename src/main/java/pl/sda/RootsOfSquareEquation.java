package pl.sda;

public class RootsOfSquareEquation {
    private double x1;
    private double x2;

    public RootsOfSquareEquation(double x1, double x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }

    @Override
    public String toString() {
        return "x1 = " + x1 + " , x2 = " + x2;
    }
}

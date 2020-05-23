package pl.sda;

public class RootsCalculator {
    public static RootsOfSquareEquation calculateRootsOfSquareEquation(double a, double b, double c) throws NegativeDeltaException{
        double delta = Math.pow(b,2) - (4 * a * c);
        if(delta < 0) {
            System.out.println("Delta ujemna smuci!.");
            throw new NegativeDeltaException();
        } else  if(delta == 0){
            double x = -b / (2*a);
            return new RootsOfSquareEquation(x,x);
        }
        double x1 = -b - Math.sqrt(delta) / (2 * a);
        double x2 = -b + Math.sqrt(delta) / (2 * a);
        return new RootsOfSquareEquation(x1,x2);
    }
}

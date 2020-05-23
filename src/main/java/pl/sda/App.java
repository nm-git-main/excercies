package pl.sda;

import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Proszę podać kolejno trzy liczby całkowite, oddzielone przecinkiem np. 1,2,3");
        String[] splittedLine = scanner.nextLine()
                .trim()
                .replaceAll(" ","")
                .split(",");

        double[] abc = new double[splittedLine.length];

        for(int i = 0; i < splittedLine.length; i++){
            abc[i] = Double.parseDouble(splittedLine[i]);
        }

        try {
            RootsOfSquareEquation pierwiastki = calculateRootsOfSquareEquation(abc[0], abc[1], abc[2]);
            if(pierwiastki.getX1()==pierwiastki.getX2()){
                System.out.println("Jeden pierwiastek x = " + pierwiastki.getX1());
            } else {
                System.out.println(pierwiastki.toString());
            }

        } catch(NegativeDeltaException e){
            System.out.println("Parametry a: " + abc[0] + ", b: " + abc[1] + ", c: " + abc[2] + " spowodowały ujemną deltę.");
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Za mało argumentów.");
        }
    }

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

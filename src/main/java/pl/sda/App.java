package pl.sda;

import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Proszę podać kolejno trzy liczby całkowite, oddzielone przecinkiem np. 1,2,3");
        String line = scanner.nextLine();
        double[] abc = new double[3];

        try {
            abc = cleanAndConvertToDoubleArray(line);

            RootsOfSquareEquation pierwiastki = RootsCalculator.calculateRootsOfSquareEquation(abc[0], abc[1], abc[2]);
            if(pierwiastki.getX1()==pierwiastki.getX2()){
                System.out.println("Jeden pierwiastek x = " + pierwiastki.getX1());
            } else {
                System.out.println(pierwiastki.toString());
            }

        } catch(NegativeDeltaException e){
            System.out.println("Parametry a: " + abc[0] + ", b: " + abc[1] + ", c: " + abc[2] + " spowodowały ujemną deltę.");
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Za mało argumentów.");
        } catch(NumberFormatException e) {
            System.out.println("Zły format danych.");
        }
    }

    public static double[] cleanAndConvertToDoubleArray(String line) {
        String[] splittedLine = line.trim()
                .replaceAll(" ","")
                .split(",");

        double[] abc = new double[splittedLine.length];

        for(int i = 0; i < splittedLine.length; i++) {
            abc[i] = Double.parseDouble(splittedLine[i]);
        }
        return abc;
    }
}

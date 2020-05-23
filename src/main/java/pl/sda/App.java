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
            try {
                abc[i] = Double.parseDouble(splittedLine[i]);
            } catch(NumberFormatException e) {
                System.out.print("Zły format danych.");
                return;
            }
        }

        try {
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
        }
    }
}

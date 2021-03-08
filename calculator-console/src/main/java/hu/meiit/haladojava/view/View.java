package hu.meiit.haladojava.view;

import java.util.Scanner;

public class View {
    private static final Scanner SCANNER = new Scanner(System.in);

    public String readFromConsole() {
        return SCANNER.nextLine();
    }

    public void writeToConsole(String output) {
        //System.out needed not System.err
        System.out.print(output);
    }
}

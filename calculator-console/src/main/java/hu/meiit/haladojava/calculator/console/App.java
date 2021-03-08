package hu.meiit.haladojava.calculator.console;

import hu.meiit.haladojava.logic.Expression;
import hu.meiit.haladojava.calculator.console.view.Parser;
import hu.meiit.haladojava.calculator.console.view.View;

public class App {
    private static final String ERROR_RESPONSE = "-";

    private static final View view = new View();

    private static final Parser parser = new Parser();

    public static void main(String[] args) {
        String result = ERROR_RESPONSE;
        try {
            Expression expression = parser.inputParser(view.readFromConsole());
            result = parser.outPutFormatter(expression.calculateExpression());
        } catch (Exception e) { } //Empty on purpose
        view.writeToConsole(result);


    }

}

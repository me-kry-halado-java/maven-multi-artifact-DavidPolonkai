package hu.meiit.haladojava.view;

import hu.meiit.haladojava.exceptions.InvalidInputException;
import hu.meiit.haladojava.logic.Expression;
import hu.meiit.haladojava.restrictions.Operation;
import java.text.DecimalFormat;

public class Parser {

    private static final String REGEX_OR = "|";

    private static final String REGEX_BEFORE_OPERATOR = "\\";

    private static final String REGEX_PREFIX = "(?<=(";

    private static final String REGEX_POSTFIX = "))";

    private static final String RESULT_FORMAT = "#.0";

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat(RESULT_FORMAT);

    public Expression inputParser(String input) throws InvalidInputException {
        return getExpression(divideExpressionIntoTwoPiece(input));
    }

    public String outPutFormatter(double result) {
        return DECIMAL_FORMAT.format(result);
    }

    private String[] divideExpressionIntoTwoPiece(String input) {

        return input.replace(" ", "").split(separatorRegexBuilder());

    }

    private Expression getExpression(String[] twoPieces) throws InvalidInputException {
        if (twoPieces.length != 2) {
            throw new InvalidInputException();
        }
        final int indexOfOperator = twoPieces[0].length() - 1;
        return new Expression(
                numberParser(twoPieces[0].substring(0, indexOfOperator)),
                twoPieces[0].charAt(indexOfOperator),
                numberParser(twoPieces[1])
        );
    }

    private int numberParser(String stringInput) {
        return Integer.parseInt(stringInput);
    }

    private String separatorRegexBuilder() {
        StringBuilder stringBuilder = new StringBuilder();
        Operation[] operators = Operation.values();
        stringBuilder.append(REGEX_PREFIX);
        for (int i = 0; i < operators.length; i++) {
            stringBuilder.append(REGEX_BEFORE_OPERATOR);
            stringBuilder.append(operators[i].getSign());
            if (i < operators.length - 1) {
                stringBuilder.append(REGEX_OR);
            }
        }
        stringBuilder.append(REGEX_POSTFIX);
        return new String(stringBuilder);
    }
}

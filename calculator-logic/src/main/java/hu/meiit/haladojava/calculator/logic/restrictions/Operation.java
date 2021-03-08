package hu.meiit.haladojava.calculator.logic.restrictions;

import hu.meiit.haladojava.calculator.logic.exceptions.InvalidInputException;

public enum Operation {
    ADDITION('+'),
    SUBTRACTION('-'),
    MULTIPLICATION('*'),
    DIVISION('/');

    private final char sign;

    Operation(char sign) {
        this.sign = sign;
    }

    public static Operation getName(char sign) throws InvalidInputException {
        for (Operation operator : Operation.values()) {
            if (operator.sign == sign) {
                return operator;
            }
        }
        throw new InvalidInputException();
    }

    public char getSign() {
        return this.sign;
    }
}

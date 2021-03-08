package hu.meiit.haladojava.calculator.logic;

import hu.meiit.haladojava.calculator.logic.exceptions.DivisionByZeroException;

public class Executor {
    private static final int ZERO = 0;

    public int add(int operand1, int operand2) {
        return operand1 + operand2;
    }

    public int sub(int operand1, int operand2) {
        return operand1 - operand2;
    }

    public int div(int operand1, int operand2) throws DivisionByZeroException {
        if (operand2 == ZERO) {
            throw new DivisionByZeroException();
        }
        return operand1 / operand2;
    }

    public int mul(int operand1, int operand2) {
        return operand1 * operand2;
    }
}

package hu.meiit.haladojava.calculator.logic;

import hu.meiit.haladojava.calculator.logic.exceptions.DivisionByZeroException;
import hu.meiit.haladojava.calculator.logic.exceptions.InvalidInputException;
import hu.meiit.haladojava.calculator.logic.exceptions.InvalidOperatorException;
import hu.meiit.haladojava.calculator.logic.restrictions.Operation;

public class Expression {
    private static final Executor EXECUTOR = new Executor();

    private final int operand1;

    private final char operator;

    private final int operand2;

    public Expression(int operand1, char operator, int operand2) {
        this.operand1 = operand1;
        this.operator = operator;
        this.operand2 = operand2;
    }

    public int getOperand1() {
        return operand1;
    }

    public char getOperator() {
        return operator;
    }

    public int getOperand2() {
        return operand2;
    }

    public double calculateExpression() throws InvalidInputException,
            DivisionByZeroException, InvalidOperatorException {
        switch (Operation.getName(this.operator)) {
            case ADDITION:
                return EXECUTOR.add(this.operand1, this.operand2);
            case SUBTRACTION:
                return EXECUTOR.sub(this.operand1, this.operand2);
            case MULTIPLICATION:
                return EXECUTOR.mul(this.operand1, this.operand2);
            case DIVISION:
                return EXECUTOR.div(this.operand1, this.operand2);
            default:
                throw new InvalidOperatorException();
        }

    }

}

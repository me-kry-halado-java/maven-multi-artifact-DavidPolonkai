package hu.meiit.haladojava.logic;

public class Expression {
    private final int operand1;
    private final String operator;
    private final int operand2;

    public Expression(int operand1, String operator, int operand2) {
        this.operand1 = operand1;
        this.operator = operator;
        this.operand2 = operand2;
    }

    public int getOperand1() {
        return operand1;
    }

    public String getOperator() {
        return operator;
    }

    public int getOperand2() {
        return operand2;
    }

}

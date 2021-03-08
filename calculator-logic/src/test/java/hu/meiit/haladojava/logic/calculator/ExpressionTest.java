package hu.meiit.haladojava.logic.calculator;

import hu.meiit.haladojava.calculator.logic.Expression;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExpressionTest {

    @Test
    public void getOperand1() {
        //given
        int operator1 = 12;
        char operator = '+';
        int operand2 = 0;
        //when
        Expression expression = new Expression(operator1, operator, operand2);
        //then
        assertEquals(operator1, expression.getOperand1());
    }

    @Test
    public void getOperator() {
        //given
        int operator1 = 0;
        char operator = '*';
        int operand2 = 0;
        //when
        Expression expression = new Expression(operator1, operator, operand2);
        //then
        assertEquals(operator, expression.getOperator());
    }

    @Test
    public void getOperand2() {
        //given
        int operand2 = 12;
        //when
        Expression expression = new Expression(0, '+', operand2);
        //then
        assertEquals(operand2, expression.getOperand2());
    }
}
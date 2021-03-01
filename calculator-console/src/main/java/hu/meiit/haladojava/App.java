package hu.meiit.haladojava;

import hu.meiit.haladojava.logic.Executor;
import hu.meiit.haladojava.logic.Expression;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final String errorResponse ="-";

    private static String[] parse(String expression){
        String[] returnValue = expression.split(" ");
        return returnValue;
    }

    private static String getExpressionFromStandardInput(){
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        return expression;
    }

    private static void assertExpression(String[] parts) throws Exception {
        if (parts.length != 3){
            throw new Exception("wrong input");
        }
    }

    private static Expression getAsExpression(String[] parts){
        return new Expression(
                Integer.parseInt(parts[0]),
                parts[1],
                Integer.parseInt(parts[1])
                );

    }
    private static String executeExpression(Expression expression){
        String result = errorResponse;

        Executor executor = new Executor();

        switch(expression.getOperator()){
            case "+": result = String.valueOf(executor.add(expression.getOperand1(),expression.getOperand2()));
                break;
            case "-": result = String.valueOf(executor.sub(expression.getOperand1(),expression.getOperand2()));
                break;

        }
        return result;
    }

    public static void main( String[] args )
    {
        String result = errorResponse;
        try{
            String expressionFromStandardInput = getExpressionFromStandardInput();
            String[] parts = parse(expressionFromStandardInput);
            assertExpression(parts);
            Expression expression = getAsExpression(parts);
            result = executeExpression(expression);
        }catch (Exception e){}
            System.out.println(result);

    }

}

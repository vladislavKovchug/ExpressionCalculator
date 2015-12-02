package com.teamdev.calculator;

import com.teamdev.fsm.AbstractFiniteStateMachine;
import com.teamdev.calculator.parser.ExpressionParserFactory;

public class MathExpressionCalculator extends AbstractFiniteStateMachine<

        MathExpressionReader,
        EvaluationStack,
        CalculationState,
        EvaluationCommand,
        ExpressionParser,
        CalculationMatrix,
        CalculationError,
        Double>

        implements Calculator {

    final private ExpressionParserFactory parserFactory = new ExpressionParserFactory();
    final private CalculationMatrix matrix = new CalculationMatrix();

    @Override
    public double calculate(String expression) throws CalculationError {
        return run(new MathExpressionReader(expression), new EvaluationStack());
    }


    @Override
    protected Double prepareResult(EvaluationStack context) {
        return context.getStackNode().getOperandStack().pop();
    }

    @Override
    protected void deadlock(MathExpressionReader context) throws CalculationError {
        throw new CalculationError("", -1);
    }

    @Override
    protected ExpressionParser getStateAcceptor(CalculationState state) {
        return parserFactory.getParser(state);
    }

    @Override
    protected CalculationMatrix getTransitionMatrix() {
        return matrix;
    }

    public static void main(String[] args) throws Exception {
        final MathExpressionCalculator calculator = new MathExpressionCalculator();
        final double result = calculator.calculate("2 + 2 * 2 ^ 3");
        System.out.println("result = " + result);
    }
}

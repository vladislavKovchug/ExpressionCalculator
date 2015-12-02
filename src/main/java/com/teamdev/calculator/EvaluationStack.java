package com.teamdev.calculator;

import com.teamdev.fsm.OutputContext;

public class EvaluationStack implements OutputContext {

    private StackNode stackNode = new StackNode(null);

    public StackNode getStackNode() {
        return stackNode;
    }

    public void setStackNode(StackNode stackNode) {
        this.stackNode = stackNode;
    }

    public void popAllOperators() {
        while (!stackNode.getOperatorStack().isEmpty()) {
            popOperator();
        }
    }

    private void popOperator() {
        final Double rightOperand = stackNode.getOperandStack().pop();
        final Double leftOperand = stackNode.getOperandStack().pop();

        final BinaryOperator binaryOperator = stackNode.getOperatorStack().pop();

        final double result = binaryOperator.execute(leftOperand, rightOperand);

        stackNode.getOperandStack().push(result);
    }

    public void pushBinaryOperator(BinaryOperator operator) {

        while (!stackNode.getOperatorStack().isEmpty() &&
                (stackNode.getOperatorStack().peek().compareTo(operator) > -1)) {

            popOperator();

        }

        stackNode.getOperatorStack().push(operator);
    }
}

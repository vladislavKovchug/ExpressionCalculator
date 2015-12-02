package com.teamdev.calculator;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackNode {
    private Deque<Double> operandStack = new ArrayDeque<>();
    private Deque<BinaryOperator> operatorStack = new ArrayDeque<>();
    private StackNode parent;

    public StackNode(StackNode parent) {
        this.parent = parent;
    }

    public Deque<Double> getOperandStack() {
        return operandStack;
    }

    public Deque<BinaryOperator> getOperatorStack() {
        return operatorStack;
    }

    public StackNode getParent() {
        return parent;
    }

    public void setParent(StackNode parent) {
        this.parent = parent;
    }
}

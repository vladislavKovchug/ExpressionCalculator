package com.teamdev.calculator.operator;

import com.teamdev.calculator.BinaryOperator;

public abstract class AbstractBinaryOperator implements BinaryOperator {

    static enum Priority {
        LOW, // +, -
        MEDIUM, // *, /
        HIGH // ^
    }

    private Priority priority;

    public AbstractBinaryOperator(Priority priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(BinaryOperator operator) {
        return priority.compareTo(
                ((AbstractBinaryOperator) operator).priority);
    }
}

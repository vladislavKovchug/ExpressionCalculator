package com.teamdev.calculator.parser;

import com.teamdev.calculator.*;


public class BlockStartParser implements ExpressionParser {
    @Override
    public EvaluationCommand accept(MathExpressionReader reader) {
        if(!reader.hasMoreElements() || reader.geCurrentCharacter() != '('){
            return null;
        }
        reader.movePosition(1);

        return new EvaluationCommand() {
            @Override
            public void execute(EvaluationStack outputContext) {
                StackNode currentNode = outputContext.getStackNode();
                outputContext.setStackNode(new StackNode(currentNode));
            }
        };

    }
}

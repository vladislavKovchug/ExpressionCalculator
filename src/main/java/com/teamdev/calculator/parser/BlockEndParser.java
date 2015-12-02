package com.teamdev.calculator.parser;

import com.teamdev.calculator.*;

/**
 * @author vladislav.kovchug
 */
public class BlockEndParser implements ExpressionParser {
    @Override
    public EvaluationCommand accept(MathExpressionReader reader) {
        if(!reader.hasMoreElements() || reader.geCurrentCharacter() != ')'){
            return null;
        }
        reader.movePosition(1);

        return new EvaluationCommand() {
            @Override
            public void execute(EvaluationStack outputContext) {
                outputContext.popAllOperators();
                StackNode childNode = outputContext.getStackNode();
                double blockResult = childNode.getOperandStack().pop();
                childNode.getParent().getOperandStack().push(blockResult);
                outputContext.setStackNode(childNode.getParent());
            }
        };
    }
}

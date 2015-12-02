package com.teamdev.calculator;

import com.teamdev.fsm.TransitionMatrix;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.teamdev.calculator.CalculationState.*;
import static java.util.EnumSet.noneOf;
import static java.util.EnumSet.of;

public class CalculationMatrix implements TransitionMatrix<CalculationState> {

    private Map<CalculationState, Set<CalculationState>> transitions = new HashMap<
            CalculationState, Set<CalculationState>>() {{
        put(START, of(NUMBER, BLOCK_START));
        put(NUMBER, of(BINARY_OPERATOR, FINISH, BLOCK_END));
        put(BINARY_OPERATOR, of(NUMBER, BLOCK_START));
        put(BLOCK_START, of(NUMBER, BLOCK_START));
        put(BLOCK_END, of(BINARY_OPERATOR, FINISH, BLOCK_END));
        put(FINISH, noneOf(CalculationState.class));
    }};

    @Override
    public CalculationState getStartState() {
        return START;
    }

    @Override
    public CalculationState getFinishState() {
        return FINISH;
    }

    @Override
    public Set<CalculationState> getPossibleTransitions(CalculationState calculationState) {
        return transitions.get(calculationState);
    }
}

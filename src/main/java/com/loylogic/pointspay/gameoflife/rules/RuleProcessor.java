package com.loylogic.pointspay.gameoflife.rules;

import com.loylogic.pointspay.gameoflife.model.Cell;
import com.loylogic.pointspay.gameoflife.model.State;
import com.loylogic.pointspay.gameoflife.strategy.GameStrategy;

public class RuleProcessor {

    private final GameStrategy gameStrategy;

    public RuleProcessor(GameStrategy gameStrategy) {
        this.gameStrategy = gameStrategy;
    }

    public Cell processCell(Cell cell, int neighbourCount) {
        if(cell == null)
            return null;
        for (Rule rule : gameStrategy.getRules()) {
            cell.setState(rule.nextState(cell.getState(), neighbourCount));
        }
        return cell;
    }
}

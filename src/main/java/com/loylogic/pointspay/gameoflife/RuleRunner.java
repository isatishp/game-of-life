package com.loylogic.pointspay.gameoflife;

import com.loylogic.pointspay.gameoflife.gameboard.GameOfLifeBoard;
import com.loylogic.pointspay.gameoflife.model.Cell;
import com.loylogic.pointspay.gameoflife.model.State;
import com.loylogic.pointspay.gameoflife.rules.RuleProcessor;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Hitesh.Dhingra@loylogic.com
 */

public class RuleRunner {

    private final RuleProcessor ruleProcessor;

    public RuleRunner(RuleProcessor ruleProcessor) {
        this.ruleProcessor = ruleProcessor;
    }

    public GameOfLifeBoard applyRules(GameOfLifeBoard board) {
        if(board == null)
            return null;
        Set<Cell> nextGeneration = board.getLiveCells()
                .stream()
                .map(board::findNeighbours)
                .flatMap(Collection::stream)
                .map(cell -> ruleProcessor.processCell(cell, board.findLiveNeighbourCount(cell)))
                .filter(cell -> State.LIVE.equals(cell.getState()))
                .collect(Collectors.toSet());
        return new GameOfLifeBoard(nextGeneration);
    }
}

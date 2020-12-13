package com.loylogic.pointspay.gameoflife;

import com.loylogic.pointspay.gameoflife.gameboard.GameOfLifeBoard;
import com.loylogic.pointspay.gameoflife.model.Cell;
import com.loylogic.pointspay.gameoflife.model.State;
import com.loylogic.pointspay.gameoflife.rules.RuleProcessor;
import com.loylogic.pointspay.gameoflife.strategy.DefaultGameStrategy;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {

        Set<Cell> liveCells = new HashSet<>();
        liveCells.add(new Cell(2, 2, State.LIVE));
        liveCells.add(new Cell(2, 3, State.LIVE));
        liveCells.add(new Cell(2, 4, State.LIVE));

        GameOfLifeBoard board = new GameOfLifeBoard(liveCells);

        RuleRunner ruleRunner = new RuleRunner(new RuleProcessor(new DefaultGameStrategy()));

        for (int i = 1; i <= 5; i++) {
            for (Cell c : board.getLiveCells()) {
                System.out.println("x:" + c.getX() + " ,y:" + c.getY() + " ,state: " + c.getState());
            }
            System.out.println("***********************");
            board = ruleRunner.applyRules(board);
        }
    }
}

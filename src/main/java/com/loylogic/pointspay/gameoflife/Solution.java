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
        GameOfLifeBoard board = new GameOfLifeBoard(getLiveCells());
        RuleRunner ruleRunner = new RuleRunner(new RuleProcessor(new DefaultGameStrategy()));

        System.out.println("*********CURRENT BOARD**************");
        printBoard(board);

        for (int i = 1; i <= 5; i++) {
            System.out.println("*********NEW BOARD**************");
            board = ruleRunner.applyRules(board);
            printBoard(board);
        }
    }

    private static Set<Cell> getLiveCells() {
        Set<Cell> liveCells = new HashSet<>();
        liveCells.add(new Cell(2, 2, State.LIVE));
        liveCells.add(new Cell(2, 3, State.LIVE));
        liveCells.add(new Cell(2, 4, State.LIVE));
        return liveCells;
    }

    private static void printBoard(GameOfLifeBoard board) {
        for (Cell c : board.getLiveCells()) {
            System.out.println("x:" + c.getX() + " ,y:" + c.getY() + " ,state: " + c.getState());
        }
    }
}

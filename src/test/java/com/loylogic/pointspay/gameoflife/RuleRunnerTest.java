package com.loylogic.pointspay.gameoflife;

import com.loylogic.pointspay.gameoflife.gameboard.GameOfLifeBoard;
import com.loylogic.pointspay.gameoflife.rules.RuleProcessor;
import com.loylogic.pointspay.gameoflife.strategy.DefaultGameStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

public class RuleRunnerTest {

    private final RuleRunner ruleRunner = new RuleRunner(new RuleProcessor(new DefaultGameStrategy()));

    @Test
    public void applyRulesTest(){
        GameOfLifeBoard board = new GameOfLifeBoard(ObjectFactory.liveCells());
        GameOfLifeBoard resultBoard = ruleRunner.applyRules(board);
        Assert.assertEquals(3, resultBoard.getLiveCells().size());
        Assert.assertEquals(ObjectFactory.liveCellsAfterFirstStep(), resultBoard.getLiveCells());

        GameOfLifeBoard resultOfResultBoard = ruleRunner.applyRules(resultBoard);
        Assert.assertEquals(3, resultOfResultBoard.getLiveCells().size());
        Assert.assertEquals(ObjectFactory.liveCells(),resultOfResultBoard.getLiveCells());
    }

    @Test
    public void applyRulesEmptyLiveCellsBoardTest(){
        GameOfLifeBoard board = new GameOfLifeBoard(Collections.emptySet());
        GameOfLifeBoard resultBoard = ruleRunner.applyRules(board);
        Assert.assertEquals(0, resultBoard.getLiveCells().size());
    }

    @Test
    public void applyRulesNullBoardTest(){
        Assert.assertNull(ruleRunner.applyRules(null));
    }
}

package com.loylogic.pointspay.gameoflife.rules;

import com.loylogic.pointspay.gameoflife.model.Cell;
import com.loylogic.pointspay.gameoflife.model.State;
import com.loylogic.pointspay.gameoflife.strategy.DefaultGameStrategy;
import com.loylogic.pointspay.gameoflife.strategy.GameStrategy;
import org.junit.Assert;
import org.junit.Test;

public class RuleProcessorTest {

    private final RuleProcessor ruleProcessor = new RuleProcessor(new DefaultGameStrategy());

    @Test
    public void processCellTest() {
        Cell cell = new Cell(2,3, State.DEAD);
        Cell resultCell = ruleProcessor.processCell(cell, 3);
        Assert.assertEquals(State.LIVE, resultCell.getState());
        Assert.assertEquals(State.DEAD, ruleProcessor.processCell(resultCell, 4).getState());
    }

    @Test
    public void processNullCellTest() {
        Assert.assertNull(ruleProcessor.processCell(null, 3));
    }
}

package com.loylogic.pointspay.gameoflife.rules;

import com.loylogic.pointspay.gameoflife.model.State;
import org.junit.Assert;
import org.junit.Test;

public class RuleImplTest {

    private final Rule rule = new RuleImpl();

    @Test
    public void nextStateTestWhenStateLive() {
        State nextState = rule.nextState(State.LIVE, 2);
        Assert.assertEquals(State.LIVE, nextState);

        nextState = rule.nextState(State.LIVE, 0);
        Assert.assertEquals(State.DEAD, nextState);
    }

    @Test
    public void nextStateTestWhenStateDead() {
        State nextState = rule.nextState(State.DEAD, 3);
        Assert.assertEquals(State.LIVE, nextState);

        nextState = rule.nextState(State.DEAD, 0);
        Assert.assertEquals(State.DEAD, nextState);
    }

    @Test
    public void nextStateTestWhenStateNull() {
        State nextState = rule.nextState(null, 3);
        Assert.assertNull(nextState);
    }
}

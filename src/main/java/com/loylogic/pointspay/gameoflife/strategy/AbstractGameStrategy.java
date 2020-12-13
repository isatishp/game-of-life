package com.loylogic.pointspay.gameoflife.strategy;

import com.loylogic.pointspay.gameoflife.rules.Rule;

/**
 * @author Hitesh.Dhingra@loylogic.com
 */
public abstract class AbstractGameStrategy implements GameStrategy {

    private Rule[] rules;

    @Override
    public Rule[] getRules() {
        return rules;
    }

    @Override
    public void setRules(Rule[] rules) {
        this.rules = rules;
    }
}

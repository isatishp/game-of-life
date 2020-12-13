package com.loylogic.pointspay.gameoflife.strategy;

import com.loylogic.pointspay.gameoflife.rules.Rule;

/**
 * @author Hitesh.Dhingra@loylogic.com
 */
public interface GameStrategy {

    Rule[] getRules();

    void setRules(Rule[] rules);
}

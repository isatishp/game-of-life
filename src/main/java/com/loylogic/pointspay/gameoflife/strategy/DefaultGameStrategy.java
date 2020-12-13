package com.loylogic.pointspay.gameoflife.strategy;

import com.loylogic.pointspay.gameoflife.rules.Rule;
import com.loylogic.pointspay.gameoflife.rules.RuleImpl;

/**
 * @author Hitesh.Dhingra@loylogic.com
 */
public class DefaultGameStrategy extends AbstractGameStrategy {

    public DefaultGameStrategy() {
        setRules(new Rule[]{new RuleImpl()});
    }

}

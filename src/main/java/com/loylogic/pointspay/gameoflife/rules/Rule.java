package com.loylogic.pointspay.gameoflife.rules;

import com.loylogic.pointspay.gameoflife.model.State;

/**
 * @author Hitesh.Dhingra@loylogic.com
 */
public interface Rule {
    State nextState(State currentState, int liveNeighbours);
}

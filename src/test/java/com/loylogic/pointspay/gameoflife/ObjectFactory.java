package com.loylogic.pointspay.gameoflife;

import com.loylogic.pointspay.gameoflife.model.Cell;
import com.loylogic.pointspay.gameoflife.model.State;

import java.util.HashSet;
import java.util.Set;

public class ObjectFactory {

    public static Set<Cell> liveCells() {
        Set<Cell> liveCells = new HashSet<>();
        liveCells.add(new Cell(2, 2, State.LIVE));
        liveCells.add(new Cell(2, 3, State.LIVE));
        liveCells.add(new Cell(2, 4, State.LIVE));
        return liveCells;
    }

    public static Set<Cell> liveCellsAfterFirstStep() {
        Set<Cell> liveCells = new HashSet<>();
        liveCells.add(new Cell(1, 3, State.LIVE));
        liveCells.add(new Cell(2, 3, State.LIVE));
        liveCells.add(new Cell(3, 3, State.LIVE));
        return liveCells;
    }
}

package com.loylogic.pointspay.gameoflife.gameboard;

import com.loylogic.pointspay.gameoflife.model.Cell;
import com.loylogic.pointspay.gameoflife.model.State;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class GameOfLifeBoard {

    private final Set<Cell> liveCells;

    public GameOfLifeBoard(Set<Cell> liveCells) {
        this.liveCells = liveCells;
    }

    public Set<Cell> getLiveCells() {
        return this.liveCells;
    }

    public Set<Cell> findNeighbours(Cell cell) {
        if (cell == null)
            return Collections.emptySet();

        Set<Cell> neighbours = new HashSet<>();
        int x = cell.getX();
        int y = cell.getY();

        for (int i = x - 1; i <= x + 1; i++) {
            if (i < 0) continue;

            for (int j = y - 1; j <= y + 1; j++) {
                if (j < 0) continue;

                if( i == x && j == y) continue;

                Cell tempCell = new Cell(i, j);
                if (this.liveCells.contains(tempCell)) {
                    tempCell.setState(State.LIVE);
                }
                neighbours.add(tempCell);
            }
        }
        return neighbours;
    }

    public int findLiveNeighbourCount(Cell cell) {
        if (cell == null)
            return 0;

        return (int) findNeighbours(cell).stream()
                .filter(cl -> State.LIVE.equals(cl.getState()))
                .count();
    }
}

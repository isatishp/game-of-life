package com.loylogic.pointspay.gameoflife.gameboard;


import com.loylogic.pointspay.gameoflife.ObjectFactory;
import com.loylogic.pointspay.gameoflife.model.Cell;
import com.loylogic.pointspay.gameoflife.model.State;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class GameOfLifeBoardTest {

    private final GameOfLifeBoard board = new GameOfLifeBoard(ObjectFactory.liveCells());



    @Test
    public void findLiveNeighbourCountTest() {
        Cell cell = new Cell(2, 3, State.LIVE);
        int liveNeighbourCount = board.findLiveNeighbourCount(cell);
        Assert.assertEquals(2, liveNeighbourCount);

        cell = new Cell(1, 3);
        liveNeighbourCount = board.findLiveNeighbourCount(cell);
        Assert.assertEquals(3, liveNeighbourCount);

        cell = new Cell(0, 0);
        liveNeighbourCount = board.findLiveNeighbourCount(cell);
        Assert.assertEquals(0, liveNeighbourCount);
    }

    @Test
    public void findLiveNeighboursCountWithNullArguments() {
        Assert.assertEquals(0, board.findLiveNeighbourCount(null));
    }

    @Test
    public void findNeighboursTest() {
        Cell cell = new Cell(2, 3, State.LIVE);
        Set<Cell> neighbours = board.findNeighbours(cell);
        Assert.assertEquals(9, neighbours.size());
    }

    @Test
    public void findNeighboursTestCornerCells() {
        Cell cell = new Cell(0, 0);
        Set<Cell> neighbours = board.findNeighbours(cell);
        Assert.assertEquals(4, neighbours.size());
        neighbours.forEach(cl -> Assert.assertEquals(State.DEAD, cl.getState()));
    }

    @Test
    public void findNeighboursWithNullArguments() {
        Assert.assertTrue(board.findNeighbours(null).isEmpty());
    }
}

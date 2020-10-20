package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;

import javax.swing.text.Position;

import java.sql.SQLOutput;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BishopBlackTest {


    @Test
    public void position() {
        BishopBlack bishopBlack = new BishopBlack(Cell.H1);
        Cell cell = bishopBlack.position();
        assertThat(cell, is(bishopBlack.position()));
    }

    @Test
    public void copy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.H1);
        Cell cell = bishopBlack.position();
        Cell cell1 = bishopBlack.copy(cell).position();
        assertThat(cell1, is(cell));


    }

    @Test
    public void way() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] cellsExp = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(cellsExp, is( bishopBlack.way(Cell.G5)));
    }

    @Test
    public void isDiagonalWhen() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        bishopBlack.way(Cell.D7);

    }

    @Test (expected = IllegalStateException.class)
    public void wayExeptions() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] cellsExp = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(cellsExp, is(bishopBlack.way(Cell.G6)));

    }
}
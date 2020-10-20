package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new IllegalStateException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        }
        Cell[] steps = new Cell[Math.abs(this.position().getX() - dest.getX())];
        for (int index = 0; index < steps.length; index++) {
            if (position.getX() > dest.getX()) {
                if (position.getY() > dest.getY()) {
                    steps[index] = Cell.findBy(this.position.getX() - 1 - index, this.position.getY() - 1 - index);
                } else {
                    steps[index] = Cell.findBy(this.position.getX() - 1 - index, this.position.getY() + 1 + index);
                }
            } else if (position.getX() < dest.getX()) {
                if (position.getY() < dest.getY()) {
                    steps[index] = Cell.findBy(this.position.getX() + 1 + index, this.position.getY() + 1 + index);
                } else {
                    steps[index] = Cell.findBy(this.position.getX() + 1 + index, this.position.getY() - 1 - index);
                }
            }
        }
        return steps;
    }

    public boolean isDiagonal(Cell position, Cell dest) {
        boolean rsl = false;
        if (position.getX() + position.getY() == dest.getX() + dest.getY() || position.getX() - position.getY() == dest.getX() - dest.getY()) {
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}

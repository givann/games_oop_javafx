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
        int deltaX = (dest.getX() - position.getX() > 0) ? 1 : -1;
        int deltaY = (dest.getY() - position.getY() > 0) ? 1 : -1;
        int x = this.position.getX();
        int y = this.position.getY();
        for (int index = 0; index < steps.length; index++) {
            x += deltaX;
            y += deltaY;
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell position, Cell dest) {
        return (Math.abs(position.getX() + position.getY()) == Math.abs(dest.getX() + dest.getY()));
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}

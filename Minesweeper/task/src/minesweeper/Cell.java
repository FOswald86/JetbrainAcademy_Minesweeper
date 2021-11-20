package minesweeper;

public class Cell {
    private boolean cell;
    private final char empty = '.';
    private final char mine = 'X';

    public char getEmpty ( ) {
        return empty;
    }

    public char getMine ( ) {
        return mine;
    }

    public Cell ( boolean cell ) {
        this.cell = cell;
    }

    protected boolean isEmpty ( ) {
        return this.cell;
    }
}

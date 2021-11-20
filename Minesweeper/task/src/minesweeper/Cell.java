package minesweeper;

public class Cell {
    private final boolean cell;

    public char getEmpty ( ) {
        return '.';
    }

    public char getMine ( ) {
        return 'X';
    }

    public Cell ( boolean cell ) {
        this.cell = cell;
    }

    protected boolean isEmpty ( ) {
        return this.cell;
    }
}

package minesweeper;

public class Cell {
    private boolean cell;

    public Cell ( boolean cell ) {
        this.cell = cell;
    }

    protected boolean isEmpty ( ) {
        return this.cell;
    }

    public void placeMine ( ) {
        this.cell = false;
    }
}

package minesweeper;

public class Field {

    private char field;

    protected boolean isEmpty ( ) {
        return this.field == '.';
    }

    protected boolean isMine ( ) {
        return this.field == 'X';
    }

    protected void placeMine ( ) {
        this.field = 'X';
    }

    protected void placeCounter ( int counter ) {
        this.field = (char) (counter + 48);
    }

    protected char getField ( ) {
        return field;
    }

    protected Field ( char cell ) {
        this.field = cell;
    }
}

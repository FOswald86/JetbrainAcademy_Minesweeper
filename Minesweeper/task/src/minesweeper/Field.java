package minesweeper;

public class Field {

    private char field;

    protected boolean isEmpty ( ) {
        return this.field == '.';
    }

    protected boolean isMine ( ) {
        return this.field == 'X';
    }

    protected boolean isNumber ( ) {
        return Character.isDigit( this.field );
    }

    public boolean isMark ( ) {
        return this.field == '*';
    }

    protected void setMine ( ) {
        this.field = 'X';
    }

    public void setEmpty ( ) {
        this.field = '.';
    }

    public void setMark ( ) {
        this.field = '*';
    }

    protected void setCounter ( int counter ) {
        this.field = ( char ) ( counter + 48 );
    }

    protected char getField ( ) {
        return this.field;
    }

    protected Field ( char field ) {
        this.field = field;
    }
}

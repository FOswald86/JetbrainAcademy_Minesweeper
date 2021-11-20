package minesweeper;

public class Field {

    private Cell[][] field;
    private final int rows = 9;
    private final int columns = 9;

    protected Field ( ) {
        this.field = new Cell[ this.rows ][ this.columns ];
    }

    protected void preSet ( ) {
        for ( int i = 0; i < this.field.length; i++ ) {
            for ( int j = 0; j < field.length; j++ ) {
                this.field[ i ][ j ] = new Cell( Math.random( ) > 0.1 );
            }
        }
    }

    protected void print ( ) {
        for ( int i = 0; i < this.field.length; i++ ) {
            for ( int j = 0; j < this.field.length; j++ ) {
                System.out.print( this.field[ i ][ j ].isEmpty( ) ?
                        this.field[ i ][ j ].getEmpty( ) : this.field[ i ][ j ].getMine( ) );
            }
            System.out.println( );
        }
    }
}

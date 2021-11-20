package minesweeper;

public class Field {

    private final Cell[][] field;

    protected Field ( ) {
        this.field = new Cell[ 9 ][ 9 ];
    }

    protected void preSet ( ) {
        for ( int i = 0; i < this.field.length; i++ ) {
            for ( int j = 0; j < field.length; j++ ) {
                this.field[ i ][ j ] = new Cell( Math.random( ) > 0.1 );
            }
        }
    }

    protected void print ( ) {
        for ( Cell[] cells : this.field ) {
            for ( int j = 0; j < this.field.length; j++ ) {
                System.out.print( cells[ j ].isEmpty( ) ?
                        cells[ j ].getEmpty( ) : cells[ j ].getMine( ) );
            }
            System.out.println( );
        }
    }
}

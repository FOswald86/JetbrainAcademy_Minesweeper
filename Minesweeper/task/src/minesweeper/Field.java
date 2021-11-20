package minesweeper;

import java.util.Random;

public class Field {

    private final Cell[][] field;

    protected Field ( ) {
        this.field = new Cell[ 9 ][ 9 ];
    }

    protected void preSet ( int mineCount ) {
        generateCells( );
        placeMines( mineCount );
    }

    private void placeMines ( int mineCount ) {
        int c1, c2;
        Random random = new Random();
        while ( mineCount > 0 ) {
            c1 = random.nextInt ( this.field.length - 1 );
            c2 = random.nextInt ( this.field.length - 1 );
            if ( this.field[ c1 ][ c2 ].isEmpty( ) ) {
                this.field[ c1 ][ c2 ].placeMine( );
                mineCount--;
            }
        }
    }

    private void generateCells ( ) {
        for ( int i = 0; i < this.field.length; i++ ) {
            for ( int j = 0; j < this.field.length; j++ ) {
                this.field[ i ][ j ] = new Cell( true );
            }
        }
    }

    protected void print ( ) {
        for ( Cell[] cells : this.field ) {
            for ( int j = 0; j < this.field.length; j++ ) {
                System.out.print( cells[ j ].isEmpty( ) ? '.' : 'X' );
            }
            System.out.println( );
        }
    }
}

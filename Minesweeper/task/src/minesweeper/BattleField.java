package minesweeper;

import java.util.Arrays;
import java.util.Random;

public class BattleField {

    private Field[][] field;

    protected BattleField ( ) {
        this.field = new Field[ 9 ][ 9 ];
    }

    protected void preSet ( int mineCount ) {
        generateEmptyCells( );
        placeMines( mineCount );
        hints( );
    }

    private void generateEmptyCells ( ) {
        for ( int i = 0; i < this.field.length; i++ ) {
            for ( int j = 0; j < this.field.length; j++ ) {
                this.field[ i ][ j ] = new Field( '.' );
            }
        }
    }

    private void placeMines ( int mineCount ) {
        int c1, c2;
        Random random = new Random( );
        while ( mineCount > 0 ) {
            c1 = random.nextInt( this.field.length - 1 );
            c2 = random.nextInt( this.field.length - 1 );
            if ( this.field[ c1 ][ c2 ].isEmpty( ) ) {
                this.field[ c1 ][ c2 ].placeMine( );
                mineCount--;
            }
        }
    }

    protected void hints ( ) {
        int counter = 0;
        for ( int i = 0; i < this.field.length; i++ ) {
            for ( int j = 0; j < this.field.length; j++ ) {
                if ( i == 0 ) {

                } else if ( i == 0 && j == 0) {

                } else if ( i == 0 ) {

                } else if ( i == 0 && j == this.field.length - 1 ) {

                } else if ( ! ( field[ i ][ j ].isEmpty( ) ) ) {

                } else if ( ! ( field[ i ][ j ].isEmpty( ) ) ) {

                } else if ( ! ( field[ i ][ j ].isEmpty( ) ) ) {

                } else if ( ! ( field[ i ][ j ].isEmpty( ) ) ) {

                } else if ( ! ( field[ i ][ j ].isEmpty( ) ) ) {

                }
            }
        }
    }

    protected void print ( ) {
        for ( Field[] row : this.field ) {
            for ( Field field : row ) {
                System.out.print( field.getField( ) );
            }
            System.out.println( );
        }
    }
}


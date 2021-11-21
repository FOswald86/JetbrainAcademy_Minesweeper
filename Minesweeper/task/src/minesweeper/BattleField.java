package minesweeper;

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
        for ( int i = 0; i < this.field.length; i++ ) {
            for ( int j = 0; j < this.field.length; j++ ) {
                int counter = 0;
                // row above
                if ( i - 1 >= 0 && j - 1 >= 0 ) if ( this.field[ i - 1 ][ j - 1 ].isMine( ) ) counter++;
                if ( i - 1 >= 0 ) if ( this.field[ i - 1 ][ j ].isMine( ) ) counter++;
                if ( i - 1 >= 0 && j + 1 < this.field.length ) if ( this.field[ i - 1 ][ j + 1 ].isMine( ) ) counter++;
                // middle row
                if ( j - 1 >= 0 ) if ( this.field[ i ][ j - 1 ].isMine( ) ) counter++;
                if ( j + 1 < this.field.length ) if ( this.field[ i ][ j + 1 ].isMine( ) ) counter++;
                // bottom row
                if ( i + 1 < this.field.length && j - 1 >= 0 ) if ( this.field[ i + 1 ][ j - 1 ].isMine( ) ) counter++;
                if ( i + 1 < this.field.length ) if ( this.field[ i + 1 ][ j ].isMine( ) ) counter++;
                if ( i + 1 < this.field.length && j + 1 < this.field.length ) if ( this.field[ i + 1 ][ j + 1 ].isMine( ) ) counter++;
                // set counter
                if ( counter > 0 && this.field[ i ][ j ].isEmpty( ) ) this.field[ i ][ j ].placeCounter( counter );
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


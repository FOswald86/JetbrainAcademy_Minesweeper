package minesweeper;

import java.util.Random;

public class BattleField {

    protected final Field[][] fieldArray;

    protected BattleField ( ) {
        this.fieldArray = new Field[ 12 ][ 12 ];
    }

    protected void preSet ( int mineCount ) {
        generateField( );
        placeMines( mineCount );
        hints( );
    }

    private void generateField ( ) {
        for ( int i = 0; i < this.fieldArray.length; i++ ) {
            for ( int j = 0; j < this.fieldArray.length; j++ ) {
                if ( i == 0 && j == 0 ) {
                    this.fieldArray[ i ][ j ] = new Field( ' ' );
                } else if ( j == 1 || j == this.fieldArray.length - 1 ) {
                    this.fieldArray[ i ][ j ] = new Field( '|' );
                } else if ( i == 0 && j > 1 && j < this.fieldArray.length - 1 ) {
                    this.fieldArray[ i ][ j ] = new Field( ( char ) ( j + 47 ) );
                } else if ( i == 1 && j > 1 && j < this.fieldArray.length - 1
                        || i == this.fieldArray.length - 1 && j > 1 && j < this.fieldArray.length - 1
                        || i == 1 && j == 0 || i == this.fieldArray.length - 1 && j == 0 ) {
                    this.fieldArray[ i ][ j ] = new Field( '-' );
                } else if ( j == 0 && i > 1 && i < this.fieldArray.length - 1 ) {
                    this.fieldArray[ i ][ j ] = new Field( ( char ) ( i + 47 ) );
                } else {
                    this.fieldArray[ i ][ j ] = new Field( '.' );
                }
            }
        }
    }

    private void placeMines ( int mineCount ) {
        int c1, c2;
        Random random = new Random( );
        while ( mineCount > 0 ) {
            c1 = random.nextInt( 10 ) + 2;
            c2 = random.nextInt( 10 ) + 2;
            if ( this.fieldArray[ c1 ][ c2 ].isEmpty( ) ) {
                this.fieldArray[ c1 ][ c2 ].setMine( );
                mineCount--;
            }
        }
    }

    protected void hints ( ) {
        for ( int i = 0; i < this.fieldArray.length; i++ ) {
            for ( int j = 0; j < this.fieldArray.length; j++ ) {
                int counter = 0;
                // row above
                if ( i - 1 >= 0 && j - 1 >= 0 ) if ( this.fieldArray[ i - 1 ][ j - 1 ].isMine( ) ) counter++;
                if ( i - 1 >= 0 ) if ( this.fieldArray[ i - 1 ][ j ].isMine( ) ) counter++;
                if ( i - 1 >= 0 && j + 1 < this.fieldArray.length )
                    if ( this.fieldArray[ i - 1 ][ j + 1 ].isMine( ) ) counter++;
                // middle row
                if ( j - 1 >= 0 ) if ( this.fieldArray[ i ][ j - 1 ].isMine( ) ) counter++;
                if ( j + 1 < this.fieldArray.length ) if ( this.fieldArray[ i ][ j + 1 ].isMine( ) ) counter++;
                // bottom row
                if ( i + 1 < this.fieldArray.length && j - 1 >= 0 )
                    if ( this.fieldArray[ i + 1 ][ j - 1 ].isMine( ) ) counter++;
                if ( i + 1 < this.fieldArray.length ) if ( this.fieldArray[ i + 1 ][ j ].isMine( ) ) counter++;
                if ( i + 1 < this.fieldArray.length && j + 1 < this.fieldArray.length )
                    if ( this.fieldArray[ i + 1 ][ j + 1 ].isMine( ) ) counter++;
                // set counter
                if ( counter > 0 && this.fieldArray[ i ][ j ].isEmpty( ) )
                    this.fieldArray[ i ][ j ].setCounter( counter );
            }
        }
    }

    protected void print ( ) {
        for ( Field[] row : this.fieldArray ) {
            for ( Field field : row ) {
                System.out.print( field.getField( ) );
            }
            System.out.println( );
        }

    }

    public void replaceMinesWithEmptyInCopy ( BattleField battleField1 ) {
        for ( int i = 0; i < this.fieldArray.length; i++ ) {
            for ( int j = 0; j < this.fieldArray.length; j++ ) {
                if ( battleField1.fieldArray[ i ][ j ].isMine( ) ) {
                    this.fieldArray[ i ][ j ] = new Field( '.' );
                } else {
                    this.fieldArray[ i ][ j ] = new Field( battleField1.fieldArray[ i ][ j ].getField( ) );
                }
            }
        }
    }

    public boolean checkNumber ( int i, int j ) {
            if ( this.fieldArray[ i ][ j ].isNumber( ) ) {
                System.out.println( "There is a number here!" );
                return false;
            } else {
                return true;
            }
    }

    public void handleMark ( int i, int j, BattleField battleField1 ) {
        if ( ! this.fieldArray[ i ][ j ].isMark( ) ) {
            this.fieldArray[ i ][ j ].setMark( );
        } else {
            this.fieldArray[ i ][ j ] = new Field( battleField1.fieldArray[ i ][ j ].getField( ) );
        }
    }
}


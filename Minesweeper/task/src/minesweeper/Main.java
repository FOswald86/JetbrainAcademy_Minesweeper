package minesweeper;

import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) {

        Scanner scanner = new Scanner( System.in );
        BattleField battleField1 = new BattleField( );

        System.out.print( "How many mines do you want on the field? " );
        int mineCounter = scanner.nextInt( );
        battleField1.preSet( mineCounter );

        BattleField battleField2 = new BattleField( );
        battleField2.replaceMinesWithEmptyInCopy( battleField1 );

        while ( ! checkWin( battleField1, battleField2, mineCounter ) ) {
            battleField2.print( );
            int x;
            int y;
            do {
                //do {
                    System.out.println( "Set/delete mine marks (x and y coordinates): " );
                    y = scanner.nextInt( ) + 1;
                    x = scanner.nextInt( ) + 1;
                //} while ( ! ( x > 1 && x < 10 && y > 1 && y < 10 ) );
            } while ( ! battleField2.checkNumber( x, y ) );
            battleField2.handleMark( x, y, battleField1 );
        }
        System.out.println( "Congratulations! You found all the mines!" );
    }

    private static boolean checkWin ( BattleField battleField1, BattleField battleField2, int mineCounter ) {
        int counter = 0;
        for ( int i = 0; i < battleField1.fieldArray.length; i++ ) {
            for ( int j = 0; j < battleField1.fieldArray.length; j++ ) {
                if ( battleField2.fieldArray[ i ][ j ].isMark( ) && battleField1.fieldArray[ i ][ j ].isMine( ) ) {
                    counter++;
                }
            }
        }
        return counter == mineCounter;
    }
}

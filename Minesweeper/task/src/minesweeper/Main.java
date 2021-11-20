package minesweeper;

public class Main {
    public static void main ( String[] args ) {
        run( );
    }

    private static void run ( ) {
        BattleField field = new BattleField( );
        System.out.print( "How many mines do you want on the field? " );
        field.preSet( new java.util.Scanner( System.in ).nextInt( ) );
        field.print( );
    }
}

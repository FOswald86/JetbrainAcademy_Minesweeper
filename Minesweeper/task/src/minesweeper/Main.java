package minesweeper;

public class Main {
    public static void main ( String[] args ) {
        run( );
    }

    private static void run ( ) {
        Field field = new Field( );
        field.preSet( );
        field.print( );
    }
}

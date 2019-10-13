package model;
@SuppressWarnings("all")

public class Position {
    public int row;
    public int column;
    private static int BoardWidth = 8;
    private static int BoardHeight = 8;

    public Position( int row,int column) {
        this.row =row;
        this.column =column;

    }

    public static int getWidth(){
        return Position.BoardWidth;
    }

    public static int getHeight(){
        return Position.BoardHeight;
    }

    public static void setWidth(int i){
        Position.BoardWidth = i;
    }

    public static void setHeight(int i){
        Position.BoardHeight = i;
    }

    public static boolean isValid(int row, int column){
        if(row<0 || column < 0){
            return false;
        }
        if(row >= BoardHeight || column >= BoardWidth){
            return false;
        }
        return true;
    }
    @Override
    public boolean equals(Object o)
    {
        if(o.getClass() != this.getClass()){
            return true;
        }
        Position p = (Position) o;
        return this.column ==p.column &&this.row ==p.row;

    }

    public Position cpyTo(int zeile, int spalte){
        return new Position(this.row - zeile, this.column - spalte);
    }

    @Override
    public String toString() {
        return this.row +" "+this.column;
    }
}

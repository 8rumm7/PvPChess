package model;
@SuppressWarnings("all")

public class Position {
    int zeile;
    int spalte;
    private static int BoardWidth = 8;
    private static int BoardHeight = 8;

    public Position( int zeile,int spalte) {
        this.zeile=zeile;
        this.spalte=spalte;

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

    public static boolean isValid(int zeile, int spalte){
        if(zeile<0 || spalte < 0){
            return false;
        }
        if(zeile >= BoardHeight || spalte >= BoardWidth){
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
        return this.spalte==p.spalte&&this.zeile==p.zeile;

    }

    public Position cpyTo(int zeile, int spalte){
        return new Position(this.zeile - zeile, this.spalte - spalte);
    }

    @Override
    public String toString() {
        return this.zeile+" "+this.spalte;
    }
}

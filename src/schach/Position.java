package schach;

public class Position {
    int spalte;
    int zeile;
    public Position(int spalte, int zeile) {
        this.spalte=spalte;
        this.zeile=zeile;
    }

    public boolean equals(Position p){
        return this.spalte==p.spalte&&this.zeile==p.zeile;
    }
}

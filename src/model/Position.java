package model;

public class Position {
    int zeile;
    int spalte;
    public Position( int zeile,int spalte) {
        this.zeile=zeile;
        this.spalte=spalte;

    }

    public boolean equals(Position p){
        return this.spalte==p.spalte&&this.zeile==p.zeile;
    }

    @Override
    public String toString() {
        return this.zeile+" "+this.spalte;
    }
}
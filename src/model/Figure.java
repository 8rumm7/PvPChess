package model;


public abstract class Figure {
    String kind;
    String color;
    Position position;
    Figure[][] board;

    Figure(String kind, String color, Position position){
        this.kind=kind;
        this.color=color;
        this.position=position;
    }
}

package model;


public  class Figure {
    public String kind;
    public String color;
    public Position position;
    Figure[][] board;

    Figure(String kind, String color, Position position){
        this.kind=kind;
        this.color=color;
        this.position=position;
    }
}

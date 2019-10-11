package model;


import javafx.geometry.Pos;

import java.util.List;
import java.util.stream.Collectors;
@SuppressWarnings("all")

public abstract class Figure {

    Model m;
    private PLAYERCOLOR color;
    private Position position;

    public Figure(Model m, PLAYERCOLOR color, Position position){
        this.color=color;
        this.m = m;
        this.position=position;
    }

    public List<Position> getEligiblePositions(){
        return getPossiblePositions().stream().distinct().filter(p -> m.isFree(this.getColor(), p) ).collect(Collectors.toList());
    }

    public PLAYERCOLOR getColor(){
        return this.color;
    }

    public Position getPosition(){
        return position;
    }

    public abstract List<Position> getPossiblePositions();

    public void setPosition(Position newP){
        this.position = newP;
    }

    @Override
    public String toString(){
        return this.getType()+"@"+this.getPosition().zeile+"/"+this.getPosition().spalte;
    }

    public abstract String getType();


    @Override
    public boolean equals(Object obj) {
        if(obj.getClass()!=this.getClass()){
            return false;
        }
        Figure other = (Figure)obj;
        return this.getColor().equals(other.getColor());
    }
}

package model;


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

    public List<Position> getAllowedPositions(){
        return getEligiblePositions();
    }

    public PLAYERCOLOR getColor(){
        return this.color;
    }

    public Position getPosition(){
        return position;
    }


    public abstract List<Position> getPossiblePositions();

    public boolean move(Position p){
        if(!Position.isValid(p.row,p.column)) return false;
        this.position = p;
        return true;
    }

    public boolean move(int zeile, int spalte){
        if(!Position.isValid(zeile, spalte)) return false;
        this.position = new Position(zeile, spalte);
        return true;
    }

    public void setPosition(Position newP){
        this.position = newP;
    }

    @Override
    public String toString(){
        return this.getColor()+" "+this.getType()+"@"+this.getPosition().row +"/"+this.getPosition().column;
    }

    public abstract String getType();


    @Override
    public boolean equals(Object obj) {
        if(obj.getClass()!=this.getClass()){
            return false;
        }
        Figure other = (Figure)obj;
        return this.getColor().equals(other.getColor()) && this.getPosition().equals(other.getPosition());
    }
}

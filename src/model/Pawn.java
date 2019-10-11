package model;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("all")
public class Pawn extends Figure {


    public Pawn(Model m, PLAYERCOLOR color, Position position) {
        super(m, color, position);
    }

    @Override
    public String getType() {
        return "Pawn";
    }

    private boolean eligiblePos(Position p){
        if(m.getFigureAt(p.zeile,p.spalte) == null){
            return false;
        }
        if(m.getFigureAt(p.zeile,p.spalte).getColor() == this.getColor()){
            return false;
        }
        return true;
    }

    @Override
    public List<Position> getPossiblePositions() {
        List<Position> ret = new LinkedList<Position>();
        Position p;
        int i=-1;
        if(this.getColor() == PLAYERCOLOR.WHITE){
            i=1;
        }
        if(Position.isValid(this.getPosition().zeile+i, this.getPosition().spalte)){
            p = new Position(this.getPosition().zeile+i, this.getPosition().spalte);
            ret.add(p);
        }
        for(int c = -1; c<2; c+=2){
            if(Position.isValid(this.getPosition().zeile+i, this.getPosition().spalte+c )){
                p = new Position(this.getPosition().zeile+i, this.getPosition().spalte+c);
                if(eligiblePos(p)) ret.add(p);
            }
        }
        return ret;

    }
}
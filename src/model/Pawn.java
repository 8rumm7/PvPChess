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
        if(m.getFigureAt(p.row,p.column) == null){
            return false;
        }
        if(m.getFigureAt(p.row,p.column).getColor() == this.getColor()){
            return false;
        }
        return true;
    }

    @Override
    public List<Position> getPossiblePositions() {
        List<Position> ret = new LinkedList<Position>();
        Position p;
        int i=-1;
        int start = 6;
        if(this.getColor() == PLAYERCOLOR.WHITE){
            i=1;
            start = 1;
        }
        if(this.getPosition().row == start ){
            p = new Position(this.getPosition().row +i, this.getPosition().column);

        }
        if(Position.isValid(this.getPosition().row +i, this.getPosition().column)){
            p = new Position(this.getPosition().row +i, this.getPosition().column);
            if(m.getFigureAt(p.row,p.column) == null){
                ret.add(p);
                if(this.getPosition().row == start){
                    p = new  Position(this.getPosition().row +2*i, this.getPosition().column);
                    if(m.getFigureAt(p.row,p.column) == null){
                        ret.add(p);
                    }
                }
            }

        }
        for(int c = -1; c<2; c+=2){
            if(Position.isValid(this.getPosition().row +i, this.getPosition().column +c )){
                p = new Position(this.getPosition().row +i, this.getPosition().column +c);
                if(eligiblePos(p)) ret.add(p);
            }
        }
        return ret;

    }
}

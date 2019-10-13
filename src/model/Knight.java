package model;

import java.util.LinkedList;
import java.util.List;
@SuppressWarnings("all")

public class Knight extends Figure {


    public Knight(Model m, PLAYERCOLOR color, Position position) {
        super(m, color, position);
    }

    @Override
    public String getType() {
        return "Knight";
    }

    @Override
    public List<Position> getPossiblePositions() {
        List<Position> ret = new LinkedList<Position>();
        Position p;
        for(int i = -2; i <5; i+=4){
            for(int c = -1; c < 2; c+=2){
                if(Position.isValid(this.getPosition().row +i, this.getPosition().column +c)){
                    p = new Position(this.getPosition().row +i, this.getPosition().column +c);
                    ret.add(p);
                }
                if(Position.isValid(this.getPosition().row +c, this.getPosition().column +i)){
                    p = new Position(this.getPosition().row +c, this.getPosition().column +i);
                    ret.add(p);
                }
            }
        }
        return ret;
    }
}

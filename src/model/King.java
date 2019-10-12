package model;

import java.util.LinkedList;
import java.util.List;
@SuppressWarnings("all")

public class King extends Figure{


    public King(Model m, PLAYERCOLOR color, Position position) {
        super(m, color, position);
    }

    @Override
    public String getType() {
        return "King";
    }

    @Override
    public List<Position> getPossiblePositions() {
        List<Position> ret = new LinkedList<Position>();
        Position p;
            for(int i = -1; i<2; i++){
                for(int c = -1; c < 2; c++){
                    if(Position.isValid(this.getPosition().zeile+i,this.getPosition().spalte+c)){
                        p = new Position(this.getPosition().zeile+i,this.getPosition().spalte+c);
                        if(!ret.contains(p)){
                            ret.add(p);
                        }
                    }
                }
            }

            


            return ret;
    }
}

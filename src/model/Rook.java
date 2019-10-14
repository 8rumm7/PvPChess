package model;

import java.util.LinkedList;
import java.util.List;
@SuppressWarnings("all")

public class Rook extends Figure {


    public Rook(Model m, PLAYERCOLOR color, Position position) {
        super(m, color, position);
    }

    @Override
    public String getType() {
        return "Rook";
    }

    @Override
    public List<Position> getPossiblePositions() {
        List<Position> ret = new LinkedList<Position>();
        Position p;
        int maxedNum = Math.max(Position.getHeight(),Position.getWidth());
        for(int i = 1; i <maxedNum; i++){
            if(Position.isValid(this.getPosition().row, this.getPosition().column -i)){
                p = new Position(this.getPosition().row, this.getPosition().column -i);
                //if(!m.isFree(this.getColor(), p)) break;

                ret.add(p);
                if(m.getFigureAt(p) != null) break;

            }
        }

        for(int i = 1; i <maxedNum; i++){
            if(Position.isValid(this.getPosition().row, this.getPosition().column +i)){
                p = new Position(this.getPosition().row, this.getPosition().column +i);
                //if(!m.isFree(this.getColor(), p)) break;

                ret.add(p);
                if(m.getFigureAt(p) != null) break;

            }
        }

        for(int i = 1; i <maxedNum; i++){
            if(Position.isValid(this.getPosition().row +i, this.getPosition().column)){
                p = new Position(this.getPosition().row +i, this.getPosition().column);
                //if(!m.isFree(this.getColor(), p)) break;

                ret.add(p);
                if(m.getFigureAt(p) != null) break;

            }
        }
        for(int i = 1; i <maxedNum; i++){
            if(Position.isValid(this.getPosition().row -i, this.getPosition().column)){
                p = new Position(this.getPosition().row -i, this.getPosition().column);
                //if(!m.isFree(this.getColor(), p)) break;

                ret.add(p);
                if(m.getFigureAt(p) != null) break;

            }
        }
        return ret;
    }
}

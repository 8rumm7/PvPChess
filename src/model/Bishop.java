package model;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("all")

public class Bishop extends Figure{


    public Bishop(Model m, PLAYERCOLOR color, Position position) {
        super(m, color, position);
    }



    @Override
    public String getType() {
        return "Bishop";
    }


    public List<Position> getPossiblePositions() {
        List<Position> ret = new LinkedList<Position>();
        int maxedNum = Math.max(Position.getHeight(),Position.getWidth());
        Position p;
        for(int i = 1; i< maxedNum; i++){
            if(Position.isValid(this.getPosition().row +i, this.getPosition().column +i)){
                p = (new Position(this.getPosition().row +i, this.getPosition().column +i));
                if(!m.isFree(this.getColor(), p)){
                    break;
                }
                if(!ret.contains(p)) ret.add(p);
                if(m.getFigureAt(p) != null) break;

            }
        }

        for(int i = 1; i< maxedNum; i++){
            if(Position.isValid(this.getPosition().row +i, this.getPosition().column -i)){
                p = (new Position(this.getPosition().row +i, this.getPosition().column -i));
                if(!m.isFree(this.getColor(), p)){
                    break;
                }
                if(!ret.contains(p)) ret.add(p);
                if(m.getFigureAt(p) != null) break;

            }
        }

        for(int i = 1; i< maxedNum; i++){
            if(Position.isValid(this.getPosition().row -i, this.getPosition().column +i)){
                p = (new Position(this.getPosition().row -i, this.getPosition().column +i));
                if(!m.isFree(this.getColor(), p)){
                    break;
                }
                if(!ret.contains(p)) ret.add(p);
                if(m.getFigureAt(p) != null) break;

            }
        }

        for(int i = 1; i< maxedNum; i++){
            if(Position.isValid(this.getPosition().row -i, this.getPosition().column -i)){
                p = (new Position(this.getPosition().row -i, this.getPosition().column -i));
                if(!m.isFree(this.getColor(), p)){
                    break;
                }
                if(!ret.contains(p)) ret.add(p);
                if(m.getFigureAt(p) != null) break;


            }
        }

        return ret;
    }
}

package model;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<Position> getEligiblePositions(){
        List<Position> ret = new LinkedList<Position>();
        ret= getPossiblePositions().stream().distinct().filter(p -> m.isFree(this.getColor(), p) ).collect(Collectors.toList());
        PLAYERCOLOR color = this.getColor();
        List<Position> possiblePositionsForNextTurn = new LinkedList<Position>();
        for(Figure f : m.getFigureList()){
            if(f.getColor() != color){
                possiblePositionsForNextTurn.addAll(f.getPossiblePositions());
            }
        }
        System.out.println("LOS");
        for(Position p : possiblePositionsForNextTurn){
            System.out.println(p);
        }
        System.out.println("STOP");
        ret.removeAll(possiblePositionsForNextTurn);
        return ret;
    }


    @Override
    public List<Position> getPossiblePositions() {
        List<Position> ret = new LinkedList<Position>();
        Position p;
            for(int i = -1; i<2; i++){
                for(int c = -1; c < 2; c++){
                    if(Position.isValid(this.getPosition().row +i,this.getPosition().column +c)){
                        p = new Position(this.getPosition().row +i,this.getPosition().column +c);
                        if(!ret.contains(p)){
                            ret.add(p);
                        }
                    }
                }
            }

            


            return ret;
    }
}

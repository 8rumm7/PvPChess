package schach;

import java.util.LinkedList;

class Pawn implements Figure {
    private static final boolean WHITE = true;
    private static final boolean BLACK = false;
    public LinkedList<Figure> allFigures;
    Position position;
    boolean color;

    Pawn(Position position, boolean color) {
        this.position = position;
        this.color = color;
    }

    LinkedList<Position> possiblePositions() {
        LinkedList<Position> positions= new LinkedList<>();
        if(color==WHITE){
            if(position.zeile==1){
                positions.add(new Position(position.zeile+2,position.spalte));
            }
            positions.add(new Position(position.zeile+1,position.spalte));
        }else{
            if(position.zeile==6){
                positions.add(new Position(position.zeile-2,position.spalte));
            }
            positions.add(new Position(position.zeile-1,position.spalte));
        }
        return positions;
    }


}

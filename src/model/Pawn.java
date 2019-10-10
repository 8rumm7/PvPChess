package model;

import java.util.LinkedList;

class Pawn extends Figure {
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
            if(position.zeile==1&&board[3][position.spalte] == null){
                positions.add(new Position(position.zeile+2,position.spalte));
            }
            if(board[position.zeile+1][position.spalte] == null){
                positions.add(new Position(position.zeile+1,position.spalte));
            }
            if(board[position.zeile+1][position.spalte-1] != null){
                positions.add(new Position(position.zeile+1,position.spalte-1));
            }
            if(board[position.zeile+1][position.spalte+1] != null){
                positions.add(new Position(position.zeile+1,position.spalte+1));
            }
        }else{
            if(position.zeile==6&&board[4][position.spalte] == null){
                positions.add(new Position(position.zeile-2,position.spalte));
            }
            if(board[position.zeile-1][position.spalte] == null){
                positions.add(new Position(position.zeile-1,position.spalte));
            }
            if(board[position.zeile-1][position.spalte-1] == null){
                positions.add(new Position(position.zeile-1,position.spalte-1));
            }
            if(board[position.zeile-1][position.spalte+1] == null){
                positions.add(new Position(position.zeile-1,position.spalte+1));
            }
        }
        return positions;
    }


}

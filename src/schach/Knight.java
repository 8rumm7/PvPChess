package schach;

import java.util.LinkedList;

class Knight implements Figure {
    private static final boolean WHITE = true;
    private static final boolean BLACK = false;
    Position position;
    boolean color;

    Knight(Position position, boolean color) {
        this.position = position;
        this.color = color;
    }

    LinkedList<Position> possiblePositions() {
        LinkedList<Position> positions = new LinkedList<>();
        Position p;
        p = new Position(position.spalte + 1, position.zeile + 2);
        if (!position.equals(p)&&p.spalte >= 0 && p.spalte <= 7 && p.zeile >= 0 && p.zeile <= 7){
            positions.add(p);
        }
        p = new Position(position.spalte + 1, position.zeile - 2);
        if (!position.equals(p)&&p.spalte >= 0 && p.spalte <= 7 && p.zeile >= 0 && p.zeile <= 7){
            positions.add(p);
        }
        p = new Position(position.spalte - 1, position.zeile + 2);
        if (!position.equals(p)&&p.spalte >= 0 && p.spalte <= 7 && p.zeile >= 0 && p.zeile <= 7) {
            positions.add(p);
        }
        p = new Position(position.spalte - 1, position.zeile - 2);
        if (!position.equals(p)&&p.spalte >= 0 && p.spalte <= 7 && p.zeile >= 0 && p.zeile <= 7){
            positions.add(p);
        }
        p = new Position(position.spalte + 2, position.zeile + 1);
        if (!position.equals(p)&&p.spalte >= 0 && p.spalte <= 7 && p.zeile >= 0 && p.zeile <= 7) {
            positions.add(p);
        }
        p = new Position(position.spalte + 2, position.zeile - 1);
        if(!position.equals(p)&&p.spalte >= 0 && p.spalte <= 7 && p.zeile >= 0 && p.zeile <= 7) {
            positions.add(p);
        }
        p = new Position(position.spalte - 2, position.zeile + 1);
        if (!position.equals(p)&&p.spalte >= 0 && p.spalte <= 7 && p.zeile >= 0 && p.zeile <= 7) {
            positions.add(p);
        }
        p = new Position(position.spalte - 2, position.zeile - 1);
        if (!position.equals(p)&&p.spalte >= 0 && p.spalte <= 7 && p.zeile >= 0 && p.zeile <= 7){
            positions.add(p);
        }
        return positions;
    }
}

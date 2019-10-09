package chess;

import java.util.LinkedList;

class King extends Figure {
    private static final boolean WHITE = true;
    private static final boolean BLACK = false;
    Position position;
    boolean color;

    King(Position position, boolean color) {
        this.position = position;
        this.color = color;
    }

    LinkedList<Position> possiblePositions() {
        Position p;
        LinkedList<Position> positions = new LinkedList<>();
        p = new Position(position.spalte + 1, position.zeile + 1);
        if (p.spalte >= 0 && p.spalte <= 7 && p.zeile >= 0 && p.zeile <= 7) {
            positions.add(p);
        }
        p = new Position(position.spalte + 1, position.zeile - 1);
        if (p.spalte >= 0 && p.spalte <= 7 && p.zeile >= 0 && p.zeile <= 7) {
            positions.add(p);
        }
        p = new Position(position.spalte - 1, position.zeile + 1);
        if (p.spalte >= 0 && p.spalte <= 7 && p.zeile >= 0 && p.zeile <= 7) {
            positions.add(p);
        }
        p = new Position(position.spalte - 1, position.zeile - 1);
        if (p.spalte >= 0 && p.spalte <= 7 && p.zeile >= 0 && p.zeile <= 7) {
            positions.add(p);
        }
        p = new Position(position.spalte + 1, position.zeile);
        if (p.spalte >= 0 && p.spalte <= 7 && p.zeile >= 0 && p.zeile <= 7) {
            positions.add(p);
        }
        p = new Position(position.spalte, position.zeile + 1);
        if (p.spalte >= 0 && p.spalte <= 7 && p.zeile >= 0 && p.zeile <= 7) {
            positions.add(p);
        }
        p = new Position(position.spalte - 1, position.zeile);
        if (p.spalte >= 0 && p.spalte <= 7 && p.zeile >= 0 && p.zeile <= 7) {
            positions.add(p);
        }
        p = new Position(position.spalte, position.zeile - 1);
        if (p.spalte >= 0 && p.spalte <= 7 && p.zeile >= 0 && p.zeile <= 7) {
            positions.add(p);
        }
        return positions;
    }
}

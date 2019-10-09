package chess;

import java.util.LinkedList;

class Bishop extends Figure {
    private static final boolean WHITE = true;
    private static final boolean BLACK = false;
    Position position;
    boolean color;
    Figure[][] board;

    Bishop(Position position, boolean color) {
        this.position = position;
        this.color = color;
    }

    LinkedList<Position> possiblePositions() {
        LinkedList<Position> positions = new LinkedList<>();
        Position p;
        for (int i = 0; i < 8; i++) {
            p = new Position(position.spalte + i, position.zeile + i);
            if (!position.equals(p) && p.spalte >= 0 && p.spalte <= 7 && p.zeile >= 0 && p.zeile <= 7) {
                positions.add(p);

                if (board[p.zeile][p.spalte] != null) {
                    break;
                }
            }
        }
        for (int i = 0; i < 8; i++) {

            p = new Position(position.spalte + i, position.zeile - i);
            if (!position.equals(p) && p.spalte >= 0 && p.spalte <= 7 && p.zeile >= 0 && p.zeile <= 7) {
                positions.add(p);
                if (board[p.zeile][p.spalte] != null) {
                    break;
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            p = new Position(position.spalte - i, position.zeile + i);
            if (!position.equals(p) && p.spalte >= 0 && p.spalte <= 7 && p.zeile >= 0 && p.zeile <= 7) {
                positions.add(p);
                if (board[p.zeile][p.spalte] != null) {
                    break;
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            p = new Position(position.spalte - i, position.zeile - i);
            if (!position.equals(p) && p.spalte >= 0 && p.spalte <= 7 && p.zeile >= 0 && p.zeile <= 7) {
                positions.add(p);
                if (board[p.zeile][p.spalte] != null) {
                    break;
                }
            }
        }
        return positions;
    }
}

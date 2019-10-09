package schach;

import java.util.LinkedList;

class Model {
    LinkedList<Figure> figureList = init();
    private static final boolean WHITE = true;
    private static final boolean BLACK = false;

    private LinkedList<Figure> init() {
        LinkedList<Figure> ret = new LinkedList<>();
        ret.add(new King(new Position(4, 0), WHITE));
        ret.add(new King(new Position(4, 7), BLACK));
        ret.add(new Queen(new Position(3, 0), WHITE));
        ret.add(new Queen(new Position(3, 7), BLACK));
        ret.add(new Rook(new Position(0, 0), WHITE));
        ret.add(new Rook(new Position(7, 0), WHITE));
        ret.add(new Rook(new Position(0, 7), BLACK));
        ret.add(new Rook(new Position(7, 7), BLACK));
        ret.add(new Bishop(new Position(2, 0), WHITE));
        ret.add(new Bishop(new Position(5, 0), WHITE));
        ret.add(new Bishop(new Position(2, 7), BLACK));
        ret.add(new Bishop(new Position(5, 7), BLACK));
        ret.add(new Knight(new Position(1, 0), WHITE));
        ret.add(new Knight(new Position(6, 0), WHITE));
        ret.add(new Knight(new Position(1, 7), BLACK));
        ret.add(new Knight(new Position(6, 7), BLACK));
        for (int i = 0; i < 8; i++) {
            ret.add(new Pawn(new Position(i, 1), WHITE));
            ret.add(new Pawn(new Position(i, 6), BLACK));
        }
        return ret;
    }
}

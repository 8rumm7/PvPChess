package chess;

import java.util.LinkedList;

class Model {
    private LinkedList<Figure> figureList;
    private static final boolean WHITE = true;
    private static final boolean BLACK = false;
    static Figure[][] board;

    void init() {
        figureList.add(new King(new Position(4, 0), WHITE));
        figureList.add(new King(new Position(4, 7), BLACK));
        figureList.add(new Queen(new Position(3, 0), WHITE));
        figureList.add(new Queen(new Position(3, 7), BLACK));
        figureList.add(new Rook(new Position(0, 0), WHITE));
        figureList.add(new Rook(new Position(7, 0), WHITE));
        figureList.add(new Rook(new Position(0, 7), BLACK));
        figureList.add(new Rook(new Position(7, 7), BLACK));
        figureList.add(new Bishop(new Position(2, 0), WHITE));
        figureList.add(new Bishop(new Position(5, 0), WHITE));
        figureList.add(new Bishop(new Position(2, 7), BLACK));
        figureList.add(new Bishop(new Position(5, 7), BLACK));
        figureList.add(new Knight(new Position(1, 0), WHITE));
        figureList.add(new Knight(new Position(6, 0), WHITE));
        figureList.add(new Knight(new Position(1, 7), BLACK));
        figureList.add(new Knight(new Position(6, 7), BLACK));
        for (int i = 0; i < 8; i++) {
            figureList.add(new Pawn(new Position(i, 1), WHITE));
            figureList.add(new Pawn(new Position(i, 6), BLACK));
        }
        for(Figure f: figureList){
            Position p = f.position;
            board[p.zeile][p.spalte]=f;
        }
        for(Figure f :figureList){
            f.board=board;
        }
    }
}

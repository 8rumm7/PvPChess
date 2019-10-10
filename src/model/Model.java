package model;

import java.util.LinkedList;

public class Model {
    public LinkedList<Figure> figureList;
    public LinkedList<Figure> blackDeadList;
    public LinkedList<Figure> whiteDeadList;
    static Figure[][] board;
    private static final String KING = "KING";
    private static final String QUEEN = "QUEEN";
    private static final String BISHOP = "BISHOP";
    private static final String ROOK = "ROOK";
    private static final String KNIGHT = "KNIGHT";
    private static final String PAWN = "PAWN";
    private static final String BLACK = "BLACK";
    private static final String WHITE = "WHITE";


    public void init() {
        figureList = new LinkedList<>();
        whiteDeadList = new LinkedList<>();
        blackDeadList = new LinkedList<>();
        board = new Figure[8][8];
        figureList.add(new Figure(KING, WHITE, new Position(0, 4)));
        figureList.add(new Figure(KING, BLACK, new Position(7, 4)));
        figureList.add(new Figure(QUEEN, WHITE, new Position(0, 3)));
        figureList.add(new Figure(QUEEN, BLACK, new Position(7, 3)));
        figureList.add(new Figure(ROOK, WHITE, new Position(0, 0)));
        figureList.add(new Figure(ROOK, BLACK, new Position(7, 0)));
        figureList.add(new Figure(ROOK, WHITE, new Position(0, 7)));
        figureList.add(new Figure(ROOK, BLACK, new Position(7, 7)));
        figureList.add(new Figure(BISHOP, WHITE, new Position(0, 2)));
        figureList.add(new Figure(BISHOP, BLACK, new Position(7, 2)));
        figureList.add(new Figure(BISHOP, WHITE, new Position(0, 5)));
        figureList.add(new Figure(BISHOP, BLACK, new Position(7, 5)));
        figureList.add(new Figure(KNIGHT, WHITE, new Position(0, 1)));
        figureList.add(new Figure(KNIGHT, BLACK, new Position(7, 1)));
        figureList.add(new Figure(KNIGHT, WHITE, new Position(0, 6)));
        figureList.add(new Figure(KNIGHT, BLACK, new Position(7, 6)));
        for (int i = 0; i < 8; i++) {
            figureList.add(new Figure(PAWN, WHITE, new Position(1, i)));
            figureList.add(new Figure(PAWN, BLACK, new Position(6, i)));
        }
        for (Figure f : figureList) {
            Position p = f.position;
            board[p.zeile][p.spalte] = f;
        }
        for (Figure f : figureList) {
            f.board = board;
        }
    }

    LinkedList<Position> possiblePositions(Figure figure) {
        Position position = figure.position;
        Position newPosition = figure.position;
        LinkedList<Position> positions = new LinkedList<>();
        if (figure.kind.equals(KING)) {
            newPosition = new Position(position.spalte + 1, position.zeile + 1);
            if (newPosition.spalte >= 0 && newPosition.spalte <= 7 && newPosition.zeile >= 0 && newPosition.zeile <= 7) {
                positions.add(newPosition);
            }
            newPosition = new Position(position.spalte + 1, position.zeile - 1);
            if (newPosition.spalte >= 0 && newPosition.spalte <= 7 && newPosition.zeile >= 0 && newPosition.zeile <= 7) {
                positions.add(newPosition);
            }
            newPosition = new Position(position.spalte - 1, position.zeile + 1);
            if (newPosition.spalte >= 0 && newPosition.spalte <= 7 && newPosition.zeile >= 0 && newPosition.zeile <= 7) {
                positions.add(newPosition);
            }
            newPosition = new Position(position.spalte - 1, position.zeile - 1);
            if (newPosition.spalte >= 0 && newPosition.spalte <= 7 && newPosition.zeile >= 0 && newPosition.zeile <= 7) {
                positions.add(newPosition);
            }
            newPosition = new Position(position.spalte + 1, position.zeile);
            if (newPosition.spalte >= 0 && newPosition.spalte <= 7 && newPosition.zeile >= 0 && newPosition.zeile <= 7) {
                positions.add(newPosition);
            }
            newPosition = new Position(position.spalte, position.zeile + 1);
            if (newPosition.spalte >= 0 && newPosition.spalte <= 7 && newPosition.zeile >= 0 && newPosition.zeile <= 7) {
                positions.add(newPosition);
            }
            newPosition = new Position(position.spalte - 1, position.zeile);
            if (newPosition.spalte >= 0 && newPosition.spalte <= 7 && newPosition.zeile >= 0 && newPosition.zeile <= 7) {
                positions.add(newPosition);
            }
            newPosition = new Position(position.spalte, position.zeile - 1);
            if (newPosition.spalte >= 0 && newPosition.spalte <= 7 && newPosition.zeile >= 0 && newPosition.zeile <= 7) {
                positions.add(newPosition);
            }
        }
        if (figure.kind.equals(QUEEN)) {
            for (int i = 1; i < 8; i++) {
                newPosition = new Position(position.spalte + i, position.zeile + i);
                if (!position.equals(newPosition) && newPosition.spalte >= 0 && newPosition.spalte <= 7 && newPosition.zeile >= 0 && newPosition.zeile <= 7) {
                    positions.add(newPosition);
                    if (board[newPosition.zeile][newPosition.spalte] != null) {
                        break;
                    }
                }
            }
            for (int i = 1; i < 8; i++) {
                newPosition = new Position(position.spalte + i, position.zeile - i);
                if (!position.equals(newPosition) && newPosition.spalte >= 0 && newPosition.spalte <= 7 && newPosition.zeile >= 0 && newPosition.zeile <= 7) {
                    positions.add(newPosition);
                    if (board[newPosition.zeile][newPosition.spalte] != null) {
                        break;
                    }
                }
            }
            for (int i = 1; i < 8; i++) {
                newPosition = new Position(position.spalte - i, position.zeile + i);
                if (!position.equals(newPosition) && newPosition.spalte >= 0 && newPosition.spalte <= 7 && newPosition.zeile >= 0 && newPosition.zeile <= 7) {
                    positions.add(newPosition);
                    if (board[newPosition.zeile][newPosition.spalte] != null) {
                        break;
                    }
                }
            }
            for (int i = 1; i < 8; i++) {
                newPosition = new Position(position.spalte - i, position.zeile - i);
                if (!position.equals(newPosition) && newPosition.spalte >= 0 && newPosition.spalte <= 7 && newPosition.zeile >= 0 && newPosition.zeile <= 7) {
                    positions.add(newPosition);
                    if (board[newPosition.zeile][newPosition.spalte] != null) {
                        break;
                    }
                }
            }
            for (int i = 1; i < 8; i++) {
                newPosition = new Position(i, position.zeile);
                if (!position.equals(newPosition) && newPosition.spalte >= 0 && newPosition.spalte <= 7 && newPosition.zeile >= 0 && newPosition.zeile <= 7) {
                    positions.add(newPosition);
                    if (board[newPosition.zeile][newPosition.spalte] != null) {
                        break;
                    }
                }
            }
            for (int i = 1; i < 8; i++) {
                newPosition = new Position(position.spalte, i);
                if (!position.equals(newPosition) && newPosition.spalte >= 0 && newPosition.spalte <= 7 && newPosition.zeile >= 0 && newPosition.zeile <= 7) {
                    positions.add(newPosition);
                    if (board[newPosition.zeile][newPosition.spalte] != null) {
                        break;
                    }
                }

            }
        }
        if (figure.kind.equals(ROOK)) {
            for (int i = 0; i < 8; i++) {
                newPosition = new Position(position.spalte, i);
                if (!position.equals(newPosition) && newPosition.spalte >= 0 && newPosition.spalte <= 7 && newPosition.zeile >= 0 && newPosition.zeile <= 7) {
                    positions.add(newPosition);
                    if (board[newPosition.zeile][newPosition.spalte] != null) {
                        break;
                    }

                }
            }
            for (int i = 0; i < 8; i++) {
                newPosition = new Position(i, position.zeile);
                if (!position.equals(newPosition) && newPosition.spalte >= 0 && newPosition.spalte <= 7 && newPosition.zeile >= 0 && newPosition.zeile <= 7) {
                    positions.add(newPosition);
                    if (board[newPosition.zeile][newPosition.spalte] != null) {
                        break;
                    }
                }
            }
        }
        if (figure.kind.equals(BISHOP)) {
            for (int i = 0; i < 8; i++) {
                newPosition = new Position(position.spalte + i, position.zeile + i);
                if (!position.equals(newPosition) && newPosition.spalte >= 0 && newPosition.spalte <= 7 && newPosition.zeile >= 0 && newPosition.zeile <= 7) {
                    positions.add(newPosition);

                    if (board[newPosition.zeile][newPosition.spalte] != null) {
                        break;
                    }
                }
            }
            for (int i = 0; i < 8; i++) {

                newPosition = new Position(position.spalte + i, position.zeile - i);
                if (!position.equals(newPosition) && newPosition.spalte >= 0 && newPosition.spalte <= 7 && newPosition.zeile >= 0 && newPosition.zeile <= 7) {
                    positions.add(newPosition);
                    if (board[newPosition.zeile][newPosition.spalte] != null) {
                        break;
                    }
                }
            }
            for (int i = 0; i < 8; i++) {
                newPosition = new Position(position.spalte - i, position.zeile + i);
                if (!position.equals(newPosition) && newPosition.spalte >= 0 && newPosition.spalte <= 7 && newPosition.zeile >= 0 && newPosition.zeile <= 7) {
                    positions.add(newPosition);
                    if (board[newPosition.zeile][newPosition.spalte] != null) {
                        break;
                    }
                }
            }
            for (int i = 0; i < 8; i++) {
                newPosition = new Position(position.spalte - i, position.zeile - i);
                if (!position.equals(newPosition) && newPosition.spalte >= 0 && newPosition.spalte <= 7 && newPosition.zeile >= 0 && newPosition.zeile <= 7) {
                    positions.add(newPosition);
                    if (board[newPosition.zeile][newPosition.spalte] != null) {
                        break;
                    }
                }
            }
        }
        if (figure.kind.equals(KNIGHT)) {
            newPosition = new Position(position.spalte + 1, position.zeile + 2);
            if (!position.equals(newPosition) && newPosition.spalte >= 0 && newPosition.spalte <= 7 && newPosition.zeile >= 0 && newPosition.zeile <= 7) {
                positions.add(newPosition);
            }
            newPosition = new Position(position.spalte + 1, position.zeile - 2);
            if (!position.equals(newPosition) && newPosition.spalte >= 0 && newPosition.spalte <= 7 && newPosition.zeile >= 0 && newPosition.zeile <= 7) {
                positions.add(newPosition);
            }
            newPosition = new Position(position.spalte - 1, position.zeile + 2);
            if (!position.equals(newPosition) && newPosition.spalte >= 0 && newPosition.spalte <= 7 && newPosition.zeile >= 0 && newPosition.zeile <= 7) {
                positions.add(newPosition);
            }
            newPosition = new Position(position.spalte - 1, position.zeile - 2);
            if (!position.equals(newPosition) && newPosition.spalte >= 0 && newPosition.spalte <= 7 && newPosition.zeile >= 0 && newPosition.zeile <= 7) {
                positions.add(newPosition);
            }
            newPosition = new Position(position.spalte + 2, position.zeile + 1);
            if (!position.equals(newPosition) && newPosition.spalte >= 0 && newPosition.spalte <= 7 && newPosition.zeile >= 0 && newPosition.zeile <= 7) {
                positions.add(newPosition);
            }
            newPosition = new Position(position.spalte + 2, position.zeile - 1);
            if (!position.equals(newPosition) && newPosition.spalte >= 0 && newPosition.spalte <= 7 && newPosition.zeile >= 0 && newPosition.zeile <= 7) {
                positions.add(newPosition);
            }
            newPosition = new Position(position.spalte - 2, position.zeile + 1);
            if (!position.equals(newPosition) && newPosition.spalte >= 0 && newPosition.spalte <= 7 && newPosition.zeile >= 0 && newPosition.zeile <= 7) {
                positions.add(newPosition);
            }
            newPosition = new Position(position.spalte - 2, position.zeile - 1);
            if (!position.equals(newPosition) && newPosition.spalte >= 0 && newPosition.spalte <= 7 && newPosition.zeile >= 0 && newPosition.zeile <= 7) {
                positions.add(newPosition);
            }
        }
        if (figure.kind.equals(PAWN)) {
            if (figure.color.equals(WHITE)) {
                if (position.zeile == 1 && board[3][position.spalte] == null) {
                    positions.add(new Position(position.zeile + 2, position.spalte));
                }
                if (board[position.zeile + 1][position.spalte] == null) {
                    positions.add(new Position(position.zeile + 1, position.spalte));
                }
                if (board[position.zeile + 1][position.spalte - 1] != null) {
                    positions.add(new Position(position.zeile + 1, position.spalte - 1));
                }
                if (board[position.zeile + 1][position.spalte + 1] != null) {
                    positions.add(new Position(position.zeile + 1, position.spalte + 1));
                }
            } else {
                if (position.zeile == 6 && board[4][position.spalte] == null) {
                    positions.add(new Position(position.zeile - 2, position.spalte));
                }
                if (board[position.zeile - 1][position.spalte] == null) {
                    positions.add(new Position(position.zeile - 1, position.spalte));
                }
                if (board[position.zeile - 1][position.spalte - 1] == null) {
                    positions.add(new Position(position.zeile - 1, position.spalte - 1));
                }
                if (board[position.zeile - 1][position.spalte + 1] == null) {
                    positions.add(new Position(position.zeile - 1, position.spalte + 1));
                }
            }
        }
        return positions;

    }

    void removeFigure(Figure figure) {
        figureList.remove(figure);
        if (figure.color.equals(WHITE)) {
            whiteDeadList.add(figure);
        } else {
            blackDeadList.add(figure);
        }
    }
}

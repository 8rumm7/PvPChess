package model;

import java.util.LinkedList;
import java.util.List;
@SuppressWarnings("all")

public class Queen extends Figure{


    public Queen(Model m, PLAYERCOLOR color, Position position) {
        super(m, color, position);
    }

    @Override
    public String getType() {
        return "Queen";
    }

    @Override
    public List<Position> getPossiblePositions() {
        List<Position> ret = new LinkedList<Position>();
        int maxedNum = Math.max(Position.getHeight(), Position.getWidth());
        Position p;

        for (int i = 1; i < maxedNum; i++) {
            if (Position.isValid(this.getPosition().zeile + i, this.getPosition().spalte)) {
                p = new Position(this.getPosition().zeile + i, this.getPosition().spalte);
                if (!m.isFree(this.getColor(), p)) break;
                ret.add(p);
                if(m.getFigureAt(p) != null) break;
            }
        }
        for (int i = 1; i < maxedNum; i++) {
            if (Position.isValid(this.getPosition().zeile - i, this.getPosition().spalte)) {
                p = new Position(this.getPosition().zeile - i, this.getPosition().spalte);
                if (!m.isFree(this.getColor(), p)) break;

                ret.add(p);
                if(m.getFigureAt(p) != null) break;

            }
        }

        for (int i = 1; i < maxedNum; i++) {
            if (Position.isValid(this.getPosition().zeile, this.getPosition().spalte + i)) {
                p = new Position(this.getPosition().zeile, this.getPosition().spalte + i);
                if (!m.isFree(this.getColor(), p)) break;

                ret.add(p);
                if(m.getFigureAt(p) != null) break;

            }
        }
        for (int i = 1; i < maxedNum; i++) {
            if (Position.isValid(this.getPosition().zeile, this.getPosition().spalte - i)) {
                p = new Position(this.getPosition().zeile, this.getPosition().spalte - i);
                if (!m.isFree(this.getColor(), p)) break;

                ret.add(p);
            }
        }

        for (int i = 1; i < maxedNum; i++) {
            if (Position.isValid(this.getPosition().zeile + i, this.getPosition().spalte - i)) {
                p = new Position(this.getPosition().zeile + i, this.getPosition().spalte - i);
                if (!m.isFree(this.getColor(), p)) break;

                ret.add(p);
                if(m.getFigureAt(p) != null) break;

            }
        }

        for (int i = 1; i < maxedNum; i++) {
            if (Position.isValid(this.getPosition().zeile + i, this.getPosition().spalte + i)) {
                p = new Position(this.getPosition().zeile + i, this.getPosition().spalte + i);
                if (!m.isFree(this.getColor(), p)) break;

                ret.add(p);
                if(m.getFigureAt(p) != null) break;

            }
        }

        for (int i = 1; i < maxedNum; i++) {
            if (Position.isValid(this.getPosition().zeile - i, this.getPosition().spalte + i)) {
                p = new Position(this.getPosition().zeile - i, this.getPosition().spalte + i);
                if (!m.isFree(this.getColor(), p)) break;

                ret.add(p);
                if(m.getFigureAt(p) != null) break;

            }
        }

        for (int i = 1; i < maxedNum; i++) {
            if (Position.isValid(this.getPosition().zeile - i, this.getPosition().spalte - i)) {
                p = new Position(this.getPosition().zeile - i, this.getPosition().spalte - i);
                if (!m.isFree(this.getColor(), p)) break;

                ret.add(p);
                if(m.getFigureAt(p) != null) break;

            }
        }
        return ret;
    }
}

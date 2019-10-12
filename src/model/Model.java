package model;

import javafx.geometry.Pos;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("all")

public class Model {
    private LinkedList<Figure> figureList = new LinkedList<Figure>();
    private static Figure[][] board;
    private LinkedList<Figure> deadFigures = new LinkedList<Figure>();

    public void init() {
        board = new Figure[8][8];
        Position.setHeight(8);
        Position.setWidth(8);
        figureList.add(new King(this,PLAYERCOLOR.WHITE, new Position(0, 4)));
        figureList.add(new King(this,PLAYERCOLOR.BLACK, new Position(7, 4)));
        figureList.add(new Queen(this,PLAYERCOLOR.WHITE, new Position(0, 3)));
        figureList.add(new Queen(this,PLAYERCOLOR.BLACK, new Position(7, 3)));
        figureList.add(new Rook(this,PLAYERCOLOR.WHITE, new Position(0, 0)));
        figureList.add(new Rook(this,PLAYERCOLOR.BLACK, new Position(7, 0)));
        figureList.add(new Rook(this,PLAYERCOLOR.WHITE, new Position(0, 7)));
        figureList.add(new Rook(this,PLAYERCOLOR.BLACK, new Position(7, 7)));
        figureList.add(new Bishop(this,PLAYERCOLOR.WHITE, new Position(0, 2)));
        figureList.add(new Bishop(this,PLAYERCOLOR.BLACK, new Position(7, 2)));
        figureList.add(new Bishop(this,PLAYERCOLOR.WHITE, new Position(0, 5)));
        figureList.add(new Bishop(this,PLAYERCOLOR.BLACK, new Position(7, 5)));
        figureList.add(new Knight(this,PLAYERCOLOR.WHITE, new Position(0, 1)));
        figureList.add(new Knight(this,PLAYERCOLOR.BLACK, new Position(7, 1)));
        figureList.add(new Knight(this,PLAYERCOLOR.WHITE, new Position(0, 6)));
        figureList.add(new Knight(this,PLAYERCOLOR.BLACK, new Position(7, 6)));
        for (int i = 0; i < 8; i++) {
            figureList.add(new Pawn(this,PLAYERCOLOR.WHITE, new Position(1, i)));
            figureList.add(new Pawn(this,PLAYERCOLOR.BLACK, new Position(6, i)));
        }


        figureList.forEach(f -> put(f));

        for (Figure f : figureList) {
            System.out.println(f);
            System.out.println("possible steps: ");
            for(Position pos : f.getEligiblePositions()){
                System.out.println(pos);
            }

        }

    }
    public boolean isFree(PLAYERCOLOR col, Position p){
        return board[p.zeile][p.spalte] == null || board[p.zeile][p.spalte].getColor() != col;
    }

    public List<Figure> getFigureList(){
        return this.figureList;
    }

    public List<Figure> getDeadFigure(){
        return this.deadFigures;
    }

    public Figure getFigureAt(int zeile, int spalte){
        return board[zeile][spalte];
    }

    /**
     * the put method is used for putting a figure on the board on an empty field.
     * @param f
     * @return
     */
    public boolean put(Figure f){
            try{
                if(board[f.getPosition().zeile][f.getPosition().spalte]!= null){
                    int i = figureList.indexOf(f);
                    figureList.remove(i);
                    throw new Exception("Tried putting a figure on a settled position");
                }
                board[f.getPosition().zeile][f.getPosition().spalte] = f;

                return true;
            }
            catch (Exception e){
                e.printStackTrace();
            }


            return false;
    }

    public boolean strike(Figure f) throws Exception{
        PLAYERCOLOR color = f.getColor();
        if(board[f.getPosition().zeile][f.getPosition().spalte] == null || board[f.getPosition().zeile][f.getPosition().spalte].getColor() == color){
            throw new Exception("tried striking to a field that is either empty or settled by a noharm figure");
        }
        deadFigures.add(board[f.getPosition().zeile][f.getPosition().spalte]);
        figureList.remove(board[f.getPosition().zeile][f.getPosition().spalte]);
        board[f.getPosition().zeile][f.getPosition().spalte] = f;
        return true;
    }

    public Figure getFigureAt(Position p){
        return board[p.zeile][p.spalte];
    }

    public boolean switchPawn(Figure f, String type){
        if(f.getType().equals("Pawn")){
            Figure newF;
            switch(type){
                case "Bishop": newF = new Bishop(this, f.getColor(), f.getPosition()); break;
                case "Knight": newF = new Knight(this, f.getColor(), f.getPosition()); break;
                case "Rook" : newF = new Rook(this, f.getColor(), f.getPosition()); break;
            }
        }
        return false;
    }





    void removeFigure(Figure figure) {
        figureList.remove(figure);
        deadFigures.add(figure);
    }


}

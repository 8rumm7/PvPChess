package model;

import javafx.geometry.Pos;

import java.util.LinkedList;
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

    public Figure getFigureAt(int zeile, int spalte){
        return board[zeile][spalte];
    }

    public boolean put(Figure f){
        System.out.println(board[f.getPosition().zeile][f.getPosition().spalte]);

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

    public boolean strike(Figure f){
        //TODO
        return true;
    }

    public Figure getFigureAt(Position p){
        return board[p.zeile][p.spalte];
    }



}

package view;

import model.Model;

public class View {

    Model model;
    ChessBoard chessBoard;
    ChessBox chessBox;


    public View(Model model) {
        this.model=model;
        init();
    }

    public void init(){
        this.chessBoard=new ChessBoard();
        this.chessBox= new ChessBox();
    }
}
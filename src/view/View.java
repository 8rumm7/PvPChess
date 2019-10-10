package view;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Model;

public class View extends Application {

    Model model;
    ChessBoard chessBoard;
    ChessBox chessBox;


    View(Model model) {
        this.model=model;
        init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }

    public void init(){
        this.chessBoard=new ChessBoard();
        this.chessBox= new ChessBox();
    }
}
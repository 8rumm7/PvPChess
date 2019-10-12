package main;

import controller.Controller;
import model.Model;
import view.View;

public class Main {
    public static void main(String[] args) {

        Model model = new Model();
        model.init();
        View view = new View(model);
        Controller controller = new Controller(model, view);
        Controller.init();

    }
}

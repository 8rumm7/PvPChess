package controller;

import model.Model;
import view.View;

public class Controller {
    static Model model;
    View view;

    public Controller(Model model, View view) {
        Controller.model = model;
        this.view = view;
    }

    public static void init() {
        model.init();
    }
}

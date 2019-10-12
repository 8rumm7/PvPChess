package controller;

import model.Model;
import view.View;

public class Controller {
    static Model model;
    static View view;

    public Controller(Model model, View view) {
        Controller.model = model;
        this.view = view;

    }

    public static void init() {
        model.init();view.initComponents();
        ;
    }
}

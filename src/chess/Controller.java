package chess;

public class Controller {
    static Model model;
    View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public static void init() {
        model.init();
    }
}
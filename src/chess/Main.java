package chess;

public class Main {
    public static void main(String[] args) {

        Model model = new Model();
        View view = new View(model);
        Controller controller = new Controller(model, view);

    }
}

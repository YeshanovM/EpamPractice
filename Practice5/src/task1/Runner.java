package task1;

import task1.controller.Controller;
import task1.model.Model;
import task1.view.View;

public class Runner {
    public static void run() {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        controller.run();
    }
}
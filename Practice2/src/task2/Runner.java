package task2;

import task2.controller.Controller;
import task2.model.Model;
import task2.view.View;

public class Runner {
    public static void run() {
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(model, view);
        controller.run();
    }
}
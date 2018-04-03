package task1;

import task1.controller.Controller;
import task1.model.Model;
import task1.view.View;

public class Runner {
    public static void run() {
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(view, model);
        controller.run();
    }
}

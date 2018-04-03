package task1;

import task1.model.Model;

public class Runner {
    public static void run() {
        Model model = new Model();
        System.out.println(model.addRecord(new String[] {
                "Yeshanov",
                "Maksym",
                "1999.07.09",
                "+380(99)25-45-411",
                "Akademica Yangelya, 20f, 423"
        }));
    }
}
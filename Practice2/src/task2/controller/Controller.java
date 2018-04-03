package task2.controller;

import task2.entity.*;
import task2.model.Model;
import task2.view.View;

import java.util.Scanner;

public class Controller {

    private Model model;
    private View view;

    private static final String[] MENU_COMMANDS = {
            "1",
            "2 <shapes count (>= " + Model.DEFAULT_SHAPES_COUNT + ")",
            "3",
            "4",
            "5 <type>",
            "6",
            "7",
            "8"
    };

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        view.printMenu(MENU_COMMANDS);
        int cmd;
        do {
            view.printInvite();
            String input = getInput();
            cmd = getCommand(input);
            String arg;
            switch (cmd) {
                case 1 :
                    view.printMenu(MENU_COMMANDS);
                    break;
                case 2 :
                    arg = getArgument(input);
                    try {
                        int count = Integer.parseInt(arg);
                        if(model.generate(count) == -1)
                            throw new NumberFormatException();
                        view.printData(model.getShapes());
                    }
                    catch(NumberFormatException e) {
                        view.printInvalidArgMessage();
                    }
                    break;
                case 3 :
                    view.printData(model.getShapes());
                    break;
                case 4 :
                    view.printArea(model.calcTotalArea());
                    break;
                case 5 :
                    arg = getArgument(input);
                    switch (arg) {
                        case "Circle" :
                            view.printArea(model.calcTotalArea(Circle.class));
                            break;
                        case "Rectangle" :
                            view.printArea(model.calcTotalArea(Rectangle.class));
                            break;
                        case "Triangle" :
                            view.printArea(model.calcTotalArea(Triangle.class));
                            break;
                        default:
                            view.printInvalidArgMessage();
                    }
                    break;
                case 6 :
                    model.sortByArea();
                    break;
                case 7 :
                    model.sortByColor();
                    break;
                case 8 :
                    break;
                default :
                    view.printInvalidCmdMessage();
            }
        } while(cmd != 8);
    }

    private String getInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private int getCommand(String input) {
        String[] splittedInput = input.trim().split(" +", 2);
        try {
            int command = Integer.parseInt(splittedInput[0]);
            return (command > 0 && command < 9) ? command : -1;
        }
        catch (NumberFormatException e) {
            return -1;
        }
    }

    private String getArgument(String input) {
        String[] splittedInput = input.trim().split(" +", 2);
        return splittedInput.length == 2 ? splittedInput[1] : "";
    }
}

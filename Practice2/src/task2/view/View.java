package task2.view;

import task2.entity.Shape;

public class View {

    private static final String ERR_INVALID_ARG = "Error! Invalid argument!";
    private static final String ERR_INVALID_CMD = "Error! Invalid command!";
    private static final String ERR_NO_DATA = "Error! Nothing to show! Generate data first.";
    private static final String INVITE = "> ";
    private static final String MESSAGE_AREA = "Area: ";
    private static final String[] MENU_DESCRIPTIONS = {
            "show menu",
            "generate data",
            "show data",
            "calculate total area",
            "calculate total area of shapes of the given type (Circle, Rectangle or Triangle)",
            "sort shapes by area",
            "sort shapes by color",
            "exit"
    };

    public  View() {
    }

    public void printMenu(String[] menuCommands) {
        for(int i = 0; i < Math.min(menuCommands.length, MENU_DESCRIPTIONS.length); i++) {
            System.out.println(menuCommands[i] + " - " + MENU_DESCRIPTIONS[i]);
        }
    }

    public void printData(Shape[] shapes) {
        if(shapes == null || shapes.length == 0) {
            System.out.println(ERR_NO_DATA);
            return;
        }
        for(Shape shape : shapes) {
            System.out.println(shape);
        }
    }

    public void printArea(double area) {
        System.out.println(MESSAGE_AREA + area);
    }

    public void printInvalidArgMessage() {
        System.out.println(ERR_INVALID_ARG);
    }

    public void printInvalidCmdMessage() {
        System.out.println(ERR_INVALID_CMD);
    }

    public void printInvite() {
        System.out.print(INVITE);
    }
}
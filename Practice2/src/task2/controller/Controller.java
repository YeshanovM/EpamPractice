package task2.controller;

import org.apache.logging.log4j.*;

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
            "8 <pathname>",
            "9 <pathname>",
            "10"
    };

    private static final Logger logger = LogManager.getLogger(Controller.class);

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        logger.trace("Controller created with " + model + ", " + view);
    }

    public void run() {
        logger.info("Controller started");
        view.printMenu(MENU_COMMANDS);
        int cmd;
        do {
            logger.info("Asked for command");
            view.printInvite();
            String input = getInput();
            logger.warn("Reading command");
            cmd = getCommand(input);
            String arg;
            switch (cmd) {
                case 1 :
                    view.printMenu(MENU_COMMANDS);
                    break;
                case 2 :
                    arg = getArgument(input);
                    try {
                        logger.warn("Reading int argument");
                        int count = Integer.parseInt(arg);
                        if(model.generate(count) == -1)
                            throw new NumberFormatException();
                        logger.info("Data generated");
                        view.printData(model.getShapes());
                    }
                    catch(NumberFormatException e) {
                        logger.error("Invalid argument");
                        view.printInvalidArgMessage();
                    }
                    break;
                case 3 :
                    view.printData(model.getShapes());
                    logger.info("Data shown");
                    break;
                case 4 :
                    view.printArea(model.calcTotalArea());
                    logger.info("Total area shown");
                    break;
                case 5 :
                    logger.warn("Reading argument");
                    arg = getArgument(input);
                    switch (arg) {
                        case "Circle" :
                            view.printArea(model.calcTotalArea(Circle.class));
                            logger.info("Total circles area shown");
                            break;
                        case "Rectangle" :
                            view.printArea(model.calcTotalArea(Rectangle.class));
                            logger.info("Total rectangles area shown");
                            break;
                        case "Triangle" :
                            view.printArea(model.calcTotalArea(Triangle.class));
                            logger.info("Total triangles area shown");
                            break;
                        default:
                            view.printInvalidArgMessage();
                            logger.error("Invalid argument");
                    }
                    break;
                case 6 :
                    model.sortByArea();
                    logger.info("Sorted by area");
                    break;
                case 7 :
                    logger.info("Sorted by color");
                    model.sortByColor();
                    break;
                case 8 :
                    logger.warn("Reading filename");
                    arg = getArgument(input);
                    boolean result;
                    if(arg.length() == 0)
                        result = model.readFromFile();
                    else
                        result = model.readFromFile(arg);
                    if(!result) {
                        view.printOperationFailedMessage();
                        logger.error("Operation failed");
                    }
                    break;
                case 9 :
                    logger.warn("Reading filename");
                    arg = getArgument(input);
                    if(arg.length() == 0)
                        result = model.saveToFile();
                    else
                        result = model.saveToFile(arg);
                    if(!result) {
                        view.printOperationFailedMessage();
                        logger.error("Operation failed");
                    }
                    break;
                case 10 :
                    break;
                default :
                    view.printInvalidCmdMessage();
                    logger.error("Invalid command");
            }
        } while(cmd != 10);
        logger.info("Program exited");
    }

    private String getInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private int getCommand(String input) {
        String[] splittedInput = input.trim().split(" +", 2);
        try {
            int command = Integer.parseInt(splittedInput[0]);
            return (command > 0 && command < 11) ? command : -1;
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

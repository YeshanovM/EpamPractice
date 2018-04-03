package task1.controller;

import task1.entity.Book;
import task1.model.Model;
import task1.view.View;

import java.util.Scanner;

public class Controller {

    private View view;
    private Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    public void run() {
        view.showMenu();
        int command;
        do {
            view.showInvite();
            String input = getInput();
            command = getCommand(input);
            String argument = getArgument(input);
            switch (command) {
                case 0 :
                    model.generateData();
                    break;
                case 1 :
                    view.showData(model.getBooks());
                    break;
                case 2 :
                    if(argument != null) {
                        Book[] filteredBooks = model.filterByAuthor(argument);
                        if(filteredBooks == null || filteredBooks.length == 0)
                            view.showMessage(View.MESSAGE_NO_ELEMENTS_FOUND);
                        else
                            view.showData(filteredBooks);
                    }
                    else
                        view.showMessage(View.ERROR_INVALID_ARGUMENT);
                    break;
                case 3 :
                    if(argument != null) {
                        Book[] filteredBooks = model.filterByPublisher(argument);
                        if(filteredBooks == null || filteredBooks.length == 0)
                            view.showMessage(View.MESSAGE_NO_ELEMENTS_FOUND);
                        else
                            view.showData(filteredBooks);
                    }
                    else
                        view.showMessage(View.ERROR_INVALID_ARGUMENT);
                    break;
                case 4 :
                    if(argument != null) {
                        try {
                            Book[] filteredBooks = model.filterAfterYear(Integer.parseInt(argument));
                            if (filteredBooks == null || filteredBooks.length == 0)
                                view.showMessage(View.MESSAGE_NO_ELEMENTS_FOUND);
                            else
                                view.showData(filteredBooks);
                        }
                        catch (NumberFormatException e) {
                            view.showMessage(View.ERROR_INVALID_ARGUMENT);
                        }
                    }
                    else
                        view.showMessage(View.ERROR_INVALID_ARGUMENT);
                    break;
                case 5 :
                    model.sortByPublisher();
                    view.showData(model.getBooks());
                    break;
                case 6:
                    view.showMenu();
                    break;
                case 7:
                    break;
                default:
                    view.showMessage(View.ERROR_INVALID_COMMAND);
            }
        } while (command != 7);
    }

    private String getInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private String getArgument(String input) {
        try {
            return input.split(" +")[1];
        }
        catch  (Exception e) {
            return null;
        }
    }

    private int getCommand(String input) {
        if(input == null || input.length() == 0)
            return -1;
        String command = input.split(" +")[0];
        if(command.charAt(0) >= '0' && command.charAt(0) <= '7') {
            return Integer.parseInt(command);
        }
        return -1;
    }
}

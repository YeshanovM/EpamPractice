package task1.view;

import task1.entity.Book;

public class View {

    private static final String INVITE = "> ";
    private static final String[] MENU = {
            "0 - generate data;",
            "1 - show data;",
            "2 <argument> - filter data by author and show;",
            "3 <argument> - filter data by publisher and show;",
            "4 <int argument> - filter data by year and show;",
            "5 - sort data by publisher;",
            "6 - show menu;",
            "7 - exit."
    };

    public static final String ERROR_INVALID_COMMAND = "Error! Invalid command! Only ONE DIGIT less than or equals to 7 allowed!";
    public static final String ERROR_INVALID_ARGUMENT = "Error! Invalid argument!";
    public static final String MESSAGE_NO_ELEMENTS_FOUND = "No matching elements found!";

    public View() {
    }

    public void showMenu() {
        for(String menuItem : MENU) {
            System.out.println(menuItem);
        }
    }

    public void showInvite() {
        System.out.print(INVITE);
    }

    public void showData(Book[] books) {
        for(Book book : books) {
            System.out.println(book.toString());
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}

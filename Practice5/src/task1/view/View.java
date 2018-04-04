package task1.view;

public class View {

    public static final String[] MENU = {
            "show menu",
            "add record",
            "show all records",
            "exit"
    };

    public static final String ASK_REINPUT_MESSAGE = "Incorrect input. Please, reinput.";
    public static final String NO_DATA_MESSAGE = "Nothing to show!";

    public View() {
    }

    public void showMenu() {
        for(int i = 0; i < MENU.length; i++) {
            System.out.println(i + " - " + MENU[i]);
        }
    }

    public void showInvite() {
        System.out.print("> ");
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showRecords(String[] records) {
        if(records.length == 0)
            showMessage(NO_DATA_MESSAGE);
        for(String record : records)
            System.out.println(record);
    }
}

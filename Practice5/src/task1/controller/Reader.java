package task1.controller;

import java.util.*;

public class Reader {

    private Scanner sc;

    public Reader() {
        sc = new Scanner(System.in);
    }

    public String readString() {
        return sc.nextLine();
    }

    public int readCommand() {
        String cmd = sc.nextLine();
        if(cmd.matches("[0-3]"))
            return Integer.parseInt(cmd);
        return -1;
    }
}

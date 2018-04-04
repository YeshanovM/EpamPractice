package task1.controller;

import task1.model.Model;
import task1.view.View;

public class Controller {

    private Model model;
    private View view;
    private Reader reader;



    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        reader = new Reader();
    }

    public void run() {
        view.showMenu();
        int cmd;
        do {
            boolean isCorrect;
            do {
                view.showInvite();
                cmd = reader.readCommand();
                isCorrect = cmd != -1 && cmd < View.MENU.length;
                if(!isCorrect)
                    view.showMessage(View.ASK_REINPUT_MESSAGE);
            } while (!isCorrect);
            performCommand(cmd);
        } while(cmd != 3);
    }

    private void performCommand(int cmd) {
        switch(cmd) {
            case 0:
                view.showMenu();
                break;
            case 1:
                addRecord();
                break;
            case 2:
                view.showRecords(model.getRecords());
                break;
            default:
                break;
        }
    }

    private void addRecord() {
        String[] record = new String[Model.RECORD_FIELDS.length];
        for (int i = 0; i < record.length; i++) {
            view.showMessage(Model.RECORD_FIELDS[i]);
            view.showInvite();
            record[i] = reader.readString();
        }
        int status = model.addRecord(record);
        while(status != -1) {
            view.showMessage(View.ASK_REINPUT_MESSAGE + " (" + Model.RECORD_FIELDS[status] + ")");
            view.showInvite();
            record[status] = reader.readString();
            status = model.addRecord(record);
        }
    }
}

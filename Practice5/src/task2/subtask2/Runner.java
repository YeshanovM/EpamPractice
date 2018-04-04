package task2.subtask2;
import java.util.*;

public class Runner {
    public static void run() {
        Translator translator = new Translator();
        translator.addPair("I", "я");
        translator.addPair("go", "идти");
        translator.addPair("to", "в");
        translator.addPair("shop", "магазин");
        System.out.print("Input phrase: ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Перевод на русский: " + translator.translate(sc.nextLine()));
    }
}

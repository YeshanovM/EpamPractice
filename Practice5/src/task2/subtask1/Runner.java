package task2.subtask1;
import java.util.*;

public class Runner {
    public static void run() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Input numbers count: ");
            int length = sc.nextInt();
            System.out.print("Input minimal number: ");
            int min = sc.nextInt();
            System.out.print("Input maximal number: ");
            int max = sc.nextInt();
            System.out.println("List: " +
                    CollectionGenerator.generateList(length, min, max));
            System.out.println("Set: " +
                    CollectionGenerator.generateSet(length, min, max));
        }
        catch(InputMismatchException e) {
            System.err.println("Invalid input! Program exited");
        }
    }
}

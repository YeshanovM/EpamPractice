package task2.subtask1;

public class Runner {
    public static void run() {
        System.out.println("List: " +
                CollectionGenerator.generateList(30, -10, 10));
        System.out.println("Set: " +
                CollectionGenerator.generateSet(30, -10, 10));
    }
}

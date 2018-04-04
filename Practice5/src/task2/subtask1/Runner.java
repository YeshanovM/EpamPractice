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

            List<Integer> generatedList = CollectionGenerator.generateList(length, min, max);
            if(generatedList == null || generatedList.size() == 0)
                System.out.println("Can't generate list with this parameters.");
            else
                System.out.println("Set: " + generatedList);

            Set<Integer> generatedSet = CollectionGenerator.generateSet(length, min, max);
            if(generatedSet == null || generatedSet.size() == 0)
                System.out.println("Can't generate set with this parameters.");
            else
                System.out.println("Set: " + generatedSet);
        }
        catch(InputMismatchException e) {
            System.err.println("Invalid input! Program exited");
        }
    }
}

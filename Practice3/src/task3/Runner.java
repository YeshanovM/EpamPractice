package task3;

public class Runner {
    public static void run() {
        System.out.println(EnumUsage.COUPE);
        System.out.println(EnumUsage.LUX.getName());
        System.out.println(EnumUsage.COUPE.getOrdinal() +
                " " + EnumUsage.LUX.getOrdinal() +
                " " + EnumUsage.ECONOM.getOrdinal() +
                " " + EnumUsage.INTERCITY.getOrdinal());
        System.out.println(EnumUsage.COUPE.equals(EnumUsage.COUPE));
        System.out.println(EnumUsage.COUPE.equals(EnumUsage.LUX));
        System.out.println(EnumUsage.COUPE.compareTo(EnumUsage.COUPE));
        System.out.println(EnumUsage.COUPE.compareTo(EnumUsage.LUX));
    }
}

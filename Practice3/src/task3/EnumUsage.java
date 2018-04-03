package task3;

public class EnumUsage extends MyEnum {

    private static int ordinal;

    public static final EnumUsage COUPE = new EnumUsage("COUPE");
    public static final EnumUsage LUX = new EnumUsage("LUX");
    public static final EnumUsage ECONOM = new EnumUsage("ECONOM");
    public static final EnumUsage INTERCITY = new EnumUsage("INTERCITY");

    private EnumUsage(String name) {
        super(name, ordinal++);
    }
}

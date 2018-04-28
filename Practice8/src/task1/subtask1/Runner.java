package task1.subtask1;

import java.lang.reflect.*;

public class Runner {
    public static void run() {
        String str = "String before changing";
        System.out.println(str);
        Class<?> clazz = str.getClass();
        try {
            Field valueField = clazz.getDeclaredField("value");
            valueField.setAccessible(true);
            valueField.set(str, "String after changing".toCharArray());
        }
        catch(NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(str);
    }
}

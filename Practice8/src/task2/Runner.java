package task2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Runner {
    public static void run() {
        Class clazz = UnaryOperation.class;
        try {
            Field field = clazz.getDeclaredField("value");
            field.setAccessible(true);
            Constructor constructor = clazz.getConstructor(double.class);
            UnaryOperation uo = (UnaryOperation) constructor.newInstance(10);
            System.out.println(field.getDouble(uo));
            clazz.getMethod("increment").invoke(uo);
            System.out.println(field.getDouble(uo));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

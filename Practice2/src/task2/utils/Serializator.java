package task2.utils;

import task2.entity.Shape;

import java.io.*;
import java.util.ArrayList;

public class Serializator {

    public static boolean saveToFile(String pathname, Shape[] shapes) {
        File file = new File(pathname);
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            for(Shape shape : shapes) {
                oos.writeObject(shape);
            }
            oos.close();
            return true;
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Shape[] readFromFile(String pathname) {
        File file = new File(pathname);
        if(!file.exists())
            return null;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Shape shape;
            ArrayList<Shape> shapes = new ArrayList<>();
            do {
                try {
                    shape = (Shape) ois.readObject();
                }
                catch (EOFException e) {
                    shape = null;
                }
                if(shape != null)
                    shapes.add(shape);
            } while(shape != null);
            ois.close();
            return shapes.toArray(new Shape[0]);
        }
        catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

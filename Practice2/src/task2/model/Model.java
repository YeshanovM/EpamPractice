package task2.model;

import task2.data.Data;
import task2.entity.*;

import java.util.Arrays;

public class Model {
    private Shape[] shapes;
    public static final int DEFAULT_SHAPES_COUNT = 10;

    public Model() {
        shapes = new Shape[0];
    }

    public int generate(int count) {
        if(count < DEFAULT_SHAPES_COUNT)
            return -1;
        shapes = new Shape[count];
        for(int i = 0; i < count; i++) {
            int random = (int)(Math.random() * 3);
            switch (random) {
                case 0:
                    shapes[i] = new Circle(
                            Data.COLORS[(int)(Math.random() * Data.COLORS.length)],
                            Data.LENGTHS[(int)(Math.random() * Data.LENGTHS.length)]
                    );
                    break;
                case 1:
                    shapes[i] = new Rectangle(
                            Data.COLORS[(int)(Math.random() * Data.COLORS.length)],
                            Data.LENGTHS[(int)(Math.random() * Data.LENGTHS.length)],
                            Data.LENGTHS[(int)(Math.random() * Data.LENGTHS.length)]
                    );
                    break;
                default:
                    do {
                        shapes[i] = new Triangle(
                                Data.COLORS[(int) (Math.random() * Data.COLORS.length)],
                                Data.LENGTHS[(int) (Math.random() * Data.LENGTHS.length)],
                                Data.LENGTHS[(int) (Math.random() * Data.LENGTHS.length)],
                                Data.LENGTHS[(int) (Math.random() * Data.LENGTHS.length)]
                        );
                    } while(!isTriangle((Triangle)shapes[i]));
                    break;
            }
        }
        return 0;
    }

    private boolean isTriangle(Triangle triangle) {
        return triangle.getA() + triangle.getB() > triangle.getC() &&
                triangle.getA() + triangle.getC() > triangle.getB() &&
                triangle.getB() + triangle.getC() > triangle.getA();
    }

    public double calcTotalArea() {
        double area = 0;
        for(Shape shape : shapes) {
            area += shape.calcArea();
        }
        return area;
    }

    public double calcTotalArea(Class type) {
        double area = 0;
        for(Shape shape : shapes) {
            if(shape.getClass() == type)
                area += shape.calcArea();
        }
        return area;
    }

    public void sortByArea() {
        Arrays.sort(shapes, (Object a, Object b) -> {
            Shape shapeA = (Shape)a;
            Shape shapeB = (Shape)b;
            return Double.compare(shapeA.calcArea(), shapeB.calcArea());
        });
    }

    public void sortByColor() {
        Arrays.sort(shapes, (Object a, Object b) -> {
            Shape shapeA = (Shape)a;
            Shape shapeB = (Shape)b;
            return shapeA.getShapeColor().compareTo(shapeB.getShapeColor());
        });
    }

    public Shape[] getShapes() {
        return shapes;
    }
}

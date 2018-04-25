package task2.entity;

import java.io.Serializable;

public class Circle extends Shape implements Serializable {

    private double radius;

    public Circle(String shapeColor, double radius) {
        super(shapeColor);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double calcArea() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", shapeColor='" + getShapeColor() + '\'' +
                '}';
    }
}

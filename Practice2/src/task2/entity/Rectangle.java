package task2.entity;

import java.io.Serializable;

public class Rectangle extends Shape implements Serializable {

    private double a, b;

    public Rectangle(String shapeColor, double a, double b) {
        super(shapeColor);
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    @Override
    public double calcArea() {
        return a * b;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "a=" + a +
                ", b=" + b +
                ", shapeColor='" + getShapeColor() + '\'' +
                '}';
    }
}
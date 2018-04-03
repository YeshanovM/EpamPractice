package task2.entity;

public abstract class Shape implements Drawable {
    private String shapeColor;

    public Shape(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    public abstract double calcArea();

    public String getShapeColor() {
        return shapeColor;
    }

    @Override
    public void draw() {
        System.out.println(getClass().getName() + " of " + shapeColor);
    }

    @Override
    public String toString() {
        return getClass() + "{" +
                "shapeColor='" + shapeColor + '\'' +
                '}';
    }
}

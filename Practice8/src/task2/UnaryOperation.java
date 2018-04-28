package task2;

public class UnaryOperation {
    private double value;

    public UnaryOperation(double value) {
        this.value = value;
    }

    public UnaryOperation() {
    }

    public void increment() {
        value++;
    }

    public void decrement() {
        value--;
    }

    public void changeSign() {
        value = -value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "UnaryOperation{" +
                "value=" + value +
                '}';
    }
}

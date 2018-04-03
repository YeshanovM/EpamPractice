package task2;

public class IntercityCarriage extends Carriage {
    public  IntercityCarriage() {
        super(2, 135, 0, 27);
    }

    @Override
    public String getType() {
        return "Intercity";
    }
}

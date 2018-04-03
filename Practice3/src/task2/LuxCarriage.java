package task2;

public class LuxCarriage extends Carriage {

    public LuxCarriage() {
        super(5, 18, 18, 18);
    }

    @Override
    public String getType() {
        return "Luxury";
    }
}

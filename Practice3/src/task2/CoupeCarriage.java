package task2;

public class CoupeCarriage extends Carriage {

    public CoupeCarriage() {
        super(3, 36, 36, 18);
    }

    @Override
    public String getType() {
        return "Coupe";
    }
}
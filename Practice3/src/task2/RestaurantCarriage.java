package task2;

public class RestaurantCarriage extends Carriage{
    public RestaurantCarriage() {
        super(4, 50, 0, 0);
    }

    @Override
    public String getType() {
        return "Restaurant";
    }
}

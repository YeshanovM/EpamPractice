package task2;

public class Runner {
    public static void run() {
        operateWithTrain(formTrain());
    }

    private static Carriage createCarriageByNumber(int number) {
        Carriage result;
        switch (number) {
            case 1 :
                result = new CoupeCarriage();
                break;
            case 2 :
                result = new EconomClassCarriage();
                break;
            case 3 :
                result = new IntercityCarriage();
                break;
            case 4 :
                result = new LuxCarriage();
                break;
            case 5 :
                result = new RestaurantCarriage();
                break;
            default :
                result = null;
                break;
        }
        return result;
    }

    private static void printTrain(Train<Carriage> train) {
        System.out.println("Train " + train.getNumber() + ":");
        System.out.println("comfort\tseats\tbeds\tluggage\ttype");
        for(Carriage carriage : train.getCarriages()) {
            System.out.println(carriage.getComfortLevel() +
                    "\t\t" + carriage.getSeatsCount() +
                    "\t\t" + carriage.getBedsCount() +
                    "\t\t" + carriage.getLuggage() +
                    "\t\t" + carriage.getType());
        }
    }

    private static Train<Carriage> formTrain() {
        int[] order = Reader.readCarriagesOrder();
        Train<Carriage> train = new Train<>(Reader.readTrainNumber());
        for(int item : order)
            train.addCarriage(createCarriageByNumber(item));
        return train;
    }

    private static void operateWithTrain(Train<Carriage> train) {
        System.out.println("\n\n");
        printTrain(train);
        train.sortByComfortLevel();
        System.out.println("\n\nSorted by comfort level:");
        printTrain(train);
        System.out.println("Total seats count: " + train.getTotalSeatsCount());
        System.out.println("Total beds count: " + train.getTotalBedsCount());
        System.out.println("Total luggage: " + train.getTotalLuggage());
    }
}

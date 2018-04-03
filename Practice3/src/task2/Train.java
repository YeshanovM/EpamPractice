package task2;

import java.util.ArrayList;

public class Train <T extends Carriage> {
    private ArrayList<T> carriages;
    private int number;

    public Train(int number) {
        this.number = number;
        carriages = new ArrayList<>();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void addCarriage(T carriage) {
        carriages.add(carriage);
    }

    public void removeCarriage(T carriage) {
        carriages.remove(carriage);
    }

    public ArrayList<T> getCarriages() {
        return carriages;
    }

    public void sortByComfortLevel() {
        carriages.sort((Object a, Object b) -> {
            Carriage carriage1 = (Carriage) a;
            Carriage carriage2 = (Carriage) b;
            return Integer.compare(carriage1.getComfortLevel(), carriage2.getComfortLevel());
        });
    }

    public int getTotalSeatsCount() {
        int result = 0;
        for(Carriage carriage : carriages) {
            result += carriage.getSeatsCount();
        }
        return result;
    }

    public int getTotalBedsCount() {
        int result = 0;
        for(Carriage carriage : carriages) {
            result += carriage.getBedsCount();
        }
        return result;
    }

    public int getTotalLuggage() {
        int result = 0;
        for(Carriage carriage : carriages) {
            result += carriage.getLuggage();
        }
        return result;
    }

    public ArrayList<T> getCarriagesBySeatsCount(int from, int to) {
        ArrayList<T> result = new ArrayList<>();
        for(Carriage carriage : carriages) {
            if(carriage.getSeatsCount() >= from && carriage.getSeatsCount() <= to)
                result.add((T)carriage);
        }
        return result;
    }
}

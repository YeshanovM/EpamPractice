package task2;

public abstract class Carriage {
    private int comfortLevel, seatsCount, bedsCount, luggage;

    public Carriage(int comfortLevel, int seatsCount, int bedsCount, int luggage) {
        this.comfortLevel = comfortLevel;
        this.seatsCount = seatsCount;
        this.bedsCount = bedsCount;
        this.luggage = luggage;
    }

    public int getComfortLevel() {
        return comfortLevel;
    }

    public int getSeatsCount() {
        return seatsCount;
    }

    public int getBedsCount() {
        return bedsCount;
    }

    public int getLuggage() {
        return luggage;
    }

    @Override
    public String toString() {
        return "Carriage{" +
                "comfortLevel=" + comfortLevel +
                ", seatsCount=" + seatsCount +
                ", bedsCount=" + bedsCount +
                ", luggage=" + luggage +
                '}';
    }
}
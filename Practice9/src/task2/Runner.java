package task2;

public class Runner {
    private Integer value;
    private boolean valueChanged;

    private static final int COUNT = 1_000_000;

    public void run() {
        System.out.println("Not synchronized:");
        startNotSynchronizedIncrementing();
        System.out.println("\n-----------------------------\n");
        System.out.println("Synchronized:");
        startSynchronizedIncrementing();
    }

    private void startNotSynchronizedIncrementing() {
        value = 0;
        Thread counter = new Thread(() -> {
            while (value < COUNT)
                value++;
        });
        Thread printer = new Thread(() -> {
            while (value < COUNT)
                System.out.println(value);
        });
        counter.start();
        printer.start();
        try {
            printer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void startSynchronizedIncrementing() {
        value = 0;
        valueChanged = true;
        Thread counter = new Thread(() -> {
            while (value < COUNT)
                increment();
        });
        Thread printer = new Thread(() -> {
            while (value < COUNT)
                print();
        });
        counter.start();
        printer.start();
    }

    private synchronized void increment() {
        if(valueChanged) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else {
            value++;
            valueChanged = true;
            notify();
        }
    }

    private synchronized void print() {
        if(valueChanged) {
            System.out.println(value);
            valueChanged = false;
            notify();
        }
        else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

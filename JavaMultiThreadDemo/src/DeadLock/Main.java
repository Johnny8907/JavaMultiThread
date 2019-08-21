package DeadLock;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Tool spoon = new Tool("spoon");
        Tool fork = new Tool("fork");
        EaterThread Alice = new EaterThread("Alice", spoon, fork);
        EaterThread Bob = new EaterThread("Bob", fork, spoon);
        Alice.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Bob.start();
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

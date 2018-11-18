package ProducerConsumer;

import java.util.Random;

/**
 * @Author: Johnny Zhang
 * @Date: 2018/11/17 10:39
 */
public class MakerThread extends Thread{
    private final Table table;
    private final Random random;
    private static int cakeID = 0;
    MakerThread(String name, Table table, long seed) {
        super(name);
        this.table = table;
        this.random = new Random(seed);
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(random.nextInt(1000));
                String cake = "[ cake No." + nextID() + " made by " + getName() + "]";
                table.put(cake);
            } catch (InterruptedException e) {
            }
        }
    }

    private static synchronized int nextID() {
        cakeID ++;
        return cakeID;
    }
}

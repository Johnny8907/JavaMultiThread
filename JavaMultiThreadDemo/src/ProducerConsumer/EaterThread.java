package ProducerConsumer;

import java.util.Random;

/**
 * @Author: Johnny Zhang
 * @Date: 2018/11/17 10:47
 */
public class EaterThread extends Thread {
    private final Table table;
    private final Random random;

    EaterThread(String name, Table table, long seed) {
        super(name);
        this.table = table;
        this.random = new Random(seed);
    }

    @Override
    public void run() {
        try {
            while (true) {
                String cake = table.take();
                System.out.println(getName() + " take " + cake);
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
        }
    }
}

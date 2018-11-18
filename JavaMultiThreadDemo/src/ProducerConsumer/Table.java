package ProducerConsumer;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author: Johnny Zhang
 * @Date: 2018/11/17 10:30
 */
class Table {
    private static final int MAX_CAKE_NUM = 3;
    private final BlockingDeque<String> cakeList;

    Table() {
        cakeList = new LinkedBlockingDeque<>();
    }

    synchronized void put(String cake) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " put " + cake);
        while (cakeList.size() > MAX_CAKE_NUM) {
            wait();
        }
        cakeList.add(cake);
        notifyAll();
    }

    synchronized String take() throws InterruptedException {
        while (cakeList.size() <= 0) {
            wait();
        }
        notifyAll();
        return cakeList.poll();
    }
}

package ProducerConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author: Johnny Zhang
 * @Date: 2018/11/24 17:22
 */
public class ArrayBlockingQueueTable extends ArrayBlockingQueue<String> implements Table{
    public ArrayBlockingQueueTable(int count) {
        super(count);
    }

    public void put(String cake) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " puts " + cake);
        super.put(cake);
    }

    public String take() throws InterruptedException {
        String cake = super.take();
        System.out.println(Thread.currentThread().getName() + " takes " + cake);
        return cake;
    }

}

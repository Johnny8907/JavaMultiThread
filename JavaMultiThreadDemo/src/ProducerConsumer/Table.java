package ProducerConsumer;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author: Johnny Zhang
 * @Date: 2018/11/17 10:30
 */
interface Table {
    void put(String cake) throws InterruptedException;
    String take() throws  InterruptedException;
}

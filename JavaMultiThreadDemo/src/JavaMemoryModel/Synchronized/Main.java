package JavaMemoryModel.Synchronized;

/**
 * @Author: Johnny Zhang
 * @Date: 2018/12/3 20:44
 */
public class Main {
    private final static Object lock = new Object();
    public static void main(String[] args) {
        synchronized (lock) {
            doSomething();
        }
    }
    public synchronized static void doSomething() {

    }
}

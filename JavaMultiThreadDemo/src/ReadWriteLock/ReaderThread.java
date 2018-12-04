package ReadWriteLock;

import java.util.Arrays;

public class ReaderThread extends Thread {
    private final Data data;

    public ReaderThread(String name, Data data) {
        super(name);
        this.data = data;
    }

    @Override
    public void run() {
        while(true) {
            try {
                char[] result = data.read();
                System.out.println(Thread.currentThread().getName() + " read " + Arrays.toString(result));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

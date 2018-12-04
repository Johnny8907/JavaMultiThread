package ReadWriteLock;

import java.util.Random;

public class WriterThread extends Thread {
    private final Random random = new Random();
    private final ReentrantReadWriteData data;
    private final char[] buffer;
    private int index = 0;

    WriterThread(String name, ReentrantReadWriteData data, char[] buffer) {
        super(name);
        this.data = data;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                data.write(buffer[index]);
                index++;
                if (index >= 10) {
                    index = 0;
                }
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

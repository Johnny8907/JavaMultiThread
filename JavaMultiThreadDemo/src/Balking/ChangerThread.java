package Balking;

import java.io.IOException;
import java.util.Random;

/**
 * @Author: Johnny Zhang
 * @Date: 2018/11/7 22:04
 */
public class ChangerThread extends Thread {
    private final Data data;
    private final Random random = new Random();

    ChangerThread(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; true; i++) {
                data.change("NO." + i);
                Thread.sleep(random.nextInt(1000));
                data.save();
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}

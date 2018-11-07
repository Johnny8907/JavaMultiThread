package Balking;

import java.io.IOException;

/**
 * @Author: Johnny Zhang
 * @Date: 2018/11/7 22:01
 */
public class SaverThread extends Thread {
    private final Data data;

    SaverThread(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        try {
            while (true) {
                data.save();
                sleep(1000);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

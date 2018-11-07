package Balking;

/**
 * @Author: Johnny Zhang
 * @Date: 2018/11/7 22:16
 */
public class Main {
    public static void main(String[] args) {
        Data data = new Data("data.txt", "(empty)");
        new ChangerThread(data).start();
        new SaverThread(data).start();
    }
}

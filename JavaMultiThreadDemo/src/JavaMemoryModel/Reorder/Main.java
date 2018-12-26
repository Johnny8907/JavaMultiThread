package JavaMemoryModel.Reorder;

/**
 * @Author: Johnny Zhang
 * @Date: 2018/12/3 20:08
 */
public class Main {
    static boolean ready;
    static int number;

    private static class ReaderThread extends Thread {
        public void run() {
            hahahaha(new Integer(2));
        }

        private void hahahaha(Integer haha) {
            synchronized (haha) {

            }
        }

    }

    private static class ReaderThread1 extends Thread {
        public void run() {
            if (ready) {
                System.out.println("=" + number);
            }
        }

    }

    public static void main(String[] para) {

        new ReaderThread().start();
        ready = true;
        new ReaderThread1().start();
    }
}

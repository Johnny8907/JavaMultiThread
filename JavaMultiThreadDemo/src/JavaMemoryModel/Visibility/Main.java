package JavaMemoryModel.Visibility;

/**
 * @Author: Johnny Zhang
 * @Date: 2018/12/3 20:44
 */
public class Main {
    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.start();
        new Thread() {
            @Override
            public void run() {
                runner.shutdown();
            }
        }.start();

    }

    private static class Runner extends Thread {
        private boolean quit = false;
        @Override
        public void run() {
            while(!quit) {
                System.out.println("while.....");
            }
            System.out.println("Done");
        }

        public void shutdown() {
            System.out.println("shutdown");
            quit = true;
        }
    }
}

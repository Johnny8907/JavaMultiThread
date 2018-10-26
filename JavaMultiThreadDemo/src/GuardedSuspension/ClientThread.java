package GuardedSuspension;

import java.util.Random;

public class ClientThread extends Thread {
    private final RequestQueue requestQueue;
    private final Random random;

    ClientThread(RequestQueue queue, String name, long seed) {
        super(name);
        requestQueue = queue;
        random = new Random(seed);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Request request = new Request("No." + i);
            System.out.println(Thread.currentThread().getName() + " requests " + request);
            requestQueue.putRequest(request);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

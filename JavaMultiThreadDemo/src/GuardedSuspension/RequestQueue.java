package GuardedSuspension;

import java.util.LinkedList;
import java.util.Queue;

class RequestQueue {
    private final Queue<Request> requestQueue = new LinkedList<>();

    RequestQueue() {

    }

    synchronized void putRequest(Request request) {
        requestQueue.offer(request);
        notifyAll();
    }

    synchronized Request getRequest() {
        while (requestQueue.peek() == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return requestQueue.remove();
    }
}

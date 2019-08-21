package SingleThreadExecution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Ticket> tickets = new ArrayList<>();
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100000; i++) {
            tickets.add(new Ticket());
        }

        Thread shopA = new Thread(() -> {
            System.out.println("a Thread run");
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 5000; i ++) {
                removeTicket(tickets, i);
            }
            long stopTime = System.currentTimeMillis();
            System.out.println("shop a spent " + (stopTime - startTime) + "ms");

        });

        Thread shopB = new Thread(() -> {
            System.out.println("b Thread run");
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 5000; i ++) {
                removeTicket(tickets, i);
            }
            long stopTime = System.currentTimeMillis();
            System.out.println("shop b spent " + (stopTime - startTime) + "ms");
        });

        shopA.start();
        shopB.start();
        Thread.sleep(5000);
        System.out.println(tickets.size());
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void removeTicket(List<Ticket> ticketList, int index) {
        ticketList.remove(index);
    }
}

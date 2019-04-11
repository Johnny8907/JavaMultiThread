package FutureTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author: Johnny Zhang
 * @Date: 2019/3/24 23:33
 */
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        testOne();
        testTwo();
    }

    private static void testOne() throws ExecutionException, InterruptedException {
        long beforeStartTime = System.currentTimeMillis();
        Future<Long> result = Executors.newScheduledThreadPool(2).submit(() -> {
            long secondNum = 0L;
            for (long i = 1000000000L; i < 2000000000L; i ++) {
                secondNum += i;
            }
            return secondNum;
        });
        long firstNum = 0L;
        for (long i = 0L; i < 1000000000L; i ++) {
            firstNum += i;
        }

        long finalResult = firstNum + result.get();
        long afterTime = System.currentTimeMillis();
        long spentTime = afterTime - beforeStartTime;
        System.out.println("result:[" + finalResult + "] spent time: [" + spentTime + "] ms");
    }

    private static void testTwo() {
        long beforeStartTime = System.currentTimeMillis();
        long resultNum = 0L;
        for (long i = 0; i < 2000000000L; i ++) {
            resultNum += i;
        }
        long afterTime = System.currentTimeMillis();
        long spentTime = afterTime - beforeStartTime;
        System.out.println("result:[" + resultNum + "] spent time: [" + spentTime + "] ms");
    }
}

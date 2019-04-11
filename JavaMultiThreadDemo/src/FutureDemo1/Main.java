package FutureDemo1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Content content1 = Retriever.retrieve("http://www.yahoo.com/");
        Content content2 = Retriever.retrieve("http://www.google.com/");
        Content content3 = Retriever.retrieve("http://www.baidu.com/");

        saveToFile("yahoo.html", content1);
        saveToFile("google.html", content2);
        saveToFile("baidu.html", content3);

        long end = System.currentTimeMillis();
        System.out.println("Elapse time = " + (end - start) + "msec");
    }

    private static void saveToFile(String fileName, Content content) {
        byte[] bytes = content.getBytes();
        System.out.println(Thread.currentThread().getName() + "saving to " + fileName);
        try {
            FileOutputStream outputStream = new FileOutputStream(fileName);
            for (byte aByte : bytes) {
                outputStream.write(aByte);
            }
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

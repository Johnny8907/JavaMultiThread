package ReadWriteLock;

public class Main {
    public static void main(String[] args) {
        final ReentrantReadWriteData data = new ReentrantReadWriteData();
        new ReaderThread("ReaderThread - 1", data).start();
        new ReaderThread("ReaderThread - 2", data).start();
        new ReaderThread("ReaderThread - 3", data).start();
        new ReaderThread("ReaderThread - 4", data).start();
        new ReaderThread("ReaderThread - 5", data).start();
        new WriterThread("WriterThread - 1", data, "1234567890".toCharArray()).start();
        new WriterThread("WriterThread - 2", data, "abcdefghij".toCharArray()).start();
    }
}

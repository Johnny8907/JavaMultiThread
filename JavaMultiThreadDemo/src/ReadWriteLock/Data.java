package ReadWriteLock;

import java.util.Arrays;

class Data {
    private int size = 10;
    private char[] buffer = new char[size];
    private final ReadWriteLock readWriteLock;

    Data() {
        initBuffer();
        readWriteLock = new ReadWriteLock(true);
    }

    private void initBuffer() {
        for (int i = 0; i < size; i++) {
            buffer[i] = '*';
        }
    }

    char[] read() throws InterruptedException {
        readWriteLock.lockRead();
        try {
            return doRead();
        } finally {
            readWriteLock.unlockRead();
        }
    }

    private char[] doRead() {
        char[] result = new char[buffer.length];
        for (int i = 0; i < buffer.length; i ++) {
            result[i] = buffer[i];
        }
        slowly();
        return result;
    }

    void write(char content) {
        try {
            readWriteLock.lockWrite();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            doWrite(content);
        } finally {
            readWriteLock.unlockWrite();
        }
    }

    private void doWrite(char content) {
        for (int i = 0; i < size; i ++) {
            buffer[i] = content;
            slowly();
        }
    }

    private void slowly() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

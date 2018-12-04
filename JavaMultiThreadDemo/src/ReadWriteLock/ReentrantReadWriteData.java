package ReadWriteLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteData {
        private int size = 10;
        private char[] buffer = new char[size];
        private final java.util.concurrent.locks.ReadWriteLock lock = new ReentrantReadWriteLock(true);
        private final Lock readLock = lock.readLock();
        private final Lock writeLock = lock.writeLock();

        ReentrantReadWriteData() {
            initBuffer();
        }

        private void initBuffer() {
            for (int i = 0; i < size; i++) {
                buffer[i] = '*';
            }
        }

        char[] read() throws InterruptedException {
            readLock.lock();
            try {
                return doRead();
            } finally {
                readLock.unlock();
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
            writeLock.lock();
            try {
                doWrite(content);
            } finally {
                writeLock.unlock();
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

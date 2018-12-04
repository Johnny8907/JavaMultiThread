package ReadWriteLock;

final class ReadWriteLock {
    private int readingThreadCount = 0;
    private int writingThreadCount = 0;
    private int waitWriteThreadCount = 0;
    private boolean preferWrite;

    ReadWriteLock(boolean preferWrite) {
        this.preferWrite = preferWrite;
    }

    synchronized void lockRead() throws InterruptedException {
        while(writingThreadCount > 0 || (preferWrite && waitWriteThreadCount > 0)) {
            wait();
        }
        readingThreadCount ++;
    }

    synchronized void unlockRead() {
        readingThreadCount --;
        preferWrite = true;
        notifyAll();
    }

    synchronized void lockWrite() throws InterruptedException {
        waitWriteThreadCount ++;
        while (readingThreadCount > 0 || writingThreadCount > 0) {
            wait();
        }
        waitWriteThreadCount --;
        writingThreadCount ++;
    }

    synchronized void unlockWrite() {
        writingThreadCount --;
        preferWrite = false;
        notifyAll();
    }
}

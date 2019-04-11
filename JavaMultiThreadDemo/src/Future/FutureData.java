package Future;

/**
 * @Author: Johnny Zhang
 * @Date: 2019/1/23 22:24
 */
public class FutureData {
    private int data = 0;
    private boolean ready;
    public void setRealData(int data) {
        this.data = data;
        ready = true;
    }

    public int getRealData() {
        return data;
    }
    public int getContent() {
        while (!ready) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return this.data;
    }
}

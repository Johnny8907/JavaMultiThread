package Future;

/**
 * @Author: Johnny Zhang
 * @Date: 2019/1/23 22:20
 */
class Host {
    FutureData request() {
        FutureData data = new FutureData();
        Thread thread = new Thread(() -> {
            data.setRealData(10);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        });
        thread.start();
        return data;
    }
}

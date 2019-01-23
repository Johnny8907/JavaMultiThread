package Future;

/**
 * @Author: Johnny Zhang
 * @Date: 2019/1/23 22:18
 */
public class Main {
    public static void main(String[] args) {
        Host host = new Host();
        FutureData data = host.request();
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//        }
        System.out.println(data.getRealData());
    }
}

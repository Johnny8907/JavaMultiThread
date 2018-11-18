package ProducerConsumer;

/**
 * @Author: Johnny Zhang
 * @Date: 2018/11/17 10:23
 */
public class Main {
    public static void main(String[] args) {
        Table table = new Table();
        new MakerThread("MakerThread - 1", table, 897654).start();
        new MakerThread("MakerThread - 2", table, 894521).start();
        new MakerThread("MakerThread - 3", table, 154698).start();
        new EaterThread("EaterThread - 1", table, 458974).start();
        new EaterThread("EaterThread - 2", table, 236569).start();
        new EaterThread("EaterThread - 3", table, 987546).start();
    }
}

package FutureDemo1;

public class Retriever {
    public static Content retrieve(String urlStr) {
        return new SyncContentImpl(urlStr);
    }
}

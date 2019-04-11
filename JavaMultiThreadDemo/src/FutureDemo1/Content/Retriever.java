package FutureDemo1.Content;

public class Retriever {
    public static Content retrieve(String urlStr) {
        return new SyncContentImpl(urlStr);
    }
}

package FutureDemo1.Content;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.URL;

public class SyncContentImpl implements Content {
    private byte[] contentBytes;
    public SyncContentImpl(String urlStr) {
        System.out.println(Thread.currentThread().getName() + ": Getting " + urlStr);
        DataInputStream dataInputStream = null;
        try {
            URL url = new URL(urlStr);
            dataInputStream = new DataInputStream(url.openStream());
            byte[] buffer = new byte[1];
            int index = 0;
            try {
                while (true) {
                    int c = dataInputStream.readUnsignedByte();
                    if (buffer.length <= index) {
                        byte[] largerbuffer = new byte[buffer.length * 2];
                        System.arraycopy(buffer, 0, largerbuffer, 0, index);
                        buffer = largerbuffer;
                    }
                    buffer[index++] = (byte) c;
                }
            } catch (EOFException e) {

            } finally {
                dataInputStream.close();
            }
            contentBytes = new byte[index];
            System.arraycopy(buffer, 0, contentBytes, 0, index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public byte[] getBytes() {
        return contentBytes;
    }
}

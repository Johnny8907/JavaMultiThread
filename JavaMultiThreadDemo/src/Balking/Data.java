package Balking;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @Author: Johnny Zhang
 * @Date: 2018/11/6 23:47
 */
class Data {
    private final String fileName;
    private String content;
    private boolean changed;

    Data(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
    }

    synchronized void change(String content) {
        this.content = content;
        changed = true;
    }

    synchronized void save() throws IOException {
        if (!changed) {
            return;
        }
        doSave();
        changed = false;
    }

    private void doSave() throws IOException {
        System.out.println(Thread.currentThread().getName() + " calls doSave, content = " + content);
        Writer writer = new FileWriter(fileName);
        writer.write(content);
        writer.close();
    }
}

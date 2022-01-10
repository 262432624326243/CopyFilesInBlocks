package hw;

import java.io.*;

public class Provider implements Runnable {
    private final Mediator mediator;
    private final File file;

    public Provider(Mediator mediator, File file) {
        this.mediator = mediator;
        this.file = file;
    }

    private void generateNums() {
        try (FileInputStream fis = new FileInputStream(file)) {
            int readedByte;
            for (; ; ) {
                readedByte = fis.read();
                if (readedByte == -1) {
                    mediator.setTemp(new Pair(-1, true));
                    break;
                } else {
                    mediator.setTemp(new Pair(readedByte, false));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        generateNums();
        System.out.println("Provider is end");
    }
}
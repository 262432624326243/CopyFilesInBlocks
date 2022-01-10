package hw;

import java.io.*;

public class Reciever implements Runnable {
    private final Mediator mediator;
    private final File file;

    Reciever(Mediator mediator, File file) {
        this.mediator = mediator;
        this.file = file;
    }

    private void printNums() {
        try (FileOutputStream fos = new FileOutputStream(file)) {
            Pair pair;
            for (; ; ) {
                //Pair pair = mediator.getTemp();
                pair = mediator.getTemp();
                if (pair.isStopWork()) {
                    break;
                } else {
                    fos.write(pair.getValue());
                    mediator.printProgress();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        printNums();
        System.out.println("Reciever is end");
    }
}
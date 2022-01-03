package hw;

import java.io.*;

public class Reciever implements Runnable {
    private File file;
    private Mediator mediator;
    private int turn;

    public Reciever(File file, Mediator mediator, int turn) {
        this.file = file;
        this.mediator = mediator;
        this.turn = turn;
    }

    public void outBytes() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            while (!mediator.isStop()) {
                bw.write(mediator.getTemp());
            }
            System.out.println("----While is end.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("----outBytes is end");
    }

    @Override
    public void run() {
        outBytes();
        System.out.println("Reciever is END.");
    }
}

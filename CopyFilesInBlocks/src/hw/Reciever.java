package hw;

import java.io.*;

public class Reciever implements Runnable {
    private File file;
    private Mediator mediator;

    public Reciever(File file, Mediator mediator) {
        this.file = file;
        this.mediator = mediator;
    }

    public void outBytes() {
        do {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
                bw.write(mediator.getTemp());
                //System.out.println(mediator.getTemp());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        while (mediator.isStop() != true);
    }

    @Override
    public void run() {
        outBytes();
    }
}

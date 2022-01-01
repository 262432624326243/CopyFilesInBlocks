package hw;

import java.io.*;

public class Provider implements Runnable {
    private File file;
    private Mediator mediator;

    public Provider(File file, Mediator mediator) {
        this.file = file;
        this.mediator = mediator;
    }

    private void setBytes() {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String readedByte;
            while ((readedByte = br.readLine()) != null) {
                mediator.setTemp(readedByte);
                System.out.println(readedByte);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        setBytes();
        mediator.setStop(true);
    }
}

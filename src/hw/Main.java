package hw;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File in = new File("in.doc");
        File out = new File("out.doc");

        Mediator mediator = new Mediator(in, out);
        Provider provider = new Provider(mediator, in);
        Reciever reciever = new Reciever(mediator, out);

        Thread th1 = new Thread(provider);
        Thread th2 = new Thread(reciever);

        th1.start();
        th2.start();

        System.out.println("Main is END.");
    }
}

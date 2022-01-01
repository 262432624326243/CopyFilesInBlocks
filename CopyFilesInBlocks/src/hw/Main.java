package hw;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        Mediator mediator = new Mediator();
        Provider provider = new Provider(new File("in.txt"), mediator);
        Reciever reciever = new Reciever(new File("out.txt"), mediator);

        Thread th1 = new Thread(provider);
        Thread th2 = new Thread(reciever);

        th1.start();
        th2.start();
    }
}

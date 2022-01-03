package hw;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        Mediator mediator = new Mediator();
        Provider provider = new Provider(new File("in.txt"), mediator, 0);
        Reciever reciever = new Reciever(new File("out.txt"), mediator, 1);
        //Progress progress = new Progress(new File("in.txt"), new File("out.txt"), mediator, 2);
        Thread th1 = new Thread(provider);
        Thread th2 = new Thread(reciever);
        //Thread th3 = new Thread(progress);
        th1.start();
        th2.start();
        //th3.start();
        System.out.println("Main is END.");
    }
}

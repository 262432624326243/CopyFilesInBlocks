package hw;

import java.io.File;

public class Progress implements Runnable{
    private int turn;
    private File fileIn;
    private File fileOut;
    private Mediator mediator;
    private int progress;

    public Progress(File fileIn, File fileOut, Mediator mediator, int turn)
    {
        this.fileIn = fileIn;
        this.fileOut = fileOut;
        this.mediator = mediator;
        this.turn = turn;
    }

    @Override
    public void run() {
        while(!mediator.isStop())
        {
            mediator.printProgress(fileIn.length(), fileOut.length());
        }
        System.out.println("Progress is END.");
    }
}

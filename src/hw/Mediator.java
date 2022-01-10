package hw;

import java.io.File;

public class Mediator {
    private final File fileIn;
    private final File fileOut;
    private Pair pair;
    private boolean turn = false;

    public Mediator(File fileIn, File fileOut) {
        this.fileIn = fileIn;
        this.fileOut = fileOut;
    }

    public void printProgress() {
        System.out.println("Complete " + (double) (((double) fileOut.length() * 100) / (double) fileIn.length()) + " %");
    }

    public synchronized Pair getTemp() {
        while (!this.turn) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Pair temp = this.pair;
        this.turn = false;
        notifyAll();
        // System.out.println("Get number -> " + this.pair.getValue());
        return temp;
    }

    public synchronized void setTemp(Pair pair) {
        while (this.turn) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.pair = pair;
        this.turn = true;
        //System.out.println("Send number -> " + this.pair.getValue());
        notifyAll();
    }

}

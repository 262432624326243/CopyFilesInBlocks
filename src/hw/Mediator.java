package hw;

public class Mediator {
    private String temp;
    private int turn = 0;
    private boolean isStop = false;

    public synchronized void setTemp(String temp) {
        while (this.turn != 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.temp = temp;
        this.turn = 1;
        notifyAll();
    }

    public synchronized String getTemp() {
        while (this.turn != 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.turn = 0;
        notifyAll();
        return temp;
    }

    public synchronized void printProgress(float fileInSize, float fileOutSize) {
        while (this.turn != 2) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(((fileOutSize * 100) / fileInSize));
        this.turn = 0;
        notifyAll();
    }

    public void setStop(boolean stop) {
        isStop = stop;
    }

    public boolean isStop() {
        return isStop;
    }
}


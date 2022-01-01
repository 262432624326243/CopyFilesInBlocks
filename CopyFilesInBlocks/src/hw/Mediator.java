package hw;

public class Mediator {
    private String temp;
    private boolean turn;
    private boolean isStop = false;

    public synchronized String getTemp() {
        while(!this.turn)
        {
            try {
                wait();
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        this.turn = false;
        notifyAll();
        return temp;
    }

    public synchronized void setTemp(String temp) {
        while(this.turn)
        {
            try {
                wait();
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        this.temp = temp;
        this.turn = true;
        notifyAll();
    }

    public void setStop(boolean stop) {

        isStop = stop;
    }

    public boolean isStop() {

        return isStop;
    }
}


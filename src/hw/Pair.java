package hw;

public final class Pair {
    private final int value;
    private final boolean stopWork;

    public Pair(int value, boolean stopWork) {
        super();
        this.value = value;
        this.stopWork = stopWork;
    }

    public int getValue() {
        return value;
    }

    public boolean isStopWork() {
        return stopWork;
    }

    @Override
    public String toString() {
        return "Pair [value=" + value + ", stopWork=" + stopWork + "]";
    }
}
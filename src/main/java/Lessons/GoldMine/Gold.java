package Lessons.GoldMine;

public class Gold {
    protected int total;

    public Gold (int total) {
        this.total = total;
    }

    public synchronized int mineGold (int count) {
        if (total == 0) return 0;
        if (total < count)  {
            count = total - count;
        };
        total-= count;
        return count;
    }

    public int getLeftGold() {
        return total;
    }
}

package Lessons.GoldMine;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WatchDog implements Runnable {
    private List<BackPack> backPackList;
    private Gold gold;

    public WatchDog(List<BackPack> backPackList, Gold gold) {
        this.backPackList = backPackList;
        this.gold = gold;
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (gold.getLeftGold() > 0) {
            backPackList.forEach(b -> System.out.printf("name: %s has gold: %s left gold: %s \n", b.getOwner(), b.getGold(), gold.getLeftGold()));
            try {
                TimeUnit.SECONDS.sleep(1);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

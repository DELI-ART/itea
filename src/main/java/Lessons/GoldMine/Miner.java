package Lessons.GoldMine;

import java.util.concurrent.TimeUnit;

public class Miner implements Runnable {
    private int total = 0;
    private Gold gold;
    private final String name;
    private final BackPack backPack;

    public Miner (String name) {
        this.name = name;
        this.backPack = new BackPack(name);
    }

    @Override
    public void run() {
        while (gold.getLeftGold() > 0) {
            int mined = gold.mineGold(3);
            if (mined == 0) break;
            this.total += mined;
            this.backPack.setGold(this.total);

            try {
                TimeUnit.SECONDS.sleep(3);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String getName() {
        return this.name;
    }

    public BackPack getBackPack () {
        return this.backPack;
    }

    public void setGold(Gold gold) {
        this.gold = gold;
    }
}

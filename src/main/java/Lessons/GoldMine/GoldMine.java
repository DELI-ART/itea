package Lessons.GoldMine;

public class GoldMine {
    private Gold gold;

    public GoldMine (Gold gold) {
        this.gold = gold;
    }

    public BackPack addMiner(Miner miner) {
        miner.setGold(gold);
        Thread thread = new Thread(miner);
        thread.start();
        System.out.printf("Welcome to team: - " + miner.getName() + ":) \n");
        return miner.getBackPack();
    }
}

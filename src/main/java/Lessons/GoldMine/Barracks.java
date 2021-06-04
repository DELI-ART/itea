package Lessons.GoldMine;

public class Barracks {
    private int miners;

    public Miner getMiner() {
        miners ++;
        Miner miner = new Miner("Miner_" + miners);
        return miner;
    }
}

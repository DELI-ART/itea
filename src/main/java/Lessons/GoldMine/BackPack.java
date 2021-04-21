package Lessons.GoldMine;

public class BackPack {
    private int gold = 0;
    private final String owner;

    public BackPack(String  owner) {
        this.owner = owner;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public String getOwner() {
        return owner;
    }
}

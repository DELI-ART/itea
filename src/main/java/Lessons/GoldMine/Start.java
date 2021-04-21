package Lessons.GoldMine;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Start {
    public static void main(String[] args) {
        Gold gold = new Gold(100);
        GoldMine goldMine = new GoldMine(gold);
        Barracks barracks = new Barracks();
        List<BackPack> backPacks = new ArrayList<>();
        WatchDog watchDog = new WatchDog(backPacks, gold);

        backPacks.add(goldMine.addMiner(barracks.getMiner()));
        backPacks.add(goldMine.addMiner(barracks.getMiner()));
        backPacks.add(goldMine.addMiner(barracks.getMiner()));
        backPacks.add(goldMine.addMiner(barracks.getMiner()));
        backPacks.add(goldMine.addMiner(barracks.getMiner()));

        while (true) {
            try {
                TimeUnit.SECONDS.sleep(5);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (gold.getLeftGold() == 0) break;
            backPacks.add(goldMine.addMiner(barracks.getMiner()));
        }

        System.out.println("Game over! Good job!");
        System.out.println("Result:");
        backPacks.forEach(b-> System.out.printf("name: %s total mined: %s%n", b.getOwner(), b.getGold()));
    }
}

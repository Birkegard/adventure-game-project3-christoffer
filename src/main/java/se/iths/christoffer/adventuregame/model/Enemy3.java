package se.iths.christoffer.adventuregame.model;

public class Enemy3 extends AbstractCharacter {
    public Enemy3(String name, int health, int score, int strength) {
        super(name, health, score, strength);
    }

    @Override
    public void attack(AbstractCharacter target) {
        target.setHealth(target.getHealth() - this.getStrength());
    }
}

package se.iths.christoffer.adventuregame.model;

public class Player extends AbstractCharacter {
    private boolean foundKey;
    private boolean defeatedEnemy;
    private boolean openedChest;
    private boolean foundDiamond;
    private boolean foundHammer;

    private String name;
    private int health;
    private int score;
    private int strength;
    private int absorb;

    private Player(Builder builder) {
        super(builder.name, builder.health, builder.score, builder.strength);
    }

    public boolean hasFoundKey() {
        return foundKey;
    }

    public void setFoundKey(boolean foundKey) {
        this.foundKey = foundKey;
    }

    public boolean hasDefeatedEnemy() {
        return defeatedEnemy;
    }

    public void setDefeatedEnemy(boolean defeatedEnemy) {
        this.defeatedEnemy = defeatedEnemy;
    }

    public boolean hasOpenedChest() {
        return openedChest;
    }

    public void setOpenedChest(boolean openedChest) {
        this.openedChest = openedChest;
    }

    public boolean hasFoundDiamond() {
        return foundDiamond;
    }

    public void setFoundDiamond(boolean foundDiamond){
        this.foundDiamond=foundDiamond;
    }

    public boolean hasFoundHammer() {
        return foundHammer;
    }

    public void setFoundHammer(boolean foundHammer){
        this.foundHammer = foundHammer;
    }

    public boolean hasWon() {
        return foundKey && defeatedEnemy && openedChest && foundDiamond;
    }

    @Override
    public void attack(AbstractCharacter target) {
        target.setHealth(target.getHealth() - this.getStrength());

        if (!target.isAlive()) {
            addScore(50);
        }
    }

    public static class Builder {
        private String name;
        private int health;
        private int score;
        private int strength;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder health(int health) {
            this.health = health;
            return this;
        }

        public Builder score(int score) {
            this.score = score;
            return this;
        }

        public Builder strength(int strength) {
            this.strength = strength;
            return this;
        }

        public Player build() {
            return new Player(this);
        }
    }
}

package se.iths.christoffer.adventuregame.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void attack() {
        Player player = new Player.Builder()
                .name("Christoffer")
                .health(100)
                .score(0)
                .strength(10)
                .build();

        Enemy goblin = new Enemy("Vätte", 20, 10, 10);

        player.attack(goblin);

        Assertions.assertEquals(10, goblin.getHealth());

    }
}
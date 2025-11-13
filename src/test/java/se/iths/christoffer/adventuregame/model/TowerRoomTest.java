package se.iths.christoffer.adventuregame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.iths.christoffer.adventuregame.view.FakeUi;

import static org.junit.jupiter.api.Assertions.*;

class TowerRoomTest {
    private Player player;
    private FakeUi fakeUi;
    private TowerRoom towerRoom;
    private Enemy2 knightArmour;

    @BeforeEach
    public void setUp(){
        player = new Player.Builder()
                .name("Chrille")
                .health(100)
                .score(0)
                .strength(50)
                .build();

        knightArmour = new Enemy2("Rustning", 50, 0, 20);
        fakeUi = new FakeUi();
        fakeUi.setInput("a");
        towerRoom = new TowerRoom();
    }

    @Test
    void playerDefeatsEnemy() {
        towerRoom.enterRoom(player, fakeUi);

        player.attack(knightArmour);

        assertFalse(knightArmour.isAlive());
        assertTrue(player.hasFoundDiamond());
        assertTrue(player.hasDefeatedEnemy());
    }
}
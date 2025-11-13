package se.iths.christoffer.adventuregame.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.iths.christoffer.adventuregame.view.FakeUi;

class AtticRoomTest {
    private Player player;
    private FakeUi fakeUi;
    private AtticRoom atticRoom;
    private Enemy ghost;

    @BeforeEach
    public void setUp(){
        player = new Player.Builder()
                .name("Chrille")
                .health(100)
                .score(0)
                .strength(50)
                .build();

        ghost = new Enemy("Spöke", 50, 0, 20);
        fakeUi = new FakeUi();
        fakeUi.setInput("a");
        atticRoom = new AtticRoom();
    }

    @Test
    void enterRoom() {
        atticRoom.enterRoom(player, fakeUi);
        Assertions.assertTrue(player.hasDefeatedEnemy(), "Om ja, fienden dör.");
    }

    @Test
    void attackEnemy(){
        player.attack(ghost);
        Assertions.assertEquals(0, ghost.getHealth());
    }

}
package se.iths.christoffer.adventuregame.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.iths.christoffer.adventuregame.view.FakeUi;

import static org.junit.jupiter.api.Assertions.*;

class DiningRoomTest {
    private Player player;
    private FakeUi fakeUi;
    private DiningRoom diningRoom;

    @BeforeEach
    public void setUp(){
        player = new Player.Builder()
                .name("Chrille")
                .health(100)
                .score(0)
                .strength(100)
                .build();

        fakeUi = new FakeUi();
        fakeUi.setInput("ja");
        diningRoom = new DiningRoom();
    }

    @Test
    void enterRoom() {
        diningRoom.enterRoom(player, fakeUi);

        Assertions.assertTrue(player.hasFoundHammer(), "Om ja");
    }
}
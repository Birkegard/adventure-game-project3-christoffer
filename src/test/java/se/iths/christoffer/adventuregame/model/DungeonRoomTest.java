package se.iths.christoffer.adventuregame.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import se.iths.christoffer.adventuregame.view.FakeUi;

class DungeonRoomTest {

    @Test
    void enterRoom() {
        DungeonRoom dungeonRoom = new DungeonRoom();
        FakeUi fakeUi = new FakeUi();
        fakeUi.setInput("a");

        Player player = new Player.Builder()
                .name("Christoffer")
                .health(100)
                .score(0)
                .strength(10)
                .build();

        dungeonRoom.enterRoom(player, fakeUi);


        Assertions.assertTrue(player.hasDefeatedEnemy(), "Sant om du slår fienden.");

    }
}
package se.iths.christoffer.adventuregame.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import se.iths.christoffer.adventuregame.view.FakeUi;

class TreasureRoomTest {


    @Test
    void enterRoom() {
        FakeUi fakeUi = new FakeUi();
        fakeUi.setInput("ja");

        Player player = new Player.Builder()
                .name("Christoffer")
                .health(100)
                .score(0)
                .strength(10)
                .build();

        TreasureRoom treasureRoom = new TreasureRoom();
        ForestRoom forestRoom = new ForestRoom();

        forestRoom.enterRoom(player, fakeUi);
        treasureRoom.enterRoom(player, fakeUi);

        Assertions.assertTrue(player.hasFoundKey(), "Om ja");
        Assertions.assertTrue(player.hasOpenedChest(), "Om ja, har öppnat kistan.");
    }
}
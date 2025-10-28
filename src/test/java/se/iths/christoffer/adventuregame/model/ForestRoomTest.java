package se.iths.christoffer.adventuregame.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import se.iths.christoffer.adventuregame.view.FakeUi;

class ForestRoomTest {

    @Test
    void enterRoom() {
        ForestRoom forestRoom = new ForestRoom();
        FakeUi fakeUi = new FakeUi();
        fakeUi.setInput("ja");

        Player player = new Player.Builder()
                .name("Christoffer")
                .health(100)
                .score(0)
                .strength(10)
                .build();

        forestRoom.enterRoom(player, fakeUi);

        Assertions.assertTrue(player.hasFoundKey(), "Ska hitta nyckel om ja");

    }
}
package se.iths.christoffer.adventuregame.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import se.iths.christoffer.adventuregame.view.FakeUi;

class TreasureRoomTest {


    @Test
    void enterRoom() {
        TreasureRoom treasureRoom = new TreasureRoom();
        ForestRoom forestRoom = new ForestRoom();
        TowerRoom towerRoom = new TowerRoom();

        FakeUi fakeUi = new FakeUi();
        FakeUi fakeUiForest = new FakeUi();
        FakeUi fakeUiTreasure = new FakeUi();
        fakeUi.setInput("a");
        fakeUiForest.setInput("ja");
        fakeUiTreasure.setInput("ja");

        Player player = new Player.Builder()
                .name("Christoffer")
                .health(100)
                .score(0)
                .strength(10)
                .build();

        Enemy2 knightArmour = new Enemy2("Rustning", 50, 0, 20);

        towerRoom.enterRoom(player, fakeUi);
        player.attack(knightArmour);


        forestRoom.enterRoom(player, fakeUiForest);
        player.setFoundDiamond(true);
        treasureRoom.enterRoom(player, fakeUiTreasure);

        Assertions.assertTrue(player.hasFoundDiamond(), "Har hittat diamanten om true.");
        Assertions.assertTrue(player.hasFoundKey(), "Om ja, har hittat nyckeln.");
        Assertions.assertTrue(player.hasOpenedChest(), "Om ja, har inte hittat diamanten.");
    }
}
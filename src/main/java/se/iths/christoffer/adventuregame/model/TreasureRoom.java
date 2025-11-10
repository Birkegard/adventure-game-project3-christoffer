package se.iths.christoffer.adventuregame.model;

import se.iths.christoffer.adventuregame.view.UI;

public class TreasureRoom implements Room {

    @Override
    public void enterRoom(Player player, UI ui) {
        ui.showMessage("Du hittar en skattkista. Den verkar låst...");

        String choice = ui.getInput("Vill du försöka öppna kistan? (ja/nej)");
        if (choice.equalsIgnoreCase("ja")) {
            if (player.hasFoundKey() && player.hasFoundDiamond()) {
                ui.showMessage("Du öppnar kistan med din nyckel och har din diamant!");
                player.setOpenedChest(true);
                player.addScore(100);
            } else {
                ui.showMessage("Kistan är låst, du saknar nyckeln eller diamanten...");
            }
        } else {
            ui.showMessage("Du lämnar kistan orörd.");
        }
    }
}

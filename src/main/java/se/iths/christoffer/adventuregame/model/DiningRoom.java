package se.iths.christoffer.adventuregame.model;

import se.iths.christoffer.adventuregame.view.UI;

public class DiningRoom implements Room {
    @Override
    public void enterRoom(Player player, UI ui) {
        ui.showMessage("Du kliver in i ett kök och letar runt i skåpen.");
        ui.showMessage("När du drar ut en låda hittar du en gryningshammare.");
        String choice = ui.getInput("Vill du ta med och använda hammaren? (ja/nej)");
        if (choice.equalsIgnoreCase("ja")) {
            ui.showMessage("Du tar upp hammaren och din styrka ökar med 40!");
            player.setFoundHammer(true);
            player.setStrength(50);
        } else {
            ui.showMessage("Du ignorerar hammaren och går vidare.");
        }
    }
}

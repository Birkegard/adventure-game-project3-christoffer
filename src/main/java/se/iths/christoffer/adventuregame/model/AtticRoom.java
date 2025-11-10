package se.iths.christoffer.adventuregame.model;

import se.iths.christoffer.adventuregame.view.UI;

public class AtticRoom implements Room {
    @Override
    public void enterRoom(Player player, UI ui) {
        ui.showMessage("Du går upp på en mörk vind. Ett spöke står i vägen!");
        Enemy2 ghost = new Enemy2("Spöke", 60, 0, 10);

        while (player.isAlive() && ghost.isAlive()) {
            String choice = ui.getInput("Vill du (a)ttackera eller (r)etirera?");
            if (choice.equalsIgnoreCase("a")) {
                player.attack(ghost);
                ui.showMessage("Du attackerar spöket! Spökets HP: " + ghost.getHealth());
                if (ghost.isAlive()) {
                    ghost.attack(player);
                    ui.showMessage("Spöket attackerar dig! Ditt HP: " + player.getHealth());
                } else {
                    ui.showMessage("Du besegrade spöket!");
                    player.setDefeatedEnemy(true);
                }
            } else if (choice.equalsIgnoreCase("r")) {
                ui.showMessage("Du springer därifrån!");
                break;
            }
        }
    }
}

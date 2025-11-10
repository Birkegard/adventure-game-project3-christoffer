package se.iths.christoffer.adventuregame.model;

import se.iths.christoffer.adventuregame.view.UI;

public class TowerRoom implements Room{
    @Override
    public void enterRoom(Player player, UI ui) {
        ui.showMessage("Du vandrar upp för en lång trappa och hittar en rustning!");
        ui.showMessage("Du öppnar visiret och ser en diamant, när du stoppar in handen för att ta den börjar" +
                " rustningen att röra sig...");
        Enemy3 knightArmour = new Enemy3("Rustningen", 100, 0, 15);

        while (player.isAlive() && knightArmour.isAlive()) {
            String choice = ui.getInput("Vill du (a)ttackera eller (r)etirera?");
            if (choice.equalsIgnoreCase("a")) {
                player.attack(knightArmour);
                ui.showMessage("Du attackerar rustningen! Rustningens HP: " + knightArmour.getHealth());
                if (knightArmour.isAlive()) {
                    knightArmour.attack(player);
                    ui.showMessage("Rustningen attackerar dig! Ditt HP: " + player.getHealth());
                } else {
                    ui.showMessage("Du besegrade rustningen och tar diamanten!");
                    player.setDefeatedEnemy(true);
                    player.setFoundDiamond(true);
                }
            } else if (choice.equalsIgnoreCase("r")) {
                ui.showMessage("Du springer därifrån och glömmer diamanten!");
                break;
            }
        }


    }
}

package se.iths.christoffer.adventuregame;

import se.iths.christoffer.adventuregame.dao.FileStatisticsDao;
import se.iths.christoffer.adventuregame.dao.StatisticsDao;
import se.iths.christoffer.adventuregame.model.Player;
import se.iths.christoffer.adventuregame.model.StartRoom;
import se.iths.christoffer.adventuregame.model.Statistics;
import se.iths.christoffer.adventuregame.service.StatisticsService;
import se.iths.christoffer.adventuregame.view.ScannerUI;
import se.iths.christoffer.adventuregame.view.UI;

public class Main {

    public static void main(String[] args) {
        UI ui = new ScannerUI();

        AppInfo appInfo = AppInfo.getInstance();


        ui.showMessage("Välkommen till Äventyrsspelet!");
        ui.showMessage(AppInfo.getInstance().getProperty("app.author"));
        ui.showMessage(AppInfo.getInstance().getProperty("app.version"));
        Player player = new Player.Builder()
                .name(ui.getInput("Ange ditt namn:"))
                .health(100)
                .score(0)
                .strength(10)
                .build();

        new StartRoom().enterRoom(player, ui);

        StatisticsDao dao = new FileStatisticsDao();
        dao.save(new Statistics(player.getName(), player.getScore()));

        StatisticsService service = new StatisticsService(dao);
        ui.showMessage("\n--- Topplista ---");
        for (Statistics s : service.getSortedStatistics()) {
            ui.showMessage(s.getPlayerName() + " - " + s.getScore() + " poäng");
        }
    }
}


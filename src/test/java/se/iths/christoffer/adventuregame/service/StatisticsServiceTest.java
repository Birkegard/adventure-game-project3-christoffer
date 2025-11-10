package se.iths.christoffer.adventuregame.service;

import org.junit.jupiter.api.Test;
import se.iths.christoffer.adventuregame.dao.FakeFileStatisticsDao;
import se.iths.christoffer.adventuregame.model.Statistics;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsServiceTest {

    @Test
    void getSortedStatistics() {

        FakeFileStatisticsDao fakeFileStatisticsDao = new FakeFileStatisticsDao();
        StatisticsService statisticsService = new StatisticsService(fakeFileStatisticsDao);

        List<Statistics> sortedList = statisticsService.getSortedStatistics();

        assertEquals("Chris", sortedList.getFirst().getPlayerName());
        assertEquals(200, sortedList.getFirst().getScore());
    }
}
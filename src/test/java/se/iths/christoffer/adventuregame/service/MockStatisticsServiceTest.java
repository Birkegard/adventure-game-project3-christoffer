package se.iths.christoffer.adventuregame.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import se.iths.christoffer.adventuregame.dao.FileStatisticsDao;
import se.iths.christoffer.adventuregame.model.Statistics;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MockStatisticsServiceTest {

    @Mock
    private FileStatisticsDao mockFileStatisticsDao;


    @InjectMocks
    private StatisticsService statisticsService;


    @Test
    public void getSortedStatistics(){
        List<Statistics> stats = new ArrayList<>();
        stats.add(0, new Statistics("Christoffer", 150));
        stats.add(1, new Statistics("Chris", 120));
        stats.add(2, new Statistics("CB", 200));


        Mockito.when(mockFileStatisticsDao.loadAll()).thenReturn(stats);

        List<Statistics> result = statisticsService.getSortedStatistics();

        Assertions.assertEquals(200, result.getFirst().getScore());
        Assertions.assertEquals("CB", result.getFirst().getPlayerName());
    }
}

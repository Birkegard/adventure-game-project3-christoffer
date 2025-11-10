package se.iths.christoffer.adventuregame.dao;

import se.iths.christoffer.adventuregame.model.Statistics;

import java.util.ArrayList;
import java.util.List;

public class FakeFileStatisticsDao implements StatisticsDao{
    @Override
    public void save(Statistics stat) {

    }

    @Override
    public List<Statistics> loadAll() {
        List<Statistics> stats = new ArrayList<>();
        stats.add(0, new Statistics("Christoffer", 130));
        stats.add(1, new Statistics("Chris", 200));
        stats.add(2, new Statistics("CB", 100));
        return stats;
    }
}

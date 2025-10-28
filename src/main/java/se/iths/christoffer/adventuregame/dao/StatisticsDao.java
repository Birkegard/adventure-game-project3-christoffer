package se.iths.christoffer.adventuregame.dao;

import se.iths.christoffer.adventuregame.model.Statistics;

import java.util.List;

public interface StatisticsDao {
    void save(Statistics stat);

    List<Statistics> loadAll();
}


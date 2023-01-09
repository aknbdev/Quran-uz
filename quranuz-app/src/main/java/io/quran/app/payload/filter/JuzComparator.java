package io.quran.app.payload.filter;

import io.quran.db.entity.Juz;

import java.util.Comparator;

public class JuzComparator implements Comparator<Juz> {

    private int sort;

    public void sort(){

    }

    @Override
    public int compare(Juz o1, Juz o2) {
        return o1.getId() > o2.getId() ? 1 : -1;
    }
}

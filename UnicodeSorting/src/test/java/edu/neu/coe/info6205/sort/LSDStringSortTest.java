package edu.neu.coe.info6205.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LSDStringSortTest {

    private LSDStringSort lsdStringSort;

    //@Test
    public void lsdSortTest1(){
        lsdStringSort = new LSDStringSort();
        String[] words = new String[]{"कम", "केम","काम","कूम", "कुम", "कीम","किम"};
        lsdStringSort.sort(words);
    //    String[] sortedWords = {"कम", "काम", "किम", "कीम", "कुम", "कूम", "केम"};
        assertEquals("कम", words[0]);
        assertEquals("काम", words[1]);
        assertEquals("किम", words[2]);
        assertEquals("कीम", words[3]);
        assertEquals("कुम", words[4]);
        assertEquals("कूम", words[5]);
        assertEquals("केम", words[6]);
    }

    @Test
    public void lsdSortTest2(){
        lsdStringSort = new LSDStringSort();
        String[] words = new String[]{"कम", "केम","काम","कूम", "कुम","कीम","किम"};
        lsdStringSort.sort(words, 0, words.length - 1);
        assertEquals("कम", words[0]);
        assertEquals("काम", words[1]);
        assertEquals("किम", words[2]);
        assertEquals("कीम", words[3]);
        assertEquals("कुम", words[4]);
        assertEquals("कूम", words[5]);
        assertEquals("केम", words[6]);
    }
}

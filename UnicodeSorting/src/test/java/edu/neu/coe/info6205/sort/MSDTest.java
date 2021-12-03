package edu.neu.coe.info6205.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MSDTest {

    private MSD msd;

    @Test
    public void msdSortTest1(){
        msd = new MSD();
        String[] words = new String[]{"कम", "केम","काम","कूम", "कुम", "कीम","किम"};
        msd.sort(words);
        String[] sortedWords = {"कम", "काम", "किम", "कीम", "कुम", "कूम", "केम"};
        Assert.assertArrayEquals(sortedWords, words);
    }
}

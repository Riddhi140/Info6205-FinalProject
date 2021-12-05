package edu.neu.coe.info6205.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static edu.neu.coe.info6205.util.Utilities.show;
import static org.junit.Assert.assertEquals;

public class MSDTest {

    private MSD msd;

    @Test
    public void msdSortTest1(){
        msd = new MSD();
        String[] words = new String[]{"कम", "केम","काम","कूम", "कुम", "कीम","किम"};
        show(words,"Input for MSD Sort");
        msd.sort(words);
        String[] sortedWords = {"कम", "काम", "किम", "कीम", "कुम", "कूम", "केम"};
        show(words,"Output for MSD Sort");
        Assert.assertArrayEquals(sortedWords, words);
    }
}

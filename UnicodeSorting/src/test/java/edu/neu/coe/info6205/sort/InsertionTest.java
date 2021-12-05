package edu.neu.coe.info6205.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static edu.neu.coe.info6205.util.Utilities.show;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InsertionTest {
    private Insertion insertion;

    @Test
    public void sortTest1() throws Exception{
        insertion = new Insertion();

        String[] xs = new String[]{"कम", "केम","काम","कूम", "कुम", "कीम","किम"};
        show(xs,"Input for Insertion Sort");
        insertion.sort(xs, 0, xs.length - 1, 0);
        show(xs,"Output for Insertion Sort");
        String[] sortedWords = {"कम", "काम", "किम", "कीम", "कुम", "कूम", "केम"};
        Assert.assertArrayEquals(sortedWords, xs);
    }

    @Test
    public void isSortedTest() throws Exception{
        String[] xs = new String[]{"कम", "केम","काम","कूम", "कुम", "कीम","किम"};
        insertion = new Insertion();
        insertion.sort(xs, 0, xs.length - 1, 0);
        assertTrue(insertion.isSorted(xs));
    }
}

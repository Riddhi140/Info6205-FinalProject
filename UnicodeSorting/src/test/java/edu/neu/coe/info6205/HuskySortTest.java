package edu.neu.coe.info6205;


import edu.neu.coe.info6205.huskySortUtils.HuskyCoderFactory;
import edu.neu.coe.info6205.sort.MergeHuskySort;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HuskySortTest {
    @Test
    public void testHindiSort() throws Exception{
        String[] xs = new String[]{"कम", "केम","काम","कूम", "कुम"};
        MergeHuskySort huskySort =  new MergeHuskySort<>(HuskyCoderFactory.asciiCoder);
        huskySort.sort(xs);
        assertEquals("कम", xs[0]);
        assertEquals("काम", xs[1]);
        assertEquals("कुम", xs[2]);
        assertEquals("कूम", xs[3]);
        assertEquals("केम", xs[4]);
    }
}

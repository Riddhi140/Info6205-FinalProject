package edu.neu.coe.info6205.sort;

import edu.neu.coe.info6205.sort.TimSort;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TimSortTest {


    @Test
    public void testHindiSort() throws Exception{
        String[] xs = new String[]{"कम", "केम","काम","कूम", "कुम"};
        TimSort timSortTest =  new TimSort();
        timSortTest.sort(xs, 0, xs.length);
        assertEquals("कम", xs[0]);
        assertEquals("काम", xs[1]);
        assertEquals("कुम", xs[2]);
        assertEquals("कूम", xs[3]);
        assertEquals("केम", xs[4]);
    }
}

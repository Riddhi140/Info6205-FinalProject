package edu.neu.coe.info6205.sort;

import org.junit.Test;

import static edu.neu.coe.info6205.util.Utilities.show;
import static org.junit.Assert.assertEquals;

public class TimSortTest {


    @Test
    public void testHindiSort() throws Exception{
        String[] xs = new String[]{"कम", "केम","काम","कूम", "कुम"};
        show(xs,"Input for Tim Sort");
        TimSort timSortTest =  new TimSort();
        timSortTest.sort(xs, 0, xs.length);
        assertEquals("कम", xs[0]);
        assertEquals("काम", xs[1]);
        assertEquals("कुम", xs[2]);
        assertEquals("कूम", xs[3]);
        assertEquals("केम", xs[4]);
        show(xs,"Output for Tim Sort");
    }
}

package edu.neu.coe.info6205.sort;


import edu.neu.coe.info6205.sort.QuickDualPivot;
import org.junit.Test;


import static edu.neu.coe.info6205.util.Utilities.show;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QuickSortDualPivotTest {


    @Test
    public void testHindiSort() throws Exception{
        String[] xs = new String[]{"कम", "केम","काम","कूम", "कुम"};
        show(xs,"Input for QuickDualPivot Sort");
        QuickDualPivot quickDualPivot =  new QuickDualPivot();
        quickDualPivot.sort(xs);
        assertEquals("कम", xs[0]);
        assertEquals("काम", xs[1]);
        assertEquals("कुम", xs[2]);
        assertEquals("कूम", xs[3]);
        assertEquals("केम", xs[4]);
        show(xs,"Output for QuickDualPivot Sort");
    }

    @Test
    public void isSortedTest() throws Exception{
        String[] xs = new String[]{"कम", "केम","काम","कूम", "कुम"};
        QuickDualPivot quickDualPivot =  new QuickDualPivot();
        quickDualPivot.sort(xs);
        assertTrue(QuickDualPivot.isSorted(xs));
    }
}

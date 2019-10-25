package _1_sorting._1_bubble_sort;

import org.junit.Assert;
import org.junit.Test;

public class TestBubbleSort {

    @Test
    public void testSortingAllEqualElements() {
        int[] testArray1 = new int[] {0,0,0,0,0};
        BubbleSort.sort(testArray1);
        Assert.assertArrayEquals(new int[] {0,0,0,0,0}, testArray1);
    }

    @Test
    public void testSortingSuccess() {
        int[] testArray1 = new int[] {5, 9 ,2 ,7, 4, 5, 8, -1, 0, 0};
        BubbleSort.sort(testArray1);
        Assert.assertArrayEquals(new int[] {-1, 0, 0, 2, 4, 5, 5, 7, 8, 9}, testArray1);
    }

}

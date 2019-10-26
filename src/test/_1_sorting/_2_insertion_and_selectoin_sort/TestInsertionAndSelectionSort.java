package _1_sorting._2_insertion_and_selectoin_sort;

import org.junit.Assert;
import org.junit.Test;

public class TestInsertionAndSelectionSort {

    @Test
    public void testInsertionSortSuccess() {
        int[] testArray1 = new int[] {5, 9 ,2 ,7, 4, 5, 8, -1, 0, 0};
        InsertionSort.sort(testArray1);
        Assert.assertArrayEquals(new int[] {-1, 0, 0, 2, 4, 5, 5, 7, 8, 9}, testArray1);
    }

    @Test
    public void testSelectionSortSuccess() {
        int[] testArray1 = new int[] {5, 9 ,2 ,7, 4, 5, 8, -1, 0, 0};
        SelectionSort.sort(testArray1);
        Assert.assertArrayEquals(new int[] {-1, 0, 0, 2, 4, 5, 5, 7, 8, 9}, testArray1);
    }
}

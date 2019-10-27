package _2_searching._2_binary_search;

import org.junit.Assert;
import org.junit.Test;

public class TestBinarySearch {

    @Test
    public void testIterativeBinarySearch() {
        Assert.assertEquals(-5, IterativeBinarySearch.binarySearch(new int[] {0,1,2,3,6}, 5));
        Assert.assertEquals(-6, IterativeBinarySearch.binarySearch(new int[] {0,1,2,3,6}, 8));
        Assert.assertEquals(-1, IterativeBinarySearch.binarySearch(new int[] {0,1,2,3,6}, -1));
        Assert.assertEquals(-1, IterativeBinarySearch.binarySearch(new int[0], 5));
        Assert.assertEquals(0, IterativeBinarySearch.binarySearch(new int[] {Integer.MAX_VALUE}, Integer.MAX_VALUE));
        Assert.assertEquals(2, IterativeBinarySearch.binarySearch(new int[] {-1, 3, 5, 7}, 5));
        Assert.assertEquals(0, IterativeBinarySearch.binarySearch(new int[] {-1, 3, 5, 7}, -1));
        Assert.assertEquals(-1, IterativeBinarySearch.binarySearch(new int[] {-1, 3, 5, 7}, -3));
        Assert.assertEquals(-3, IterativeBinarySearch.binarySearch(new int[] {-1, 3, 5, 7}, 4));
        Assert.assertEquals(-5, IterativeBinarySearch.binarySearch(new int[] {-1, 3, 5, 7}, 987));
        Assert.assertEquals(1, IterativeBinarySearch.binarySearch(new int[] {-1, 3, 4, 5, 7}, 3));
        Assert.assertEquals(4, IterativeBinarySearch.binarySearch(new int[] {-1, 3, 4, 5, 7}, 7));
        Assert.assertEquals(0, IterativeBinarySearch.binarySearch(new int[] {-10, -1, 3, 4, 5, 7}, -10));
        Assert.assertEquals(5, IterativeBinarySearch.binarySearch(new int[] {-10, -1, 3, 4, 5, 7}, 7));
        Assert.assertEquals(-6, IterativeBinarySearch.binarySearch(new int[] {-10, -1, 3, 4, 5, 7}, 6));
        Assert.assertEquals(0, IterativeBinarySearch.binarySearch(new int[] {-10, -1, 3, 4, 5, 7}, -10));
        Assert.assertEquals(-2, IterativeBinarySearch.binarySearch(new int[] {-10, -1, 3, 4, 5, 7}, -9));
        Assert.assertEquals(1, IterativeBinarySearch.binarySearch(new int[] {-10, -1, 3, 4, 5, 7}, -1));
        Assert.assertEquals(3, IterativeBinarySearch.binarySearch(new int[] {-10, -1, 3, 4, 5, 7}, 4));
        Assert.assertEquals(-1, IterativeBinarySearch.binarySearch(new int[] {-10, -1, 3, 4, 5, 7}, Integer.MIN_VALUE));
    }

    @Test
    public void testRecursiveBinarySearch() {
        Assert.assertEquals(-1, RecursiveBinarySearch.binarySearch(new int[] {0,1,2,3,6}, 5));
        Assert.assertEquals(-1, RecursiveBinarySearch.binarySearch(new int[] {0,1,2,3,6}, 8));
        Assert.assertEquals(-1, RecursiveBinarySearch.binarySearch(new int[] {0,1,2,3,6}, -1));
        Assert.assertEquals(-1, RecursiveBinarySearch.binarySearch(new int[0], 5));
        Assert.assertEquals(0, RecursiveBinarySearch.binarySearch(new int[] {Integer.MAX_VALUE}, Integer.MAX_VALUE));
        Assert.assertEquals(2, RecursiveBinarySearch.binarySearch(new int[] {-1, 3, 5, 7}, 5));
        Assert.assertEquals(0, RecursiveBinarySearch.binarySearch(new int[] {-1, 3, 5, 7}, -1));
        Assert.assertEquals(-1, RecursiveBinarySearch.binarySearch(new int[] {-1, 3, 5, 7}, -3));
        Assert.assertEquals(-1, RecursiveBinarySearch.binarySearch(new int[] {-1, 3, 5, 7}, 4));
        Assert.assertEquals(-1, RecursiveBinarySearch.binarySearch(new int[] {-1, 3, 5, 7}, 987));
        Assert.assertEquals(1, RecursiveBinarySearch.binarySearch(new int[] {-1, 3, 4, 5, 7}, 3));
        Assert.assertEquals(4, RecursiveBinarySearch.binarySearch(new int[] {-1, 3, 4, 5, 7}, 7));
        Assert.assertEquals(0, RecursiveBinarySearch.binarySearch(new int[] {-10, -1, 3, 4, 5, 7}, -10));
        Assert.assertEquals(5, RecursiveBinarySearch.binarySearch(new int[] {-10, -1, 3, 4, 5, 7}, 7));
        Assert.assertEquals(-1, RecursiveBinarySearch.binarySearch(new int[] {-10, -1, 3, 4, 5, 7}, 6));
        Assert.assertEquals(0, RecursiveBinarySearch.binarySearch(new int[] {-10, -1, 3, 4, 5, 7}, -10));
        Assert.assertEquals(-1, RecursiveBinarySearch.binarySearch(new int[] {-10, -1, 3, 4, 5, 7}, -9));
        Assert.assertEquals(1, RecursiveBinarySearch.binarySearch(new int[] {-10, -1, 3, 4, 5, 7}, -1));
        Assert.assertEquals(3, RecursiveBinarySearch.binarySearch(new int[] {-10, -1, 3, 4, 5, 7}, 4));
        Assert.assertEquals(-1, RecursiveBinarySearch.binarySearch(new int[] {-10, -1, 3, 4, 5, 7}, Integer.MIN_VALUE));
    }
}

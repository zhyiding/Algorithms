package _12_math_and_bit_manipulation;

public class ExchangeTwoNumbers {
    // With O(0) extra space
    public static int[] swap(int[] twoNums) {
        assert twoNums.length == 2;
        twoNums[0] ^= twoNums[1];
        twoNums[1] ^= twoNums[0];
        twoNums[0] ^= twoNums[1];
        return twoNums;
    }
}

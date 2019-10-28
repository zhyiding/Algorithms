package _2_searching._2_binary_search;

// LeetCode #4 [hard]
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m < n) return findMedianSortedArrays(nums2, nums1);

        int imin = 0;
        int imax = m;
        int half = (m + n + 1) / 2;
        while (imin <= imax) {
            int i = imin + (imax - imin + 1) / 2;
            int j = half - i;

            if (i > imin && nums1[i - 1] > nums2[j]) {
                imax--;
            } else if (i < imax && nums2[j - 1] > nums1[i]){
                imin++;
            } else {
                int maxOfLeft;
                if (i == 0) maxOfLeft = nums2[j - 1];
                else if (j == 0) maxOfLeft = nums1[i - 1];
                else maxOfLeft = Math.max(nums1[i - 1], nums2[j - 1]);

                if ((m + n) % 2 == 1) {
                    return maxOfLeft / 1.0;
                }


                int minOfRight;
                if (i == m) minOfRight = nums2[j];
                else if (j == n) minOfRight = nums1[i];
                else minOfRight = Math.min(nums1[i], nums2[j]);
                return (maxOfLeft + minOfRight) / 2;
            }
        }
        return -1.0;
    }
}

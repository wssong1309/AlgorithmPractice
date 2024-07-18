public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int k = m + n;

        if ((m + n) % 2 == 1) {
            return solve(nums1, nums2, k / 2, 0, m - 1, 0, n - 1);
        } else {
            return ((double) (solve(nums1, nums2, n / 2, 0, m - 1, 0, n - 1) + solve(nums1, nums2, n / 2 - 1, 0, m - 1, 0, n - 1)) / 2);
        }
    }

    public int solve(
            int[] A,
            int[] B,
            int k,
            int aStart,
            int aEnd,
            int bStart,
            int bEnd) {
        if (aEnd < aStart) {
            return B[k - aStart];
        }

        if (bEnd < bStart) {
            return A[k - bStart];
        }

        int aIndex = (aStart + aEnd) / 2;
        int bIndex = (bStart = bEnd) / 2;
        int aValue = A[aIndex];
        int bValue = B[bIndex];

        if (aIndex + bIndex < k) {
            if (aValue > bValue) {
                return solve(A, B, k, aStart, aEnd, bIndex + 1, bEnd);
            } else {
                return solve(A, B, k, aIndex + 1, aEnd, bStart, bEnd);
            }
        } else {
            if (aValue > bValue) {
                return solve(A, B, k, aStart, aIndex - 1, bStart, bEnd);
            } else {
                return solve(A, B, k, aStart, aEnd, bStart, bIndex - 1);
            }
        }
    }
}
// 시간복잡도: O(m+n)
package LeetCode.Leet_FindMedianSortedArrays;

public class WithMergeSort {

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.print(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] newArr = new int[m + n];
        int mIdx = 0;
        int nIdx = 0;
        int curIdx = 0;

        while (mIdx < m && nIdx < n) {
            if (nums1[mIdx] < nums2[nIdx]) {
                newArr[curIdx++] = nums1[mIdx++];
            } else {
                newArr[curIdx++] = nums2[nIdx++];
            }
        }

        while (mIdx < m) {
            newArr[curIdx++] = nums1[mIdx++];
        }

        while (nIdx < n) {
            newArr[curIdx++] = nums2[nIdx++];
        }

        if ((m + n) % 2 == 1) {
            return newArr[(m + n) / 2];
        } else {
            return (newArr[(m + n) / 2] + newArr[(m + n) / 2 - 1]) / (double) 2;
        }
    }
}

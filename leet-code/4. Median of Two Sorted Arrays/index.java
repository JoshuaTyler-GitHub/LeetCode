import java.util.Arrays;

class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int combinedLength = nums1.length + nums2.length;
    Integer[] concatNums = new Integer[combinedLength];
    for (int i = 0; i < concatNums.length; i++) {
      if (i < nums1.length) {
        concatNums[i] = nums1[i];
      } else {
        concatNums[i] = nums2[i - nums1.length];
      }
    }
    concatNums = Arrays.asList(concatNums).stream().sorted().toArray(Integer[]::new);

    if (combinedLength % 2 == 0) {
      return (concatNums[combinedLength / 2] + concatNums[combinedLength / 2 - 1]) / 2;
    } else {
      return concatNums[combinedLength / 2];
    }
  }
}
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
const findMedianSortedArrays = function (nums1, nums2) {
  const nums = nums1.concat(nums2).sort((a, b) => a - b);
  const length = nums.length;
  if (length % 2 === 0) {
    return (nums[length / 2] + nums[length / 2 - 1]) / 2;
  } else {
    return nums[Math.floor(length / 2)];
  }
};

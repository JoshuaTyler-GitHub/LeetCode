/**
 * @param {number[]} nums
 * @return {number[]}
 */
 var runningSum = function(nums) {
    const sums = Array(nums.length).fill(0);
    for(const index in sums) {
        if(index > 0) {
            sums[index] = nums[index] + sums[index - 1];
        } else {
            sums[index] = nums[index];
        }
    }
    return sums;
};
/**
 * @param {number[]} nums
 * @return {number}
 */
const pivotIndex = function (nums) {
  for (const index in nums) {
    // left
    let left = 0;
    nums.slice(0, index).forEach((i) => left += Number(i));

    // right
    let right = 0;
    nums.slice(Number(index) + 1).forEach((i) => right += Number(i));

    // compare
    if (left === right) {
      return index;
    }
  }
  return -1;
};

const param1 = [1,7,3,6,5,6];
pivotIndex(param1);
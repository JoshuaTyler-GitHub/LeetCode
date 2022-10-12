/**
 * @param {string} s
 * @return {string}
 */
const longestPalindrome = function (s) {
  let max = 0;
  let result = '';
  for (let i = 0; i < s.length; i++) {
    for (let j = i + 1; j <= s.length; j++) {
      const str = s.slice(i, j);
      if (isPalindrome(str) && str.length > max) {
        max = str.length;
        result = str;
      }
    }
  }
  return result;
};

const isPalindrome = function (s) {
  let left = 0;
  let right = s.length - 1;
  while (left < right) {
    if (s[left] !== s[right]) {
      return false;
    }
    left++;
    right--;
  }
  return true;
};

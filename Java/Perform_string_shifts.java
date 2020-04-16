// You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:

// direction can be 0 (for left shift) or 1 (for right shift). 
// amount is the amount by which string s is to be shifted.
// A left shift by 1 means remove the first character of s and append it to the end.
// Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
// Return the final string after all operations.

// Example 1:

// Input: s = "abc", shift = [[0,1],[1,2]]
// Output: "cab"
// Explanation: 
// [0,1] means shift to left by 1. "abc" -> "bca"
// [1,2] means shift to right by 2. "bca" -> "cab"
// Example 2:

// Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
// Output: "efgabcd"
// Explanation:  
// [1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
// [1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
// [0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
// [1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
// Constraints:

// 1 <= s.length <= 100
// s only contains lower case English letters.
// 1 <= shift.length <= 100
// shift[i].length == 2
// 0 <= shift[i][0] <= 1
// 0 <= shift[i][1] <= 100

//reference to: https://github.com/Wenting-Song/Interview/blob/master/Java/189_Rotate%20Array.java
class Solution {
    public String stringShift(String s, int[][] shift) {
        if(s == null) return s;
        char[] chars = s.toCharArray();
        int right = 0;
        //shift[i] = [direction, amount]
        //0: left: 1: right
        for(int[] sh: shift){
            int k = sh[1] % s.length();
            if(k == 0){
                continue;
            }else {
                k = sh[0] == 1? k: s.length()-k;
                right += k;
            } 
        }
        right %= s.length();
        reverse(chars, 0, chars.length - 1);
        reverse(chars, 0, right - 1);
        reverse(chars, right, chars.length - 1);
        return String.valueOf(chars);
    }
    private void reverse(char[] chars, int i, int j){
        while(i < j){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
    }
}


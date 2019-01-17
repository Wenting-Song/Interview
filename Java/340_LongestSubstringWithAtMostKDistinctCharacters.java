/*
Given a string, find the length of the longest substring T that contains at most k distinct characters.

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: T is "ece" which its length is 3.
Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: T is "aa" which its length is 2.
*/
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        //use num to track the number of distinct characters within the slide window
        int[] ch = new int[256];
        int start = 0, num = 0, res = 0;
        for(int end = 0; end < s.length(); end++){
            if(ch[s.charAt(end)] == 0) {
                num++;
            } 
            ch[s.charAt(end)]++;
            
            //never allow num exceends, move start pointer until num <= k
            while(num > k){
                ch[s.charAt(start)]--;
                if(ch[s.charAt(start)] == 0){
                      num--;
                 }
                start++;
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }
}

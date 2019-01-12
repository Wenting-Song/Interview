/* 
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
*/
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null || s.length() != t.length()) return false;
        int[] dict = new int[26];
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            dict[ch - 'a']++;
        }
         for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
             dict[ch -'a']--;
            if(dict[ch - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}

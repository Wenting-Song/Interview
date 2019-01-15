/*
Given an input string , reverse the string word by word. 

Example:

Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
Note: 

A word is defined as a sequence of non-space characters.
The input string does not contain leading or trailing spaces.
The words are always separated by a single space.
Follow up: Could you do it in-place without allocating extra space?
*/
class Solution {
    public void reverseWords(char[] str) {
        //reverse the whole input
        reverse(str, 0 , str.length - 1);
        //reverse each individual word
        int start = 0, end = 0;
        while(end < str.length){
            start = end;
            while(end < str.length && str[end] != ' ') end++;
            reverse(str, start, end-1);
            end++;
        }
    }
    void reverse(char[] str, int l, int r ){
        while(l < r){
            char temp = str[l];
            str[l] = str[r];
            str[r] = temp;
            l++;
            r--;
        }
    }
}

// Check from left to right and then check from right to left.
// When check from left to right, take all '*'s as '(', to see whether can match all ')'s.
// And, When check from right to left, take all '*'s as ')', to see whether can match all '('s.
// If both checks are valid, then the string is valid.

// Part one:
// The first loop guarantees there would be no ) left for pairing, but there may be ( or * left.
// if * left, we can use * as '', there is still a fully match.
// To check if there are ( left, the second loop comes.

// Part two:
// the second loop guarantees there would be no ( left for pairing.

// The Intersection of part one and part two guarantees there would be no ) and no ( left for pairing.
// So this solution works well.
class Solution {
    public boolean checkValidString(String s) {
        int bal = 0;
        // char[] sArray = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '*'){
                bal++;
            }else{
                bal--;
            }
            if(bal < 0) return false;
        }
        if(bal == 0) return true;
        bal = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == ')' || s.charAt(i) == '*'){
                bal++;
            }else{
                bal--;
            }
            if(bal < 0) return false;
        }
        return true;
    }
}
// https://leetcode.com/problems/valid-parenthesis-string/discuss/139759/Java-Very-easy-solution.-No-recursion-dp.

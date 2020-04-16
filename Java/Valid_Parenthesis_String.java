Check from left to right and then check from right to left.
When check from left to right, take all '*'s as '(', to see whether can match all ')'s.
And, When check from right to left, take all '*'s as ')', to see whether can match all '('s.
If both checks are valid, then the string is valid.
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

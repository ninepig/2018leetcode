package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *  Backtracking , o(2^n)
 */
public class palindromePartitioning {
    public List<List<String>> partition(String s) {

        List<List<String>> res = new ArrayList<>();
        if(s == null || s.length() == 0){
            return res;
        }
        List<String> cur = new ArrayList<>();
        helper(res,cur,s,0);
        return res;
    }

    private void helper(List<List<String>> res, List<String> cur, String s, int pos) {
        // Ending condtion.
        if(pos == s.length()){
            res.add(new ArrayList<>(cur));
        }else{
            for(int i = pos ; i < s.length() ; i++){
                if(isPalindrome(s,pos,i)){
                    cur.add(s.substring(pos,i+1));
                    helper(res,cur,s,i+1);
                    cur.remove(cur.size()-1);
                }
            }
        }
    }

    private boolean isPalindrome(String s, int pos, int i) {
        while(pos < i ){
            if(s.charAt(pos)!=s.charAt(i)){
                return false;
            }
            pos++;
            i--;
        }
        return true;
    }
}

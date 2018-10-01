package backtracking;

/**
 * Question 93
 * https://leetcode.com/problems/restore-ip-addresses/description/
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * Example:
 *
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 *
 */

import java.util.ArrayList;
import java.util.List;

/**
 *  BackTracking
 *  Using backtracking to find all the possibility.  Using conditions to trim the result.
 */
public class Iprestoring {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();

        if(s == null || s.length() == 0 || s.length() > 12){
            return res;
        }

        helper(s,res,new StringBuilder(),0,0);

        return res;
    }

    private void helper(String s, List<String> res , StringBuilder sb, int pos, int dotCount){
        // Ending condition is pos == s.length()
        if(pos == s.length() && dotCount == 3){
            res.add(sb.toString());
        }
        if(dotCount > 3){
            return ;
        }
        for(int i = pos ; i < s.length() ; i++){
            // To current loop, it will loop 3 times.
            // KeyPoint is pos!
            String sub = s.substring(pos,i+1);
            // Trimming condition.
            if(sub.length() > 3 || (sub.length() >1 && sub.charAt(0) == '0') || Integer.valueOf(sub) > 255){
                break;
            }
            int len = sb.length();
            sb.append(sub);
            if(i+1 != s.length()){
                sb.append('.');
                helper(s,res,sb,i+1,dotCount+1);
            }else{
                helper(s,res,sb,i+1,dotCount);
            }
            sb.setLength(len);
        }
    }

}

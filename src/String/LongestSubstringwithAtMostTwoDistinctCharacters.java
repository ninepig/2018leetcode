package String;

import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
 * For example, Given s = “eceba”,
 * T is "ece" which its length is 3.
 */
public class LongestSubstringwithAtMostTwoDistinctCharacters {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        // Two pointers
        int l = 0 , r = 0;
        // Counter to record how many distinct characters.
        int count = 0;
        int result = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();

        while(r < s.length()){
            char cur = s.charAt(r);
            map.put(cur,map.getOrDefault(cur,0)+1);
            if(map.get(cur) == 1) {
                count++;
            }
            // if we have more than 2 dinstict chars
            while(count > 2){
                char head = s.charAt(l);
                map.put(head,map.get(head)-1);
                if(map.get(cur) == 0){
                    count--;
                }
                l++;
            }
            result = Math.max(result,r-l);
            r++;
        }

        return result;
    }

    // if we extend this question to K distinct characters.
    // It seems work with same code.

    public int lengthOfLongestSubstringkDistinct(String s,int k) {
        if(s == null || s.length() == 0){
            return 0;
        }
        // Two pointers
        int l = 0 , r = 0;
        // Counter to record how many distinct characters.
        int count = 0;
        int result = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();

        while(r < s.length()){
            char cur = s.charAt(r);
            map.put(cur,map.getOrDefault(cur,0)+1);
            if(map.get(cur) == 1) {
                count++;
            }
            // if we have more than 2 dinstict chars
            while(count > k){
                char head = s.charAt(l);
                map.put(head,map.get(head)-1);
                if(map.get(cur) == 0){
                    count--;
                }
                l++;
            }
            result = Math.max(result,r-l);
            r++;
        }

        return result;
    }
}

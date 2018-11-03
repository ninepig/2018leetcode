package String;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }

        HashSet<Character> set = new HashSet<>();
        int r = 0, l = 0;
        int res = Integer.MIN_VALUE;

        while(r < s.length()){
            if(set.add(s.charAt(r))){
                res = Math.max(res,set.size());
                r++;
            }else{
                set.remove(s.charAt(l));
                l++;
            }
        }

        return res;
    }
}

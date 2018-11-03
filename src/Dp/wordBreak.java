package Dp;

import java.util.List;

public class wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0||wordDict.size()==0){
            return false;
        }
        // initial state
        boolean[] breakAble = new boolean[s.length()+1];
        breakAble[0] = true;

        for(int i = 1 ; i <= s.length();i++){
            for (int j = 0 ; j < i ; j++){
                // 对于i来说， 如果J TRUE, 那么如果j，i的substring 在dict之中，就说明 i 是true的
                if(breakAble[j]&&wordDict.contains(s.substring(j,i))){
                    breakAble[i] = true;
                    break;
                }
            }
        }
        // final result
        return breakAble[s.length()];
    }
}

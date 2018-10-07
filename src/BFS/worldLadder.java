package BFS;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *  BFS to do the question like count the step, length.
 *  time n length of words * m size of reachword * 26
 */
public class worldLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> dict = new HashSet<>(wordList);
        Set<String> reached = new HashSet<>();

        reached.add(beginWord);
        int ladder = 1;

        while(!reached.contains(endWord)){
            Set<String> toAdd = new HashSet<>();
            for(String str:reached){
                for(int i = 0 ; i < str.length() ; i++){
                    // Bug i made, you can only change once a step!
                    char[] curArray = str.toCharArray();
                    for (char ch = 'a';ch<='z';ch++){
                        curArray[i] = ch;
                        String newStr = new String(curArray);
                        if(dict.contains(newStr)){
                            toAdd.add(newStr);
                            dict.remove(newStr);
                        }
                    }
                }
            }
            ladder++;
            if(toAdd.size()==0){
                return 0;
            }
            reached = toAdd;
        }
        return ladder;
    }


    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Set<String> reach = new HashSet<>();
        reach.add(beginWord);
        int ladder = 1;
        while(!reach.contains(endWord)){
            Set<String> toAdd = new HashSet<>();
            for(String str:reach){
                for(int i = 0 ; i < str.length() ; i++){
                    char[] curArray = str.toCharArray();
                    for(char a ='a';a<='z';a++){
                        curArray[i] = a;
                        String newString = curArray.toString();
                        if(dict.contains(newString)){
                            toAdd.add(newString);
                            dict.remove(newString);
                        }
                    }
                }
            }
            ladder++;
            if(toAdd.size()==0){
                return 0;
            }
            reach = toAdd;
        }

        return ladder;
    }

}

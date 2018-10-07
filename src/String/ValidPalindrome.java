package String;

/**
 * 比较简单的双指针。
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        int l = 0, r = s.length()-1;
        s = s.toLowerCase();

        while(l < r){
            while(l < r && !validHelper(s.charAt(l))){
                l++;
            }
            while(l < r && !validHelper(s.charAt(r))){
                r--;
            }
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            r--;
            l++;
        }
        return true;
    }
    private boolean validHelper(char cur){
        return (cur >= 'a' && cur <= 'z')||(cur >= '0' && cur <= '9');
    }
}

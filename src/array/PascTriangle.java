package array;

import java.util.ArrayList;
import java.util.List;

public class PascTriangle {
    // For question one.
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        if(numRows == 0){
            return res;
        }

        List<Integer> pre = new ArrayList<>();

        pre.add(1);
        res.add(new ArrayList(pre));

        for(int i = 2 ; i <= numRows;i++ ){
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            // Key
            for(int j = 0 ; j < pre.size()-1;j++){
                cur.add(pre.get(j)+pre.get(j+1));
            }
            cur.add(1);
            res.add(new ArrayList(cur));
            pre = cur;
        }

        return res;
    }
    // For question two.
    // Index From 0.
    public List<Integer> getRow(int rowIndex) {
        List<Integer> cur = new ArrayList<>();

        if(rowIndex == 0){
            cur.add(1);
            return cur;
        }

        List<Integer> pre = new ArrayList<>();
        pre.add(1);

        for(int i = 1 ; i <= rowIndex;i++ ){
            cur = new ArrayList<>();
            cur.add(1);
            for(int j = 0 ; j < pre.size()-1;j++){
                cur.add(pre.get(j)+pre.get(j+1));
            }
            cur.add(1);
            pre = cur;
        }

        return cur;
    }
}

package Math;

public class GasStation {
    /**
     * 1. 假如从位置i开始，i+1，i+2...，一路开过来一路油箱都没有空。说明什么？说明从i到i+1，i+2，...肯定是正积累。
     * 2. 现在突然发现开往位置j时油箱空了。这说明什么？说明从位置i开始没法走完全程(废话)。那么，我们要从位置i+1开始重新尝试吗？不需要！为什么？
     * 因为前面已经知道，位置i肯定是正积累，那么，如果从位置i+1开始走更加没法走完全程了，因为没有位置i的正积累了。同理，也不用从i+2，i+3，...开始尝试。所以我们可以放心地从位置j+1开始尝试。
     * https://www.cnblogs.com/boring09/p/4248482.html
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int remain = 0;
        int debt = 0;
        int start = 0;
        for(int i = 0 ; i < gas.length ; i++){
            remain += gas[i] - cost[i];
            if(remain < 0){
                debt += remain;
                start = i+1;
                remain = 0;
            }
        }
        return remain+debt >=0 ? start : -1;
    }
}

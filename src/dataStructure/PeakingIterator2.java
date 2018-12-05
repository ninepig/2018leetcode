package dataStructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PeakingIterator2 implements Iterator<Integer>  {
    /**
     * LeetCode 284
     * https://leetcode.com/problems/peeking-iterator/
     * Iterator 就是返回 next 以及 看是否有hasNext的 接口
     * 这道题要增加一个peek方法 同时实现 next 以及hasNext 方法
     * 用一个next value 以及一个 noElement 的boolean 来cache
     */
        Iterator<Integer> iter ;
        boolean noElement;
        Integer next;

        public PeakingIterator2(Iterator<Integer> iterator){
            iter = iterator;
            advanceIter();
        }


        /**
         * Just return noElement flag
         * @return
         */
        @Override
        public boolean hasNext() {
            return !noElement;
        }

        /**
         * check if we have element, then return next
         * @return
         */
        @Override
        public Integer next() {
            if(noElement){
                throw new NoSuchElementException();
            }
            Integer res = next;
            advanceIter();
            return res;
        }

        public Integer peek(){
            return next;
        }

        private void advanceIter(){
            if(iter.hasNext()){
                next = iter.next();
            }else{
                noElement = true;
            }
        }

    }

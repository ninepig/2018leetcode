package linkedList;

import java.util.HashMap;

/**
 * o(n) time o(n) space for hashmap
 * Do it in one pass.
 * 很直观地去做这个题，利用hashmap，复制节点。
 */
public class copyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {

        if(head == null){
            return null;
        }

        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();

        RandomListNode dummy = new RandomListNode(0);
        RandomListNode pre = dummy;
        RandomListNode newHead = null;

        while(head != null){
            if(map.containsKey(head)){
               newHead = map.get(head);
            }else{
                newHead = new RandomListNode(head.label);
                map.put(head,newHead);
            }

            if(head.random!=null){
                if(map.containsKey(head.random)){
                    newHead.random = map.get(head.random);
                }else{
                    newHead.random = new RandomListNode(head.random.label);
                    map.put(head.random,newHead.random);
                }
            }
            pre.next = newHead;
            pre = pre.next;
            head = head.next;
        }

        return dummy.next;

    }

      class RandomListNode {
          int label;
         RandomListNode next, random;
          RandomListNode(int x) { this.label = x; }
      }
}

package dataStructure;

import java.util.HashMap;

/**
 * 难，容易考
 */
public class LRUCache {
    class node {
        int key;
        int value;
        node pre,next;
        public node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer,node> map;
    int capcity;
    int count;
    node head,tail;

    public LRUCache(int capcity){
        this.capcity = capcity;
        map = new HashMap<>();
        head = new node(0,0);
        tail = new node(0,0);
        head.next = tail;
        tail.pre =head;
        head.pre = null;
        tail.next = null;
        count  = 0;
    }
    //delete node after it was get
    public void deleteNode(node node){
        node.pre.next = node.next;
        node.next.pre  = node.pre;
    }
    // add resently used node to head
    public void addToHead(node node){
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }
    public int get(int key){
        //when we want get a node, if it is in map, we return it ,and delete the orinal one then add the one to Head;
        if(map.get(key)!=null){
            node node = map.get(key);
            int result = node.value;
            deleteNode(node);
            addToHead(node);
            return result;
        }
        //otherwise return -1;
        return -1;
    }


    public void put(int key , int value){
        //when we insert the value, we first check if it in the map, if yes, replace the old value, then delete the node and insert into head
        if(map.get(key)!=null){
            node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        }else {
            //if not in the map ,put into map
            node node = new node(key,value);
            map.put(key,node);
            //if not over capcity
            if(count<capcity){
                count++;
                addToHead(node);
            }else {
                //otherwise we need remove the tail one
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
                addToHead(node);
            }
        }
    }

}

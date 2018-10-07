package BFS;

import java.util.*;

public class cloneGraph {
      class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
        }


        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

            if(node == null){
                return null;
            }
            HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();
            ArrayList<UndirectedGraphNode> queue = new ArrayList<>();
            queue.add(node);
            map.put(node, new UndirectedGraphNode(node.label));
            int start = 0 ;
            // put all the node into map.
            while (start<queue.size()){
                UndirectedGraphNode tempNode = queue.get(start);
                start++;
                for (int i = 0 ; i<tempNode.neighbors.size();i++){
                    UndirectedGraphNode tempNeighbout = tempNode.neighbors.get(i);
                    if(!map.containsKey(tempNeighbout)){
                        map.put(tempNeighbout,new UndirectedGraphNode(tempNeighbout.label));
                        queue.add(tempNeighbout);
                    }
                }
            }
            // Copy Node and edge
            for (int i = 0;i<queue.size();i++){
                UndirectedGraphNode newHead = map.get(queue.get(i));
                for (int j= 0; j<queue.get(i).neighbors.size();j++){
                    // Copy edge
                    newHead.neighbors.add(map.get(queue.get(i).neighbors.get(j)));
                }
            }

            return map.get(node);
        }
}

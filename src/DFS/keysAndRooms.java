package DFS;

import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.com/problems/keys-and-rooms/
 * 这道题就是一道图是否是连通的问题，关键是把问题画出来 整理好思路才可以。多做了肯定就问题不大
 * dfs 辅助数组visited 走一圈即可。
 * 连通图问题！
 * time o（v+E） space（v）
 */
public class keysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(visited,0,rooms);
        for(boolean room : visited){
            if(room == false){
                return false;
            }
        }
        return true;
    }
    private void dfs(boolean[] visited , int roomNumber , List<List<Integer>> rooms){
        if(visited[roomNumber]){
            return;
        }else{
            visited[roomNumber] = true;
        }
        List<Integer> keysInRoom = rooms.get(roomNumber);
        for(int i = 0 ; i < keysInRoom.size();i++){
            dfs(visited,keysInRoom.get(i),rooms);
        }
    }
//        boolean[] visited = new boolean[rooms.size()];
//        dfs(rooms,visited,0);
//        for(int i = 0 ; i < visited.length;i++){
//            if(!visited[i]){
//                return false;
//            }
//        }
//        return true;
//    }
//    private void dfs(List<List<Integer>> rooms,boolean[] visited, int room){
//        if(visited[room]){
//            return;
//        }else{
//            visited[room] = true;
//        }
//        List<Integer> currentKeys =  rooms.get(room);
//        for(int i = 0 ; i < currentKeys.size() ; i++){
//            dfs(rooms,visited,currentKeys.get(i));
//        }
//    }
//
//    HashSet<Integer> enteredRooms = new HashSet<>();
//
//    public boolean canVisitAllRooms2(List<List<Integer>> rooms) {
//        enterRoom(0, rooms);
//        return enteredRooms.size() == rooms.size();
//    }
//
//    private void enterRoom(int roomId, List<List<Integer>> rooms) {
//        enteredRooms.add(roomId);
//        List<Integer> keysInRoom = rooms.get(roomId);
//        for (int key: keysInRoom)
//            if (!enteredRooms.contains(key))
//                enterRoom(key, rooms);
//    }

}

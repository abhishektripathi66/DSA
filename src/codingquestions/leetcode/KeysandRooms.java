import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 841. Keys and Rooms
 * Solved
 * Medium
 * Topics
 * Companies
 * There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.
 * <p>
 * When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.
 * <p>
 * Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true if you can visit all the rooms, or false otherwise.
 **/
public class KeysandRooms {
    Set<Integer> keys = new HashSet<>();
    Set<Integer> visited = new HashSet<>();
    boolean newlyAdded = false;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {


        List<Integer> b = rooms.get(0);
        for (Integer c : b) {
            keys.add(c);
        }
        visited.add(0);
        roomsVisited(keys, visited, rooms);
        if (visited.size() == rooms.size()) return true;
        return false;

    }

    public boolean roomsVisited(Set<Integer> keys, Set<Integer> visited, List<List<Integer>> rooms) {

        if ((rooms.size() == keys.size()) || (rooms.size() == visited.size())) {
            return true;
        }

        Set<Integer> keysBackup = new HashSet<>();
        keysBackup.addAll(keys);
        for (int i : keys) {
            if (visited.add(i)) {
                keysBackup.remove(i);
                newlyAdded = true;
                for (int j = 0; j < rooms.get(i).size(); j++) {
                    keysBackup.add(rooms.get(i).get(j));
                }
            }

        }
        if (!newlyAdded) return false;
        newlyAdded = false;
        keys = keysBackup;
        return roomsVisited(keys, visited, rooms);

    }
}

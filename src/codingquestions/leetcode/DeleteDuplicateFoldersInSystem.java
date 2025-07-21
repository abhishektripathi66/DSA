/**
1948. Delete Duplicate Folders in System
Solved
Hard
Topics
premium lock icon
Companies
Hint
Due to a bug, there are many duplicate folders in a file system. You are given a 2D array paths, where paths[i] is an array representing an absolute path to the ith folder in the file system.

For example, ["one", "two", "three"] represents the path "/one/two/three".
Two folders (not necessarily on the same level) are identical if they contain the same non-empty set of identical subfolders and underlying subfolder structure. The folders do not need to be at the root level to be identical. If two or more folders are identical, then mark the folders as well as all their subfolders.

For example, folders "/a" and "/b" in the file structure below are identical. They (as well as their subfolders) should all be marked:
/a
/a/x
/a/x/y
/a/z
/b
/b/x
/b/x/y
/b/z
However, if the file structure also included the path "/b/w", then the folders "/a" and "/b" would not be identical. Note that "/a/x" and "/b/x" would still be considered identical even with the added folder.
Once all the identical folders and their subfolders have been marked, the file system will delete all of them. The file system only runs the deletion once, so any folders that become identical after the initial deletion are not deleted.

Return the 2D array ans containing the paths of the remaining folders after deleting all the marked folders. The paths may be returned in any order.

 

Example 1:


Input: paths = [["a"],["c"],["d"],["a","b"],["c","b"],["d","a"]]
Output: [["d"],["d","a"]]
Explanation: The file structure is as shown.
Folders "/a" and "/c" (and their subfolders) are marked for deletion because they both contain an empty
folder named "b".
Example 2:


Input: paths = [["a"],["c"],["a","b"],["c","b"],["a","b","x"],["a","b","x","y"],["w"],["w","y"]]
Output: [["c"],["c","b"],["a"],["a","b"]]
Explanation: The file structure is as shown. 
Folders "/a/b/x" and "/w" (and their subfolders) are marked for deletion because they both contain an empty folder named "y".
Note that folders "/a" and "/c" are identical after the deletion, but they are not deleted because they were not marked beforehand.
Example 3:


Input: paths = [["a","b"],["c","d"],["c"],["a"]]
Output: [["c"],["c","d"],["a"],["a","b"]]
Explanation: All folders are unique in the file system.
Note that the returned array can be in a different order as the order does not matter.
 

Constraints:

1 <= paths.length <= 2 * 104
1 <= paths[i].length <= 500
1 <= paths[i][j].length <= 10
1 <= sum(paths[i][j].length) <= 2 * 105
path[i][j] consists of lowercase English letters.
No two paths lead to the same folder.
For any folder not at the root level, its parent folder will also be in the input.
**/

import java.util.*;
public class DeleteDuplicateFoldersInSystem {
    // for every folder I want to find its subfolder structure. so we would be using the trie data structure
    // we would be moving from the root to the last node and we would be returning the next folders in the sorted way to the parent node, and then back to the root node.
    // all the folder strcutre shown in the list will be converted to the trie data structure.
    // if there are two folders that have same set of folders but in different roots like a has folder c and d, and d has folder e, and another folder b  has folder e and c and c has folder d. so both a and b will have c d e, so to identify we would be adding the brackets to know them like (c)(d(e)) (c(d))(e), now we can see both the folders are different now.
    // we would be creating the map so that it can hold the count of the sub folder.
    // then we start removing the folders using the map
    // we would remove the entire connection
    // after that we would contruct again to create a list for sending back again.

    // creating a Node for The trie data structure
    static class Node{
        String val; //name of the folder
        String subFolder; //subfolder structure
        Map<String, Node> children;

        Node(String val){
            this.val=val;
            this.subFolder ="";
            this.children = new HashMap<>();
        }
    }

    //create a new Node
    private Node getNode(String val){
        return new Node(val);
    }

    //if a particular path is not present then create is else proceed to next folder
    private void insert(Node root, List<String> path){
        for(String folder:path){
            root.children.putIfAbsent(folder,getNode(folder));
            root = root.children.get(folder);
        }
    }

    // to store the count from the root in the subFolderPaths with the subfolder.
    private String populateNodes(Node root, Map<String,Integer> subFolderMap){

        List<Map.Entry<String,String>> subFolderPaths = new ArrayList<>();

        for(Map.Entry<String,Node> entry : root.children.entrySet()){
            String subFolderResult = populateNodes(entry.getValue(),subFolderMap);
            subFolderPaths.add(new AbstractMap.SimpleEntry<>(entry.getKey(),subFolderResult));
        }
        subFolderPaths.sort(Comparator.comparing(Map.Entry::getKey));
        StringBuilder completePath = new StringBuilder(); // this is the subfolder of current root which we will form from children path
        // we will go through each sub folder and we add it to the root.subFolder and the count is increased in the map as well
        for(Map.Entry<String,String> entry:subFolderPaths){
            completePath.append("(").append(entry.getKey()).append(entry.getValue()).append(")");

        } 

            root.subFolder = completePath.toString();
            if(!completePath.toString().isEmpty()){
                subFolderMap.put(completePath.toString(),subFolderMap.getOrDefault(completePath.toString(),0)+1);
            }
            return completePath.toString();

    }


    // to remove the folders based on subFolderMap that has the count, if any subfolder has count more than 1 then we delete it
    private void removeDuplicates(Node root, Map<String,Integer> subFolderMap){
        Iterator<Map.Entry<String, Node>> it = root.children.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String,Node> entry = it.next();
            Node child = entry.getValue();
            if(!child.subFolder.isEmpty() && subFolderMap.get(child.subFolder)>1){
                it.remove();
            }
            else{
                removeDuplicates(child,subFolderMap);
            }
        }
    }

    // to add back the thing to the list to return it.
    private void constructResult(Node root, List<String> path, List<List<String>> result){
        for(Map.Entry<String, Node> entry: root.children.entrySet()){
            path.add(entry.getKey()); // adding the key to the path
            result.add(new ArrayList<>(path)); // adding it to the result 
            constructResult(entry.getValue(),path,result); //continue
            path.remove(path.size()-1); // before returning back we would remove the last key.
        }
    }

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        //creating the root node
        Node root = getNode("/");

        //construct trie
        for(List<String> path:paths){
            insert(root,path);
        }

        //map to store the count of the subfolder
        Map<String, Integer> subFolderMap = new HashMap<>();
        // to store the subfolders in the tree and even keep the count
        populateNodes(root,subFolderMap);
        // remove duplicates from the root.
        removeDuplicates(root,subFolderMap);
        // to get th final result using the subFolderMap 
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        constructResult(root,path,result);
        return result;

        
    }
}

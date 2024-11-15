import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
1233. Remove Sub-Folders from the Filesystem
Solved
Medium
Topics
Companies
Hint
Given a list of folders folder, return the folders after removing all sub-folders in those folders. You may return the answer in any order.

If a folder[i] is located within another folder[j], it is called a sub-folder of it. A sub-folder of folder[j] must start with folder[j], followed by a "/". For example, "/a/b" is a sub-folder of "/a", but "/b" is not a sub-folder of "/a/b/c".

The format of a path is one or more concatenated strings of the form: '/' followed by one or more lowercase English letters.

For example, "/leetcode" and "/leetcode/problems" are valid paths while an empty string and "/" are not.
  **/
public class RemoveSubFoldersfromtheFilesystem {
    public List<String> removeSubfolders(String[] folder) {
        // Sort the folders lexicographically so parent folders come before their subfolders
        Arrays.sort(folder);
        
        // Initialize result list with the first folder
        List<String> ans = new ArrayList<>();
        ans.add(folder[0]);
        
        // Iterate through remaining folders starting from index 1
        for (int i = 1; i < folder.length; i++) {
            // Get the last added folder path and add a trailing slash
            String lastFolder = ans.get(ans.size() - 1) + "/";
            
            // Check if current folder starts with lastFolder
            // If it doesn't start with lastFolder, then it's not a subfolder
            if (!folder[i].startsWith(lastFolder)) {
                ans.add(folder[i]);
            }
        }
        
        return ans;
    }
}

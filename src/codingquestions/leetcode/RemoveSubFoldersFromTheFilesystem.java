package codingquestions.leetcode;

/*
1233. Remove Sub-Folders from the Filesystem
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given a list of folders folder, return the folders after removing all sub-folders in those folders. You may return the answer in any order.

If a folder[i] is located within another folder[j], it is called a sub-folder of it. A sub-folder of folder[j] must start with folder[j], followed by a "/". For example, "/a/b" is a sub-folder of "/a", but "/b" is not a sub-folder of "/a/b/c".

The format of a path is one or more concatenated strings of the form: '/' followed by one or more lowercase English letters.

For example, "/leetcode" and "/leetcode/problems" are valid paths while an empty string and "/" are not.
 

Example 1:

Input: folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
Output: ["/a","/c/d","/c/f"]
Explanation: Folders "/a/b" is a subfolder of "/a" and "/c/d/e" is inside of folder "/c/d" in our filesystem.
Example 2:

Input: folder = ["/a","/a/b/c","/a/b/d"]
Output: ["/a"]
Explanation: Folders "/a/b/c" and "/a/b/d" will be removed because they are subfolders of "/a".
Example 3:

Input: folder = ["/a/b/c","/a/b/ca","/a/b/d"]
Output: ["/a/b/c","/a/b/ca","/a/b/d"]
 

Constraints:

1 <= folder.length <= 4 * 104
2 <= folder[i].length <= 100
folder[i] contains only lowercase letters and '/'.
folder[i] always starts with the character '/'.
Each folder name is unique.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveSubFoldersFromTheFilesystem {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);

        List<String> res = new ArrayList<>();
        res.add(folder[0]);

        for(int i = 1; i < folder.length; i++){
            String last = res.get(res.size() - 1);
            last += '/';
            if(folder[i].startsWith(last))
                continue;
            
            res.add(folder[i]);
        }

        return res;
    }

 //solution 2 Abhishek Tripathi
 public List<String> removeSubfolders1(String[] folder) {
        List<String> a = new ArrayList<>();
        Arrays.sort(folder);
        a.add(folder[0]);
        int j=0;
        for(int i=1;i<folder.length;i++){
            if(!folder[i].startsWith(a.get(j)+"/")){
                    a.add(folder[i]);
                    j++;
            }
            
        }
        return a;
    }
}

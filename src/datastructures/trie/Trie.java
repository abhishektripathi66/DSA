package datastructures.trie;

public class Trie {
    
    //static inner node class, so no reference to outer Trie instance
    static public class TrieNode{
        TrieNode[] children;
        boolean isEnd;

        TrieNode(){
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    //each trie object will have their own root
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public static void main(String[] args) {
        
        Trie trie = new Trie();
        //lower-case letters only
        trie.insert("abc");
        trie.insert("pqr");
        trie.insert("xyz");

        System.out.println(" "+trie.search("abc"));//true
        System.out.println(" "+trie.search("abd"));//false
        System.out.println(" "+trie.startsWith("ab"));//true
        trie.delete("abc");
        System.out.println(" "+trie.search("abc"));//false
    }

    //Inserts a word into the trie
    private void insert(String word){
        TrieNode curr = root;

        for(char ch : word.toCharArray()){

            // Calculate index for current character ch and create a new node if path does not exist
            if (curr.children[ch - 'a'] == null)
                curr.children[ch - 'a'] = new TrieNode();
            curr = curr.children[ch - 'a'];
        }

        //mark the end of a valid word
        curr.isEnd = true;
    }

    //searches for a complete word in the trie
    private boolean search(String word){
        TrieNode curr = root;

        for(char ch : word.toCharArray()){
            //if the path does not exist, the word is not present
            if(curr.children[ch - 'a'] == null)
                    return false;
            curr = curr.children[ch - 'a'];
        }

        //return true only if the word ends at this node
        return curr.isEnd;
    }

    //checks  whether any word in the trie starts with the given prefix
    private boolean startsWith(String prefix){
        TrieNode curr = root;

        for(char ch : prefix.toCharArray()){

             //if the path does not exist, prefix is not present
            if(curr.children[ch - 'a'] == null)
                    return false;
            curr = curr.children[ch - 'a'];
        }

        //all prefix characters were found
        return true;
    }


    private void delete(String key) {
        //reassign root because deletion may remove nodes up to the root
        root = delKey(root, key, 0);
    }

    private TrieNode delKey(TrieNode root, String key, int i) {

        //if the node does not exist, nothing to delete
        if(root == null)
            return null;

        //if we have reached the end of the word
        if(i == key.length()) {

            //unmark the end-of-word flag
            root.isEnd = false;

            //if the node has no children, it can be deleted
            if(isEmpty(root))
                return null;

            //otherwise, keep the node
            return root;
        }

        //calculate index for the current character
        int idx = key.charAt(i) - 'a';

        //if the path does not exist, the word is not present
        if (root.children[idx] == null)
            return root;

        //recursively delete the child node
        root.children[idx] = delKey(root.children[idx], key, i + 1);

        //after deleting child, check if current node can be removed
        //it should not be an end of another word and must have no children
        if (isEmpty(root) && !root.isEnd)
            return null;

        return root;
    }

    //checks whether a trie node has any children.
    private boolean isEmpty(TrieNode root){

        for(int i=0; i<26; i++){
            if(root.children[i] != null)
                    return false;
        }
        return true;
    }
}

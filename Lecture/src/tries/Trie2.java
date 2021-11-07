package tries;

class TrieNode{

    char data;
    boolean isTerminating;
    TrieNode children[];
    int childCount;

    public TrieNode(char data) {
        this.data = data;
        isTerminating = false;
        children = new TrieNode[26];
        childCount = 0;
    }
}


public class Trie2 {

    private TrieNode root;
    public int count;
    public Trie2() {
        root = new TrieNode('\0');
    }

    private void add(TrieNode root, String word){
        if(word.length() == 0){
            root.isTerminating = true;
            return;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null){
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.childCount++;
        }
        add(child, word.substring(1));

    }

    public void add(String word){
        add(root, word);
    }

    private boolean search(TrieNode root,String word){
        if(word.length() == 0){
            if(root.isTerminating == true){
                return true;
            }else{
                return false;
            }
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null){
            return false;
        }
        return search(child,word.substring(1));
    }
    public boolean search(String word){
        return search(root,word);
    }

    public void delete(TrieNode root,String word){
        if(word.length() == 0){
            root.isTerminating = false;
            return;
        }

        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null){
            return;
        }

        delete(child,word.substring(1));

        if(!child.isTerminating && child.childCount == 0){
            root.children[childIndex] = null;
            child = null;
            root.childCount--;
        }

        // We can only remove when the child is non-terminating and its number of children == 0
//        if(!child.isTerminating){
//            int numChild = 0;
//            for(int i = 0; i < 26;i++){
//                if(child.children[i] != null){
//                    numChild++;
//                }
//            }
//            if(numChild != 0){
//                root.children[childIndex] = null;
//                child = null;
////                root.childCount--;
//            }
//        }

    }

    public void delete(String word){
        delete(root,word);
    }

    public static void main(String[] args) {
        Trie2 trie = new Trie2();
        trie.add("alok");
        System.out.println(trie.search("alok"));
        trie.delete("alok");
        System.out.println(trie.search("alok"));
    }
}

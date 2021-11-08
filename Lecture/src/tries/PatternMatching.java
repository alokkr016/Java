package tries;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class PatternMatching {
    private TrieNode root;
    public int count;
    public PatternMatching() {
        root = new TrieNode('\0');
    }

    public boolean search(String word){
        return search(root, word);
    }

    private boolean search(TrieNode root, String word) {
        if(word.length() == 0){
            return true;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null){
            return false;
        }
        return search(child, word.substring(1));
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
    public boolean patternMatching(ArrayList<String> vect, String pattern) {
        // Write your code here
        for(int i = 0;i < vect.size();i++){
            String s = vect.get(i);
            while(s.length() > 0){
//                System.out.println(s);
                add(s);
                s = s.substring(1);
            }
        }

        return search(pattern);
    }
}

 class Runner2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException{
        PatternMatching t = new PatternMatching();
        int n = Integer.parseInt(br.readLine().trim());
        ArrayList<String> input = new ArrayList<String>();
        String[] words = br.readLine().split("\\s");
        for(int i = 0; i < n; i++) {
            input.add(words[i]);
        }
        String pattern = br.readLine();
        System.out.println(t.patternMatching(input, pattern));
    }
}
package hashMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
public class ExtractUniqueCharacters {
    public static String uniqueChar(String str){
        HashMap<Character, Boolean> h = new HashMap<>();
        String ans = "";
        for(int i = 0;i < str.length();i++){
            if(h.containsKey(str.charAt(i))){
                continue;
            }
            else{
                ans += str.charAt(i);
                h.put(str.charAt(i),true);
            }
        }

        return ans;

    }
}


 class Runner12 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String takeInput() throws IOException {
        String str = br.readLine();
        return str;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {


        String str = takeInput();
        System.out.print(ExtractUniqueCharacters.uniqueChar(str));


    }
}
package dynamicProgramming;

public class EditDistance {
    public static int editDistance(String s1, String s2){
        if(s1.length() == 0){
            return s2.length();
        }

        if(s2.length() == 0){
            return s1.length();
        }

        if(s1.charAt(0) == s2.charAt(0)){
            return editDistance(s1.substring(1),s2.substring(1));
        }else{
            int delete = editDistance(s1.substring(1),s2);
            int insert = editDistance(s1,s2.substring(1));
            int substitute = editDistance(s1.substring(1),s2.substring(1));
            return 1 + Math.min(substitute,Math.min(insert,delete));
        }
    }

    public static int editDistanceM(String s1, String s2){
        int storage[][] = new int[s1.length() + 1][s2.length() + 1];
        for(int i = 0; i < s1.length() + 1; i++){
            for(int j = 0; j < s2.length() + 1; j++){
                storage[i][j] = -1;
            }
        }
        return editDistanceM(s1,s2,storage);
    }

    private static int editDistanceM(String s1, String s2, int[][] storage) {
        int m = s1.length();
        int n = s2.length();
        if(storage[m][n] != -1){
            return storage[m][n];
        }
        if(s1.length() == 0){
            storage[m][n] = s2.length();
            return storage[m][n];
        }

        if(s2.length() == 0){
            storage[m][n] = s1.length();
            return storage[m][n];
        }


        if(s1.charAt(0) == s2.charAt(0)){
            storage[m][n] =  editDistanceM(s1.substring(1),s2.substring(1),storage);
        }else{

            int delete = editDistanceM(s1.substring(1),s2,storage);
            int insert = editDistanceM(s1,s2.substring(1),storage);
            int substitute = editDistanceM(s1.substring(1),s2.substring(1),storage);

            storage[s1.length()][s2.length()] = 1 + Math.min(substitute,Math.min(insert,delete));
        }
        return storage[m][n];
    }
    public static int editDistanceDP(String s1, String s2){
        int storage[][] = new int[s1.length() + 1][s2.length() + 1];
        for(int i = 0; i < s1.length() + 1; i++){
            for(int j = 0; j < s2.length() + 1; j++){
                storage[i][j] = -1;
            }
        }
        return editDistanceDP(s1,s2,storage);
    }

    private static int editDistanceDP(String s1, String s2, int[][] storage) {
        int m = s1.length();
        int n = s2.length();


        if(s1.length() == 0){
            storage[m][n] = s2.length();
            return storage[m][n];
        }

        if(s2.length() == 0){
            storage[m][n] = s1.length();
            return storage[m][n];
        }

        for(int j = 0; j <= n; j++){
            storage[0][j] = j;
        }
        for(int i = 0; i <= m; i++){
            storage[i][0] = i;
        }

        for(int i = 1;i < s1.length() + 1; i++){
            for(int j = 1; j < s2.length() + 1; j++){
                if(s1.charAt(m -i) == s2.charAt(n - j)){
                    storage[i][j] = storage[i - 1][j - 1];
                }
                else{
                    storage[i][j] = 1 + Math.min(storage[i][j - 1],
                            Math.min(storage[i - 1][j], storage[i - 1][j - 1]));
                }
            }
        }

        return storage[m][n];

    }

    public static void main(String[] args) {
        String s = "wncvbsddas";
        String t = "wqegesgetjgfff";

        System.out.println(editDistanceM(s,t));
        System.out.println(editDistanceDP(s, t));
        System.out.println(editDistance(s, t));
    }
}
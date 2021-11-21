//package dynamicProgramming;
//
//public class LCS {
//    public static int lcs(String a, String b){
//        if(a.length() == 0 || b.length() == 0){
//            return 0;
//        }
//
//        if(a.charAt(0) == b.charAt(0)){
//            return 1 + lcs(a.substring(1),b.substring(1));
//        }else{
//            int op1 = lcs(a.substring(1),b);
//            int op2 = lcs(a,b.substring(1));
////            int op3 = lcs(a.substring(1),b.substring(1));
//
//            return Math.max(op1,op2);
//        }
//    }
//
//    public static int lcsM(String a, String b){
//        int storage[][] = new int[a.length() + 1][b.length() + 1];
//        for(int i = 0; i < a.length() + 1;i++){
//            for(int j = 0; j < b.length() + 1;j++){
//                storage[i][j] = -1;
//            }
//        }
//        return lcsM(a,b,storage);
//    }
//
//    public static int lcsM(String a, String b, int[][] storage){
//        int m = a.length();
//        int n = b.length();
//
//        if(storage[m][n] != -1){
//            return storage[m][n];
//        }
//
//        if(a.length() == 0 || b.length() == 0){
//            storage[m][n] = 0;
//            return storage[m][n];
//        }
//
//        if(a.charAt(0) == b.charAt(0)){
//            storage[m][n] = 1 + lcsM(a.substring(1),b.substring(1),storage);
//        }else{
//            int op1 = lcsM(a.substring(1),b,storage);
//            int op2 = lcsM(a,b.substring(1),storage);
//            storage[m][n] = Math.max(op1, op2);
//        }
//
//        return storage[m][n];
//    }
//
//    public static int lcsDP(String a, String b){
//        int storage[][] = new int[a.length() + 1][b.length() + 1];
//        for(int i = 0; i < a.length() + 1;i++){
//            for(int j = 0; j < b.length() + 1;j++){
//                storage[i][j] = -1;
//            }
//        }
//
//        return lcsDP(a,b,storage);
//
//    }
//
//    public static int lcsDP(String a, String b, int[][] storage){
//        int m = a.length();
//        int n = b.length();
//
//        if(a.length() == 0 || b.length() == 0){
//            storage[m][n] = 0;
//            return storage[m][n];
//        }
//
//    }
//
//
//    public static void main(String[] args) {
//        String s = "dgeigeigeigeigeigeigeigeigei";
//        String t = "begigeigeigaaawqgeigeiggeigeigeigei";
//        System.out.println(lcsM(s,t));
//        System.out.println(lcs(s,t));
//    }
//}

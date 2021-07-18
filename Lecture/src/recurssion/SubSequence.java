package recurssion;

public class SubSequence {
    public static String[] subSequence(String str){
        if(str.length() == 0){
            String[] ans = {""};
            return ans;
        }
        String[] subString = subSequence(str.substring(1));
//        for(int i = 0; i < subString.length;i++){
//            System.out.println("substring = " + subString[i]);
//        }
        String[] finalArray = new String[2 * subString.length];

        for(int i = 0;i < subString.length;i++){
            finalArray[i] = subString[i];
        }
        for(int i = 0;i < subString.length;i++) {
            finalArray[i + subString.length] = str.charAt(0) + subString[i];

        }
        return finalArray;
    }

    public static void main(String[] args) {
        String str = "xyz";
        String[] ans =  subSequence(str);
        for(int i = 0;i < ans.length;i++){
            System.out.println(ans[i]);
        }
    }

}